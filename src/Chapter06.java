/**
 * {@code @Description}
 * {@code @author}          Hierarch
 * {@code @file}            Chapter06.java
 * {@code @project}         MyJava
 * {@code @software}        IntelliJ IDEA
 * {@code @create}          2023-08-19 10:06
 */
public class Chapter06 {
    public static void main(String[] args) {
        int[] data = new int[] {1, 4, 2, 6, 9, 7, 3, 8, 10, 5};
        ArrayUtil array = new ArrayUtil(data);
        System.out.println(array.getInfo());
        ArraySort.Sort(data);
        ArraySort.printArray(data);
        System.out.println();

        ArrayReverse.reverse(data);
        ArrayReverse.printArray(data);
    }
}

class ArrayUtil {
    //求出数组的最大值，最小值，平均值，总和
    private int minValue;
    private int maxValue;
    private int sum;
    private double average;

    //构造方法
    public ArrayUtil() {}
    public ArrayUtil(int[] data) {
        this.minValue = data[0];
        this.maxValue = data[0];
        for (int b : data) {
            if (this.minValue > b) {
                this.minValue = b;
            }
            if (this.maxValue < b) {
                this.maxValue = b;
            }
            this.sum += b;
        }
        this.average = (double) this.sum / data.length;
    }
    //getter、setter方法
    public double getAverage() {
        return average;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getSum() {
        return sum;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
    public String getInfo() {
        return "最大值：" + this.maxValue +
                "\n最小值：" + this.minValue +
                "\n平均值：" + this.average +
                "\n和：" + this.sum;
    }
}

class ArraySort {
    //数组排序
    public static void Sort(int[] data) {
        //不使用普通方法而使用static方法的原因是类中没有成员属性，即便产生了实例化对象，也没有任何意义
        for (int x = 0; x < data.length; x++) {
            for (int y = 0; y < data.length - x - 1; y++) {
                if (data[y] > data[y + 1]) {
                    int temp = data[y];
                    data[y] = data[y + 1];
                    data[y + 1] = temp;
                }
            }
        }
    }

    //打印数组
    public static void printArray(int[] data) {
        for (int x : data) {
            System.out.print(x + "、");
        }
    }
}

class ArrayReverse {
    //数组转置
    public static void reverse (int[] data) {
        int center = data.length / 2;  //定义中心
        int head = 0;  //定义头角标
        int tail = data.length - 1;  //定义尾角标
        for (int x = 0; x < center; x ++) {
            int temp = data[head];
            data[head] = data[tail];
            data[tail] = temp;
            head++;
            tail--;
        }
    }
    public static void printArray(int[] data) {
        for (int x : data) {
            System.out.printf(x + "、");
        }
    }
}