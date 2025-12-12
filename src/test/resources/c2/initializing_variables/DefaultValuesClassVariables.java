public class DefaultValuesClassVariables{
    static int AN_INT;
    static long A_LONG;
    static boolean A_BOOLEAN;
    static char A_CHAR;
    static Object AN_OBJECT;


    public static void main(String[] args){
        System.out.println("Default values for class variables");
        System.out.println("Default value for int is : " + AN_INT);
        System.out.println("Default value for long is : " + A_LONG);
        System.out.println("Default value for boolean is : " + A_BOOLEAN);
        System.out.println("Default value for char is : " + Integer.toHexString((int) A_CHAR ));
        System.out.println("Default value for an object is : " + AN_OBJECT);
    }
}