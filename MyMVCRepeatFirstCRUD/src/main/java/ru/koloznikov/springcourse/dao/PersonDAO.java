package ru.koloznikov.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.koloznikov.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_CONT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_CONT, "Tom"));
        people.add(new Person(++PEOPLE_CONT, "Pasha"));
        people.add(new Person(++PEOPLE_CONT, "Bob"));
        people.add(new Person(++PEOPLE_CONT, "Katy"));
    }
    public List<Person>index(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_CONT);
        people.add(person);
    }
    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
    }
    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }

}
