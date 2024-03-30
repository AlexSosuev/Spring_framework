package Seminar_1;

import Seminar_1.model.Person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Иванов", "Иван", 30);
        String json = person.toJson();
        System.out.println("JSON: " + json);

        Person newPerson = Person.fromJson(json);
        System.out.println("Десериализованный Person: " + newPerson);
    }
}