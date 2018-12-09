package com.niles.instancepool;

/**
 * Created by Niles
 * Date 2018/12/9 13:59
 * Email niulinguo@163.com
 */
public interface InstanceCreator<T> {

    T createInstance();
}
