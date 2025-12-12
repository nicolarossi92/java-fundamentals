public class ConditionalUninitializedLocalVariable {

    // Won't compile since x might have not been initialized in the else branch
    public static void main(String[] args){
        int y = 5;
        int x;
        if(y == 3){
            x = 3;
        }else{
            y++;
        }
        int z = y + x; // Won't compile
    }
}