package al1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Climbing_the_Leaderboard {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("result.txt"));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }
        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);

        }
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        ArrayList<Integer> ranks = new ArrayList<>();
        ranks.add(scores[0]);
        for (int i = 1; i < scores.length ; i++) {
            if(ranks.get(ranks.size()-1)!=scores[i]) {
                ranks.add(scores[i]);
            }
        }
        int[] result = new int[alice.length];
        for (int i = 0; i <alice.length ; i++) {
            result[i] = getRank(ranks,alice[i]);
        }
        return result;
    }

    static int getRank(ArrayList<Integer> ranks, int score){
        int mid=0;
        int left = 0;
        int right = ranks.size() - 1;
        boolean ishere = false;
        if(ranks.get(0)<=score)
            return 1;
        else if(ranks.get(ranks.size()-1)>score)
            return ranks.size()+1;
        while (right >= left) {
            mid = (right + left) / 2;

            if (score == ranks.get(mid)) {
                ishere=true;
                break;
            }

            if (score > ranks.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        if(ishere)
            return mid+1;
        else
            return left+1;
    }
}
