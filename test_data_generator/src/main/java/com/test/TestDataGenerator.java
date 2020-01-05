package com.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class TestDataGenerator {

    public Field setField(Object o, Field f) throws IllegalAccessException {

        f.setAccessible(true);

        if (f.getType().equals(String.class)) {
            f.set(o, "test");
        } else if ((f.getType().equals(Integer.class))){
            f.set(o, (int) (Math.random() * 1000));
        } else if ((f.getType().equals(Long.class))){
            f.set(o, (long) (Math.random() * 1000));
        }
        return f;
    }

    public <T> T getTestObject(Class<T> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Constructor<T> constructor = clazz.getConstructor();
        T newInstance = constructor.newInstance();

        List<Field> fields = Arrays.asList(newInstance.getClass().getDeclaredFields());

        fields.forEach(field -> {
            try {
                setField(newInstance, field);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return newInstance;
    }
}
