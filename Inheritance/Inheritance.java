class Employee {
    float salary = 40000;
}
class Programmer extends Employee {
    int bonus = 10000;

    public static void main(String args[]) {
        Programmer p = new Programmer();
        System.out.println("Programmer salary is: ", p.salary);
        System.out.println("Bonus of Programmer is: ", p.bonus);
    }
}

// Output
/**
 * Programmer salary is: 40000.0
 * Bonus of Programmer is: 10000.0
 */

/** Types of inheritance
 * 1. Single inheritance
 * 2. Multilevel inheritance
 * 3. Hierarchical inheritance
 */

  1. Single Inheritance
  ================================

 class Animal {
    voit eat(){
        System.out.println("Eating...");
    }
 }
 class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
 }

 class TestInheritance {
    public static void main(String args[]) {
        Dog d = new Dog();
        d.bark();
        d.eat();
    }
 }

 /** OUTPUT
  * Barking...
  * Eating...
  */

 2. Multilevel Inheritance
 =========================
 
 class Animal {
    void eat() {
        System.out.println("Eating...");
    }
 }

 class Dog extends Animal {
    void bark() {

        System.out.println("Barking...");
    }
 }

 class BabyDog extends Dog {
    void weep() {
        System.out.println("Weeping...");
    }
 }

 class TestInheritance2 {
    public static void main(String args[]) {
        BabyDog d = new BabyDog();
        d.weep();
        d.bark();
        d.eat();
    }
 }

 /** OUTPUT
  * Weeping...
  * Barking...
  * Eating...
  */

 3. Hierachical Inheritance
 ==========================

 class Animal {
    void eat() {
        System.out.println("Eating...");
    }
 }

 class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
 }

 class Cat extends Animal {
    void meow() {
        System.out.println("Meowing...");
    }
 }

 class TestInheritance3 {
    public static void main(String args[]) {
        Cat c = new Cat();
        c.meow();
        c.eat();
        // c.bark(); // C.T.Error
    }
 }

 /** WHY MULTIPLE INHERITANCE IS NOT SUPPORTED IN JAVA 
  * To reduce complexity and simplify the language
 */

 class A {
    void msg() {
        System.out.println("Hello");
    }
 }

 class B {
    void msg() {
        System.out.println("Welcome");
    }
 }

 class C extends A, B { //Suppose if it were
    public static void main(String args[]) {
        C obj = new C();
        obj.msg(); // Now which msg() method would be invoked?
    }
 } // Compile Time error


 /** Super keyword
  * 1. Super is used to refer immediate parent class instance variable
  */
 class Animal {
    String color = " White";
 }
 
 class Dog extends Animal {
    String color = "Black";

    void printColor() {
        System.out.println(color); // prints color of dog class
        System.out.println(super.color); // prints color of Animal class
    }
 }

 class TestSuper {
    public static void main(String args[]) {
        Dog d = new Dog();
        d.printColor();
    }
 }

 /** OUTPUT
  * Black
  * White
  */

 /**
  * 2. Super can be used to invoke parent class methof
  */

 class Animal {
    void eat() {
        System.out.println("Eating...");
    }
 }

 class Dog extends Animal {
    void eat() {
        System.out.println("Eating bread...");
    }
    void bark() {
        System.out.println("Barking...");
    }
    void work() {
        super.eat();
        bark();
    }
 }

 class TestSuper2 {
    public static void main (String args []) {
        Dog d = new Dog();
        d.work();
    }
 }

 /** OUTPUT
  * Eating...
  * Barking...
  */

 /**
  * 3. Super is used to invoke parent class constructor
  */

 class Animal {
    Animal() {
        System.out.println("Animal is created");
    }
 }

 class Dog extends Animal {
    Dog() {
        super();
        System.out.println("Dog is created");
    }
 }

 class TestSuper3 {
    public static void main(String args[]) {
        Dog d = new Dog();
    }
 }

 /** OUTPUT
  * Animal is created
  * Dog is created
  */

 /** FINAL KEYWORD
  * 
  * 1. Java Final variable
  * Making any variable as final, you cannot change its value
  */
 
 class Bike9 {
    final int speedLimit = 90; // final variable

    void run() {
        speedLimit = 400;
    }
    public static void main(String args []) {
        Bike9 obj = new Bike9();
        obj.run();
    }
 } // end of class
 // Output: Compile Time Error

 /** 
  * 2. Java final method
  * If you make any method as final, you cannot  override it.
  */

 class Bike {
    final void run () {
        System.out.println("Running...");
    }
 }

 class Honda extends Bike {
    void run() {
        System.out.println("Running safely with 100kmph");

        public static void main(String args[]) {
            Honda honda = new Honda();
            honda.run();
        }
    }
 } // Output: Compile Time Error

 






 


