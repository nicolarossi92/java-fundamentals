public class ScopeInsideAMethod{
    public static void main(String[] args){
        new ClassWithAMethod().methodWithParameter("Hello i am in scope inside a method!!");

    }
}

class ClassWithAMethod{
    public void methodWithParameter(String name){
        int anotherMethodScopedVariable = 1;
        System.out.println(name); // both the variables: name and anotherMethoScopedVariable are accessible till the end
    }
}