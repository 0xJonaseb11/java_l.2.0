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

  1. Single inheritance
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