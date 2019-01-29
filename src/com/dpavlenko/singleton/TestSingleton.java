package com.dpavlenko.singleton;

/**
 * Created by denys.pavlenko on 8/17/2017.
 */
public class TestSingleton {

    public DbSingleton mySingleton2 = DbSingleton.getInstance();

    public void out() {
        System.out.println(mySingleton2);
    }
}
