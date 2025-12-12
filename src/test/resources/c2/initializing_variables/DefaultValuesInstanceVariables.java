public class DefaultValuesInstanceVariables {
    public static void main(String[] args){
        ClassWithDefaultValues a = new ClassWithDefaultValues();
        System.out.println("Default values for instance variables");
        System.out.println("Default value for int is : " + a.anInt);
        System.out.println("Default value for long is : " + a.aLong);
        System.out.println("Default value for boolean is : " + a.aBoolean);
        System.out.println("Default value for char is : " + Integer.toHexString((int)a.aChar));
        System.out.println("Default value for an object is : " + a.anObject);
    }
}

class ClassWithDefaultValues{
    int anInt;
    long aLong;
    boolean aBoolean;
    char aChar;
    Object anObject;
}