public class ReadingAndWritingFields{
    public static void main(String[] args){
        ClassWithFieldInitialization n = new ClassWithFieldInitialization();
        System.out.println("name is : " + n.name);
        System.out.println("surname is : " + n.surname);
        System.out.println("full name is: " + n.full);
    }
}

class ClassWithFieldInitialization {
    String name = "Nicola";
    String surname = "Rossi";
    String full = name + " " + surname; // you can read previous fields inside a field initialization
}