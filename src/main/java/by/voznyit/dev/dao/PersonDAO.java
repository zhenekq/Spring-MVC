package by.voznyit.dev.dao;

import by.voznyit.dev.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int peopleCount = 0;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++peopleCount, "Uliana", "19", "fomina@mail.ru"));
        people.add(new Person(++peopleCount, "Yauheni", "21", "zelman@gan.ru"));
        people.add(new Person(++peopleCount, "Uladzimir","10", "don@mail.ru"));
        people.add(new Person(++peopleCount, "Vladislav", "19", "12345@ooop.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public void save(Person person) {
        person.setId(++peopleCount);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }

    public Person show(int id) {
        Person person;
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId() == id)
                return people.get(i);
        }
        return null;
    }
}
