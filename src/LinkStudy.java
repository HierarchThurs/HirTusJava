/**
 * {@code @author}          Hierarch
 * {@code @file}            LinkStudy
 * {@code @project}         HirTusJava
 * {@code @software}        IntelliJ IDEA
 * {@code @create}          2023-09-28 20:09
 * {@code @Description}     建立基础链表
 */
public class LinkStudy {
    public static void main(String[] args) {
        ILink<String> link = new LinkImpl<>();
        System.out.println("目前的节点数量: " + link.size());
        link.add("坤坤");
        link.add("科比");
        link.add("老大");
        link.add("阿伟");
        link.add("物资");

        link.getInfo();
        System.out.println("目前的节点数量: " + link.size());

        System.out.println("第 2 个位置的是: " + link.get(2));
        System.out.println("老大 在里面吗: " + link.contains("老大"));


        link.set(2, "zzh");
        System.out.println("第 2 个位置的是: " + link.get(2));

        link.remove("阿伟");
        link.getInfo();
    }
}

interface ILink<E> {
    //链表公共标准
    /**
     * 在链表尾增加数据，不允许null数据;
     * @param data 新增的数据
     */
    void add(E data);

    /**
     * 根据索引获取链表中指定元素的内容
     * @param index 要获取的元素的索引
     * @return 指定索引位置的数据
     */
    E get(int index);

    /**
     * 查询指定内容是否存在
     * @param data 要查询的数据
     * @return 数据存在返回true, 数据不存在返回false;
     */
    boolean contains(E data);

    /**
     * 获取链表长度，一共有几个节点：
     * @return 返回节点数量
     */
    int size();

    /**
     * 删除指定内容的数据
     * @param data 要删除的数据;
     */
    void remove(E data);

    /**
     * 判断链表是否为空表
     * @return 若为空链表，返回true,若不是空链表，返回false;
     */
    boolean isEmpty();

    /**
     * 修改指定索引中的数据内容
     * @param index 要更改的数据的索引
     * @param data 要替换的新内容
     */
    void set(int index, E data);

    /**
     * 清空链表中所有元素
     */
    void clean();

    /**
     * 获取链表中的全部内容，改内容将以数组的形式返回
     * @return 如果链表有内容，则返回与保存元素个数相当的数组，如果没有内容则返回null;
     */
    Object[] toArray();

    /**
     * 遍历链表的全部内容
     */
    void getInfo();
}

class LinkImpl<E> implements ILink<E>{
    //实现接口的工厂
    class Node<E> {
        //实现单个节点
        private E data;  //定义节点的数据
        private Node<E> next; //指向下一个节点;
        private Node<E> previous;  //指向上一个节点;

        public Node (E data) {  //构造方法保存数据
            this.data = data;
        }

        public void addNode (Node<E> newNode) {
            if (this.next == null) {
                newNode.previous = this;
                this.next = newNode;
            }else {  //如果下一个节点不是空的
                this.next.addNode(newNode);  //下一个节点执行添加;
            }
        }

        public E getNode(int index) {
            if (LinkImpl.this.foot == index) {  //索引相同;
                return this.data;
            }else {
                LinkImpl.this.foot++;  //下一个角标
                return this.next.getNode(index);  //递归调用
            }
        }

        public boolean containsNode(E data) {
            boolean isContainsNode;  //定义返回值
            if (this.data.equals(data)) {
                isContainsNode = true;  //匹配到了数据
            }else {
                if (this.next == null) {
                    isContainsNode = false;  //没有这个数据
                }else {
                    isContainsNode = this.next.containsNode(data);  //递归
                }
            }
            return isContainsNode;
        }

        public void removeNode(E data) {
            if (this.data.equals(data)) {
                this.previous.next = this.next;  //上一个节点的next指针指向当前节点的下一个节点
            }else {
                if (this.next == null) {
                    System.out.println("没有此数据");
                }else {
                    this.next.removeNode(data);
                }
            }
        }

        public void setNode(int index, E data) {
            if (LinkImpl.this.foot == index) {  //当前索引相同
                this.data = data;  //赋新值
            }else {
                LinkImpl.this.foot++;
                this.next.setNode(index, data);  //递归调用
            }
        }

        public void toArrayNode() {
            LinkImpl.this.returnData[LinkImpl.this.foot] = this.data;  //给数组赋值
            LinkImpl.this.foot++;  //数组角标
            if (this.next != null) {
                this.next.toArrayNode();  //递归赋值
            }
        }
    }

    //LinkImpl
    private Node<E> root;  //根节点;
    private int foot;  //定义数组角标
    private int count;  //定义节点数量
    private Object[] returnData;  //定义返回数组

    //对接口的实现
    @Override
    public void add (E data) {
        if (data == null) {
            return;  //如果数据为空，直接结束调用；
        }
        Node<E> newNode = new Node<>(data);
        if (this.root == null) {  //如果根节点没有数据
            this.root = newNode;
            this.root.next = null;
            this.root.previous = null;
        }else {  //如果根节点有数据
            this.root.addNode(newNode);
        }
        this.count++;
    }

    @Override
    public E get(int index) {
        if (index >= count) {
            throw new ArrayIndexOutOfBoundsException("索引不正确");
        }
        this.foot = 0;
        return this.root.getNode(index);  //从根节点开始索引，foot从0开始；
    }

    @Override
    public boolean contains(E data) {
        boolean isContains;
        if (data == null) {
            isContains = false;  //数据为空，返回false
        }else {
            isContains = this.root.containsNode(data);  //递归
        }
        return isContains;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public void remove(E data) {
        if (this.contains(data)) {
            if (this.root.data.equals(data)) {  //如果这个数据是根节点的
                this.root = this.root.next;
            }else {
                this.root.removeNode(data);
            }
            this.count--;
        }
    }

    @Override
    public boolean isEmpty() {
        boolean isEmptyNode;
        isEmptyNode = this.count == 0;  //如果count是0个节点，则为空链表
        return isEmptyNode;
    }

    @Override
    public void set(int index, E data) {
        if (index >= this.count) {
            throw new ArrayIndexOutOfBoundsException("索引不正确");
        }
        this.foot = 0;
        this.root.setNode(index, data);
    }

    @Override
    public void clean(){
        this.root = null;
        this.count = 0;
    }

    @Override
    public Object[] toArray() {
        if (this.isEmpty()) {
            throw new NullPointerException("链表为空");
        }
        this.foot = 0;
        this.returnData = new Object[this.count];
        this.root.toArrayNode();
        return this.returnData;
    }

    @Override
    public void getInfo() {
        System.out.print("| ");
        for (Object obj : this.toArray()) {
            String str = (String) obj;
            System.out.print(str + " | ");
        }
        System.out.println();
    }
}