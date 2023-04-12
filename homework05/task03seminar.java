import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class task03seminar {
    public static void main(String[] args) {
        String equation = "aaa+((<{a+b}>)*c+[{d}+e])*f";
        
        Map<Character,Character> br = new HashMap<>();
        br.put('[',']');
        br.put('{','}');
        br.put('<','>');
        br.put('(',')');
        
        System.out.println(checkBrackets(equation, br));
        
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

