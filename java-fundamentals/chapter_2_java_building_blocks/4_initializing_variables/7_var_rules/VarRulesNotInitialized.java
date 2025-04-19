public class VarRulesNotInitialized {

    public static void main(String[] args){
        var i; // Won't compile. Local type inference requires both declaration and initialization
        i = 1;
    }
}