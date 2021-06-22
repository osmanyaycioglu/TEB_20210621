package com.training.java.anno;

import java.lang.reflect.Method;

public class ReflectionRun {

    public static void main(final String[] args) {
        Class<MyAnnoTest> clazz = MyAnnoTest.class;
        MyAnno annotationClassLoc = clazz.getAnnotation(MyAnno.class);
        System.out.println("Clazz name : " + annotationClassLoc.name() + " port : " + annotationClassLoc.port());
        Method[] declaredMethodsLoc = clazz.getDeclaredMethods();
        for (Method methodLoc : declaredMethodsLoc) {
            System.out.println(methodLoc);
            MyAnno annotationLoc = methodLoc.getAnnotation(MyAnno.class);
            if (annotationLoc != null) {
                System.out.println("---MyAnno name : " + annotationLoc.name() + " port : " + annotationLoc.port());

            }
        }
    }
}
