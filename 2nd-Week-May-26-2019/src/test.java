public class test {
    public static boolean[][] site;
    public static int gridSize;

    public static void open(int row, int col) {
        if (isOpen(row, col)) return;
        System.out.println("opened = "+ Integer.toString(row - 1)  + " , " +  Integer.toString(col - 1) );
        site[row - 1][col - 1] = true;
    }

    // is site (row, col) open?
    public static boolean isOpen(int row, int col) {
        System.out.println("isOpen = "+ site[row - 1][col - 1]);
        return site[row - 1][col - 1];
    }

    public static int getFlattenId(int row, int col) {
        return (row - 1) * gridSize + col;
    }

    public static void main(String[] args) {

        // boolean 테스트
        int n = 4;
        site = new boolean[n][n];
        gridSize = n;

        int row = 1;
        int col = 1;
        open(row,col);
        isOpen(row,col);

        row = 4;
        col = 4;
        open(row,col);
        isOpen(row,col);

        int i = 0;
        for (boolean[] s : site) {
            int j = 0;
            for (boolean value : s) {
                System.out.println("i= "+ i +" , j= " +j+" Value = " + value);
                j++;
            }
            i++;
        }

        //getFlattenId test
        int result;
        result = getFlattenId(row,col);
        System.out.println(result);

        row = 4;
        col = 3;
        result = getFlattenId(row,col);
        System.out.println(result);

    }
}

