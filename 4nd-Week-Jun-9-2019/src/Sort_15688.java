import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Sort_15688 {

    private static int arraySize;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arraySize = Integer.parseInt(br.readLine());
        array = new int[arraySize];
        int readLine;
        for (int i = 0; i < arraySize; i++) {
            readLine = Integer.parseInt(br.readLine());
            array[i] = readLine;
            System.out.println(array[i]);
        }

//        ArrayList a = new ArrayList<>();
//        a.sort();
    }
}
