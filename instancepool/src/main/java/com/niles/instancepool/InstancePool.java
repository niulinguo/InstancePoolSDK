package com.niles.instancepool;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Niles
 * Date 2018/12/9 13:57
 * Email niulinguo@163.com
 */
public class InstancePool {

    /**
     * 用来保存所有的单例创建回调接口
     */
    private static final Map<Class, InstanceCreator> sCreatorMap = new ConcurrentHashMap<>();

    /**
     * 用于保存所有的单例对象
     */
    private static final Map<Class, Object> sInstanceMap = new ConcurrentHashMap<>();

    /**
     * 先注册某个类是单例类，并指定该类的创建方法
     */
    public static <T> void register(Class<T> clazz, InstanceCreator<T> creator) {
        sCreatorMap.put(clazz, creator);
    }

    /**
     * 根据单例类，获取单例对象
     */
    public static <T> T get(Class<T> clazz) {
        Object instance = sInstanceMap.get(clazz);
        if (instance == null) {
            synchronized (InstancePool.class) {
                if (sInstanceMap.containsKey(clazz)) {
                    instance = sInstanceMap.get(clazz);
                } else {
                    InstanceCreator creator = sCreatorMap.remove(clazz);
                    if (creator != null) {
                        instance = creator.createInstance();
                        sInstanceMap.put(clazz, instance);
                    }
                }
            }
        }
        //noinspection unchecked
        return (T) instance;
    }
}
