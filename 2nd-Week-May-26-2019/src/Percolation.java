import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private WeightedQuickUnionUF uf;
    private int gridSize;
    private final int startPoint;
    private final int endPoint;
    private boolean[][] site; // 픽셀로 생각..
    private int openSiteNumber;


    // create n-by-n grid, with all site blocked
    public Percolation(int n) {
        if (n < 1) throw new IllegalArgumentException();

        uf = new WeightedQuickUnionUF(n * n + 2); // +2 virtual top and bottom

        site = new boolean[n][n];
        openSiteNumber = 0;

        startPoint = 0;
        endPoint = n * n + 1;
        gridSize = n;
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {

        if (row < 1 || row > gridSize || col < 1 || col > gridSize) throw new IndexOutOfBoundsException();

        if (isOpen(row, col)) return;

        site[row - 1][col - 1] = true;
        openSiteNumber++; //totalOpenNumber

        // 1번째 줄은 가상 시작점과 연결
        if (row == 1) {
//            uf.union(getSiteIndex(row, col), startPoint);
            uf.union((row - 1) * gridSize + col, startPoint);
        }

        // 마지막줄은 가상 종료점과 연결
        if (row == gridSize) {
//            uf.union(getSiteIndex(row, col), endPoint);
            uf.union((row - 1) * gridSize + col, endPoint);
        }

        //위쪽 연결 체크
        if ((1 < row && row < gridSize) && isOpen(row - 1, col)) {
//            uf.union(getSiteIndex(row - 1, col), getSiteIndex(row, col));
            uf.union((row - 2) * gridSize + col, (row - 1) * gridSize + col);
        }

        //아래쪽 연결 체크
        if ((1 < row && row < gridSize) && isOpen(row + 1, col)) {
//            uf.union(getSiteIndex(row + 1, col), getSiteIndex(row, col));
            uf.union((row + 0) * gridSize + col, (row - 1) * gridSize + col);
        }

        //왼쪽 연결 체크
        if ((1 < col && col < gridSize) && isOpen(row, col - 1)) {
//            uf.union(getSiteIndex(row, col - 1), getSiteIndex(row, col));
            uf.union((row - 1) * gridSize + (col - 1), (row - 1) * gridSize + col);
        }

        //오른쪽 연결 체크
        if ((1 < col && col < gridSize) && isOpen(row, col + 1)) {
//            uf.union(getSiteIndex(row, col + 1), getSiteIndex(row, col));
            uf.union((row - 1) * gridSize + (col + 1), (row - 1) * gridSize + col);
        }
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 1 || row > gridSize || col < 1 || col > gridSize) throw new IndexOutOfBoundsException();
        return site[row - 1][col - 1];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 1 || row > gridSize || col < 1 || col > gridSize) throw new IndexOutOfBoundsException();
//        return uf.connected(getSiteIndex(row, col), startPoint);
        return uf.connected((row - 1) * gridSize + col, startPoint);
    }

    // number of open site
    public int numberOfOpenSites() {
        return openSiteNumber;
    }

    // does the system percolate?
    public boolean percolates() {
        return numberOfOpenSites() > 0 && uf.connected(startPoint, endPoint);
    }

    //validate
//    public void validate(int row, int col) {
//        if (row < 1 || row > gridSize || col < 1 || col > gridSize) throw new IndexOutOfBoundsException();
//    }

    //get index
//    private int getSiteIndex(int row, int col) {
//        if (row < 1 || row > gridSize || col < 1 || col > gridSize) throw new IndexOutOfBoundsException();
//        return (row - 1) * gridSize + col;
//    }

    // test client (optional)
    public static void main(String[] args) {

    }
}