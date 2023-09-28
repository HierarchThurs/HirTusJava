package out;
/**
链表练习，基础链表
 */

interface Ilink<E> {
    //链表公共标准
    public void add(E e);  //在链表末尾增加数据，不允许null数据；
    public int size();  //定义链表大小，长度
    public boolean isEmpty();  //判断是否为空集合；
    /**
     * 获取链表中的全部内容，该内容将以数组的形式返回；
     * @return 如果链表有内容则返回与保存元素个数相当的数组；如果没有内容则返回null；
     */
    public Object[] toArray();

    /**
     * 根据索引获取链表中指定元素内容
     * @param index 要获取的元素的索引
     * @return 制定索引位置的数据
     */
    public E get(int index);

    /**
     * 修改制定索引中的数据内容
     * @param index 要修改的数据索引
     * @param data 要替换的新内容
     */
    public void set(int index, E data);

    /**
     * 查询指定内容是否存在
     * @param data 要查询的数据
     * @return 数据存在则返回true，否则返回false
     */
    public boolean contains(E data);

}

class LinkImpl<E> implements Ilink<E> {
    public LinkImpl() {}
    //使用内部类的结构进行定义，这样内部类和外部类可以直接进行私有成员访问
    private class Node<E> {
        private E data;  //节点保存数据
        private Node<E> next;  //节点引用，指向下一个节点
        private Node<E> front;  //指向上一个节点
        public Node() {}
        public Node(E data) {
            this.data = data;  //构造方法保存数据
        }

        public void addNode(Node<E> newNode) {
            if (this.next == null)  {  //判断下一个节点是否为空
                this.next = newNode;  //若空则添加新节点
                this.next.front = this;
            }else {
                this.next.addNode(newNode);  //递归添加数据
            }
        }

        public void toArrayNode() {
            //在Node子类中定义转换为数组的操作
            LinkImpl.this.returnData[LinkImpl.this.foot++] = this.data;
            if (this.next != null) {
                //如果还有下一个节点，则递归调用
                this.next.toArrayNode();
            }
        }

        public E getNode(int index) {
            if (LinkImpl.this.foot++ == index) {  //索引相同
                return this.data;
            }else {
                return this.next.getNode(index);  //索引不相同递归调用
            }
        }

        public void setNode(int index, E data) {
            if (LinkImpl.this.foot++ == index) {
                this.data = data;
            }else {
                this.next.setNode(index, data);  //递归调用更改数据
            }
        }

        public boolean containsNode(E data) {
            if (this.data.equals(data)) {  //对象比较
                return true;
            }else {
                if (this.next == null) {  //没有下一个 节点
                    return false;
                }else {  //有下一个节点，递归判断
                    this.next.containsNode(data);
                }
            }
            return false;
        }

    }

    //LinkImpl定义属性
    private Node<E> root;  //定义根节点；
    private int count;  //定义元素个数；
    private int foot;  //定义数组操作角标
    private Object[] returnData;  //定义返回的数组；



    @Override
    public void add(E e) {
        if (e == null) {
            return;  //如果保存的数据为空，直接结束方法调用；
        }

        Node<E> newNode = new Node<E>(e);
        if (this.root == null) {
            this.root = newNode;  //跟节点如果没有数据，则保存为根节点
            newNode.front = null;
        }else {
            this.root.addNode(newNode);  //调用Node子类的添加节点方法；
        }
        this.count++;  //链表中元素个数加一；
    }

    @Override
    public int size() {
        return this.count;  //count大小就是链表的size
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;  //长度为0就是空链表；
    }

    @Override
    public Object[] toArray() {
        if (this.isEmpty()) {
            throw new NullPointerException("集合内容为空");
        }
        this.foot = 0;  //角标清零
        this.returnData = new Object[this.count];  //定义数组长度，分配空间
        this.root.toArrayNode();  //利用Node类中的递归进行数据获取
        return this.returnData;  //返回数组；
    }

    @Override
    public E get(int index) {
        if (index >= count) {  //指定的索引比链表长度大
            throw new ArrayIndexOutOfBoundsException("索引不正确");
        }
        this.foot = 0;  //索引下标清零；
        return this.root.getNode(index);  //从根节点开始索引
    }

    @Override
    public void set(int index, E data) {
        if (index >= count) {
            throw new ArrayIndexOutOfBoundsException("索引不正确");
        }
        this.foot = 0;
        this.root.setNode(index, data);
    }

    @Override
    public boolean contains(E data) {
        if (data == null) {
            return false;
        }else {
            return this.root.containsNode(data);
        }
    }
}

public class LinkTest {
    public static void main(String[] args){
        Ilink<String> link = new LinkImpl<String>();
        System.out.println("添加数据前的链表大小: " + link.size());
        link.add("kunkun");
        link.add("fanfan");
        link.add("chen rui");
        link.add("kobi");
        link.add("aWei");
        System.out.println("链表当前元素个数为: " + link.size());

        Object[] result = link.toArray();
        for (Object obj : result) {  //遍历数组
            String str = (String) obj;  //将object类型转换为String
            System.out.print(str + "、");  //输出
        }
        System.out.println();

        System.out.println(link.get(1));

        link.set(3, "Ke bi King!");
        System.out.println(link.get(3));

        System.out.println(link.contains("Ke bi King!"));
        System.out.println(link.contains("asdf"));
    }
}
