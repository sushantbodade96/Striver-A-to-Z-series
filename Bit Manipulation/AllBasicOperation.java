
public class AllBasicOperation {

    public static Boolean checkIthBitSet(int number, int pos) {
        if ((number & (1 << pos)) == 0) {
            return false;
        }
        return true;
    }

    public static Boolean isOdd(int number) {
        if ((number & 1) == 1) {
            return true;
        }
        return false;
    }

    public static Boolean isPowerOfTwo(int number) {
        if ((number & (number - 1)) == 0) {
            return true;
        }
        return false;
    }

    public static int totalSetBits(int number) {
        int count = 0;
        while (number > 0) {
            count += number & 1;
            number = number >> 1;
        }
        return count;
    }

    public static int setRightmostUnsetBit(int number) {
        // Formula: number | (number + 1)
        return number | (number + 1);
    }

    public static void swap(int a, int b) {
        System.out.println("a = " + a + ", b = " + b);
        a = a ^ b;
        b = a - b;
        a = a - b;
        System.out.println("a = " + a + ", b = " + b);

    }

    public static void main(String args[]) {
        System.out.println(checkIthBitSet(5, 2));
        System.out.println(isOdd(8));
        System.out.println(isPowerOfTwo(64));
        System.out.println(totalSetBits(63));
        System.out.println(setRightmostUnsetBit(44));
        swap(5, 10);

    }
}
