package recursion;

/**
 *
 Given a string,compute recursively a new string where all the
 adjacent chars are now separated by a "*".
 ex:
 allStar("hello") → "h*e*l*l*o"
 allStar("abc") → "a*b*c"
 allStar("ab") → "a*b"
 */
public class AllStar {
    public String allStar(String str) {
        //allStar("hello") → "h*e*l*l*o"
        if (str.length() <=1) {
            return str;
        }
        String s = str.substring(0,1);
        return s + "*" + allStar(str.substring(1));
    }
}
