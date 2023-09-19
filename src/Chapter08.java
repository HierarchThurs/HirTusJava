/**
 * {@code @Description}
 * {@code @author}          Hierarch
 * {@code @file}            Chapter08
 * {@code @project}         HirTusJava
 * {@code @software}        IntelliJ IDEA
 * {@code @create}          2023-09-19 9:01
 */
public class Chapter08 {
    public static void main(String[] args) {
        System.out.println("Test");
        System.out.println();

        CharacterSum sen1 = new CharacterSum('n', 'o', "want you to know one thing");
        sen1.sum();
        System.out.println(sen1.getInfo());
        System.out.println();
        CharacterSum sen2 = new CharacterSum('w', 'k');
        sen2.setSentence("want you to know one thing");
        sen2.sum();
        System.out.println(sen2.getInfo());
        System.out.println();

        Student08 stu1 = new Student08("坤坤", "监狱", "man", 18, 20, 30);
        System.out.println(stu1.getInfo());
        System.out.println();
        Executive admin1 = new Executive("帆帆", 18, "woman", "典狱长", 50000);
        System.out.println(admin1.getInfo());
        System.out.println();
        Clerk worker1 = new Clerk("孙笑川", 50, "null", "rbq", 10);
        System.out.println(worker1.getInfo());
        System.out.println();

        ReverseArray array1 = new ReverseArray(5);
        System.out.println(array1.add(2));
        System.out.println(array1.add(1));
        System.out.println(array1.add(5));
        System.out.println(array1.add(8));
        System.out.println(array1.add(4));
        array1.increase(3);
        System.out.println(array1.add(3));
        System.out.println(array1.add(9));
        for (int x : array1.getIntArray()) {
            System.out.print(x + "、");
        }
    }
}


//Person 类
class Person08 {
    private String name;
    private String addr;
    private String sex;
    private int age;

    //构造方法
    Person08(){}
    Person08(String name, int age){
        this(name, null, null, age);
    }
    Person08(String name, String addr, String sex, int age) {
        this.name = name;
        this.addr = addr;
        this.sex = sex;
        this.age = age;
    }

    //setter getter

    public String getName() {
        return this.name;
    }
    public String getAddr() {
        return this.addr;
    }
    public String getSex() {
        return this.sex;
    }
    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getInfo() {
        //获取所有成员属性
        return "姓名: " + this.name +
                "\n年龄: " + this.age +
                "\n性别: " + this.sex +
                "\n地址: " + this.addr;
    }
}


//Student
class Student08 extends Person08 {
    private int math;
    private int english;

    //构造方法
    Student08() {}
    Student08(String name, int age) {
        super(name, age);
    }
    Student08(String name, String addr, String sex, int age, int math, int english) {
        super(name, addr,sex, age);
        this.math = math;
        this.english = english;
    }

    //setter getter
    public int getMath() {
        return this.math;
    }
    public int getEnglish() {
        return this.english;
    }
    public void setMath(int math) {
        this.math = math;
    }
    public void setEnglish(int english) {
        this.english = english;
    }

    @Override
    public String getInfo() {
        return "姓名: " + this.getName() +
                "\n年龄: " + this.getAge() +
                "\n性别: " + this.getSex() +
                "\n地址: " + this.getAddr() +
                "\n数学成绩: " + this.math +
                "\n英语成绩: " + this.english;
    }
}


//员工类
class Staff {
    private String name;
    private int age;
    private String sex;

