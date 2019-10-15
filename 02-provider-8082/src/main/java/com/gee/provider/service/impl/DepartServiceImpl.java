package com.gee.provider.service.impl;

import com.gee.provider.bean.Depart;
import com.gee.provider.repository.DepartRepository;
import com.gee.provider.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImpl implements DepartService {
    @Autowired
    private DepartRepository repository;
    @Value("${server.port}")
    private int port;
    // 插入
    @Override
    public boolean saveDepart(Depart depart) {
        // repository的save()方法需要注意：
        // 参数对象若id为null，则执行的是insert
        // 参数对象若具有id，则执行的是update
        Depart obj = repository.save(depart);
        if(obj != null) {
            return true;
        }
        return false;
    }

    // 根据id删除
    @Override
    public boolean removeDepartById(int id) {
        // 若指定id的对象不存在，则deleteById()会抛出异常
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyDepart(Depart depart) {
        // repository的save()方法需要注意：
        // 参数对象若id为null，则执行的是insert
        // 参数对象若具有id，则执行的是update
        Depart obj = repository.save(depart);
        if(obj != null) {
            return true;
        }
        return false;
    }

    @Override
    public Depart getDepartById(int id) {
        // repository.getOne(id)指定的id对象不存在，则会抛出异常
        if(repository.existsById(id)) {
            Depart depart = repository.getOne(id);
            depart.setName(depart.getName()+"----"+port);
            return depart;
        }
        Depart depart = new Depart();
        depart.setName("no this depart" + port);
        return depart;
    }

    @Override
    public List<Depart> listAllDeparts() {
        return repository.findAll();
    }
}
