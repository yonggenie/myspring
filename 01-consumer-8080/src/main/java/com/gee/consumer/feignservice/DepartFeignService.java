package com.gee.consumer.feignservice;


import com.gee.consumer.bean.Depart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "gee-provider-depart",path="/provider")
public interface DepartFeignService {

    @PostMapping(value = "/provider/depart/save")
    boolean saveDepart(@RequestBody Depart depart);

    @DeleteMapping(value = "/provider/del/{id}")
    boolean removeDepartById(@PathVariable("id") int id);


    @PutMapping("/provider/update")
    boolean modifyDepart(@RequestBody Depart depart);


    @GetMapping("/provider/get/{id}")
    Depart getDepartById(@PathVariable("id") int id);


    @GetMapping("/provider/list")
    List<Depart> listAllDeparts();
}
