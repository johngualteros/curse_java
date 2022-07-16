package pattern_builder;

public class Main {
    public static void main(String[] args) throws Exception {
        Person person = Person.Builder.aPerson()
                .withFirstName("John")
                .withLastName("Gualteros")
                .withEmail("gualteros@gmail.com")
                .withPhone("320866198")
                .build();
    }
}
