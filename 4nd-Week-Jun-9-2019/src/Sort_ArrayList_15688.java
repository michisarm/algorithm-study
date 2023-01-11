import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sort_ArrayList_15688 {

    private static int arraySize;
    private static ArrayList<Integer> array = new ArrayList();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arraySize = Integer.parseInt(br.readLine());
        int readLine;
        for (int i = 0; i < arraySize; i++) {
            readLine = Integer.parseInt(br.readLine());
            array.add(readLine);
        }

        Collections.sort(array);
//        Collections.sort(array, new AscendingInteger());
        for (Integer a : array) {
            System.out.println(a);
        }
    }

    static class AscendingInteger implements Comparator<Integer>{
        @Override
        public int compare (Integer a, Integer b){
          return b.compareTo(a);
        }
    }

}
