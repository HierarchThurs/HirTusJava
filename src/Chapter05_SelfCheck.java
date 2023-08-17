import javax.jnlp.SingleInstanceListener;

/**
 * {@code @Description}     《Java从入门到实践》第五章自我检测
 * {@code @author}          Hierarch
 * {@code @file}            Chapter05_SelfCheck.java
 * {@code @project}         MyJava
 * {@code @software}        IntelliJ IDEA
 * {@code @create}          2023-08-17 20:22
 */
public class Chapter05_SelfCheck {
    public static void main(String[] args) {
        System.out.println("==========CLASS ADDRESS==========");
        Address cn = new Address("中国", "河南", "郑州", "狗屎", 1234);
        System.out.println("第 " + Address.getCount() + " 个地址:");
        System.out.println(cn.getAddressInfo());
        Address sg = new Address("Singapore", "Singapore city");
        System.out.println("第 " + Address.getCount() + " 个地址:");
        System.out.println(sg.getAddressInfo());
        Address us = new Address();
        System.out.println("第 " + Address.getCount() + " 个地址:");
        System.out.println(us.getAddressInfo());

        System.out.println("==========CLASS EMPLOYEE==========");
        Employee emp1 = new Employee(1, "坤坤", 12345.6);
        System.out.println(emp1.getEmployeeInfo());
        Employee.setSalaryGrowthRate(0.5);
        System.out.println("坤坤涨价后的工资为: " + emp1.salaryIncreased());
        Employee emp2 = new Employee(2, "凡凡");
        System.out.println(emp2.getEmployeeInfo());
        System.out.println(emp2.getEmpName() + "涨价后的工资为: " + emp2.salaryIncreased());

        System.out.println("==========CLASS LIBRARY==========");
        Library bk1 = new Library("坤坤的牢狱生活", 1, 123.4);
        System.out.println(bk1.getBookInfo());
        Library bk2 = new Library("坤坤的牢狱生活", 1);
        System.out.println(bk2.getBookInfo());
        Library bk3 = new Library("坤坤的牢狱生活");
        System.out.println(bk3.getBookInfo());


    }
}

class Address {
    //编写并测试一个代表地址的Address类，地址信息由国家、省份、城市、街道、邮编等组成，并可以返回完整地址信息
    private static int count = 0;
    private String country;
    private String province;
    private String city;
    private String street;
    private int postalCode;

    //类构造方法
    public Address() {
        this("不知名国度", null, null, null, 0);
    }
    public Address(String country) {
        this(country, "某省份", null, null, 0);
    }
    public Address(String country, String province) {
        this(country, province, "某市", null, 0);
    }
    public Address(String country, String province, String city) {
        this(country, province, city, "某街道", 0);
    }
    public Address(String country, String province, String city, String street, int postalCode) {
        count++;
        this.country = country;
        this.province = province;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }
    //setter, getter方法
    public String getCountry() {
        return this.country;
    }
    public String getProvince() {
        return this.province;
    }
    public String getCity() {
        return this.city;
    }
    public String getStreet() {
        return this.street;
    }
    public int getPostalCode() {
        return this.postalCode;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    public static int getCount() {
        return count;
    }
    public String getAddressInfo() {
        return "国家: " + getCountry() +
                "\n省份: " + getProvince() +
                "\n城市: " + getCity() +
                "\n街道: " + getStreet() +
                "\n邮编: " + getPostalCode();

    }
}

class Employee {
    private int empNumber;
    private String empName;
    private double basicPay;
    private static double salaryGrowthRate;

    //构造方法
    public Employee() {
        this(0, null, 0);
    }
    public Employee(int empNumber, String empName) {
        this(empNumber, empName, 1000.0);
    }
    public Employee(int empNumber, String empName, double basicPay) {
        this.empNumber = empNumber;
        this.empName = empName;
        this.basicPay = basicPay;
    }

