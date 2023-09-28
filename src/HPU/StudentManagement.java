package HPU;

import java.util.Scanner;

/**
 * {@code @author}          Hierarch
 * {@code @file}            StudentManagement
 * {@code @project}         HirTusJava
 * {@code @software}        IntelliJ IDEA
 * {@code @create}          2023-09-28 12:21
 * {@code @Description}
 *  定义三个数组
 * 	数组一：代表学生姓名（String）
 * 	数组二：代表学生年龄（int）
 * 	数组三：代表学生成绩（double）
 * 	相同下标处的三个数据表示一个学生信息
 * 	写出四个函数，完成对学生信息的增删改查
 * 	在主函数中可以调用，并展示结果
 */
public class StudentManagement {
    public static void main(String[] args) {
        StudentArray stu = new StudentArray();
        stu.stuSystem();
    }
}

class StudentArray {
    private String[] stuName;  //姓名数组
    private int[] stuAge;  //年龄数组
    private double[] stuAch;  //成绩数组
    private int arrayLength;  //数组长度
    private int tail;  //定义尾下标

    public void add (String name, int age, double ach) {  //增加信息
        if (this.arrayLength == 0) {  //若数组为空
            this.arrayLength = 1;  //定义数组长度
            tail = 0;  //定义初始角标为0
            this.stuName = new String[this.arrayLength];  //初始化长度为1的数组
            this.stuAge = new int[this.arrayLength];
            this.stuAch = new double[this.arrayLength];

            this.stuName[tail] = name;  //赋值
            this.stuAge[tail] = age;
            this.stuAch[tail] = ach;
        } else {
            this.arrayLength += 1;
            this.tail++;  //尾角标加一

            String[] tempName = new String[this.arrayLength];  //创建一个新的扩容的数组
            int[] tempAge = new int[this.arrayLength];  //创建一个新的扩容的数组
            double[] tempAch = new double[this.arrayLength];  //创建一个新的扩容的数组
            for (int foot = 0; foot < arrayLength - 1; foot++) {  //循环
                tempName[foot] = this.stuName[foot];  //将现有的数组赋值给临时数组
                tempAge[foot] = this.stuAge[foot];
                tempAch[foot] = this.stuAch[foot];
            }
            tempName[this.tail] = name;  //临时数组的末尾加数据
            this.stuName = tempName;  //重新赋值

            tempAge[this.tail] = age;
            this.stuAge = tempAge;

            tempAch[this.tail] = ach;
            this.stuAch = tempAch;
        }
    }

    public void delete (int index) {
        this.arrayLength -= 1;  //将数组长度减少一位
        this.tail = 0;  //尾指针从0开始
        //@param index 删除此序号的学生
        String[] tempName = new String[this.arrayLength];  //新建三个小1位的数组
        int[] tempAge = new int[this.arrayLength];
        double[] tempAch = new double[this.arrayLength];

        this.stuName[index - 1] = null;  //将此人姓名置空
        for (int foot = 0; foot <= this.arrayLength; foot++) {
            //对原数组进行循环，如果name数组的值不为空，则赋值给临时数组
            //若name数组的值为空，临时数组的尾标tail不变，name数组的角标foot + 1;即将有效数据依次赋值给临时数组
            if (this.stuName[foot] != null) {
                tempName[this.tail] = this.stuName[foot];
                tempAge[this.tail] = this.stuAge[foot];
                tempAch[this.tail] = this.stuAch[foot];
                this.tail++;
            }

        }
        //更新原数组
        this.stuName = tempName;
        this.stuAge = tempAge;
        this.stuAch = tempAch;
    }

    public void modify (int index, String name, int age, double ach) {
        if (index > this.arrayLength) {
            System.out.println("没有这个序号的人");
        }else {
            int foot = index - 1;
            this.stuName[foot] = name;
            this.stuAge[foot] = age;
            this.stuAch[foot] = ach;
        }
    }

