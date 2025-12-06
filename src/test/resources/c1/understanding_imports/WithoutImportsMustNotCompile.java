public class WithoutImportsMustNotCompile {

    public static void main(String[] args){
        Random rd = new Random(); // Will not compile, since no import is found
        System.out.println("The following is a random number: " + rd.nextInt(5));
    }
}