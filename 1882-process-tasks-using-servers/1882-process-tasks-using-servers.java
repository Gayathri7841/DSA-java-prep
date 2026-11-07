
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int m = servers.length;
        int n = tasks.length;
        int ans[] = new int[n];

        PriorityQueue<int[]> free = new PriorityQueue<>((a,b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });

        PriorityQueue<long[]> busy = new PriorityQueue<>((a,b) -> {
            if(a[0] != b[0]) return Long.compare(a[0],b[0]);
            if(a[1] != b[1]) return Long.compare(a[1],b[1]);
            return Long.compare(a[2],b[2]);
        });

        for(int i = 0; i < m; i++) {
            free.offer(new int[]{servers[i], i});
        }

        long time = 0;

        for(int i = 0; i < n; i++) {
            time = Math.max(time, i);

            while(!busy.isEmpty() && busy.peek()[0] <= time) {
                long arr[] = busy.poll();
                free.offer(new int[]{(int)arr[1], (int)arr[2]});
            }

            if(free.isEmpty()) {
                time = busy.peek()[0];

                while(!busy.isEmpty() && busy.peek()[0] <= time) {
                    long arr[] = busy.poll();
                    free.offer(new int[]{(int)arr[1], (int)arr[2]});
                }
            }

            int arr2[] = free.poll();

            busy.offer(new long[]{
                time + tasks[i], arr2[0], arr2[1]
            });

            ans[i] = arr2[1];
        }

        return ans;
    }
}
