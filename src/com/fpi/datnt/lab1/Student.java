
package com.fpi.datnt.lab1;
import java.util.Scanner;
public class Student {
private String name;
private int age ;
public Student(String name , int age)
{
    this.name = name;
    this.age = age;
    
}
public void displayInfor()
{
    System.out.println("Name : "+ name);
    System.out.println("Age : "+ age);
}
 public static void main(String[] args)
 {
     Student ob = new Student("Dat",20);
     Student ob2 = new Student("SteveDuy",21);
     ob.displayInfor();
     ob2.displayInfor();
 }
}
