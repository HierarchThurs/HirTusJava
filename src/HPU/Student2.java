package HPU;

import java.util.Scanner;

/**
 * {@code @author}          Hierarch
 * {@code @file}            Student2
 * {@code @project}         HirTusJava
 * {@code @software}        IntelliJ IDEA
 * {@code @create}          2023-10-08 21:25
 * {@code @Description}
 * 类Clazz 该类对象表示一个班级
 * 属性：
 * Teacher t ；//表示老师
 * Student[] ss = new Student[10];//保存多个Student对象
 *  int count;//表示有效元素个数
 * 方法：
 * addStudent(Student s);//添加Student对象
 * removeStudent(int id);//根据id移除Student对象
 * updateStudent(Student s);//更新Student对象
 * queryStudent(int id);//根据id查询Student对象
 */
public class Student2 {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        System.out.println("----------学生管理系统----------");
        Clazz clazz = new Clazz();
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("--------------------");
            System.out.println("1 - 添加学生");
            System.out.println("2 - 删除学生");
            System.out.println("3 - 修改信息");
            System.out.println("4 - 查找学生");
            System.out.println("5 - 退出系统");
            System.out.println("--------------------");
            System.out.print("请输入操作号: ");
            int opr = input.nextInt();
            switch (opr)
            {
                case 1 : {
                    input.nextLine();
                    System.out.print("输入学生姓名: ");
                    String name = input.nextLine();
                    System.out.print("输入学生性别: ");
                    String gender = input.nextLine();
                    System.out.print("请输入年龄: ");
                    int age = input.nextInt();
                    System.out.print("请输入成绩: ");
                    double ach = input.nextDouble();
                    clazz.addStudent(new Student(name, gender, age, ach));
                    break;
                }
                case 2 : {
                    input.nextLine();
                    System.out.print("输入要删除的学生编号: ");
                    int num = input.nextInt();
                    clazz.removeStudent(num);
                    break;
                }
                case 3 : {
                    input.nextLine();
                    System.out.print("请输入要修改的学生编号: ");
                    int index = input.nextInt();
                    input.nextLine();
                    System.out.print("请输入新的姓名: ");
                    String name = input.nextLine();
                    System.out.print("请输入性别: ");
                    String gender = input.nextLine();
                    System.out.print("请输入年龄: ");
                    int age = input.nextInt();
                    System.out.print("请输入成绩: ");
                    double ach = input.nextDouble();
                    clazz.updateStudent(index, new Student(name, gender, age, ach));
                    break;
                }
                case 4 : {
                    input.nextLine();
                    System.out.print("请输入要查找的学生编号: ");
                    int index = input.nextInt();
                    clazz.queryStudent(index);
                    break;
                }
                case 5 : {
                    flag = false;
                    break;
                }
            }
            System.out.println("-------------------");
            System.out.println("现有学生");
            for (int foot = 0; foot < clazz.getCount(); foot++) {
                System.out.println((foot + 1) + ". " + clazz.getSs()[foot].getInfo());
            }
        }
    }
}

class Clazz {
    private Teacher t;
    private Student[] ss = new Student[10];
    private int count;

    public Clazz() {}
    public Clazz(String name, int age, String gender, String course) {
        //构造方法可以初始化教师
        this.t = new Teacher(name, gender, age, course);
    }

    public Student[] getSs() {
        return this.ss;
    }
    public int getCount() {
        return this.count;
    }

    public void addStudent(Student s) {  //添加Student对象
        this.count++;
        if (count <= 10) {
            ss[count - 1] = s;  //将s学生保存到数组的count - 1角标中
        }else {
            this.count--;
        }
    }
    public void removeStudent(int id) {  //根据id移除Student对象
        if (id > this.count || id < 1) {
            System.out.println("没有这个人");
        }else {
            for (int foot = id - 1; foot < count - 1; foot++) {
                ss[foot] = ss[foot + 1];
                ss[count - 1] = null;
                this.count--;
            }
        }
    }
    public void updateStudent(int id, Student s)  {  //更新Student对象
        this.ss[id - 1] = s;
    }
    public void queryStudent(int id) {  //根据id查询Student对象
        System.out.println(this.ss[id - 1].getInfo());
    }
}
class Person {
    private String name;
    private int age;
    private String gender;

    //构造方法
    public Person() {}
    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    //getter setter
    public String getName() {
        return this.name;
    }
    public String getGender() {
        return this.gender;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(String name) {
        this.gender = gender;
    }
    //info
    public String getInfo() {
        return "姓名：" + this.name +
                "、性别：" + this.gender +
                "、年龄：" + this.age;
    }
}

class Teacher extends Person {
    private String course;

    public Teacher(String name, String gender, int age, String course) {
        super(name, gender, age);
        this.course = course;
    }

    public String getCourse() {
        return this.course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
}
class Student extends Person {
    private double ach;  //成绩

    public Student(String name, String gender, int age, double arc) {
        super(name, gender, age);
        this.ach = arc;
    }

    public double getArc() {
        return this.ach;
    }
    public void setArc(double arc) {
        this.ach = arc;
    }
    @Override
    public String getInfo() {
        return "姓名: " + this.getName() +
                "、年龄: " + this.getAge() +
                "、性别: " + this.getGender() +
                "、成绩: " + this.ach;
    }
}
