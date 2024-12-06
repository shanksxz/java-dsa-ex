import java.util.HashMap;

public class Anagram {

  public static boolean isAnagram(String s1, String s2) {
    if(s1.length() != s2.length()) return false;

    HashMap<Character, Integer> map = new HashMap<>();

    for(char c : s1.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for(char c : s2.toCharArray()) {
      if(!map.containsKey(c)) return false;
    }
  }

  public static void main(String[] args) {
    String s1 = "listen";
    String s2 = "silent";

    
  }
}
