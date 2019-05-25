import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private double[] experimentScores;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) {
        int row, col;
        int i;

        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();

        Percolation[] percolations = new Percolation[trials];
        experimentScores = new double[trials];
        for (i = 0; i < trials; i++) {
            percolations[i] = new Percolation(n);
            while (!percolations[i].percolates()) {
                row = StdRandom.uniform(1, n + 1);
                col = StdRandom.uniform(1, n + 1);
                percolations[i].open(row, col);
            }
            experimentScores[i] = 1.0 * percolations[i].numberOfOpenSites() / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(experimentScores);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(experimentScores);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(experimentScores.length);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(experimentScores.length);
    }

    // test client (described below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats percolationStats = new PercolationStats(n, t);

        StdOut.printf("mean                    = %f\n", percolationStats.mean());
        StdOut.printf("stddev                  = %f\n", percolationStats.stddev());
        StdOut.println("95% confidence interval = " + percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi());
    }
}