package com.niles.instancepoolsdk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.niles.instancepool.InstancePool;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClicked(View view) {
        DbManager dbManager = InstancePool.get(DbManager.class);
        dbManager.sayHello(this);
    }
}
