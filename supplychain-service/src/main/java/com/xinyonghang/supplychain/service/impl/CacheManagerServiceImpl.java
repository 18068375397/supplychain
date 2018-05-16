package com.xinyonghang.supplychain.service.impl;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.Resource;

import com.xinyonghang.supplychain.service.CacheManagerService;
import com.xinyonghang.supplychain.utils.SerializeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CacheManagerServiceImpl
        implements CacheManagerService {
    private Log log = LogFactory.getLog(getClass());

    private String id;

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    @Resource(name = "redisTemplate")
    private RedisTemplate<?, ?> redisTemplate;

    public CacheManagerServiceImpl() {
    }

    public CacheManagerServiceImpl(String id) {
        this.id = id;
    }


    public void save(final String uid, final String jsonValue, final String validTime) {


        this.redisTemplate.execute((RedisCallback) conn -> {
            RedisSerializer<String> serializer = CacheManagerServiceImpl.this.redisTemplate.getStringSerializer();
            byte[] key_byte = serializer.serialize(uid);
            byte[] value_byte = serializer.serialize(jsonValue);
            conn.set(key_byte, value_byte);
            if (validTime != null) {
                conn.expire(key_byte, Long.parseLong(validTime));
            }
            return null;
        });
    }

    public void saveToList(final String uid, final String key, final String jsonValue, final String validTime) {
        this.redisTemplate.execute((RedisCallback) conn -> {
            RedisSerializer<String> serializer = CacheManagerServiceImpl.this.redisTemplate.getStringSerializer();
            byte[] key_byte = serializer.serialize(uid);
            byte[] field_byte = serializer.serialize(key);
            byte[] value_byte = serializer.serialize(jsonValue);
            conn.hSet(key_byte, field_byte, value_byte);
            if (validTime != null) {
                conn.expire(key_byte, Long.parseLong(validTime));
            }
            return null;
        });
    }

    public String read(final String uid) {
        String result = (String) this.redisTemplate.execute((RedisCallback) connection -> {
            RedisSerializer<String> stringSerializer = CacheManagerServiceImpl.this.redisTemplate.getStringSerializer();
            byte[] key = stringSerializer.serialize(uid);
            if (connection.exists(key).booleanValue()) {
                byte[] key_byte = connection.get(key);
                String value = stringSerializer.deserialize(key_byte);
                return value;
            }
            return null;
        });
        return result;
    }

    public String readToList(final String uid, final String key) {
        String result = (String) this.redisTemplate.execute((RedisCallback) connection -> {
            RedisSerializer<String> stringSerializer = CacheManagerServiceImpl.this.redisTemplate.getStringSerializer();
            byte[] key_byte = stringSerializer.serialize(uid);
            if (connection.exists(key_byte).booleanValue()) {
                byte[] field_byte = stringSerializer.serialize(key);
                byte[] value_byte = connection.hGet(key_byte, field_byte);
                String value = stringSerializer.deserialize(value_byte);
                return value;
            }

            return null;
        });
        return result;
    }

    public Integer lenInList(final String uid) {

        Long execute = (Long) this.redisTemplate.execute((RedisCallback) connection -> {
            Long len = connection.hLen(uid.getBytes());
            return len;
        });
        int size = execute.intValue();
        return Integer.valueOf(size);
    }

    public List<String> keyInList(final String uid) {

        List<String> execute = (List) this.redisTemplate.execute((RedisCallback) connection -> {
            List<String> list = new ArrayList();
            Set<byte[]> hKeys = connection.hKeys(uid.getBytes());
            if ((hKeys != null) && (hKeys.size() > 0)) {
                for (byte[] bs : hKeys) {
                    String key = new String(bs);
                    list.add(key);
                }
            }
            return list;
        });
        return execute;
    }

    public void delete(final String uid) {
        this.redisTemplate.execute((RedisCallback) connection -> {
            RedisSerializer<String> stringSerializer = CacheManagerServiceImpl.this.redisTemplate.getStringSerializer();
            byte[] serialize = stringSerializer.serialize(uid);
            connection.del(new byte[][]{serialize});
            return null;
        });
    }

    public void deleteToList(final String uid, final String key) {
        this.redisTemplate.execute((RedisCallback) connection -> {
            RedisSerializer<String> stringSerializer = CacheManagerServiceImpl.this.redisTemplate.getStringSerializer();
            byte[] serialize = stringSerializer.serialize(uid);
            byte[] key_byte = stringSerializer.serialize(key);
            connection.hDel(serialize, new byte[][]{key_byte});
            return null;
        });
    }

    public Set<String> keys(final String pattern) {
        Set<String> set = (Set) this.redisTemplate.execute((RedisCallback) connection -> {
            Set<String> set1 = new HashSet();
            Set<byte[]> keys = connection.keys(pattern.getBytes());
            for (byte[] key : keys) {
                set1.add(new String(key));
            }
            return set1;
        });
        return set;
    }

    public String getId() {

        return this.id;
    }

    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }

    public Object removeObject(Object arg) {

        final byte[] key = SerializeUtils.serialize(arg.hashCode());

        Object value = this.redisTemplate.execute((RedisCallback) connection -> {
            byte[] hget = connection.hGet(CacheManagerServiceImpl.this.id.getBytes(), key);
            Object value1 = null;
            if (hget != null) {
                value1 = SerializeUtils.deserialize(hget);
            }
            CacheManagerServiceImpl.this.log.warn("removeObject --> " + value1);
            return value1;
        });
        return value;
    }


    public int getSize() {
        Long execute = (Long) this.redisTemplate.execute((RedisCallback) connection -> {
            Long len = connection.lLen(CacheManagerServiceImpl.this.id.getBytes());
            return len;
        });
        int size = execute.intValue();
        this.log.warn("getSize --> " + size);
        return size;
    }


    public void clear() {
        this.redisTemplate.execute((RedisCallback) connection -> {
            Long del = connection.del(new byte[][]{CacheManagerServiceImpl.this.id.getBytes()});
            CacheManagerServiceImpl.this.log.warn("clear --> " + del);
            return null;
        });
    }

    public Object getObject(Object arg) {
        final byte[] key = SerializeUtils.serialize(arg.hashCode());
        Object value = this.redisTemplate.execute((RedisCallback) connection -> {
            byte[] hget = connection.hGet(CacheManagerServiceImpl.this.id.getBytes(), key);
            Object value1 = null;
            if (hget != null) {
                value1 = SerializeUtils.deserialize(hget);
            }
            if ((value1 != null) &&
                    (!(value1 instanceof List))) {
                if ((value1 instanceof byte[])) {
                    CacheManagerServiceImpl.this.log.warn("getObject --> cache get missing... byte[] ");
                    value1 = null;
                }
            }
            return value1;
        });
        return value;
    }


    public void putObject(Object arg0, Object arg1) {
        final byte[] key = SerializeUtils.serialize(arg0.hashCode());
        final byte[] value = SerializeUtils.serialize(arg1);
        this.redisTemplate.execute((RedisCallback) connection -> {
            Boolean set = connection.hSet(CacheManagerServiceImpl.this.id.getBytes(), key, value);
            if (set.booleanValue()) {
                CacheManagerServiceImpl.this.log.warn("putObject --> cache put done...");
            } else {
                CacheManagerServiceImpl.this.log.warn("putObject --> cache put missing...");
            }
            return null;
        });
    }
}


