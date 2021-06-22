package com.training.java.anno;

@MyAnno(name = "clazzMy", port = 9090)
public class MyAnnoTest {

    @MyAnno(name = "osman", port = 8080)
    public void run() {
        System.out.println("test");
    }

    public void method1() {
        System.out.println("test");
    }

    @MyAnno(name = "ayşe", port = 8081)
    public void tests() {
        System.out.println("test");
    }


}
