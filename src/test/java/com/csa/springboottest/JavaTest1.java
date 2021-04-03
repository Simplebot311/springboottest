package com.csa.springboottest;

import java.util.Scanner;

/**
 * @author yufeng1900
 * @create 2021-04-03 19:26
 */
public class JavaTest1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x = scan.nextDouble();
        System.out.println(toBinary(x));

    }

    static String toBinary(double x){
        String str="0.";
        while(x != 0 && str.length()<33){
            x*=2;
            if(x>=1){
                x--;
                str = str + "1";
            }else{
                str = str + "0";
            }
        }

        if(x==0.0){
            return str;
        }else{
            return "ERROR";
        }
    }
}
