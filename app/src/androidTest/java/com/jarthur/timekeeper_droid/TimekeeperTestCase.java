package com.jarthur.timekeeper_droid;

import junit.framework.TestCase;

/**
 * Created by arthur on 4/7/16.
 */
public class TimekeeperTestCase extends TestCase{

    public <T> Object assertTypeAndGet(Class<T> expectedType, Object actualObject){
        assertEquals(expectedType, actualObject.getClass());
        return actualObject;
    }
}