    //构造方法
    Staff() {}
    Staff(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    //setter getter
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public String getSex() {
        return this.sex;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getInfo() {
        return "姓名: " + this.name +
                "\n年龄: " + this.age +
                "\n性别: " + this.sex;
    }

}


//管理层类
class Executive extends Staff {
    private String post;
    private int yearSalary;

    //构造方法
    Executive() {}
    Executive(String name, int age, String sex, String post, int yearSalary) {
        super(name, age, sex);
        this.post = post;
        this.yearSalary = yearSalary;
    }

    //setter getter
    public String getPost() {
        return this.post;
    }
    public int getYearSalary() {
        return this.yearSalary;
    }
    public void setPost(String post) {
        this.post = post;
    }
    public void setYearSalary(int yearSalary) {
        this.yearSalary = yearSalary;
    }

    @Override
    public String getInfo() {
        return "姓名: " + this.getName() +
                "\n年龄: " + this.getAge() +
                "\n性别: " + this.getSex() +
                "\n职务: " + this.post +
                "\n年薪: " + this.yearSalary;
    }
}


//职员类
class Clerk extends Staff {
    private String department;
    private int monthSalary;

    //构造方法
    Clerk() {}
    Clerk(String name, int age, String sex, String department, int monthSalary) {
        super(name, age, sex);
        this.department = department;
        this.monthSalary = monthSalary;
    }

    //setter getter
    public String getDepartment() {
        return this.department;
    }
    public int getMonthSalary() {
        return this.monthSalary;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setMonthSalary(int monthSalary) {
        this.monthSalary = monthSalary;
    }

    @Override
    public String getInfo() {
        return "姓名: " + this.getName() +
                "\n年龄: " + this.getAge() +
                "\n性别: " + this.getSex() +
                "\n部门: " + this.department +
                "\n月薪: " + this.monthSalary;
    }
}


//统计字符串中字母出现的次数
class CharacterSum {
    private char oneChar;
    private char twoChar;
    private String sentence;
    private int oneSum;
    private int twoSum;

    //构造方法
    CharacterSum() {}
    CharacterSum(char oneChar, char twoChar) {
        this(oneChar, twoChar, "");
    }
    CharacterSum(char oneChar, char twoChar, String sentence) {
        this.oneChar = oneChar;
        this.twoChar = twoChar;
        this.sentence = sentence;
    }

    //setter getter
    public char getOneChar() {
        return this.oneChar;
    }
    public char getTwoChar() {
        return this.twoChar;
    }
    public String getSentence() {
        return this.sentence;
    }

    public void setOneChar(char oneChar) {
        this.oneChar = oneChar;
    }
    public void setTwoChar(char twoChar) {
        this.twoChar = twoChar;
    }
    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getInfo() {
        return this.sentence + " 中的 " +
                this.oneChar + " 出现次数为: " +
                this.oneSum + "; " + this.twoChar +
                " 出现次数为: " + this.twoSum;
    }


    public void sum() {
        //算法
        if (sentence.isEmpty()) {
            System.out.println("请设置字符串");
        }else {  //字符串存在
            char[] chars = sentence.toCharArray();  //将字符串转为字符数组
            for (char x : chars) {  //遍历字符数组
                if (x == oneChar) {
                    oneSum += 1;
                } else if (x == twoChar) {
                    twoSum += 1;
                }
            }
        }
    }
}


class IntArray {
    private int[] intArray;
    private int foot;


    IntArray() {}
    IntArray(int len) {
        intArray = new int[len];
    }

    public boolean increase(int len) {
        int[] newArray = new int[this.intArray.length + len];
        System.arraycopy(this.intArray, 0, newArray, 0, this.intArray.length);
        this.intArray = newArray;
        return true;
    }

    public boolean add(int num) {
        if (this.foot < this.intArray.length) {
            this.intArray[this.foot++] = num;
            return true;
        }
        return false;
    }
    public int[] getIntArray() {
        return this.intArray;
    }
    public void setIntArray(int[] intArray) {
        this.intArray = intArray;
    }
}

class SortArray extends IntArray {
    SortArray() {}
    SortArray(int len) {
        super(len);
    }
    @Override
    public int[] getIntArray() {
        java.util.Arrays.sort(super.getIntArray());
        return super.getIntArray();
    }
}
class ReverseArray extends IntArray {
    ReverseArray() {}
    ReverseArray(int len) {
        super(len);
    }

    @Override
    public int[] getIntArray() {
        int head = 0;
        int tail = super.getIntArray().length - 1;
        int temp;
        int center = super.getIntArray().length / 2;
        for (int x = 0; x < center; x ++) {
            temp = super.getIntArray()[head];
            super.getIntArray()[head] = super.getIntArray()[tail];
            super.getIntArray()[tail] = temp;
            head++;
            tail--;
        }
        return super.getIntArray();
    }
}