public class TracingEligibilityForGarbageCollection {
    public static void main(String[] args){
        ReferenceCounter<String> a, b;
        a = new ReferenceCounter<>(new String("a"));
        b = new ReferenceCounter<>(new String("b"));
        ReferenceCounter<String> nullReference = new ReferenceCounter<>(null);
        System.out.println("Assigned variable 'one'");
        VariableWrapper<String> firstVariable = new VariableWrapper<>(a, "one");
        System.out.println("Assigned variable 'two'");
        VariableWrapper<String> secondVariable = new VariableWrapper<>(b, "two");
        System.out.println("Variable 'one' assigned to the value of variable 'two'");
        firstVariable.reAssign(secondVariable.objectContainedInVariable);
        System.out.println("Declared new variable 'three' with the value of first variable 'one'");
        VariableWrapper<String> thirdVariable = new VariableWrapper<>(firstVariable.objectContainedInVariable, "three");
        System.out.println("First variable 'one' assigned to null");
        firstVariable.reAssign(nullReference);

        System.out.printf("Object: %s has a number of references equal to %d", a.objectReferenced, a.counterReferences);
        System.out.println();
        System.out.printf("Object: %s has a number of references equal to %d", b.objectReferenced, b.counterReferences);

    }
}

class VariableWrapper<T>{
    ReferenceCounter<T> objectContainedInVariable;
    String variableName;
    public VariableWrapper(ReferenceCounter<T> object, String variableName){
        this.variableName = variableName;
        this.objectContainedInVariable = object;
    }

    public void reAssign(ReferenceCounter<T> newObjectContainedInVariable){
        this.objectContainedInVariable.decreaseCounter();
        this.objectContainedInVariable = newObjectContainedInVariable;
        newObjectContainedInVariable.increaseCounter();
    }

    public void goOutOfScope(){
        this.objectContainedInVariable.decreaseCounter();
        this.objectContainedInVariable = null;
    }
}

class ReferenceCounter<T>{
    T objectReferenced;
    int counterReferences;

    public ReferenceCounter(T objectReferenced){
        this.objectReferenced = objectReferenced;
        increaseCounter();
    }

    public void increaseCounter(){
        counterReferences++;
    }

    public void decreaseCounter(){
        counterReferences--;
        if(counterReferences == 0){
            System.out.printf("Object %s has gone out of scope!", this.objectReferenced);
            System.out.println();
        }
    }
}