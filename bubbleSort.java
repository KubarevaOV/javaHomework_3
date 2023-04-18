import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class bubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите количество элементов в массиве: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Введите элементы массива через Enter:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sort(arr);
        sc.close();
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        try (FileWriter writer = new FileWriter("log.txt")) {
            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        swapped = true;
                    }
                }
                writer.write("Итерация " + (i + 1) + ": ");
                for (int k = 0; k < n; k++) {
                    writer.write(arr[k] + " ");
                }
                writer.write("\n");

                if (!swapped) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Отсортированный массив:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
