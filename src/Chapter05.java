/**
 * {@code @Description}
 * {@code @author}          Hierarch
 * {@code @file}            Chapter05.java
 * {@code @project}         MyJava
 * {@code @software}        IntelliJ IDEA
 * {@code @create}          2023-08-12 20:01
 */
public class Chapter05 {  //一个文件只能由一个public
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "坤坤";
        p1.age = 18;
        p1.tell();
    }
}

class Person {
    String name ;
    int age ;

    public void tell() {
        System.out.println("name: " + name + ", age: " + age);
    }
}