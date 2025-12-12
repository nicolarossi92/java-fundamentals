public class PassingUninitializedArgumentMethod{
    public static void main(String[] args){
        boolean valueToBePassed;
        aMethod(valueToBePassed); // Won't compile because valueToBePassed is left uninitialized
    }

    private static void aMethod(boolean value){

    }
}