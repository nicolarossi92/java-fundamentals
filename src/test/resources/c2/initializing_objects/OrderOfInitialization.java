public class OrderOfInitialization{
    public static void main(String[] args){
        new ClassWithComplexInitialization();
    }
}

class ClassWithComplexInitialization {
    int value = 0; // 1 this is executed firstly during initialization

    {
        System.out.println("value initialized to : " + value);
        System.out.println("Entering first initialization block!");
        value = value + 3; // 2 this initialization block is run for second
        System.out.println("value: " + value);
        System.out.println("Exiting first initialization block!");
    }

    // 5 (last) constructor code is executed only at the end
    public ClassWithComplexInitialization(){
        System.out.println("Entering constructor!");
        value = value * 2; // 8
        secondValue = secondValue * 2; // 6
        System.out.println("value: " + value);
        System.out.println("second value: " + secondValue);
        System.out.println("Exiting constructor!");
    }

    int secondValue = 5; // 3 then its the turn of this statement, for third



    // 4 this block is run afterwards, right before the constructor
    {
        System.out.println("second value initialized to : " + secondValue);
        System.out.println("Entering second initialization block!");
        value = value + 1;
        System.out.println("value: " + value);
        secondValue = secondValue - 2;
        System.out.println("second value: " + secondValue);
        System.out.println("Exiting second initialization block!");
    }

}