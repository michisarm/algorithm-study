import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int testCount;
    public static int N;
    public static int I;
    public static int J;
    public static int[] cluster;
    public static int[] length;
    public static String type;

    public static void union(int p, int q) {
//        int i = root(p);
//        int j = root(q);
//        cluster[i] = j;
        cluster[p] = q;
        length[p] = Math.abs((p + 1) - (q + 1)) % 1000;
    }

    public static int getLength(int i) {
        int size = 0;
        while (i != cluster[i]) {
            size += length[i];
            i = cluster[i];
        }
        return size;
    }
//
//    public static int getLength(int i) {
//        if(cluster[i] == i){
//            return i;
//        }else{
//            int tmp = getLength(cluster[i]);
//            length[i] += length[cluster[i]];
//            cluster[i] = tmp;
//            return tmp;
//        }
//    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            testCount = Integer.parseInt(br.readLine());
            for (int i = 0; i < testCount; i++) {
                String readLine;
                while ((readLine = br.readLine()) != null) {
                    String[] tmp = readLine.split(" ");
                    type = tmp[0];
                    if ("E".equals(type)) {
                        I = Integer.parseInt(tmp[1]);
                        int result = getLength(I - 1);
                        System.out.println(result);
//                        getLength(I - 1);
//                        System.out.println(length[I-1]);
                    } else if ("I".equals(type)) {
                        I = Integer.parseInt(tmp[1]);
                        J = Integer.parseInt(tmp[2]);
                        union(I - 1, J - 1);
                    } else if ("O".equals(type)) {
                        break;
                    } else {
                        N = Integer.parseInt(type);
                        cluster = new int[N];
                        length = new int[N];
                        for (int j = 0; j < N; j++) {
                            cluster[j] = j;
                            length[j] = 0;
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            br.close();
        }
    }
}


