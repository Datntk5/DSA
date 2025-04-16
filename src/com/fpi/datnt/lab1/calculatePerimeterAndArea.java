package com.fpi.datnt.lab1;
import java.util.Scanner;
public class calculatePerimeterAndArea {
public static void main(String[] args)
{Scanner scanner = new Scanner(System.in);
    System.out.print("Input the length of the rectangle: ");
    double length = scanner.nextDouble();
    System.out.print("Input the width of the rectangle:");
    double width = scanner.nextDouble();
    double perimeter = 2 * (length + width);
    double area = length * width;
    System.out.println("\nRectangle Properties : ");
    System.out.println("length : " + length);
    System.out.println("width : "+ width);
    System.out.println("perimeter : "+ perimeter);
    System.out.println("area : "+ area);
}
}
