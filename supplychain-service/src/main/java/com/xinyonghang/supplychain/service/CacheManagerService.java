package com.xinyonghang.supplychain.service;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.cache.Cache;

public interface CacheManagerService
        extends Cache {
    void save(String paramString1, String paramString2, String paramString3);

    void saveToList(String paramString1, String paramString2, String paramString3, String paramString4);

    String read(String paramString);

    String readToList(String paramString1, String paramString2);

    Integer lenInList(String paramString);

    List<String> keyInList(String paramString);

    void delete(String paramString);

    void deleteToList(String paramString1, String paramString2);

    Set<String> keys(String paramString);
}

