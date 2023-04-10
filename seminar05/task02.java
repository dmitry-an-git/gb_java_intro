import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// проверить два слова на изоморфность

public class task02 {
    public static void main(String[] args) {
        String one = "title";
        String two = "paper";
        String three = "foo";
        String four = "bar";
        

        // System.out.println(stringToMap(one).values());
        // System.out.println(stringToMap(two).values());
        System.out.println(isIso(one,two));
        System.out.println(isIso(three,four));
        System.out.println(isIso("123","556"));
        System.out.println(isIso("12223","25556"));
    }

    // public static Boolean isIso(String first, String second){
    //     if (first.length() != second.length())
    //         return false;
    //     boolean isEqual = true;
    //     for (ArrayList<Integer> list : stringToMap(first).values()) {
    //         if (!stringToMap(second).values().contains(list)) {
    //             isEqual = false;
    //             break;
    //         }
    //     }

    //     return isEqual;
    // }

    // public static Map<Character, ArrayList<Integer>> stringToMap(String str) {
    //     Map<Character, ArrayList<Integer>> hm = new HashMap<>();
    //     for (int i = 0; i < str.length(); i++) {
    //         ArrayList<Integer> temp = new ArrayList<>();
    //         if (hm.containsKey(str.charAt(i))) {
    //             temp = hm.get(str.charAt(i));
    //         }
    //         temp.add(i);
    //         hm.put(str.charAt(i),temp);
    //     }
    //     return hm;
    // }

    public static Boolean isIso(String first, String second){
            if (first.length() != second.length())
                return false;
            Map<Character,Character> map = new HashMap<>();
            for (int i = 0; i < first.length(); i++) {
                if (map.containsKey(first.charAt(i))) {
                    if (map.get(first.charAt(i)) != second.charAt(i)) {
                        return false;
                    }
                } else {
                    if (map.containsValue(second.charAt(i))) {
                        return false;
                    } else {
                    map.put(first.charAt(i), second.charAt(i));
                    }
                }
            
            }
            return true;
        }
}
