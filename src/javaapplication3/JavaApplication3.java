
package javaapplication3;

import java.util.Random;
import java.util.Scanner;

public class JavaApplication3 {
    public static void main(String[] args) throws InterruptedException {
        // Tạo đối tượng Scanner để nhập liệu
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Số ngẫu nhiên từ 1 đến 100
        int numberToGuess = random.nextInt(100) + 1;
        int numberOfTries = 0;
        int guess;

        // Giới thiệu trò chơi
        System.out.println("Chào mừng bạn đến với trò chơi đoán số!");
        System.out.println("Tôi đã chọn một số ngẫu nhiên từ 1 đến 100. Bạn thử đoán xem!");

        // Lặp lại cho đến khi đoán đúng
        do {
            System.out.print("Nhập số của bạn: ");
            guess = scanner.nextInt();  // Nhập số từ người chơi
            numberOfTries++;  // Tăng số lần thử

            if (guess < numberToGuess) {
                System.out.println("Số bạn đoán quá thấp!");
            } else if (guess > numberToGuess) {
                System.out.println("Số bạn đoán quá cao!");
            } else {
                System.out.println("Chúc mừng! Bạn đã đoán đúng số " + numberToGuess + " sau " + numberOfTries + " lần thử.");
            }

            // Đợi một chút để tạo hiệu ứng
            Thread.sleep(500);  // Dừng 500 mili giây

        } while (guess != numberToGuess);  // Lặp lại khi chưa đoán đúng

        // Đóng scanner sau khi kết thúc
        scanner.close();
    }
}