    public boolean search (int index) {  //通过序号或年龄查找, 序号优先
        boolean flag = false;
        if (index <= this.arrayLength) {
            System.out.println(index + "号学生为: ");
            System.out.print(this.stuName[index - 1] + "\t");
            System.out.print(this.stuAge[index - 1] + "\t");
            System.out.print(this.stuAch[index - 1]);
            flag = true;  //找到了变为true

        }else {
            //如果这个整数不属于序号范围，则遍历年龄查找是否符合
            for (int foot = 0; foot < this.arrayLength; foot++) {
                if (this.stuAge[foot] == index) {
                    System.out.println("年龄为: " + index + " 的学生是: ");
                    System.out.print(this.stuName[foot] + "\t");
                    System.out.print(this.stuAge[foot] + "\t");
                    System.out.println(this.stuAch[foot]);
                    flag = true;
                }
            }
        }

        return flag;
    }

    public boolean search (String name) {
        //通过姓名查找
        boolean flag = false;
        for (int foot = 0; foot < arrayLength; foot++) {
            if (this.stuName[foot].equals(name)) {
                System.out.println("姓名为: " + name + " 的学生是: ");
                System.out.print(this.stuName[foot] + "\t");
                System.out.print(this.stuAge[foot] + "\t");
                System.out.println(this.stuAch[foot]);
                flag = true;
            }
        }
        return flag;
    }


    public void getInfo() {
        //输出一次学生信息
        if (this.arrayLength > 0) {  //不是空数组
            System.out.println("--------------------");
            System.out.println("当前学生:");
            for (int foot = 0; foot < this.arrayLength; foot++) {
                int num = foot + 1;
                System.out.print(num + "\t");
                System.out.print(this.stuName[foot] + "\t");
                System.out.print(this.stuAge[foot] + "\t");
                System.out.println(this.stuAch[foot]);
            }
            System.out.println("--------------------");
        }
    }
    public void stuSystem() {
        System.out.println("----------学生管理系统----------");
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while (flag) {

            System.out.println("1 - 添加学生");
            System.out.println("2 - 删除学生");
            System.out.println("3 - 修改信息");
            System.out.println("4 - 查找学生");
            System.out.println("5 - 退出系统");
            System.out.print("请输入操作号: ");

            int opr = input.nextInt();
            switch (opr)
            {
                case 1 : {
                    input.nextLine();
                    System.out.print("输入学生姓名: ");
                    String name = input.nextLine();
                    System.out.print("请输入年龄: ");
                    int age = input.nextInt();
                    System.out.print("请输入成绩: ");
                    double ach = input.nextDouble();
                    this.add(name, age, ach);
                    break;
                }
                case 2 : {
                    input.nextLine();
                    System.out.print("输入要删除的学生编号: ");
                    int num = input.nextInt();
                    this.delete(num);
                    break;
                }
                case 3 : {
                    input.nextLine();
                    System.out.print("请输入要修改的学生编号: ");
                    int index = input.nextInt();
                    input.nextLine();
                    System.out.print("请输入新的姓名: ");
                    String name = input.nextLine();
                    System.out.print("请输入年龄: ");
                    int age = input.nextInt();
                    System.out.print("请输入成绩: ");
                    double ach = input.nextDouble();
                    this.modify(index, name, age, ach);
                    break;
                }
                case 4 : {
                    input.nextLine();
                    System.out.println("请输入要查询的序号、年龄或姓名:");

                    if (input.hasNextInt()) {
                        int index = input.nextInt();
                        if (this.search(index)) {
                            System.out.println("查找成功");
                        }else {
                            System.out.println("查无此人");
                        }
                    }else {
                        String name = input.nextLine();
                        if (this.search(name)) {
                            System.out.println("查找成功");
                        }else {
                            System.out.println("查无此人");
                        }
                    }
                    break;
                }
                case 5 : {
                    flag = false;
                    break;
                }
            }
            input.nextLine();
            this.getInfo();
        }
    }
}

