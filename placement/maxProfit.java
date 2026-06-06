
import java.util.Arrays;
import java.util.Comparator;

// class job {
//     int startTime;
//     int endTime;
//     int profit;
//     job(int startTime, int endTime, int profit) {
//         this.startTime = startTime;
//         this.endTime = endTime;
//         this.profit = profit;
//     }
// }
// public class maxProfit {
//     public static int upperBound(job jobs[], int endTime, int target) {
//         int low = 0;
//         int high = endTime;
//         while (low < high) {
//             int mid = (low + high) / 2;
//             if (jobs[mid].endTime <= target) {
//                 low = mid + 1;
//             } else {
//                 high = mid;
//             }
//         }
//         return low;
//     }
//     public static int schedule(int start[], int end[], int profit[]) {
//         int numsJobs = profit.length;
//         job jobs[] = new job[numsJobs];
//         for (int i = 0; i < jobs.length; i++) {
//             jobs[i] = new job(start[i], end[i], profit[i]);
//         }
//         Arrays.sort(jobs, Comparator.comparingInt(job -> job.endTime));
//         int dp[] = new int[numsJobs + 1];
//         for (int i = 0; i < numsJobs; ++i) {
//             int startTime = jobs[i].startTime;
//             int endTime = jobs[i].endTime;
//             int Profit = jobs[i].profit;
//             int latestNonConflict = upperBound(jobs, i, startTime);
//             dp[i + 1] = Math.max(dp[i], dp[latestNonConflict] + Profit);
//         }
//         return dp[numsJobs];
//     }
class job {

    int startTime;
    int endTime;
    int profit;

    job(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
}

class maxProfit {

    static int upperBound(job[] jobs, int endTime, int target) {
        int low = 0;
        int high = endTime;
        while (low < high) {
            int mid = (low + high) / 2;
            if (jobs[mid].endTime <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }

        }
        return low;
    }

    public static int schedule(int startTime[], int endTime[], int profit[]) {
        int numsjobs = profit.length;
        job[] jobs = new job[numsjobs];
        for (int i = 0; i < numsjobs; i++) {
            jobs[i] = new job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(job -> job.endTime));
        int dp[] = new int[numsjobs + 1];
        for (int i = 0; i < numsjobs; ++i) {
            int start = jobs[i].startTime;
            int Profit = jobs[i].profit;

            int latestNonConflict = upperBound(jobs, i, start);
            dp[i + 1] = Math.max(dp[i], dp[latestNonConflict] + Profit);
        }
        return dp[numsjobs];
    }

    public static void main(String[] args) {
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};
        System.out.println(schedule(startTime, endTime, profit));
    }
}
