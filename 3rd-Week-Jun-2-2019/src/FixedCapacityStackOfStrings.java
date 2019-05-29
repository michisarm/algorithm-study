public class FixedCapacityStackOfStrings {

    private String[] s;
    private int N = 0;

    //사용자에게 용량을 정하게 함.. 유연성 부족
    public FixedCapacityStackOfStrings(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        s[N++] = item;
    }

    public String pop() {

        // loitering
        // 더이상 참조하지 않는 객체를 스택 내부의 배열에 저장해두는 문제
        // N을 감소 시키면 배열 내에는 스택에서 제외된 아이템의 포인터가 남아있음.
        // return s[--N];

        // 직접 null setting
        String item = s[--N];
        s[N] = null;
        return item;
    }
}