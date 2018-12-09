package com.niles.instancepoolsdk;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Niles
 * Date 2018/12/9 14:08
 * Email niulinguo@163.com
 */
public class DbManager {

    public DbManager() {
        Log.e("new", toString());
    }

    public void sayHello(Context context) {
        Toast.makeText(context, "hello world", Toast.LENGTH_SHORT).show();
    }
}
