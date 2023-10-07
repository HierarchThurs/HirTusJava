/**
 * {@code @author}          Hierarch
 * {@code @file}            BallHeight
 * {@code @project}         HirTusJava
 * {@code @software}        IntelliJ IDEA
 * {@code @create}          2023-10-04 9:35
 * {@code @Description}
 * 一球从 h 米高度自由落下，每次落地后反跳原高度的一半再落下，求它在第 n 次落地时共经过了多少米?第 n 次返弹多高?
 * 输入描述:
 * 输入小球下落的高度和落地的次数 (先输入小球初始高度再输入反弹次数)
 * 输出描述:
 * 输出小球第 n 次 落地时经过的距离和第 n 次反弹的高度(保留小数点后1位)
 */
public class BallHeight {
    public static void main(String[] args) {
        Ball ball = new Ball(120, 4);
        ball.height();

    }
}
class Ball {
    private double h;
    private int n;

    public Ball(double h, int n) {
        this.h = h;
        this.n = n;
    }

    public void height() {
        double total = this.h;
        this.h = this.h / 2;
        for (int num = 2; num <= n; num++) {
            total += this.h * 2;
            this.h = this.h / 2;

        }
        System.out.println(total + "、" + this.h);
    }
}
