public class NullReferenceAllowedWithVar{
    public static void main(String[] args){
        var i = (String) null; // Will compile, the compiler now knows which type is var referring to during initialization
    }
}