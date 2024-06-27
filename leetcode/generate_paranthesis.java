import java.util.ArrayList;
import java.util.List;

public class generate_paranthesis {
     public static void paranthesis(int left, int right, int n, List<String> ans, StringBuilder temp) {
        if (left == n && right == n) {
            ans.add(temp.toString());
            return;
        }

        if (left < n) {
            temp.append('(');
            paranthesis(left + 1, right, n, ans, temp);
            temp.deleteCharAt(temp.length() - 1); // backtrack
        }

        if (right < left) {
            temp.append(')');
            paranthesis(left, right + 1, n, ans, temp);
            temp.deleteCharAt(temp.length() - 1); // backtrack
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        paranthesis(0, 0, n, ans, temp);
        return ans;
    }
}
