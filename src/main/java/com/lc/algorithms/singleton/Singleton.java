package com.lc.algorithms.singleton;

/**
 * 双重检查的线程安全单例模式
 */
public class Singleton {

    /**
     * 声明私有实例对象，注意增加volatile标识，用来保证线程之间的可见性
     */
    private static volatile Singleton instance;

    /**
     * 私有化构造方法，禁止外部通过new方式创建得到实例
     */
    private Singleton() {
    }

    public static Singleton getInstance() {
        // 如果当前实例为空，则进行实例创建
        if (null == instance) {
            // 在实例创建过程中，避免多线程同时创建对象，违背单例模式，则使用synchronized对创建实例的代码段加锁
            synchronized (Singleton.class) {
                // 双重检查，因为对象创建过程分3步，并非原子性的
                if (null == instance) {
                    instance = new Singleton();
                }
            }
        }
        // 若是不为空或者创建完成后，返回实例对象
        return instance;
    }
}
