package basic;

import java.util.Scanner;

public class MyClock {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        int minute = 0, hour = 0, punchi = 0, puncho = 0, TP, TH = 0, i = 0, o = 0;
        int power = 10;
        boolean k = true;
        String si, so;

        while (k == true) {

            System.out.println("Time: " + hour + ":" + minute);
            k = true;

            minute = minute + 30;

            k = true;
            if (minute == 60) {
                hour = hour + 1;
                minute = 0;
                k = true;
            } else
                k = true;

            if (hour == 24) {
                hour = 0;
                k = true;
            } else
                k = true;

            si = sc.nextLine();
            so = sc.nextLine();

            if (si == "punchi") {
                i = sc.nextInt();
            } else
                k = true;
            i = sc.nextInt();

            if (so == "puncho") {
                o = sc.nextInt();

            } else
                k = true;

            if (o > 0) {
                TH = (TH + o - i);
                o = 0;
                i = 0;

                System.out.println("Power off?");
                power = sc.nextInt();
                k = true;
            } else
                k = true;

            if (power == 9) {
                TP = TH * 14;
                k = false;
                System.out.println("your total pay is " + TP);
            } else
                k = true;

        }


    }

}
