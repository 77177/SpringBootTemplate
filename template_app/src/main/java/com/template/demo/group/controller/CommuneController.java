package com.template.demo.group.controller;

import com.template.demo.group.model.Commune;
import com.template.demo.group.service.CommuneService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
public class CommuneController {

    private final CommuneService groupService;

    public CommuneController(CommuneService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/get/{id}")
    public Commune getCommune(@PathVariable("id") Long id) {
        return groupService.getCommune(id);
    }

    @PutMapping("/update")
    public Long updateCommune(@RequestBody Commune group) {
        return groupService.updateCommune(group);
    }

    @PostMapping("/create")
    public Long createCommune(@RequestBody Commune group) {
        return groupService.createCommune(group);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCommune(@PathVariable("id") Long id) {
        groupService.deleteCommune(id);
    }


}

