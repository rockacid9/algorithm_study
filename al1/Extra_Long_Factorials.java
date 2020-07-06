package al1;

import java.math.BigInteger;
import java.util.Scanner;

public class Extra_Long_Factorials {

    static void extraLongFactorials(int n) {
        Factorials(BigInteger.valueOf(1),n);

    }
    static void Factorials(BigInteger result, int n){
        if(n>1)
        Factorials(result.multiply(BigInteger.valueOf(n)),n-1);
        else
            System.out.println(result);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
