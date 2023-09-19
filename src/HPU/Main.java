package HPU;

/**
 * {@code @Description}
 * {@code @author}          Hierarch
 * {@code @file}            Main
 * {@code @project}         HirTusJava
 * {@code @software}        IntelliJ IDEA
 * {@code @create}          2023-09-18 9:06
 */
public class Main {
    public static void main(String[] args) {
        int row = 5;
        //打印5行三角形
        for (int x = 0; x < row; x++) {
            //打印空格
            for (int i = 0; i < row - x - 1; i++) {
                System.out.print(" ");
            }
            for (int j = 0; j < x * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
