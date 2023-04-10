import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class task03 {
    public static void main(String[] args) {
        String equation = "aaa+((<{a+b}>)*c+[{d}+e])*f";
        
        Map<Character,Character> br = new HashMap<>();
        br.put('[',']');
        br.put('{','}');
        br.put('<','>');
        br.put('(',')');
        
        System.out.println(checkBrackets(equation, br));
        

        Map<Character,Character> br_inv = new HashMap<>();
        String[] array = new String[]{"{}", "[]", "()", "<>"};
        for (String item : array) {
            br_inv.put(item.charAt(1),item.charAt(0));
        }
        System.out.println(checkBrackets2(equation, br_inv));
        
        
    }

    public static boolean checkBrackets2(String str, Map<Character,Character> br_inv) {
        char[] str_array = str.toCharArray();
        Stack<Character> st = new Stack<>();
   
        // if open - add, if closed - pop
        for (int index = 0; index < str_array.length; index++) {
            if (br_inv.containsKey(str_array[index])) { // if we have "]"
                if (st.empty() || st.pop() != br_inv.get(str_array[index]))
                    return false;
            }
            if (br_inv.containsValue(str_array[index])) {
                st.add(str_array[index]);
            }
        }
        return st.isEmpty();
    }
        
    public static boolean checkBrackets(String str, Map<Character,Character> br) {
        
        boolean center = true;
        boolean after = true;

        for (int i = 0; i < str.length(); i++) {
            
            if (br.containsValue(str.charAt(i))) {
                return false; 
            }

            if (br.containsKey(str.charAt(i))) {
                center = false; 
                for (int j = str.length()-1; j > i; j--) {
                    if (str.charAt(j) == br.get(str.charAt(i))) {
                        center = checkBrackets(str.substring(i+1, j), br);
                        after = checkBrackets(str.substring(j+1), br);
                        break;
                    }
                }
                break;
            }
        }
        return (center && after);
    }

}

