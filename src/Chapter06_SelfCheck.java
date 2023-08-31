/**
 * {@code @Description}
 * {@code @author}          Hierarch
 * {@code @file}            Chapter06_SelfCheck
 * {@code @project}         MyJava
 * {@code @software}        IntelliJ IDEA
 * {@code @create}          2023-08-31 16:14
 */
public class Chapter06_SelfCheck {
    public static void main(String[] args) {
        ChildClass childClass1 = new ChildClass(1, "鸡");
        ChildClass childClass2 = new ChildClass(2, "凡");
        FatherClass fatherClass = new FatherClass(5, "坤坤");
        fatherClass.setChildClasses(new ChildClass[] {childClass1, childClass2});
        childClass1.setFatherClass(fatherClass);
        childClass2.setFatherClass(fatherClass);
        System.out.println(fatherClass.getInfo());
        for (ChildClass x : fatherClass.getChildClasses()) {
            System.out.println(x.getInfo());
        }


        Commodity thing1 = new Commodity(1, "鸡毛", 250.213);
        Commodity thing2 = new Commodity(2, "坤毛", 213.444);
        Commodity thing3 = new Commodity(3, "鸡你太美", 1234.21);
        UserInfo user1 = new UserInfo(1, "坤坤");
        UserInfo user2 = new UserInfo(2, "凡凡");

        AccessRecords record1 = new AccessRecords(user1, thing1);
        AccessRecords record2 = new AccessRecords(user2, thing1);
        AccessRecords record3 = new AccessRecords(user1, thing3);
        AccessRecords record4 = new AccessRecords(user1, thing2);

        user1.setRecords(new AccessRecords[] {record1, record3, record4});
        user2.setRecords(new AccessRecords[] {record2});

        thing1.setRecords(new AccessRecords[] {record1, record2});
        thing2.setRecords(new AccessRecords[] {record4});
        thing3.setRecords(new AccessRecords[] {record3});

        System.out.println(user1.getInfo());
        System.out.println(user1.getGoodsInfo());

        System.out.println(thing1.getInfo());
        thing1.getUserInfo();
    }
}

class FatherClass {
    private int id;
    private String name;
    private ChildClass[] childClasses;

    FatherClass() {}
    FatherClass(int id, String name) {
        this(id, name, null);
    }
    FatherClass(int id, String name, ChildClass[] childClasses) {
        this.id = id;
        this.name = name;
        this.childClasses = childClasses;
    }

    //setter and getter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChildClass[] getChildClasses() {
        return childClasses;
    }

    public void setChildClasses(ChildClass[] childClasses) {
        this.childClasses = childClasses;
    }

    public String getInfo() {
        return "分类id: " + this.id +
                "\n分类名称: " + this.name;

    }
}

class ChildClass {
    private int id;
    private String name;
    private FatherClass fatherClass;

    //构造方法
    ChildClass() {}
    ChildClass(int id, String name) {
        this(id, name, null);
    }
    ChildClass(int id,String name, FatherClass fatherClass) {
        this.id = id;
        this.name = name;
        this.fatherClass = fatherClass;
    }
    //setter and getter

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FatherClass getFatherClass() {
        return fatherClass;
    }

    public void setFatherClass(FatherClass fatherClass) {
        this.fatherClass = fatherClass;
    }

    public String getInfo () {
        return "\n\t|-子分类id: " + this.id +
                "\n\t|-所属分类id:" + this.fatherClass.getId() +
                "\n\t|-子分类名称: " + this.name;
    }
}

class AccessRecords {
    private UserInfo user;
    private Commodity goods;
    AccessRecords() {}
    AccessRecords(UserInfo user, Commodity goods) {
        this.user = user;
        this.goods = goods;
    }

    //setter getter


    public Commodity getGoods() {
        return goods;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setGoods(Commodity goods) {
        this.goods = goods;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public String getInfo() {
        return "\n浏览商品: " + this.goods.getInfo() +
                "\n浏览用户: " + this.user.getInfo();
    }

}

class UserInfo {
    private int userId;
    private String name;

    private AccessRecords[] records;
    UserInfo() {}
    UserInfo(int userID, String name) {
        this(userID, name, null);
    }
    UserInfo(int userID, String name, AccessRecords[] records) {
        this.userId = userID;
        this.name = name;
        this.records = records;
    }
    //setter 、 getter


    public AccessRecords[] getRecords() {
        return records;
    }

    public void setRecords(AccessRecords[] records) {
        this.records = records;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getInfo() {
        //获取所有信息
        return "\n用户id: " + this.userId +
                "\n用户姓名: " + this.name;
    }
    public String getGoodsInfo() {
        if (this.records.length > 0) {
            for (AccessRecords x : this.records)
                System.out.println(x.getGoods().getInfo());
        } else {
            return "无浏览记录";
        }
        return "";
    }
}

class Commodity {
    private int item;
    private String name;
    private double price;
    private AccessRecords[] records;
    Commodity() {}
    Commodity(int item, String name, double price) {
        this(item, name, price, null);
    }
    Commodity(int item, String name, double price, AccessRecords[] records) {
        this.item = item;
        this.name = name;
        this.price = price;
        this.records = records;
    }

    // setter getter


    public AccessRecords[] getRecords() {
        return records;
    }

    public void setRecords(AccessRecords[] records) {
        this.records = records;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInfo() {
        return "\n商品id: " + this.item +
                "\n商品名称: " + this.name +
                "\n商品价格: " + this.price;
    }

    public void getUserInfo() {
        if (this.records.length > 0) {
            for (AccessRecords x : this.records) {
                System.out.println(x.getUser().getInfo());
            }
        }else {
            System.out.println("没有被浏览过");
        }
    }
}

class Authority {
    private int id;
    private String name;

}
class Role {
    private int id;
    private String name;

}
class Users {
    private int id;
    private String name;
    private Role[] roles;

    Users (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setRoles(Role[] roles) {
        this.roles = roles;
    }
    public Role[] getRoles() {
        return this.roles;
    }
}
