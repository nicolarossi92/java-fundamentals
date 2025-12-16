public class LargerScopeAccess {
    public static void main(String[] args){
        int largerScopedVariable = 1;
        if(largerScopedVariable == 1){
            int smallerScopedVariable = largerScopedVariable + 1; // Valid, smaller scoped variables can access outside variable in the larger limiting scope
            System.out.printf("Value of  smallerScopedVariable is equal to largerScopedVariable + 1: %d", smallerScopedVariable);
        }

    }
}