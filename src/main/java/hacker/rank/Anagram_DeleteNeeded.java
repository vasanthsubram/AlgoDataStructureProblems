package hacker.rank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * We consider two strings to be anagrams of each other if the first string's letters
 * can be rearranged to form the second string. In other words, both strings must contain
 * the same exact letters in the same exact frequency For example, bacdc and dcbac are anagrams,
 * but bacdc and dcbad are not.
 *
 *Given two strings,  and , that may or may not be of the same length,
 * determine the minimum number of character deletions required to make  and  anagrams.
 * Any characters can be deleted from either of the strings.
 *
 * Created by vasanth on 11/20/16.
 */
public class Anagram_DeleteNeeded {
    public static int numberNeeded(String first, String second) {
        Map<Character,Integer> a_map = countAlpha(first);
        Map<Character,Integer> b_map = countAlpha(second);
        int count=0;
        for(char c='a';c<='z';c++){
            count = count + Math.abs(a_map.get(c)-b_map.get(c));
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }

    private static Map countAlpha(String s){
        Map<Character,Integer> map=new HashMap<Character,Integer>(26);
        for(char c='a';c<='z';c++){
            map.put(c,0);
        }
        for(Character c: s.toCharArray()){
            map.put(c, map.get(c)+1);
        }
        return map;
    }
}