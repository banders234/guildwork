/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.stringtests.StringTestMethods;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class StringTest {
    StringTestMethods stm = new StringTestMethods();
    public StringTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void sayHiTest() {
        String result=stm.sayHi("Bob");
        Assert.assertEquals("Hello Bob!", result);
        result=stm.sayHi("Alice");
        Assert.assertEquals("Hello Alice!", result);
        result=stm.sayHi("X");
        Assert.assertEquals("Hello X!", result);
    }
    @Test
    public void abbaTest() {
        String result=stm.abba("Hi", "Bye");
        Assert.assertEquals("HiByeByeHi", result);
        result=stm.abba("Yo", "Alice");
        Assert.assertEquals("YoAliceAliceYo", result);
        result=stm.abba("What", "Up");
        Assert.assertEquals("WhatUpUpWhat", result);
    }
    @Test
    public void makeTagsTest() {
        String result=stm.makeTags("i", "Yay");
        Assert.assertEquals("<i>Yay</i>", result);
        result=stm.makeTags("i", "Hello");
        Assert.assertEquals("<i>Hello</i>", result);
        result=stm.makeTags("cite", "Yay");
        Assert.assertEquals("<cite>Yay</cite>", result);
    }
    @Test
    public void insertWordTest() {
        String result=stm.insertWord("<<>>", "Yay");
        Assert.assertEquals("<<Yay>>", result);
        result=stm.insertWord("<<>>", "WooHoo");
        Assert.assertEquals("<<WooHoo>>", result);
        result=stm.insertWord("[[]]", "word");
        Assert.assertEquals("[[word]]", result);
    }
    @Test
    public void multipleEndingsTest() {
        String result=stm.multipleEndings("Hello");
        Assert.assertEquals("lololo", result);
        result=stm.multipleEndings("ab");
        Assert.assertEquals("ababab", result);
        result=stm.multipleEndings("Hi");
        Assert.assertEquals("HiHiHi", result);
    }
    @Test
    public void firstHalfTest() {
        String result = stm.firstHalf("WooHoo");
        Assert.assertEquals("Woo", result);
        result = stm.firstHalf("HelloThere");
        Assert.assertEquals("Hello", result);
        result = stm.firstHalf("abcdef");
        Assert.assertEquals("abc", result);
    }
    @Test
    public void trimOneTest() {
        String result = stm.trimOne("Hello");
        Assert.assertEquals("ell", result);
        result = stm.trimOne("java");
        Assert.assertEquals("av", result);
        result = stm.trimOne("coding");
        Assert.assertEquals("odin", result);
    }
    @Test
    public void longInMiddleTest() {
        String result = stm.longInMiddle("Hello", "hi");
        Assert.assertEquals("hiHellohi", result);
        result = stm.longInMiddle("hi", "Hello");
        Assert.assertEquals("hiHellohi", result);
        result = stm.longInMiddle("aaa", "b");
        Assert.assertEquals("baaab", result);
    }
    @Test
    public void rotateLeft2Test() {
        String result = stm.rotateLeft2("Hello");
        Assert.assertEquals("lloHe", result);
        result = stm.rotateLeft2("java");
        Assert.assertEquals("vaja", result);
        result = stm.rotateLeft2("Hi");
        Assert.assertEquals("Hi", result);
    }
    @Test
    public void rotateRight2Test() {
        String result = stm.rotateRight2("Hello");
        Assert.assertEquals("loHel", result);
        result = stm.rotateRight2("java");
        Assert.assertEquals("vaja", result);
        result = stm.rotateRight2("Hi");
        Assert.assertEquals("Hi", result);
    }
    @Test
    public void takeOneTest() {
        String result = stm.takeOne("Hello", true);
        Assert.assertEquals("H", result);
        result = stm.takeOne("Hello", false);
        Assert.assertEquals("o", result);
        result = stm.takeOne("oh", true);
        Assert.assertEquals("o", result);
    }
    @Test
    public void middleTwoTest() {
        String result = stm.middleTwo("string");
        Assert.assertEquals("ri", result);
        result = stm.middleTwo("code");
        Assert.assertEquals("od", result);
        result = stm.middleTwo("Practice");
        Assert.assertEquals("ct", result);
    }
    @Test
    public void endsWithLyTest() {
        boolean result = stm.endsWithLy("oddly");
        Assert.assertEquals(true, result);
        result = stm.endsWithLy("y");
        Assert.assertEquals(false, result);
        result = stm.endsWithLy("oddy");
        Assert.assertEquals(false, result);
    }
    @Test
    public void frontAndBackTest() {
        String result = stm.frontAndBack("Hello", 2);
        Assert.assertEquals("Helo", result);
        result = stm.frontAndBack("Chocolate", 3);
        Assert.assertEquals("Choate", result);
        result = stm.frontAndBack("Chocolate", 1);
        Assert.assertEquals("Ce", result);
    }
    @Test
    public void takeTwoFromPositionTest() {
        String result = stm.takeTwoFromPosition("java", 0);
        Assert.assertEquals("ja", result);
        result = stm.takeTwoFromPosition("java", 2);
        Assert.assertEquals("va", result);
        result = stm.takeTwoFromPosition("java", 3);
        Assert.assertEquals("ja", result);
    }
    @Test
    public void hasBadTest() {
        boolean result = stm.hasBad("badxx");
        Assert.assertEquals(true, result);
        result = stm.hasBad("xbadxx");
        Assert.assertEquals(true, result);
        result = stm.hasBad("xxbadxx");
        Assert.assertEquals(false, result);
    }
    @Test
    public void atFirstTest() {
        String result = stm.atFirst("hello");
        Assert.assertEquals("he", result);
        result = stm.atFirst("hi");
        Assert.assertEquals("hi", result);
        result = stm.atFirst("h");
        Assert.assertEquals("h@", result);
    }
    @Test
    public void lastChars() {
        String result = stm.lastChars("last", "chars");
        Assert.assertEquals("ls", result);
        result = stm.lastChars("yo", "mama");
        Assert.assertEquals("ya", result);
        result = stm.lastChars("hi", "");
        Assert.assertEquals("h@", result);
    }
    @Test
    public void conCatTest() {
        String result = stm.conCat("abc", "cat");
        Assert.assertEquals("abcat", result);
        result = stm.conCat("dog", "cat");
        Assert.assertEquals("dogcat", result);
        result = stm.conCat("abc", "");
        Assert.assertEquals("abc", result);
    }
    @Test
    public void swapLastTest() {
        String result = stm.swapLast("coding");
        Assert.assertEquals("codign", result);
        result = stm.swapLast("cat");
        Assert.assertEquals("cta", result);
        result = stm.swapLast("ab");
        Assert.assertEquals("ba", result);
    }
    @Test
    public void frontAgainTest() {
        boolean result = stm.frontAgain("edited");
        Assert.assertEquals(true, result);
        result = stm.frontAgain("edit");
        Assert.assertEquals(false, result);
        result = stm.frontAgain("ed");
        Assert.assertEquals(true, result);
    }
    @Test
    public void minCatTest() {
        String result = stm.minCat("Hello", "Hi");
        Assert.assertEquals("loHi", result);
        result = stm.minCat("Hello", "java");
        Assert.assertEquals("ellojava", result);
        result = stm.minCat("java", "Hello");
        Assert.assertEquals("javaello", result);
    }
    @Test
    public void tweakFrontTest() {
        String result = stm.tweakFront("Hello");
        Assert.assertEquals("llo", result);
        result = stm.tweakFront("away");
        Assert.assertEquals("aay", result);
        result = stm.tweakFront("abed");
        Assert.assertEquals("abed", result);
    }
    @Test
    public void stripXTest() {
        String result = stm.stripX("xHix");
        Assert.assertEquals("Hi", result);
        result = stm.stripX("xHi");
        Assert.assertEquals("Hi", result);
        result = stm.stripX("Hxix");
        Assert.assertEquals("Hxi", result);
    }
}
