package com.xinyonghang.supplychain.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtils {
    public static byte[] serialize(Object object) {
        byte[] bytes = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            bytes = baos.toByteArray();
            oos.close();
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytes;
    }

    public static Object deserialize(byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            obj = ois.readObject();
            ois.close();
            bais.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}

