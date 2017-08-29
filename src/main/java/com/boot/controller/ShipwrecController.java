package com.boot.controller;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipWrecRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ShipwrecController {

    @Autowired
    private ShipWrecRepository wrecRepository;

    @RequestMapping(value = "shipwrecks" , method = RequestMethod.GET )
    public List<Shipwreck> list(){
        return wrecRepository.findAll();
    }

    @RequestMapping(value = "shipwrecks" , method = RequestMethod.POST )
    public Shipwreck create(@RequestBody Shipwreck shipwreck){
        return wrecRepository.saveAndFlush(shipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}" , method = RequestMethod.PUT )
    public Shipwreck update(@PathVariable Long id,@RequestBody Shipwreck shipwreck){
        Shipwreck existing =  wrecRepository.findOne(id);
        BeanUtils.copyProperties(shipwreck,existing);
        return wrecRepository.saveAndFlush(existing);
    }

    @RequestMapping(value = "shipwrecks/{id}" , method = RequestMethod.GET )
    public Shipwreck get(@PathVariable Long id){
        return wrecRepository.findOne(id);
    }

    @RequestMapping(value = "shipwrecks/{id}" , method = RequestMethod.DELETE )
    public Shipwreck delete(@PathVariable Long id){
        Shipwreck existing =  wrecRepository.findOne(id);

        wrecRepository.delete(existing);
        return existing;
    }


}
