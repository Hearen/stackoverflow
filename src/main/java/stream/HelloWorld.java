package stream;

public class HelloWorld {
    public static void main(String... args) {
        System.out.println("Hello world");
        int[][] multi_array = {{1, 3, 4, 5}, {6, 2, 7, 10}, {12, 13, 14, 15}, {25, 30, 40, 50}};

        for (int i = 0; i < multi_array.length; i++) {
            for (int j = multi_array.length - 1; j > -1; j--) {
                if (j + i == multi_array.length - 1)
                    System.out.printf("%5d", multi_array[i][j]);
            }
        }
        System.out.println();
        for (int i = 0; i < multi_array.length; i++) {

            for (int j = 0; j < multi_array[i].length; j++) {

                if (i != 3)
                    System.out.printf("%5d", multi_array[i++][j]);
                else
                    System.out.printf("%5d%n", multi_array[i][j]);

            }

            System.out.println();
        }

    }
}
