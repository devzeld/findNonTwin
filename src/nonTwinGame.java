import java.util.Random;
import java.util.Scanner;

public class nonTwinGame {
    private int nonTwin;

    public void populateArray(int[] arr) {
        int value = randomNumber(1, 100);
        for (int i = 0; i < arr.length / 2; i++) {
            if (valueIsNotPresent(arr, value)) {
                placeTwins(arr, value);
            } else {
                value = randomNumber(1, 100);
                i--;
            }
        }
        int nonTwin = randomNumber(1, 100);
        if (valueIsNotPresent(arr, nonTwin)) {
            placeNonTwin(arr, nonTwin);
        }
    }

    public void placeNonTwin(int[] arr, int value) {
        int count = 2;
        do {
            int pos = randomNumber(0, arr.length - 1);
            if (arr[pos] == 0) {
                arr[pos] = value;
                this.nonTwin = value;
                count--;
            }
        } while (count != 1);
    }

    public boolean valueIsNotPresent(int[] arr, int value) {
        for (int j : arr) {
            if (j == value) {
                return false;
            }
        }
        return true;
    }


    public int randomNumber(int from, int to) {
        Random r = new Random();
        return from + r.nextInt(to - from + 1);
    }


    public void placeTwins(int[] arr, int value) {
        int count = 2;
        do {
            int pos = randomNumber(0, arr.length - 1);
            if (arr[pos] == 0) {
                arr[pos] = value;
                count--;
            }
        } while (count != 0);

    }

    public void displayArray(int[] arr) {
        System.out.print("\n");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public void compliments(int level) {
        switch (level % 5) {
            case 0:
                System.out.println("Excellent!");
        }
    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);
        int level = 1;
        int increaseFactor = 0;
        int userInt;
        do {
            increaseFactor += 2;
            int[] twinArr = new int[1 + increaseFactor];
            populateArray(twinArr);
            System.out.printf("Level: %s", level);
            displayArray(twinArr);
            System.out.print("\nInsert the non-Twin number: ");
            userInt = sc.nextInt();
            level++;
        } while (userInt == this.nonTwin);
    }
}