package com.gee.consumer.controller;

import com.gee.consumer.bean.Depart;
import com.gee.consumer.feignservice.DepartFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer/depart")
public class DepartController {
    @Autowired
    DepartFeignService departFeignService;

    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Depart depart) {
       return departFeignService.saveDepart(depart);
    }

    @DeleteMapping("/del/{id}")
    public void deleteHandle(@PathVariable("id") int id) {
        boolean  result = departFeignService.removeDepartById(id);
        System.out.println("result==========" + result);
    }

    @PutMapping("/update")
    public void updateHandle(@RequestBody Depart depart) {
        boolean result = departFeignService.modifyDepart(depart);
        System.out.println("result==========" + result);
    }

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id) {
        return departFeignService.getDepartById(id);
    }

    @GetMapping("/list")
    public List<Depart> listHandle() {
        return departFeignService.listAllDeparts();
    }
}
