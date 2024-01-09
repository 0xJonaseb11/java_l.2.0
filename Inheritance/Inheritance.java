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

 /** OUT PUT
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

 /** OUT PUT
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


 // Super keyword
 class Animal {
    String color = " White";
 }
 
 class Dog extends Animal {
    String color = "Black";

    void printColor() {}
 }

 


