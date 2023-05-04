package recursion;

/**
 * Given a string, return recursively a "cleaned" string where adjacent chars that
 * are the same have been reduced to a single char. So "yyzzza" yields "yza".
 *
 *
 * stringClean("yyzzza") → "yza"
 * stringClean("abbbcdd") → "abcd"
 * stringClean("Hello") → "Helo"
 */
public class StringClean {
    public String stringClean(String str) {
        if (str.length() <= 1){
            return str;
        }
        int index = 1;
        while (index < str.length()){
            if (str.charAt(0) != str.charAt(index)) {
                break;
            }
            index++;
        }
        return str.charAt(0) + stringClean(str.substring(index));
    }
}
