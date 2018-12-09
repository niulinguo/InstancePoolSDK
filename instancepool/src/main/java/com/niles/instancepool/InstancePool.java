package com.niles.instancepool;

import java.util.HashMap;

/**
 * Created by Niles
 * Date 2018/12/9 13:57
 * Email niulinguo@163.com
 */
public class InstancePool {

    private static final HashMap<Class, InstanceCreator> sCreatorHashMap = new HashMap<>();
    private static final HashMap<Class, Object> sInstanceHashMap = new HashMap<>();

    public static <T> void register(Class<T> clazz, InstanceCreator<T> creator) {
        sCreatorHashMap.put(clazz, creator);
    }

    public static <T> T get(Class<T> clazz) {
        Object obj = sInstanceHashMap.get(clazz);
        if (obj == null) {
            InstanceCreator instance = sCreatorHashMap.remove(clazz);
            if (instance != null) {
                obj = instance.createInstance();
                sInstanceHashMap.put(clazz, obj);
            }
        }
        //noinspection unchecked
        return (T) obj;
    }
}
