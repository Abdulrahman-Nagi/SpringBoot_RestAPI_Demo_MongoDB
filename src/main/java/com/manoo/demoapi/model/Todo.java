package com.manoo.demoapi.model;


import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;



@Document(collection = "todo")
public class Todo {

    @Id
    private String id;

    @NotNull(message = "Title cannot be empty")
    @Size(max = 10,min = 3,message = "word cannot be less than 3 characters or more than 10 chars")
    private String title;

    @NotNull(message = "you should type the description")
    @Size(max = 10,message = "you cannot type over than 10 characters")
    @NotEmpty
    private String description;


    private long timeStamp;

    private String userid;

    private List<SubTodo> subTodos;

    private  SubTodo subTodo;







    public Todo(String id, String title, String description,List<SubTodo> subTodos,SubTodo subTodo) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.timeStamp=System.currentTimeMillis();
        this.subTodos=subTodos;
        this.subTodo=subTodo;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public List<SubTodo> getSubTodos() {
        return subTodos;
    }

    public void setSubTodos(List<SubTodo> subTodos) {
        this.subTodos = subTodos;
    }

    public SubTodo getSubTodo() {
        return subTodo;
    }

    public void setSubTodo(SubTodo subTodo) {
        this.subTodo = subTodo;
    }
}

