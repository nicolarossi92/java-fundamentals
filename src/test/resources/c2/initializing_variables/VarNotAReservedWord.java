public class VarNotAReservedWord{
    public static void main(String[] args){
        Object var = new Object(); // valid identifier, will compile
    }

    public static void var(){} //valid identifier for a method name, will compile
}