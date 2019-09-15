package com.manoo.demoapi.presistance;


import com.manoo.demoapi.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITodoRepo extends MongoRepository<Todo,String> {


    Todo findByTitle(String title);

    List<Todo> findByUserid(String id);









}
