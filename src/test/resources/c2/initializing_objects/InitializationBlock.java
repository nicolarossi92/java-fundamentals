public class InitializationBlock{
    public static void main(String[] args){
        System.out.println("Creating object!");
        ClassWithInitializationBlock a = new ClassWithInitializationBlock();
        System.out.println("Object initialized correctly with instance variable: " + a.anInstanceVariable);
    }
}

class ClassWithInitializationBlock {
    int anInstanceVariable;
    {
        System.out.println("Inside initialization block");
        anInstanceVariable = 7;
        System.out.println("Exiting initialization block");
    }
    public ClassWithInitializationBlock(){
        System.out.println("Inside empty constructor");
        System.out.println("Exiting empty constructor");
    }
}