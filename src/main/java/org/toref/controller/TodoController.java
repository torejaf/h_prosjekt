package org.toref.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.toref.model.Todo;
import org.toref.repo.TodoRepo;

@Controller
public class TodoController {
	
	@Autowired
	TodoRepo todoRepo;
	
	@RequestMapping("/")
	public String home(){
		return "home";
	}
	
	@RequestMapping(value = "/newtask", method=RequestMethod.GET)
	public String newTask(Model model) {
		model.addAttribute("todo", new Todo());
		return "newtask";
	}
	
	@RequestMapping(value = "/newtask", method=RequestMethod.POST)
	public String newTaskAdded(@ModelAttribute Todo todo, Model model) {
		model.addAttribute("todo",todo);
		todoRepo.save(todo);
		return "redirect:/home";
	}
	
    @RequestMapping(method=RequestMethod.GET)
    public String todoList(Model model) {
        List<Todo> todoList = (List<Todo>) todoRepo.findAll();
        if (todoList != null) {
            model.addAttribute("todoList", todoList);
        }
        return "home";
    }
    
    @RequestMapping(value = "/delete", method=RequestMethod.POST)
    public String removeTask(long id, Model model) {
    	todoRepo.delete(id);
        return "redirect:/home";
    }
    
    @RequestMapping(value = "/sortbyfood", method=RequestMethod.GET)
    public String sortByFood(Model model) {
        List<Todo> todoListFood = (List<Todo>) todoRepo.findByFoodTrue();
        if (todoListFood != null) {
            model.addAttribute("todoList", todoListFood);
        }
        return "home";
    }
    
    @RequestMapping(value = "/sortbytransport", method=RequestMethod.GET)
    public String sortByTransport(Model model) {
    	List<Todo> todoListFood = (List<Todo>) todoRepo.findByTransportTrue();
        if (todoListFood != null) {
            model.addAttribute("todoList", todoListFood);
        }
        return "home";
    }
    
    @RequestMapping(value = "/sortbyassignment", method=RequestMethod.GET)
    public String sortByAssignment(Model model) {
    	List<Todo> todoListFood = (List<Todo>) todoRepo.findByAssignmentTrue();
        if (todoListFood != null) {
            model.addAttribute("todoList", todoListFood);
        }
        return "home";
    }    
}
