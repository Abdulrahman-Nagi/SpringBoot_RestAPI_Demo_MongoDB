package com.manoo.demoapi.service;


import com.manoo.demoapi.exceptionHandling.ConfilictException;
import com.manoo.demoapi.exceptionHandling.NotFoundException;
import com.manoo.demoapi.model.Todo;
import com.manoo.demoapi.presistance.ITodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoService {


    @Autowired
   ITodoRepo todoRepo;


    /**
     * Get all Todos
     * @return List of all Todos
     */
    public List<Todo> getAllTodos() {

        if(todoRepo.findAll().isEmpty()) {

            throw  new NotFoundException("No Data found");
        }

        return todoRepo.findAll();
    }


    /**
     * Get Todo By userID
     * @return List of Todos of user
     */
public List<Todo> getUserTodos(String id) {

  return   todoRepo.findByUserid(id);
}


    /**
     *
     * @param id
     * @return Todo by ID
     */
    public Todo getTodoByID(String id) {

        try {
            return todoRepo.findById(id).get();
        }
       catch (NoSuchElementException ex ) {

            throw new NotFoundException(String.format("No record with the ID [%s] was found",id));
       }
     }


    /**
     *
     * @param todo
     * @return saving Todo
     */
    public Todo saveTodo(Todo todo) {

        if(todoRepo.findByTitle(todo.getTitle())!=null){
            throw new ConfilictException(String.format("The Title [%s]  already exists",todo.getTitle()));
        }
        return todoRepo.save(todo);
    }


    /**
     *
     * @param id
     * Delete Todo by ID
     */
    public void deleteTodoByID(String id) {

        if(!todoRepo.existsById(id)){
          throw new NotFoundException(String.format("The ID [%s] you select not found for Deleting",id));

        }

            todoRepo.deleteById(id);


        }


    /**
     * Delete all Todos
     */

    public void deleteAllTodos() {

        if(todoRepo.findAll().isEmpty()) {

            throw  new NotFoundException("No such Data for Delete");
        }

        todoRepo.deleteAll();
    }
}
