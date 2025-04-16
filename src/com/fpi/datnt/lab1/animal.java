
package com.fpi.datnt.lab1;
import java.util.Scanner;
class animal {
   private String name; 
   private String species;
   public animal(String name , String species )
   {
   this.name =name;
   this.species = species;
   }
   public String getname()
   {
   return name;
   }
   public String getSpecies()
   {
   return species;
   }
   public static void main(String[] args)
 {
    Dog dog = new Dog("Buddy") ;
    Cat cat = new Cat("Whiskers");
    System.out.println(dog.getname()+ " the " + dog.getSpecies());
    dog.makeSound();
    System.out.println(cat.getname()+ " the " + cat.getSpecies());
    cat.makeSound();
     
 }
}
class Dog extends animal 
{
    public Dog(String name )
    {
        super (name ,"dog");
    }
    public void makeSound()
    {
        System.out.println("Woof");
    }
}
class Cat extends animal 
{
     public Cat(String name )
    {
        super (name ,"cat");
    }
    public void makeSound()
    {
        System.out.println("Meow!");
    }
}