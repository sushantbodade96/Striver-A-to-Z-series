
import java.util.Arrays;

public class divideStringArray {

    public static String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int fillRequired = (k - n % k) % k;

        for (int i = 0; i < fillRequired; i++) {
            s += fill;
        }

        int totalLen = s.length();
        String[] str = new String[totalLen / k];

        for (int i = 0; i < totalLen; i += k) {
            String newstr = "";
            for (int j = i; j < i + k; j++) {
                newstr += s.charAt(j);
            }
            str[i / k] = newstr;
        }

        return str;
    }

    public static void main(String[] args) {
        String s = "acdefgi";
        String[] j = divideString(s, 3, 'x');
        System.out.println(Arrays.toString(j));
    }

}
