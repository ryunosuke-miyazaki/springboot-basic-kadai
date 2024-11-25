package com.example.springkadaitodo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.service.ToDoService;

@Controller
public class ToDoController {
	
	private final ToDoService toDoService;
	
	//DI
	public ToDoController(ToDoService toDoService) {
		
		this.toDoService = toDoService;
	}
	
	@GetMapping("/ToDoList")
	public String ToDoList(Model model) {
		
		//Entityの取得
		List<ToDo> toDoList = toDoService.getAllToDos();
		
		//データをビューに渡す
		model.addAttribute("ToDos",toDoList);
		
		return "ToDoListView";
	}
	
	
}
