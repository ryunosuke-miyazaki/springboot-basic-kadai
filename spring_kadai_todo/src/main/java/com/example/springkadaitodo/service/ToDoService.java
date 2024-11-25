package com.example.springkadaitodo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.repository.ToDoRepository;

@Service
public class ToDoService {
	
	private final ToDoRepository toDoRepository;
	
	//DI
	public ToDoService(ToDoRepository toDoRepository) {
		this.toDoRepository = toDoRepository;
	}

	//ToDoの登録メソッド（後程追記予定）
	public void CreateTask(String title , String priority , String status) {
		
		//空文字チェック
		if(title == null || title.isBlank()) {
			throw new IllegalArgumentException("タスク名を入力してください");
		}
		
		//重複チェック
		if(!toDoRepository.findByTitle(title).isEmpty()) {
			throw new IllegalArgumentException("そのタスクは既に登録済みです");
		}
		
		//Entityの生成
		ToDo toDo = new ToDo();
		toDo.setTitle(title);
		toDo.setPriority(priority);
		toDo.setStatus(status);
		
		//Entityの登録
		toDoRepository.save(toDo);
	}
	
	//すべてのEntityの取得
	public List<ToDo> getAllToDos(){
		return toDoRepository.findAll();
	}
}
