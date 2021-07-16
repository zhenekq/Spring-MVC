package by.voznyit.dev.controller;

import by.voznyit.dev.dao.PersonDAO;
import by.voznyit.dev.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {


    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO){
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", personDAO.index());
        /*List<Person> personList = personDAO.index();
        for(int i=0;i<personList.size();i++){
            System.out.println(personList.get(i).getId());
            System.out.println(personList.get(i).getName());
        }*/
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

}
