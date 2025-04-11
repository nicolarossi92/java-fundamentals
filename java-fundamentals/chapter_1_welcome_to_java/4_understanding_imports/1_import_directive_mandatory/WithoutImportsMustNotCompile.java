public class WithoutImportsMustNotCompile {

    public static void main(String[] args){
        Random rd = new Random(); // This will not compile, since the compiler doesn't know where to get Random class
        System.out.println("The following is a random number: " + rd.nextInt(5));
    }
}