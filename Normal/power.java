
class power {

    public static double myPow(double x, int n) {
        double ans = 1;
        int nn = n;
        if (nn < 0) {
            nn *= -1;
        }

        while (nn > 0) {
            if (nn % 2 == 0) {
                x = x * x;
                nn /= 2;
            } else {
                ans = ans * x;
                nn--;
            }
        }
        if (n < 0) {
            return (double) 1 / ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }
}
