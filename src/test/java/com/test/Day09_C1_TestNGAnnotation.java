package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Day09_C1_TestNGAnnotation {
    /*
    @Test test caseleri oluşturmak için kallanılır testNG
    @BeforeMethod her bir @Test anotationdan önce kasması için kaullanılır, Junit @Befor ile aynı
    @AfterMethad her bir @Test annotationdan sonra kosması için kullanlır
    @Ignore bir @Test annotation atlamak için kullanılır
    @Test(anable=false) durumunda @Test annotation atlamak için kullanılır -- @Ignore gibidir

    Test caseleri sıralayabilirz
    TestNG test caseleri alfabetik sıraya göre koşturur-yukarıdan aşagıya doğru çalıştırmaz

    Test case için priority kullanarak sıralama yapabilirzi

    orn: @Test (priority=1)
     */

    @BeforeMethod
    public void setUp(){
        System.out.println("Before method kullandik");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("After method kullandik");
    }
    @Test (priority = 2)
    public void test6(){
        System.out.println("Test6");
    }

    @Test (enabled = false)
    public void test2(){
        System.out.println("Test2");
    }
    @Ignore  // bu testi koşturmaz
    @Test
    public void test3(){
        System.out.println("Test3");
    }
    @Test (priority = -1)
    public void test4(){
        System.out.println("Test4");
    }
    @Test (groups ="test-group-1" , priority = -3)
    public void test5(){
        System.out.println("Test5");
    }
    @Test (priority = 1)
    public void test7(){
        System.out.println("Test7");
    }
}
