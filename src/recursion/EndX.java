package recursion;

/**
 *
 Given a string, compute recursively a new string where all the lowercase 'x' chars have been moved to the end of the string.



 endX("xxre") → "rexx"
 endX("xxhixx") → "hixxxx"
 endX("xhixhix") → "hihixxx"
 */
public class EndX {
    public String endX(String str) {
        if (str.length() <= 1) {
            return str;
        }
        if (str.substring(0,1).equals("x")) {
            return endX(str.substring(1)) + str.substring(0,1);
        } else {
            return str.substring(0,1) + endX(str.substring(1));
        }
    }
}
