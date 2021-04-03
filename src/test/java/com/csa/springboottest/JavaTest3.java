package com.csa.springboottest;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author yufeng1900
 * @create 2021-04-03 19:26
 */
public class JavaTest3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();
        str = str.replaceAll("[\\]\\[]","");
        String[] str0 = str.split("\"\\,\"");
        System.out.println(isMerged(3, str0, -1));

        String[] target = reset(str0);
        String ans = "";
        for (int i = 0; i < target.length; i++) {
            if(isMerged(i,target,-1)){
                if(ans.equals("")){
                    ans = reset(str0)[i];
                }else if(ans.compareTo(reset(str0)[i])>0){
                    ans = reset(str0)[i];
                }
            }
        }

        System.out.println(ans);


    }

    static String[] reset(String[] strings){
        String[] str0 = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            str0[i] = strings[i];
        }
        return str0;
    }

    static String[] getMaxStrings(String str[]){
        LinkedList<String> ans = new LinkedList<>();
        int maxLen = 0;
        for (int i = 0; i < str.length; i++) {
            maxLen = (maxLen>str[i].length())?maxLen:str[i].length();
        }

        for (int i = 0; i < str.length; i++) {
            if(str[i].length() == maxLen){
                ans.add(str[i]);
            }
        }

        return ans.toArray(new String[0]);
    }


    static boolean isMerged(int i,String[] target,int k){

        if(k>=0){
            target[i] = target[i].replaceAll(target[k],"");
            target[k] = " ";
        }

        String str = target[i];
        for (int j = 0; j < target.length; j++) {
            if(str.indexOf(target[j])>=0 && i != j){
                return isMerged(i,reset(target),j) || isMerged(i,reset(target),-1);
            }
        }

        if(target[i].equals("")){
            return true;
        }else{
            return false;
        }
    }

}
