package HPU;

/**
 * {@code @Description}
 * {@code @author}          Hierarch
 * {@code @file}            Day05
 * {@code @project}         HirTusJava
 * {@code @software}        IntelliJ IDEA
 * {@code @create}          2023-09-26 17:22
 */
public class Day05 {
    public static void main(String[] args) {
        Distance d = new Distance(1, 2, 3, 4);
        System.out.println(d.ABDistance());

        GreatestCommonDivisor g = new GreatestCommonDivisor(24, 16);
        System.out.println(g.calculate());
    }
}

class Distance {
    private double x1;
    private double x2;
    private double y1;
    private double y2;

    //构造方法
    Distance() {}
    Distance(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    //setter getter
    public void setX1(double x1) {
        this.x1 = x1;
    }
    public void setY1(double y1) {
        this.y1 = y1;
    }
    public void setX2(double x2) {
        this.x2 = x2;
    }
    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getX1() {
        return this.x1;
    }

    public double getY1() {
        return this.y1;
    }

    public double getX2() {
        return this.x2;
    }
    public double getY2() {
        return this.y2;
    }

    public double ABDistance () {
        return Math.sqrt((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
    }
}

class GreatestCommonDivisor {
    private int m;
    private int n;

    //构造方法
    GreatestCommonDivisor() {}
    GreatestCommonDivisor(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public int calculate() {
        int r = this.m % this.n;
        if (r == 0) {
            return this.n;
        }else {
            this.m = this.n;
            this.n = r;
            return calculate();
        }
    }
}