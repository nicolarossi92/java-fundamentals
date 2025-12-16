public class SmallerScopeAccess{
    public static void main(String[] args){
        int largerScopedVariable = 1;
        if(largerScopedVariable == 1){
            int smallerScopedVariable = 2;
        }
        System.out.println(largerScopedVariable); // Compile, no errors: the variable is defined through the entire method
        System.out.println(smallerScopedVariable); // Won't compile. We are trying to access a variable out of its scope
    }
}