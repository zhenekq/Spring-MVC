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
        people.add(new Person(++peopleCount, "Uliana"));
        people.add(new Person(++peopleCount, "Yauheni"));
        people.add(new Person(++peopleCount, "Uladzimir"));
        people.add(new Person(++peopleCount, "Vladislav"));
    }

    public List<Person> index() {
        return people;
    }

    public void save(Person person){
        person.setId(++peopleCount);
        people.add(person);
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
