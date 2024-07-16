package ru.nurullin.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.nurullin.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom", "Johnson", 30, 5.5, "monter", "Tomas"));
        people.add(new Person(++PEOPLE_COUNT, "Tim", "Johnson", 23, 1.5, "monter", "Tomas"));
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

        personToBeUpdated.setWorkName(updatedPerson.getWorkName());
        personToBeUpdated.setWorkSurname(updatedPerson.getWorkSurname());
        personToBeUpdated.setWorkAge(updatedPerson.getWorkAge());
        personToBeUpdated.setWorkExp(updatedPerson.getWorkExp());
        personToBeUpdated.setWorkSpec(updatedPerson.getWorkSpec());
        personToBeUpdated.setManName(updatedPerson.getManName());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}