import java.util.Arrays;

public class most_profit_assigning_work {
     public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
       int maxProfit = 0;

        // Create an array of jobs with difficulty and profit
        int[][] jobs = new int[difficulty.length][2];
        for (int i = 0; i < difficulty.length; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        // Sort the jobs by difficulty
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // Sort the workers by their ability
        Arrays.sort(worker);

        int jobIndex = 0;
        int bestProfit = 0;

        for (int ability : worker) {
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= ability) {
                bestProfit = Math.max(bestProfit, jobs[jobIndex][1]);
                jobIndex++;
            }
            maxProfit += bestProfit;
        }

        return maxProfit;
    }
}
