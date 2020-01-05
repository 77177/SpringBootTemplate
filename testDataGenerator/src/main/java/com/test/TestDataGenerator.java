package com.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class TestDataGenerator {

    public <T> T getTestObject(Class<T> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Constructor<T> constructor = clazz.getConstructor();
        T newInstance = constructor.newInstance();

        List<Field> fields = Arrays.asList(newInstance.getClass().getDeclaredFields());


        return newInstance;
    }
}