    //getter, setter方法
    public int getEmpNumber() {
        return this.empNumber;
    }
    public String getEmpName() {
        return this.empName;
    }
    public double getBasicPay() {
        return this.basicPay;
    }
    public static double getSalaryGrowthRate() {
        return salaryGrowthRate;
    }
    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }
    public static void setSalaryGrowthRate(double newSalaryGrowthRate) {
        salaryGrowthRate = newSalaryGrowthRate;
    }
    public double salaryIncreased() {
        this.basicPay = (1 + salaryGrowthRate) * this.basicPay;
        return this.basicPay;
    }
    public String getEmployeeInfo() {
        return "编号：" + this.empNumber +
                "\n姓名" + this.empName +
                "\n工资：" + this.basicPay;
    }
}

class Dog {
    //设计一个Dog类，有名字、颜色和年龄属性，定义构造方法来初始化类的这些属性，定义方法输出Dog信息,编写应用程序使用Dog类
    private String name;
    private String color;
    private int age;

    //构造方法
    public Dog() {
        this(null, null, 0);
    }
    public Dog(String name) {
        this(name, null, 0);
    }
    public Dog(String name, String color) {
        this(name, color, 0);
    }
    public Dog(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    //setter, getter方法
    public String getName() {
        return this.name;
    }
    public String getColor() {
        return this.color;
    }
    public int getAge() {
        return this.age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getDogInfo() {
        return "名字: " + this.name +
                "\n颜色: " + this.color +
                "\n年龄: " + this.age;
    }
}

class BankAccount {
    //设计一个银行账户类，类的构成包括以下内容：
    //数据成员用户的账户名称、账户余额（private数据类型）
    //方法包括开户（设置账户名称和余额），利用构造方法完成
    //查询余额

    private String accountName;
    private double balance;

    //构造方法
    public BankAccount() {
        this(null, 0);
    }
    public BankAccount(String accountName) {
        this(accountName, 0);
    }
    public BankAccount(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    //setter, getter方法
    public String getAccountName() {
        return this.accountName;
    }
    public double getBalance() {
        return this.balance;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getAccountInfo() {
        return "账户名称: " + this.accountName +
                "\n账户余额: " + this.balance;
    }

}

class User {
    //设计一个表示用户的类，类中的变量有用户名、口令和记录用户个数的变量，定义类的3个构造方法(无参，为用户名赋值；为用户名和口令赋值)，
    //获取和设置口令的方法和返回类信息的方法。
    private String username;
    private String password;
    private static int count;

    //构造方法
    public User() {
        this(null, null);
    }
    public User(String username) {
        this(username, null);
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        count++;
    }

    //setter, getter方法
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public static int getCount() {
        return count;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserInfo() {
        return "用户名: " + this.username +
                "\n密码: " + this.password;
    }
}

class Library {
    //声明一个图书类，其数据成员为书名、编号（利用静态变量实现自动编号）、书价，并拥有静态数据成员册数、
    //记录图书的总册数，在构造方法中利用此静态变量为对象的编号赋值，在主方法中定义多个对象，并求出总册数。
    private String bookName;
    private int bookNumber;
    private double bookPrice;
    private static int count;

    //构造方法
    public Library() {
        this(null, 0, 0);
    }
    public Library(String bookName) {
        this(bookName, 0, 0);
    }
    public Library(String bookName, int bookNumber) {
        this(bookName, bookNumber, 0);
    }
    public Library(String bookName, int bookNumber, double bookPrice) {
        this.bookName = bookName;
        this.bookNumber = bookNumber;
        this.bookPrice = bookPrice;
        count++;
    }

    //setter, getter方法
    public String getBookName() {
        return this.bookName;
    }
    public int getBookNumber() {
        return this.bookNumber;
    }
    public double getBookPrice() {
        return this.bookPrice;
    }
    public static int getCount() {
        return count;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }
    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }
    public String getBookInfo() {
        return "书名: " + this.bookName +
                "\n编号: " + this.bookNumber +
                "\n价格: " + this.bookPrice;
    }

}