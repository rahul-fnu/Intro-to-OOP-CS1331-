//I worked on the homework assignment alone, using only course materials.
import java.util.Scanner;
import java.util.Random;
public class CoinFlip {
    public static void main(String[] args) {
        String repeat = "y";
        Random myRandom = new Random();
        int i;
        Scanner myScanner = new Scanner(System.in);
        String x;
        boolean a = true;
        while (repeat.equals("y")) {
            int h;
            int t;
            int sequence;
            int heads;
            int tails;
            int maximum = 0;
            int flip = 0;
            System.out.print("Ready to run a coin flip simulation. Enter the number of sequences: ");
            sequence = myScanner.nextInt();
            if (sequence < 0) {
                for (int j = 1; j > 0; j++) {
                    System.out.print("Would you like to run another simulation? (y/n): ");
                    x = myScanner.next();
                    if (x.equals("n") || x.equals("y")) {
                        repeat = x;
                        break;
                    } else {
                        continue;
                    }
                }
                if (repeat.equals("y")) {
                    continue;
                } else {
                    break;
                }
            }
            System.out.print("How many heads should each sequence have? ");
            heads = myScanner.nextInt();
            if (heads < 0) {
                for (int k = 1; k > 0; k++) {
                    System.out.print("Would you like to run another simulation? (y/n): ");
                    x = myScanner.next();
                    if (x.equals("n") || x.equals("y")) {
                        repeat = x;
                        break;
                    } else {
                        continue;
                    }
                }
                if (repeat.equals("y")) {
                    continue;
                } else {
                    break;
                }
            }
            System.out.print("How many tails should each sequence have? ");
            tails = myScanner.nextInt();
            if (tails < 0) {
                for (int l = 1; l > 0; l++) {
                    System.out.print("Would you like to run another simulation? (y/n): ");
                    x = myScanner.next();
                    if (x.equals("n") || x.equals("y")) {
                        repeat = x;
                        break;
                    } else {
                        continue;
                    }
                }
                if (repeat.equals("y")) {
                    continue;
                } else {
                    break;
                }
            }
            System.out.println("Simulating Sequences");
            for (int j = 1; j <= sequence; j++) {
                System.out.print(j + " - ");
                int max = 0;
                for (h = 0, t = 0; ((h <= heads) && (t <= tails)) || ((h >= heads) && (t <= tails))
                    || ((h <= heads) && (t >= tails));) {
                    flip++;
                    max++;
                    i = myRandom.nextInt(2);
                    if (i == 0) {
                        h++;
                        System.out.print("H");
                    } else {
                        t++;
                        System.out.print("T");
                    }
                    if (((h >= heads) && (t >= tails))) {
                        break;
                    }
                }
                if (max > maximum) {
                    maximum = max;
                }
                System.out.println("");
            }
            double average;
            average = (flip) / (double) sequence;
            System.out.printf("The average number of flips was %.2f and maximum was %d\n", average, maximum);
            for (int b = 1; b > 0; b++) {
                System.out.print("Would you like to run another simulation? (y/n): ");
                x = myScanner.next();
                if (x.equals("n") || x.equals("y")) {
                    repeat = x;
                    break;
                } else {
                    continue;
                }
            }
        }
    }
}
