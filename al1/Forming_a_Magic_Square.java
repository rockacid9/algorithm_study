package al1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class Forming_a_Magic_Square {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("result.txt"));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(s[i][j]);
//            }
//            System.out.println();
//        }

        int result = formingMagicSquare(s);
        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    static int formingMagicSquare(int[][] s) {
        ArrayList<Integer[][]> pre = new ArrayList<>();
//        8 3 4
//        1 5 9
//        6 7 2
        pre.add(new Integer[][]{{8,3,4},{1,5,9},{6,7,2}});
        pre.add(new Integer[][]{{4,3,8},{9,5,1},{2,7,6}});

        pre.add(new Integer[][]{{4,9,2},{3,5,7},{8,1,6}});
        pre.add(new Integer[][]{{2,9,4},{7,5,3},{6,1,8}});

        pre.add(new Integer[][]{{2,7,6},{9,5,1},{4,3,8}});
        pre.add(new Integer[][]{{6,7,2},{1,5,9},{8,3,4}});

        pre.add(new Integer[][]{{6,1,8},{7,5,3},{2,9,4}});
        pre.add(new Integer[][]{{8,1,6},{3,5,7},{4,9,2}});

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int temp = 0;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    temp+=abs(pre.get(i)[j][k]-s[j][k]);
                }
            }
            result.add(temp);
        }
        return Collections.min(result);
    }
    
}

