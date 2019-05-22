import java.util.Scanner;

/**
 * 10000번 입력 테스트
 * 소요시간: 608ms
 */
public class ScannerTimeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        int t;
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            t = Integer.parseInt(sc.nextLine());
        }
        System.out.println("소요시간: "+ (System.currentTimeMillis() - startTime) + "ms");
        sc.close();
    }
}
