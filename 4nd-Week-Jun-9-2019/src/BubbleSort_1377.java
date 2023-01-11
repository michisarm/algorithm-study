import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSort_1377 {

    private static int arraySize;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arraySize = Integer.parseInt(br.readLine());
        array = new int[arraySize+1];
        int readLine;
        for (int i = 1; i < arraySize+1; i++) {
            readLine = Integer.parseInt(br.readLine());
            array[i] = readLine;
            //System.out.println(array[i]);
        }
        printChangeCount(arraySize,array);
    }

    private static void printChangeCount(int n, int[] a){
        boolean change;
        for (int i=1; i<=n+1; i++) {
            //System.out.println("for i = " + i);
            change = false;
            for (int j=1; j<=n-i; j++) {
                if (a[j] > a[j+1]) {
                    change = true;
                    //swap(a[j], a[j+1]);
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            if (change == false) {
                System.out.println(i);
                break;
            }
        }
    }
}
