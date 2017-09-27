package com.example.java;

public class Main {

    public static void main(String[] args) {

        /*
            This program is a solution to CCI book problem 1.5 One Away. Where two strings are compared to see if the
            strings are equal, one character edit difference due to an insertion, or one character edit difference due
            to a replacement.
         */
        String str1 = "pale", str2 = "ple";
        boolean result;

        result = oneEditAway(str1, str2);
        System.out.println(result);

        str1 = "pales";
        str2 = "pale";

        result = oneEditAway(str1, str2);
        System.out.println(result);

        str1 = "pale";
        str2 = "bale";

        result = oneEditAway(str1, str2);
        System.out.println(result);

        str1 = "pale";
        str2 = "bae";

        result = oneEditAway(str1, str2);
        System.out.println(result);


    }

    /*
        This oneEditAway method will accept two string object parameters and then evaluate if one of the following
        two methods to invoke depending on the comparison of the length of both string objects.
     */
    static boolean oneEditAway(String first, String second) {

        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        }
        if (first.length() > second.length()) {
            return oneEditInsert(first, second);
        }
        if (first.length() < second.length()) {
            return oneEditInsert(first, second);
        }

        return false;

    }

    /*
        This method oneEditReplace will accept two string objects parameters and set a boolean flag foundDifference
        to false. A loop will compare each character of both string objects. If more than one edit difference is
        found then return false, but if only one edit is found then return true.
     */
    static boolean oneEditReplace(String s1, String s2) {

        boolean foundDifference = false;    //set found single diff to false

        for (int i = 0; i < s1.length(); i++) {

            if (s1.charAt(i) != s2.charAt(i)) {

                //if found more than one edit replace then exit and return false.
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }

        }
        return true;


    }

    /*
        This method oneEditInsert will accept two string objects parameters.  A loop will compare each character of
         both string objects. If more than one edit difference is found then return false, but if only one edit is
         found then return true.
     */
    static boolean oneEditInsert(String s1, String s2) {


        int index1 = 0, index2 = 0;

        while (index1 < s1.length() && index2 < s2.length()) {

            if (s1.charAt(index1) != s2.charAt(index2)) {

            //if found more than one edit of insert or delete then exit and return false.
                if (index1 != index2) {
                    return false;
                }
                index1++;
            } else {
                index1++;
                index2++;
            }
        }

        return true;

    }
}



