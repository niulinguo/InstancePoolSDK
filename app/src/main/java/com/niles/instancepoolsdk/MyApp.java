package com.niles.instancepoolsdk;

import android.app.Application;

import com.niles.instancepool.InstanceCreator;
import com.niles.instancepool.InstancePool;

/**
 * Created by Niles
 * Date 2018/12/9 14:08
 * Email niulinguo@163.com
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        InstancePool.register(DbManager.class, new InstanceCreator<DbManager>() {
            @Override
            public DbManager createInstance() {
                return new DbManager();
            }
        });
    }
}
