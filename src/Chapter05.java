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
        Company emp1 = new Company();
        System.out.println(emp1.getInfo());
        Company emp2 = new Company(1);
        System.out.println(emp2.getInfo());
        Company emp3 = new Company(3, "凡凡", "南通监狱");
        System.out.println(emp3.getInfo());
        Company emp4 = new Company(3, "坤坤", "钕通监狱", 9527);
        System.out.println(emp4.getInfo());
    }
}

class Person {
    String name ;
    int age ;

    public void tell() {
        System.out.println("name: " + name + ", age: " + age);
    }
}

class Person2 {
    private String name;
    private int age;

    public Person2() {
        //构造方法
        System.out.println("新建构造方法");
    }
    public Person2(String name) {
        this();
        this.name = name;
    }
    public Person2(String name, int age) {
        this(name);
        this.age = age;
    }

    public String getName() {
        //getter方法
        return this.name;
    }
    public int getAge() {
        //getter方法
        return this.age;
    }

    public void setAge(int age) {
        //setter方法
        this.age = age;
    }
    public void setName(String name) {
        //setter方法
        this.name = name;
    }

    public void tell() {
        System.out.println("Name: " + this.name + ",Age: " + this.age);
    }
}

class Company {
    private long id;
    private String name;
    private String department;
    private double salary;

    //构造方法
    public Company() {
        //无参
        this(1000, "无名氏", null, 0.0);
    }
    public Company(long id) {
        this(id, "新员工", "未定", 0.1);
    }
    public Company(long id, String name, String department) {
        this(id, name, department, 2500.0);
    }
    public Company(long id, String name, String department, double salary) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.salary = salary;
    }

    //getter 和 setter
    public String getName() {
        return this.name;
    }

    public long getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getInfo() {
        return "编号:" + this.id +
                "\n姓名:" + this.name +
                "\n部门：" + this.department +
                "\n工资：" + this.salary ;
    }
}