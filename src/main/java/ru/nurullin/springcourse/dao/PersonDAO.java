package ru.nurullin.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.nurullin.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neil Alishev
 */
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "AK-74", "carabine", 30));
        people.add(new Person(++PEOPLE_COUNT, "M4", "carabine", 30));
        people.add(new Person(++PEOPLE_COUNT, "M14", "rifle", 20));
        people.add(new Person(++PEOPLE_COUNT, "SKS", "rifle", 10));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setType(updatedPerson.getType());
        personToBeUpdated.setCapacity(updatedPerson.getCapacity());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}