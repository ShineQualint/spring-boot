package com.qualint.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.qualint.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/demo")
public class DemoController {

  private List<Integer> database = new ArrayList<>();

  public DemoController() {
    this.database.add(1);
    this.database.add(2);
    this.database.add(2);
    this.database.add(3);
  }

  @Autowired private DemoService service;

  @GetMapping
  public List<Integer> getList() {
    return database;
  }

  @PostMapping
  public List<Integer> addNumber(@RequestBody Integer body) {
    database.add(body);
    return database;
  }

  @PutMapping("/{id}")
  public List<Integer> editValue(@RequestBody Integer target, @PathVariable int id) {
    database.remove(id);
    database.add(target);
    return database;
  }

  @DeleteMapping("/{id}")
  public List<Integer> delHello(@PathVariable int id) {
    database.remove(id);
    return database;
  }

  @GetMapping("/{target}")
  public List<Integer> twoSum(@PathVariable Integer target) {
    return service.twoSum(database, target);
  }
}
