import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BufferedReader vs Scanner
 * https://www.baeldung.com/java-buffered-reader
 *
 * As an alternative, we could use the Scanner class to achieve the same functionality as with BufferedReader.
 *
 * However, there are significant differences between these two classes which can make them either more or less convenient for us, depending on our use case:
 *
 * BufferedReader is synchronized (thread-safe) while Scanner is not
 * Scanner can parse primitive types and strings using regular expressions
 * BufferedReader allows for changing the size of the buffer while Scanner has a fixed buffer size
 * BufferedReader has a larger default buffer size
 * Scanner hides IOException, while BufferedReader forces us to handle it
 * BufferedReader is usually faster than Scanner because it only reads the data without parsing it
 * With these in mind, if we are parsing individual tokens in a file, then Scanner will feel a bit more natural than BufferedReader. But, just reading a line at a time is where BufferedReader shines.
 *
 * If needed, we also have a guide on Scanner as well.
 *
 * 10000번 입력 테스트
 * 소요시간: 286ms
 */
public class BufferedReaderTimeTest {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int t;
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            t = Integer.parseInt(br.readLine());
        }
        System.out.println("소요시간: "+ (System.currentTimeMillis() - startTime) + "ms");
    }
}
