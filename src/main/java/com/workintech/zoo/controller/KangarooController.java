package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangroo;
import com.workintech.zoo.exceptions.ZooException;
import com.workintech.zoo.exceptions.ZooValidate;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangroos")
public class KangarooController {
 private Map<Long, Kangroo> kangrooMap;
 @PostConstruct
 public void createKangrooMap(){
     kangrooMap=new HashMap<>();
 }
@GetMapping("/")
 public List<Kangroo> allKangroos(){
     List<Kangroo> result=new ArrayList<>(kangrooMap.values());
     return result;
 }
 @GetMapping("/{id}")
 public Kangroo kangrooWithID(@PathVariable long id){
     ZooValidate.isIdNotValid(id);
  ZooValidate.isKangrooNotExist(kangrooMap,id);
     return  kangrooMap.get(id);
 }
 @PostMapping("/")
 public Kangroo createKangroo(@RequestBody Kangroo kangroo){
    ZooValidate.isKangrooIdentityNotValid(kangroo);
     kangrooMap.put(kangroo.getId(),kangroo);
     return kangrooMap.get(kangroo.getId());
 }
 @PutMapping("/{id}")
 public Kangroo updateKangroo(@PathVariable long id,@RequestBody Kangroo kangroo){
      kangrooMap.replace(id,kangroo);
     return kangrooMap.get(id);
 }
 @DeleteMapping("/{id}")
 public Kangroo deleteKangroo(@PathVariable long id){
     Kangroo result=kangrooMap.get(id);
     kangrooMap.remove(id);
     return result;
 }
}
