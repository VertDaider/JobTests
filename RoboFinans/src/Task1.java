import java.math.BigInteger;

public class Task1 {
    public static void main(String[] args) {
        final int COUNT = 4000000;
        BigInteger sum = getSum(COUNT);
        System.out.println(sum);
    }

    private static BigInteger getSum(int n) {
        BigInteger sum = BigInteger.valueOf(0);
        BigInteger fibonacci = BigInteger.valueOf(1);
        BigInteger tmp1 = BigInteger.valueOf(1);
        int i = 2;
        while (i <= n) {
            BigInteger tmp2 = tmp1;
            tmp1 = fibonacci;
            fibonacci = tmp2.add(tmp1);
            if (i % 2 == 0) {
                sum = sum.add(fibonacci);
                //System.out.println(sum);
            }
            i++;

        }
        return sum;
    }
}
