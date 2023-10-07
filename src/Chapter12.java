/**
 * {@code @author}          Hierarch
 * {@code @file}            Chapter12
 * {@code @project}         HirTusJava
 * {@code @software}        IntelliJ IDEA
 * {@code @create}          2023-09-29 18:29
 * {@code @Description}
 */
public class Chapter12 {
    public static void main(String[] args) {
        PetShop shop = new PetShop();
        shop.add(new Dog12("坤坤", "白色"));
        shop.add(new Cat("帆帆", "绿色"));
        Object[] result = shop.search("绿").toArray();
        for (Object obj : result) {
            System.out.println(obj);
        }
    }
}

/**
 * 定义宠物接口
 */
interface IPet {
    /**
     * 获取宠物的名字
     * @return 返回宠物名
     */
    String getName();

    /**
     * 获取宠物的颜色
     * @return 返回颜色
     */
    String getColor();
}

/**
 * 定义宠物商店，隐藏宠物实现细节
 */
class PetShop {
    private ILink<IPet> allPets = new LinkImpl<>();  //将宠物放入链表中管理

    /**
     * 宠物信息上架
     * @param pet 要上架的宠物
     */
    public void add (IPet pet) {  //宠物上架
        this.allPets.add(pet);  //在链表中保存对象
    }

    /**
     * 宠物信息下架，删除信息，需要equals()方法支持
     * @param pet 要删除的宠物信息
     */
    public void delete (IPet pet) {
        this.allPets.remove(pet);
    }

    /**
     * 根据关键字模糊查询宠物信息，由于返回多个对象，所以使用集合返回
     * @param keyword 查找的名字或者颜色
     * @return 返回一个链表
     */
    public ILink<IPet> search(String keyword) {
        ILink<IPet> searchResult = new LinkImpl<>();  //保存查询结果
        Object[] result = this.allPets.toArray();
        if (result != null) {
            for (Object obj : result) {
                IPet pet = (IPet) obj;
                if (pet.getName().contains(keyword) || pet.getColor().contains(keyword)) {
                    searchResult.add(pet);
                }
            }
        }
        return searchResult;
    }
}

class Cat implements IPet {  //猫实现了宠物接口
    private String name;
    private String color;
    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String getName() {  //重写接口中的方法
        return this.name;
    }
    @Override
    public String getColor() {  //重写接口中的方法
        return this.color;
    }

    @Override
    public boolean equals(Object obj) {  //重写equals方法
        if (obj == null) {  //如果输入的数据为空，返回false
            return false;
        }
        if (!(obj instanceof Cat)) {  //测试obj是否是Cat的实例，如果是，则返回true
            return false;  //如果obj不是Cat的实例，返回false
        }
        if (this == obj) {
            return true;
        }
        Cat cat = (Cat) obj;
        return this.name.equals(cat.name) && this.color.equals(cat.color);
    }
    public String toString() {
        return this.color + " 的 " + this.name;
    }
}

class Dog12 implements IPet {  //猫实现了宠物接口
    private String name;
    private String color;
    public Dog12(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String getName() {  //重写接口中的方法
        return this.name;
    }
    @Override
    public String getColor() {  //重写接口中的方法
        return this.color;
    }

    @Override
    public boolean equals(Object obj) {  //重写equals方法
        if (obj == null) {  //如果输入的数据为空，返回false
            return false;
        }
        if (!(obj instanceof Dog12)) {  //测试obj是否是Cat的实例，如果是，则返回true
            return false;  //如果obj不是Cat的实例，返回false
        }
        if (this == obj) {
            return true;
        }
        Dog12 dog = (Dog12) obj;
        return this.name.equals(dog.name) && this.color.equals(dog.color);
    }
    public String toString() {
        return this.color + " 的 " + this.name;
    }
}
























