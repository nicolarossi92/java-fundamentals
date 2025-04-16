public class DefiningYourOwnConstructor {
    public static void main(String[] args){
        System.out.println("Creating a new instance of ClassWithProperConstructor!");
        ClassWithProperConstructor a = new ClassWithProperConstructor();
        System.out.println("Instance successfully created");
        System.out.println(String.format("Instance variable has a value of: %d", a.anInstanceVariable));
    }
}

class ClassWithProperConstructor{

    int anInstanceVariable;
    public ClassWithProperConstructor(){
        System.out.println("I am inside a constructor!");
        System.out.println(String.format("Initializing instance variable with value %d", 7));
        anInstanceVariable = 7;
        System.out.println("Instance variabile initialized!");
    }

    @Override
    public String toString(){
        return "New Object";
    }
}