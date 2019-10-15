package com.gee.consumer.controller;

import com.gee.consumer.bean.Depart;
import com.gee.consumer.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer/depart")
public class DepartController {
    @Autowired
    private DepartService departService;



    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Depart depart) {
        return departService.saveDepart(depart);
    }

    @DeleteMapping("/del/{id}")
    public boolean deleteHandle(@PathVariable("id") int id) {
        return departService.removeDepartById(id);
    }

    @PutMapping("/update")
    public boolean updateHandle(@RequestBody Depart depart) {
        return departService.modifyDepart(depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id) {
        return departService.getDepartById(id);
    }

    @GetMapping("/list")
    public List<Depart> listHandle() {
        return departService.listAllDeparts();
    }
}
