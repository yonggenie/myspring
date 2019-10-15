package com.gee.consumer.service;


import com.gee.consumer.bean.Depart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 *把service当成controller来处理 @RequestBody  @PathVariable  切记不能少
 */

@Service
@FeignClient("gee-provider-depart")
@RequestMapping("/provider/depart")
public interface DepartService {

    @PostMapping("/save")
    boolean saveDepart(@RequestBody Depart depart);

    @DeleteMapping("/del/{id}")
    boolean removeDepartById(@PathVariable int id);

    @PutMapping("/update")
    boolean modifyDepart(@RequestBody Depart depart);

    @GetMapping("/get/{id}")
    Depart getDepartById(@PathVariable int id);

    @GetMapping("/list")
    List<Depart> listAllDeparts();


}
