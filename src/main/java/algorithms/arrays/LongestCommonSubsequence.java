package algorithms.arrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class LongestCommonSubsequence {

  public static void main(String[] args) throws IOException {
//    String s1 = "NOHARAAA" ;
//    String s2 = "SHINCHAN" ;

    // String s1 = "SHINCHAN" ;
    //String s2 =  "NOHARAAA" ;
    // A -> {6}, C -> {4}, H -> {1,5}, I -> {2}, N -> {3,7}, S -> {0}
    //A -> {3,5,6,7}, H -> {2}, O{1}, N{0}, R->{4}

    String s1 = "GXTXAYB";
    String s2 = "AGGTAB";

    System.out.println(longest_common_subsequence(s1,s2));
  }

  /*        b->
           AGGTAB
      G
      X
 a    T
 |    X
 v    A
      Y
      B
   */

  public static String longest_common_subsequence(String a, String b) {
    int[][] lengths = new int[a.length()+1][b.length()+1];

    // row 0 and column 0 are initialized to 0 already

    for (int i = 0; i < a.length(); i++) {
      for (int j = 0; j < b.length(); j++) {
        if (a.charAt(i) == b.charAt(j)) {
          lengths[i + 1][j + 1] = lengths[i][j] + 1;
        } else {
          lengths[i + 1][j + 1] = Math.max(lengths[i + 1][j], lengths[i][j + 1]);
        }
      }
    }

    for(int i=0;i<lengths.length;i++) {
      System.out.println(Arrays.toString(lengths[i]));
    }

    // read the substring out from the matrix
    StringBuffer sb = new StringBuffer();
    for (int x = a.length(), y = b.length(); x != 0 && y != 0; ) {
      int xy = lengths[x][y];
      int x_1y = lengths[x-1][y];
      int xy_1 = lengths[x][y-1];

      if (lengths[x][y] == lengths[x-1][y]) {
        x--;
      } else if (lengths[x][y] == lengths[x][y-1]) {
        y--;
      } else {
        assert a.charAt(x-1) == b.charAt(y-1);
        sb.append(a.charAt(x-1));
        x--;
        y--;
      }
    }

    return sb.reverse().toString();
  }



  static int commonChild2(String s1, String s2) {

    Map<Character, List<Integer>> map1 = getChars(s1);
    Map<Character, List<Integer>> map2 = getChars(s2);

    for(int i=0;i<s1.length();i++){

    }
    return -1;
  }

  // Complete the commonChild function below.
  static int commonChild(String s1, String s2) {
    if(s1.equals(s2)){
      return s1.length();
    }

    Map<Character, List<Integer>> map1 = getChars(s1);
    Map<Character, List<Integer>> map2 = getChars(s2);

    for(Character c: new HashSet<>(map2.keySet())){
      if(map1.get(c)==null){
        map2.remove(c);
      }
    }

    for(Character c: new HashSet<>(map1.keySet())){
      if(map2.get(c)==null){
        map1.remove(c);
      }
    }

    for(Character c: new HashSet<>(map1.keySet())){
      System.out.println(c + " ->" + map1.get(c));
    }

    System.out.println();
    for(Character c: new HashSet<>(map2.keySet())){
      System.out.println(c + " ->" + map2.get(c));
    }


    Map<Integer, Character> map11 = new HashMap<>();

    for(Character c: map1.keySet()){
      for(Integer index: map1.get(c)) {
        map11.put(index, c);
      }
    }


    Map<Integer, Character> map22 = new HashMap<>();

    for(Character c: map2.keySet()){
      for(Integer index: map2.get(c)) {
        map22.put(index, c);
      }
    }


    System.out.println(map11);
    System.out.println(map22);

    return -1;

  }


  static Map<Character, List<Integer>> getChars(String s1){
    Map<Character, List<Integer>> map = new HashMap<>();

    for(int i=0;i<s1.length();i++){
      char c = s1.charAt(i);
      if(map.get(c)==null){
        map.put(c, new ArrayList<>());
      }
      map.get(c).add(i);
    }
    return map;
  }


}
