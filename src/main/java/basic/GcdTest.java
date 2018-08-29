
public class GcdTest {
    static int gcd(int a,int b)
    {
        if(a==b) return a;
        if(a==0 || b==0) return 0;
        if(a>b) return gcd(a-b,b);
        return gcd(a,b-a);
    }
    public static void main(String[] args) {
//        if (args.length < 2) throw new IllegalArgumentException("Please input two numbers to get their gcd");
        int m=Integer.parseInt(args[0]);
        int o=Integer.parseInt(args[1]);
        int x= gcd(m,o);
        System.out.println(x);
    }
}
