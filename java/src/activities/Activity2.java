package activities;

public class Activity2 {
    public static void main(String[] args) {
        // Initialize the array
        int[] numbers = {10, 77, 10, 54, -11, 10};
        int sum = 0;

        // Loop through the array and add 10's
        for (int num : numbers) {//enhanced for loop
            if (num == 10) {
                sum += num;
            }
        }

        // Check if the sum is exactly 30
        if (sum == 30) {
            System.out.println("yes value equals to 30");
        } else {
            System.out.println("no value not equals to 30");
        }
    }
}
