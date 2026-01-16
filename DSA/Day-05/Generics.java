// 2. Why Generics?
// A) To handle Code redundancy by removing explicit type castings
// Without Generics
/*class IntegerDisplayer{
    Integer num;

    public void setNum(Integer num){
        this.num = num;
    }
    public void display(){
        System.out.println("element -> "+ this.num);
    }
}
//just for handling a different data type we are duplicating entire class
class DoubleDisplayer {
    Double num;

    public void setNum(Double num) {
        this.num = num;
    }

    public void display(){
        System.out.println("element -> "+ this.num);
    }
}
public class Generics {
    public static void main(String[] args) {
        IntegerDisplayer obj = new IntegerDisplayer();
        obj.setNum(20);
        obj.display();

        
        DoubleDisplayer obj1 = new DoubleDisplayer(); 
        obj1.setNum(20.0);
        obj1.display();

    }
}*/
// With Generics
/*class Displayer<T>{
    T num;

    public void setNum(T num){
        this.num = num;
    }
    public void display(){
        System.out.println("element -> "+ this.num);
    }
}
public class Generics {
    public static void main(String[] args) {
        Displayer<Integer> obj = new Displayer<>();
        obj.setNum(20);
        obj.display();

        
        Displayer<Double> obj1 = new Displayer<>(); 
        obj1.setNum(20.0);
        obj1.display();

        Displayer<String> obj2 = new Displayer<>();
        obj2.setNum("Hello Generics");
        obj2.display();
    }
}*/
// B) To provide type safety at compile time
// Without Generics
import java.util.*;
class WithoutGenerics {
    public static void main(String[] args) {
        List list = new ArrayList(); // raw type
        list.add("Hello");
        list.add(100); // allowed (not type-safe)

        for (Object obj : list) {
            String str = (String) obj; // ClassCastException at runtime
            System.out.println(str);
        }
    }
}
// With Generics
public class Generics {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); // parameterized type
        list.add("Hello");
        // list.add(100); // Compile-time error (type-safe)

        for (String str : list) {
            System.out.println(str);
        }
    }
}
// 3. Forms of Generics in Java
/*(a) Generic Classes

Define a class with type parameters.

// create only class with generics
class Displayer<T> {
    T num;

    public void setNum(T num) {
        this.num = num;
    }

    public void display(){
        System.out.println("element -> "+ this.num);
    }
}

public class MyGeneric {
    public static void main(String[] args) {
        Displayer<Integer> obj2 = new Displayer<>();
        obj2.setNum(20);
        obj2.display();

        Displayer<Double> obj3 = new Displayer<>();
        obj3.setNum(20.0);
        obj3.display();
    }
}
(b) Generic Methods

Methods can declare their own type parameters.

public class MyGeneric {
    public <E> void heyGen(E element) {
        System.out.println("Hi generics " + element);
    }
    public static void main(String[] args) {
        MyGeneric mg = new MyGeneric();
        mg.heyGen("shashwat");
    }
}
(c) Generic Interfaces

Interfaces can also be generic.

interface Container<T> {
    void add(T item);
    T get();
}

class StringContainer implements Container<String> {
    private String item;

    public void add(String item) {
        this.item = item;
    }
    public String get() {
        return item;
    }
}

public class TestGenericInterface {
    public static void main(String[] args) {
        Container<String> c = new StringContainer();
        c.add("Java Generics");
        System.out.println(c.get());
    }
}
(d) Bounded Generics

Restrict types using extends (upper bound).

class College {
    void printCollegeName(){
        System.out.println("XYZ institute of technology");
    }
}

class Student extends College{
    void printName() {
        System.out.println("Student name printed");
    }
}

class Teacher extends College{
    void printName() {
        System.out.println("Teacher name printed");
    }
}

//T must extend College 
class Displayer<T extends College> {
    T num;

    public void setNum(T num) {
        this.num = num;
        this.num.printCollegeName();
    }

    public void display(){
        System.out.println("element -> "+ this.num);
    }
}

public class MyGeneric {
    public static void main(String[] args) {
        Displayer<Student> obj2 = new Displayer<>();
        obj2.setNum(new Student());
        obj2.display();

        Displayer<Teacher> obj4 = new Displayer<>();
        obj4.setNum(new Teacher());
        obj4.display();
    }
}*/
/*4. Summary
Generics provide type safety and eliminate explicit typecasting.

Can be applied to Classes, Methods, and Interfaces.

Bounded Generics restrict type parameters.

Widely used in Collections Framework (List, Map<K,V>, etc.).*/

