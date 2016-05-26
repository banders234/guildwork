/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stringtests;

/**
 *
 * @author apprentice
 */
public class StringTestMethods {
    public String sayHi(String name) {
        name = "Hello " + name + "!";
        return name;
    }
    public String abba(String a, String b) {
        String abba = a + b + b + a;
        return abba;
    }
    public String makeTags(String tag, String content) {
        String result = "<" + tag + ">" + content + "</" + tag + ">";
        return result;
    }
    public String insertWord(String container, String word) {
        String result = container.substring(0,2) + word + container.substring(2);
        return result;
    }
    public String multipleEndings(String str) {
        return str.substring(str.length()-2) + str.substring(str.length()-2) + str.substring(str.length()-2);
    }
    public String firstHalf(String str) {
        return str.substring(0, str.length()/2);
    }
    public String trimOne(String str) {
        return str.substring(1, str.length()-1);
    }
    public String longInMiddle(String a, String b) {
        if (a.length() > b.length()) {
            return b + a + b;
        }
        else {
            return a + b + a;
        }
    }
    public String rotateLeft2(String str) {
        return str.substring(2) + str.substring(0,2);
    }
    public String rotateRight2(String str) {
        return str.substring(str.length()-2) + str.substring(0, str.length()-2);
    }
    public String takeOne(String str, boolean fromFront) {
        if (fromFront) {
            return str.substring(0, 1);
        }
        else {
            return str.substring(str.length()-1);
        }
    }
    public String middleTwo(String str) {
        return str.substring(str.length()/2-1, str.length()/2+1);
    }
    public boolean endsWithLy(String str) {
        if (str.length() >= 2) {
            return "ly".equals(str.substring(str.length()-2));
        }
        else {
            return false;
        }
    }
    public String frontAndBack(String str, int n) {
        return str.substring(0,n) + str.substring(str.length()-n);
    }
    public String takeTwoFromPosition(String str, int n) {
        if (str.length() >= n+2) {
            return str.substring(n, n+2);
        }
        else {
            return str.substring(0,2);
        }
    }
    public boolean hasBad(String str) {
        return "bad".equals(str.substring(0,3)) || "bad".equals(str.substring(1,4));
    }
    public String atFirst(String str) {
        if (str.length()>=2) {
            return str.substring(0,2);
        }
        else if (str.length() == 1){
            return str.substring(0,1) + "@";
        }
        else {
            return "@@";
        }
    }

    public String tweakFront(String str) {
        String first = "";
        if (str.substring(0,1).equals("a")) {
            first+= "a";
        }
        if (str.substring(1,2).equals("b")) {
            first+= "b";
        }
        return first+str.substring(2);
    }

    public String stripX(String str) {
        int start=0, end =str.length();
        if (str.substring(0,1).equals("x")) {
            start=1;
        }
        if (str.substring(str.length()-1).equals("x")) {
            end=str.length()-1;
        }
        return str.substring(start,end);
    }

    public String minCat(String a, String b) {
        if (a.length() > b.length()) {
            return a.substring(a.length()-b.length()) + b;
        }
        else if (b.length() > a.length()) {
            return a + b.substring(b.length() - a.length());
        }
        else {
            return a + b;
        }
    }

    public boolean frontAgain(String str) {
        return str.substring(0,2).equals(str.substring(str.length()-2));
    }

    public String swapLast(String str) {
        return str.substring(0,str.length()-2)+str.substring(str.length()-1) 
                +str.substring(str.length()-2,str.length()-1);
    }

    public String conCat(String a, String b) {
        if (a.length() > 0 && b.length() > 0) {
            if (a.substring(a.length()-1).equals(b.substring(0,1))) {
                return a + b.substring(1);
            }
        }
        return a + b;
    }

    public String lastChars(String a, String b) {
        if (a.length()>0 && b.length()>0) {
            return a.substring(0,1)+b.substring(b.length()-1);
        }
        else if (a.length() == 0) {
            return "@"+b.substring(b.length()-1);
        }
        else if (b.length() == 0) {
            return a.substring(0,1)+"@";
        }
        else {
            return "@@";
        }
    }
}
