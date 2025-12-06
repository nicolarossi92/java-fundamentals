import java.util.Random; // this is an import statement, mandatory for any class outside java.lang

public class WithImportsMustCompile {

    public static void main(String[] args){
        Random rd = new Random(); // This time it will compile
        System.out.println("The following is a random number: " + rd.nextInt(5));
    }
}