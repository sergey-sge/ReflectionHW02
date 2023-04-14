package com.gmail.sge.serejka;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        TextContainer textContainer = new TextContainer();
        checkTextContainer(textContainer);
    }

    public static void checkTextContainer(TextContainer textContainer) {
        Class textClass = textContainer.getClass();
        SaveTo saveTo = (SaveTo) textClass.getAnnotation(SaveTo.class);
        String path = saveTo.path();
        Method[] methods = textClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Saver.class)) {
                try {
                    method.invoke(textContainer, path);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}