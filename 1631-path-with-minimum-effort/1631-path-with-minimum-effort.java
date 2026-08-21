class Solution {
    class Pair {
        int row;
        int col;
        int effort;

        Pair(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        final int INF = (int) 1e9;

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((x, y) ->
                Integer.compare(x.effort, y.effort));

        int[][] distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = INF;
            }
        }

        distance[0][0] = 0;
        pq.offer(new Pair(0, 0, 0));

        while (!pq.isEmpty()) {

            Pair p = pq.poll();

            int i = p.row;
            int j = p.col;
            int d = p.effort;

            if (i == n - 1 && j == m - 1)
                return d;

            // UP
            if (i - 1 >= 0) {
                int newEffort = Math.max(
                    d,
                    Math.abs(heights[i][j] - heights[i-1][j])
                );

                if (distance[i-1][j] > newEffort) {
                    distance[i-1][j] = newEffort;
                    pq.offer(new Pair(i-1, j, newEffort));
                }
            }

            // LEFT
            if (j - 1 >= 0) {
                int newEffort = Math.max(
                    d,
                    Math.abs(heights[i][j] - heights[i][j-1])
                );

                if (distance[i][j-1] > newEffort) {
                    distance[i][j-1] = newEffort;
                    pq.offer(new Pair(i, j-1, newEffort));
                }
            }

            // RIGHT
            if (j + 1 < m) {
                int newEffort = Math.max(
                    d,
                    Math.abs(heights[i][j] - heights[i][j+1])
                );

                if (distance[i][j+1] > newEffort) {
                    distance[i][j+1] = newEffort;
                    pq.offer(new Pair(i, j+1, newEffort));
                }
            }

            // DOWN
            if (i + 1 < n) {
                int newEffort = Math.max(
                    d,
                    Math.abs(heights[i][j] - heights[i+1][j])
                );

                if (distance[i+1][j] > newEffort) {
                    distance[i+1][j] = newEffort;
                    pq.offer(new Pair(i+1, j, newEffort));
                }
            }
        }

        return distance[n-1][m-1];
    }
}