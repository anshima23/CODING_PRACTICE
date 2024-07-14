public class no_atoms {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>()); // Initialize an empty stack with a default map to count atoms
        int i = 0;
        int n = formula.length();

        while (i < n) {
            if (formula.charAt(i) == '(') {
                stack.push(new HashMap<>()); // Push a new empty map onto the stack for a new group
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> top = stack.pop(); // Pop the top map from the stack
                i++;
                int numStart = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplier = (numStart < i) ? Integer.parseInt(formula.substring(numStart, i)) : 1;
                
                // Apply the multiplier to counts in the popped map and add to the current top map
                for (Map.Entry<String, Integer> entry : top.entrySet()) {
                    String element = entry.getKey();
                    int count = entry.getValue();
                    stack.peek().put(element, stack.peek().getOrDefault(element, 0) + count * multiplier);
                }

            } else {
                int elementStart = i;
                i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String element = formula.substring(elementStart, i);
                
                int numStart = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = (numStart < i) ? Integer.parseInt(formula.substring(numStart, i)) : 1;
                
                stack.peek().put(element, stack.peek().getOrDefault(element, 0) + count);
            }
        }

        // Convert the final counts to a sorted map and build the result string
        Map<String, Integer> finalCounts = stack.pop();
        TreeMap<String, Integer> sortedCounts = new TreeMap<>(finalCounts);
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : sortedCounts.entrySet()) {
            result.append(entry.getKey());
            if (entry.getValue() > 1) {
                result.append(entry.getValue());
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.countOfAtoms("H2O"));        // Output: "H2O"
        System.out.println(solution.countOfAtoms("Mg(OH)2"));    // Output: "H2MgO2"
        System.out.println(solution.countOfAtoms("K4(ON(SO3)2)2")); // Output: "K4N2O14S4"
    }
}
