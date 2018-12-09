# InstancePoolSDK
单例池，再也不用在每个单例类里面写 sInstance 了

## 导入方式

1. 添加仓库

``` Gradle
maven { url 'https://www.jitpack.io' }
```

2. 导入 SDK

``` Gradle
implementation 'com.github.niulinguo:InstancePoolSDK:v1.0'
```

## 使用

1. 注册单例

``` Java
InstancePool.register(DbManager.class, new InstanceCreator<DbManager>() {
    @Override
    public DbManager createInstance() {
        return new DbManager();
    }
});
```

2. 获取单例

``` Java
DbManager dbManager = InstancePool.get(DbManager.class);
```

