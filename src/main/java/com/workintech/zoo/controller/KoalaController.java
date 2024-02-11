package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangroo;
import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.ZooValidate;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koala")
public class KoalaController {
    private Map<Long, Koala> koalaMap;
    @PostConstruct
    public void createKoalaMap(){
        koalaMap=new HashMap<>();
    }

    @GetMapping("/")
    public List<Koala> allKoala(){
        //List<Koala> result=new ArrayList<>(koalaMap.values());
        //return result;
        return koalaMap.values().stream().toList();
    }
    @GetMapping("/{id}")
    public Koala koalaWithID(@PathVariable long id){
        ZooValidate.isIdNotValid(id);
        ZooValidate.isKoalaNotExist(koalaMap,id);
        return  koalaMap.get(id);
    }

    @PostMapping("/")
    public Koala createKoala(@RequestBody Koala koala){
        ZooValidate.isKoalaIdentityNotValid(koala);
        koalaMap.put(koala.getId(),koala);
        return koalaMap.get(koala.getId());
    }

    @PutMapping("/{id}")
    public Koala updateKoala(@PathVariable long id,@RequestBody Koala koala){
        koalaMap.replace(id,koala);
        return koalaMap.get(id);
    }
    @DeleteMapping("/{id}")
    public Koala deleteKoala(@PathVariable long id){
        Koala result=koalaMap.get(id);
        koalaMap.remove(id);
        return result;
    }
}
