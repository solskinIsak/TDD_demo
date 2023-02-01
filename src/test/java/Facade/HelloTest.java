package Facade;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.UpperCase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {

    Hello hello;
    @BeforeEach
    void setUp() {
        hello = new Hello();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void hello(){
        String actual = hello.sayHello("Isak");
        String expected = "Hello, Isak.";
        assertEquals(expected,actual);
    }


    @Test
    public void testNameIsNull(){
        String actual = hello.sayHello(null);
        String expected = "Hello, my friend.";
        assertEquals(expected,actual);
    }
    @Test
    public void testIfNameIsShout(){
        System.out.println("Method if name is UPPERCASE");
        String actual = hello.sayHello("ISAK");
        String expected = "HELLO, ISAK!";
        assertEquals(expected,actual);
    }
    @Test
    public void testSeveralNames(){
        System.out.println("Method if theres more than 1 name");
        String[] names = new String[]{"Isak", "Kasi"};
        String actual = hello.sayHello(names);
        String expected = "Hello, Isak and Kasi.";
        assertEquals(expected,actual);
    }
    @Test
    public void oxfordCommatest(){
        System.out.println("Method if theres more than 1 name");
        String[] names = new String[]{"Isak", "Kasi", "Saki"};
        String actual = hello.sayHello(names);
        String expected = "Hello, Isak, Kasi, and Saki.";
        assertEquals(expected,actual);
    }


}
