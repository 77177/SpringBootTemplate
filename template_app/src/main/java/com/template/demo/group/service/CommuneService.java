package com.template.demo.group.service;

import com.template.demo.group.model.Commune;
import com.template.demo.group.repositories.CommuneRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommuneService {

    private final CommuneRepository groupRepository;

    public CommuneService(CommuneRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Transactional
    public Commune getCommune(Long id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("The group with id " + id + " doesn't exist"));
    }

    @Transactional
    public Long updateCommune(Commune group) {

        Long id = group.getId();

        if (groupRepository.existsById(id)){
            Commune updatedCommune = groupRepository.save(group);
            return updatedCommune.getId();
        } else {
            throw new IllegalArgumentException("The group with id " + id + " doesn't exist");
        }
    }

    @Transactional
    public Long createCommune(Commune group) {

        Long id = group.getId();

        if (groupRepository.existsById(id)){
            throw new IllegalArgumentException("The group with id " + id + " exists");
        } else {
            Commune savedCommune = groupRepository.save(group);
            return savedCommune.getId();
        }
    }

    @Transactional
    public void deleteCommune(Long id) {
        groupRepository.deleteById(id);
    }

    @Transactional
    public List<Commune> getAllCommunes(){
        return groupRepository.findAll();
    }

    @Transactional
    public void deleteAllCommunes(){
        groupRepository.deleteAll();
    }
}
