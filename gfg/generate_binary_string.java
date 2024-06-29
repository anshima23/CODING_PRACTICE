import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class generate_binary_string {
     public List<String> generate_binary_string(String input) {
        List<String> result = new ArrayList<>();
        generateAllCombinations(input.toCharArray(), 0, result);
        Collections.sort(result); // Sort the result to ensure lexicographical order
        return result;
    }

    // Recursive function to generate all combinations
    private void generateAllCombinations(char[] input, int index, List<String> result) {
        if (index == input.length) {
            result.add(new String(input));
            return;
        }

        if (input[index] == '?') {
            // Replace '?' with '0' and recurse
            input[index] = '0';
            generateAllCombinations(input, index + 1, result);

            // Replace '?' with '1' and recurse
            input[index] = '1';
            generateAllCombinations(input, index + 1, result);

            // Backtrack to restore the original state
            input[index] = '?';
        } else {
            // If current character is not '?', just move to the next character
            generateAllCombinations(input, index + 1, result);
        }
    }
}
