import java.util.concurrent.TransferQueue;

/**
 * {@code @Description}
 * {@code @author}          Hierarch
 * {@code @file}            Chapter09
 * {@code @project}         HirTusJava
 * {@code @software}        IntelliJ IDEA
 * {@code @create}          2023-09-20 8:13
 */
public class Chapter09 {
    public static void main(String[] args) {
        IClassName icn = new Company09();
        System.out.println(icn.getClassName());

        IGraphical iga = Factory.isWhat("triangle", 3, 4, 5);
        if (iga != null) {
            iga.pint();
        }
        IGraphical igb = Factory.isWhat("circular", 3);
        if (igb != null) {
            igb.pint();
        }

        IShape isa = FactoryShape.shapes("rectangle", 3, 4.2);
        if (isa != null) {
            System.out.println(isa.area());
            System.out.println(isa.perimeter());
        }
        IShape isb = FactoryShape.shapes("elliptic", 3, 4);
        if (isb != null) {
            System.out.println(isb.area());
            System.out.println(isb.perimeter());
        }
    }
}

interface IClassName {
    public String getClassName();
}

class Company09 implements IClassName {
    @Override
    public String getClassName() {
        return "Company09";
    }
}

interface IGraphical {
    public abstract void pint();
}

class Circular implements IGraphical {
    private double radius;

    Circular() {}
    Circular(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return this.radius;
    }

    @Override
    public void pint() {
        double perimeter = this.radius * 2 * 3.14;
        double area = this.radius * this.radius * 3.14;
        System.out.println("圆的周长是: " + perimeter);
        System.out.println("圆的面积是: " + area);
    }
}

class Triangle implements IGraphical {
    private double aLength;
    private double bLength;
    private double cLength;

    Triangle() {}
    Triangle(double aLength, double bLength, double cLength) {
        this.aLength = aLength;
        this.bLength = bLength;
        this.cLength = cLength;
    }

    public double getALength() {
        return this.aLength;
    }
    public double getBLength() {
        return this.bLength;
    }
    public double getCLength() {
        return this.cLength;
    }
    public void setALength(double aLength) {
        this.aLength = aLength;
    }
    public void setBLength(double bLength) {
        this.bLength = bLength;
    }
    public void setCLength(double cLength) {
        this.cLength = cLength;
    }

    @Override
    public void pint() {
        double perimeter = aLength + bLength + cLength;
        double p = (aLength + bLength + cLength) / 2;
        double area = Math.sqrt(p * (p - aLength) * (p - bLength) * (p - cLength));
        System.out.println("三角形的周长是: " + perimeter);
        System.out.println("三角形的面积是: " + area);
    }
}

class Factory implements IGraphical {
    @Override
    public void pint() {}
    public static IGraphical isWhat(String what, double... args) {
        if ("triangle".equalsIgnoreCase(what)) {
            return new Triangle(args[0], args[1], args[2]);
        } else if ("circular".equalsIgnoreCase(what)) {
            return new Circular(args[0]);
        }else {
            System.out.println("输入不对");
            return null;
        }
    }
}

interface IShape {
    public abstract double area();
    public abstract double perimeter();
}

class Rectangle implements IShape {
    private double length;
    private double width;

    Rectangle() {}
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    //setter getter
    public void setLength(double length) {
        this.length = length;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getLength() {
        return this.length;
    }
    public double getWidth() {
        return this.width;
    }

    @Override
    public double area() {
        return this.length * this.width;
    }
    public double perimeter() {
        return (this.length * 2) + (this.width * 2);
    }
}

class Elliptic implements IShape {
    private double length;
    private double width;
    Elliptic() {}
    Elliptic(double length, double width) {
        this.length = length;
        this.width = width;
    }

    //setter getter
    public void setLength(double length) {
        this.length = length;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getLength() {
        return this.length;
    }
    public double getWidth() {
        return this.width;
    }

    @Override
    public double area() {
        return this.length * this.width  * 3.14 / 4;
    }
    public double perimeter() {
        return this.width * 3.14 + 2 * (this.length - this.width);
    }
}

class FactoryShape {
    public static IShape shapes(String isShape, double length, double width) {
        if ("rectangle".equalsIgnoreCase(isShape)) {
            return new Rectangle(length, width);
        } else if ("elliptic".equalsIgnoreCase(isShape)) {
            return new Elliptic(length, width);
        }else {
            System.out.println("没有这个");
            return null;
        }
    }
}
