
class Solution {
    int[] parent, size;
    boolean[] boundary;

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return;

        if (size[pa] < size[pb]) {
            parent[pa] = pb;
            size[pb] += size[pa];
            boundary[pb] = boundary[pa] || boundary[pb];
        } else {
            parent[pb] = pa;
            size[pa] += size[pb];
            boundary[pa] = boundary[pa] || boundary[pb];
        }
    }

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        parent = new int[total];
        size = new int[total];
        boundary = new boolean[total];

        for (int i = 0; i < total; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // Mark land cells touching the grid boundary.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 &&
                    (i == 0 || i == m - 1 ||
                     j == 0 || j == n - 1)) {
                    boundary[i * n + j] = true;
                }
            }
        }

        // Connect adjacent land cells.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) continue;

                int id = i * n + j;

                if (i + 1 < m && grid[i + 1][j] == 0) {
                    union(id, (i + 1) * n + j);
                }

                if (j + 1 < n && grid[i][j + 1] == 0) {
                    union(id, i * n + j + 1);
                }
            }
        }

        // Count distinct closed components.
        int count = 0;

        for (int i = 0; i < total; i++) {
            int r = i / n;
            int c = i % n;

            if (grid[r][c] != 0) continue;

            int root = find(i);

            if (root == i && !boundary[root]) {
                count++;
            }
        }

        return count;
    }
}
