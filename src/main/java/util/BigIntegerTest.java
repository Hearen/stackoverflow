package util;

import java.math.BigInteger;

public class BigIntegerTest {
    public static void main(String... args) {
        BigInteger bigInteger = new BigInteger("35127365845782");
        String s = bigInteger.toString();
        BigInteger ret = new BigInteger(new String(new char[s.length()]).replace('\0', '0').replaceFirst("0", "1"));
        System.out.println(bigInteger.toString());
        System.out.println(ret.toString());
    }
}
