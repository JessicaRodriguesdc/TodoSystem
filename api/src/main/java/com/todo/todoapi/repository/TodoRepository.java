package com.todo.todoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.todoapi.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}
