import java.util.*;
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        
        // Create a list of projects
        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            projects.add(new Project(profits[i], capital[i]));
        }
        
        // Sort projects based on their capital requirement
        projects.sort(Comparator.comparingInt(p -> p.capital));
        
        // Max heap to store profitable projects that can be started
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        int i = 0;
        while (k > 0) {
            // Add all projects that can be started with the current capital
            while (i < n && projects.get(i).capital <= w) {
                maxHeap.add(projects.get(i).profit);
                i++;
            }
            
            // If no projects can be started, break the loop
            if (maxHeap.isEmpty()) {
                break;
            }
            
            // Select the most profitable project
            w += maxHeap.poll();
            k--;
        }
        
        return w;
    }

    // Helper class to store project details
    class Project {
        int profit;
        int capital;

        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
}
