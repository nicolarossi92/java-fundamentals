public class UninitializedLocalVariable {
    public static void main(String[] args){
        int i;
        int y = 3;
        int z = i + y; // Won't compile
    }
}