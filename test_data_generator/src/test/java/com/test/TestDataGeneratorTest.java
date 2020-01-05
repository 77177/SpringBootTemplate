package com.test;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestDataGeneratorTest {

    private TestDataGenerator testDataGeneratorUnderTest = new TestDataGenerator();

    @Test
    public void testGetTestObject() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        TestClass testObject = testDataGeneratorUnderTest.getTestObject(TestClass.class);

        List<Field> fields = Arrays.asList(testObject.getClass().getDeclaredFields());

        long count = fields.stream().filter(field -> {
            boolean returnValue = false;
            try {
                field.setAccessible(true);
                returnValue = (field.get(testObject)) == null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return returnValue;
        }
        ).count();

        assertEquals(0, count);

    }

}
