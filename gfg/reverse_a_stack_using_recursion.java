
import java.util.Stack;

class reverse_a_stack_using_recursion{
    // Method to reverse the stack
    static void reverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        
        // Remove the top element
        int top = s.pop();
        
        // Reverse the remaining stack
        reverse(s);
        
        // Insert the top element at the bottom of the reversed stack
        insertAtBottom(s, top);
    }
    
    // Helper method to insert an element at the bottom of a stack
    static void insertAtBottom(Stack<Integer> s, int element) {
        if (s.isEmpty()) {
            s.push(element);
            return;
        }
        
        // Remove the top element
        int top = s.pop();
        
        // Insert the element at the bottom of the remaining stack
        insertAtBottom(s, element);
        
        // Put back the top element
        s.push(top);
    }
}
