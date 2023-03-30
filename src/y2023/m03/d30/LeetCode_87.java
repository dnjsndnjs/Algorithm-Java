package y2023.m03.d30;

import java.util.*;

public class LeetCode_87 {

  public static void main(String[] args) {
    LeetCode_87 s = new LeetCode_87();
    String s1, s2;
//    s1 = "great"; s2 = "rgeat";
//    System.out.println(s.isScramble(s1, s2));
//    System.out.println();
//    s1 = "abcde"; s2 = "caebd";
//    System.out.println(s.isScramble(s1, s2));
//    System.out.println();
//    s1 = "a"; s2 = "a";
//    System.out.println(s.isScramble(s1, s2));
//    System.out.println();
//    s1 = "abcdbdacbdac"; s2 = "bdacabcdbdac";
//    System.out.println(s.isScramble(s1, s2));
//    System.out.println();
    s1 = "xstjzkfpkggnhjzkpfjoguxvkbuopi"; s2 = "xbouipkvxugojfpkzjhnggkpfkzjts";
    System.out.println(s.isScramble(s1, s2));
  }

  static final int anum = 'z'-'a'+1;
  static Map<String, Boolean> map = new HashMap<>();
  
  public boolean isScramble(String s1, String s2) {
//    System.out.println(s1+" "+s2);
    if (map.containsKey(s1+" "+s2))
      return map.get(s1+" "+s2);
    int len = s1.length();
    if (len == 1 && s1.equals(s2))
      return true;
    if (len == 2
        && s1.charAt(0) == s2.charAt(1)
        && s1.charAt(1) == s2.charAt(0))
      return true;
    if (s1.equals(s2)) return true;
    int[] arr1 = new int[anum], arr2 = new int[anum], arr3 = new int[anum];
    boolean res = false;
    for (int i = 0; i < len-1; i++) {
      arr1[s1.charAt(i)-'a']++;
      arr2[s2.charAt(i)-'a']++;
      arr3[s2.charAt(len-1-i)-'a']++;
      if (isEqual(arr1, arr2)) {
        res |= isScramble(s1.substring(0, i+1), s2.substring(0, i+1))
            & isScramble(s1.substring(i+1), s2.substring(i+1));
      }
      if (isEqual(arr1, arr3)) {
        res |= isScramble(s1.substring(0, i+1), s2.substring(len-1-i))
            & isScramble(s1.substring(i+1), s2.substring(0, len-1-i));
      }
    }
    map.put(s1+" "+s2, res);
    return res;
  }
  
  boolean isEqual(int[] arr1, int[] arr2) {
    for (int i = 0; i < anum; i++)
      if (arr1[i] != arr2[i])
        return false;
    return true;
  }
}
