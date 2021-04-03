package com.csa.springboottest;

import java.util.Scanner;

/**
 * @author yufeng1900
 * @create 2021-04-03 19:26
 */
public class JavaTest2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        System.out.println(isPalindrome(str,0));

    }

    static boolean isPalindrome(String str,int justTimes){
        char[] chars = str.toCharArray();
        int jT = justTimes;
        for (int i = 0; i < chars.length / 2; i++) {
            if(chars[i] != chars[chars.length-i-1]){
                if(jT == 1){
                    return false;
                }else{
                    return isPalindrome(new String(chars,i,chars.length-1-2*i),1)
                            || isPalindrome(new String(chars,i+1,chars.length-1-2*i),1);
                }
            }
        }

        return true;
    }
}
