
import java.util.Scanner;

class cipher {

    public static String encoded(String str, int x) {
        x = x % 26;
        String op = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))) {
                return "Invalid String!!";
            }
            if (ch == 'Z') {
                op += (char) ('A' + (x - 1));
                continue;
            }
            if (ch == 'z') {
                op += (char) ('a' + (x - 1));
                continue;
            }
            op += (char) (ch + x);
        }
        return op;
    }

    public static void main(String[] args) {
        // String s = "A3BCD";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String");
        String s = sc.nextLine();
        System.out.println("Enter the shift value");
        int x = sc.nextInt();
        System.out.println(encoded(s, x));
    }
}
