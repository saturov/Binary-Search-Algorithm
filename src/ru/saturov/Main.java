package ru.saturov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String EXIT_COMMAND = "exit";

    private static int[] primesArray = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    private static int min = 0;
    private static int max = primesArray.length - 1;

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter some number, or '" + EXIT_COMMAND + "' to quit");

        while (true) {
            System.out.print("> ");
            try {
                String input = br.readLine();
                try {
                    int inputNumber = Integer.parseInt(input);
                    binarySearch(inputNumber);
                } catch (NumberFormatException e) {
                    System.out.println("Wrong data type! Try again please.");
                }

                if (input.length() == EXIT_COMMAND.length() && input.toLowerCase().equals(EXIT_COMMAND)) {
                    System.out.println("Exiting...");
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Рекурсивный метод бинарного поиска
     * @param inputNumber искомое целочисленное число
     */
    private static void binarySearch(int inputNumber) {
        int guess = (max + min) / 2;
        if (primesArray[guess] == inputNumber) {
            System.out.println("Target element '" + inputNumber + "' is at index " + guess);
        } else if  (primesArray[guess] < inputNumber) {
            min = guess + 1;
            binarySearch(inputNumber);
        } else if (primesArray[guess] > inputNumber) {
            max = guess - 1;
            binarySearch(inputNumber);
        }
    }
}
