public class VarRulesNullReference{
    public static void main(String[] args){
        var i = null; // Won't compile. Var cannot infer the type if it assigned a null reference
    }
}