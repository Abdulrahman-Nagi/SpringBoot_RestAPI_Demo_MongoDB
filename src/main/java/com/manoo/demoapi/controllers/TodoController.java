package com.manoo.demoapi.controllers;

import com.manoo.demoapi.model.SubTodo;
import com.manoo.demoapi.model.Todo;


import com.manoo.demoapi.service.TodoService;
import com.manoo.demoapi.util.BasicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController extends BasicUtil {


    @Autowired
    TodoService todoService;



    @RequestMapping(value = {"","/"})
    public ResponseEntity<List<Todo>> getAlltodos() {


List<Todo> result=todoService.getUserTodos(getCurrentUser().getId());






     return new ResponseEntity<List<Todo>>(result, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable String id) {

        Todo result=todoService.getTodoByID(id);

        return new ResponseEntity<Todo>(result,HttpStatus.OK);
    }

    @PostMapping(value = {"","/"})
    public ResponseEntity<Todo> saveTodo(@Valid @RequestBody Todo todo) {

        todo.setUserid(getCurrentUser().getId());
        Todo result=todoService.saveTodo(todo);


   return new ResponseEntity<Todo>(result,HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String id) {


       Todo todo= todoService.getTodoByID(id);

       if(todo.getUserid().equals(getCurrentUser().getId())){

           todoService.deleteTodoByID(id);

           return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
       }

        return new ResponseEntity<Void>(HttpStatus.METHOD_NOT_ALLOWED);

    }


    @DeleteMapping(value = {"","/"})
    public ResponseEntity<Void> deleteAllTodos() {


        todoService.deleteAllTodos();

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


  @PutMapping(value = "/{id}")
    public ResponseEntity<Void> modifyBossById(@PathVariable String id, @Valid @RequestBody Todo todo) {

        todo.setId(id);
        todoService.saveTodo(todo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
