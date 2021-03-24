import java.util.*;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.profit = y;
        this.deadline = z;
    }
}

class Job_op {
    // return an array of size 2 having the 0th element equal to the count
    // and 1st element equal to the maximum profit
    int FindMax(Job arr[], int n) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, arr[i].deadline);
        }
        return ans;
    }

    int[] JobScheduling(Job arr[], int n) {
        // Your code here
        Arrays.sort(arr, new Comparator<Job>() {
            public int compare(Job j1, Job j2) {
                if (j1.profit < j2.profit)
                    return 1;
                if (j1.profit > j2.profit)
                    return -1;
                if (j1.deadline < j2.deadline)
                    return 1;
                if (j1.deadline > j2.deadline)
                    return -1;
                return 0;
            }
        });
        // for(Job i:arr){
        // System.out.println("Value:"+i.profit);
        // }
        int max = FindMax(arr, n);
        int total = 0;
        boolean vis[] = new boolean[max + 1];
        int count = 0;
        Arrays.fill(vis, false);
        for (Job i : arr) {
            if (vis[i.deadline] == false) {
                vis[i.deadline] = true;
                count++;
                total += i.profit;
            } else {
                int t = i.deadline - 1;
                while (t != 0 && vis[t] == true) {
                    t--;
                }
                if (t != 0) {
                    count++;
                    vis[t] = true;
                    total += i.profit;
                }
            }
        }
        int res[] = { count, total };
        return res;
    }
}

public class JobSequence {
    public static void main(String[] args) {
        int n = 5;
        Job[] arr = new Job[5];
        int profit[] = { 25, 35, 30, 20, 12, 15, 5 };
        int deadline[] = { 4, 3, 4, 2, 1, 3, 2 };
        for (int i = 0; i < n; i++) {
            arr[i] = new Job(i + 1, profit[i], deadline[i]);
        }
        Job_op j1 = new Job_op();
        int res[] = j1.JobScheduling(arr, n);
        System.out.println("Count for maximum profit:" + res[0]);
        System.out.println(" Maximum profit:" + res[1]);
    }
}