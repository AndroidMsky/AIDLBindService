// IMyAidlService.aidl
package com.air.service;

// Declare any non-default types here with import statements

interface IMyAidlService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
     void play(int i);
     int  add(int i);

    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

}
