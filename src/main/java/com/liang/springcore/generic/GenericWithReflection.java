package com.liang.springcore.generic;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

public class GenericWithReflection<T> {
    T value;
    public GenericWithReflection(T value) {
        this.value = value;
    }

    static class StringBox extends GenericWithReflection<String> {
        public StringBox(String value) {
            super(value);
        }
    }

    public static void main(String[] args) throws Exception {
        Field field = GenericWithReflection.class.getDeclaredField("value");
        Type type = field.getGenericType();
        System.out.println(type);

        GenericWithReflection<String> genericWithReflection = new GenericWithReflection<String>("Hello!");
        field = genericWithReflection.getClass().getDeclaredField("value");
        type = field.getGenericType();
        System.out.println(type);

        type = StringBox.class.getGenericSuperclass();
        System.out.println(type); // class Box<java.lang.


        //type = new TypeToken<List<String>>() {}.getType();
        //System.out.println(type); // java.util.List<java.lang.String>


    }

}
