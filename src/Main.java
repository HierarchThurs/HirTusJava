// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }
    }
}
class Test {
    //打印九九乘法表
    public static void main(String[] args) {
        for(int i = 1;i <= 9;i++) {
            for(int j = 1;j <= i;j++) {
                System.out.print(i+"*"+j+"="+i*j+" ");
            }
            System.out.println();
        }
        //打印斐波那契数列
        int a = 1;
        int b = 1;
        int c;
        System.out.print(a+" "+b+" ");
        for(int i = 1;i <= 10;i++) {
            c = a+b;
            System.out.print(c+" ");
            a = b;
            b = c;
        }
    }
}