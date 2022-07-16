package interfaces_anotations.models;

public class Dragon extends Enemy implements Flyable{

    @Override @ExampleAnnotation
    public void fly() {

    }
}
