package com.example.service;

import com.example.dto.ModuleDTO;
import com.example.models.Module;
import com.example.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ModuleServiceImpl {
    @Autowired
    private ModuleRepository repository;

    public List<ModuleDTO> findAll() {
        return repository.findAll().stream()
                .map(entity -> new ModuleDTO(entity.getId(), entity.getLibelle(), entity.getNiveaux()))
                .collect(Collectors.toList());
    }

    @Transactional
    public ModuleDTO create(ModuleDTO module) {
        Module newModule = new Module();
        newModule.setLibelle(module.getLibelle());
        newModule.setNiveaux(module.getNiveaux());
        Module savedModule = repository.saveAndFlush(newModule);
        return new ModuleDTO(savedModule.getId(), savedModule.getLibelle(), savedModule.getNiveaux());
    }

    @Transactional
    public ModuleDTO update(Long id, ModuleDTO module) {
        Module entity = findOneSafe(id);
        entity.setLibelle(module.getLibelle());
        entity.setNiveaux(module.getNiveaux());
        return new ModuleDTO(entity.getId(), entity.getLibelle(),entity.getNiveaux());
    }

    @Transactional
    public void delete(Long id) {
        Module module = findOneSafe(id);
        repository.delete(module);
    }

    @Transactional
    public Module findOneSafe(Long id) {
        Module module = repository.getOne(id);
        if (module == null) {
            throw new QuestionNotFoundException();
        } else {
            return module;
        }
    }
    @Transactional
    public ModuleDTO moduleToDto(Module module) {
        if (module == null) {
            throw new QuestionNotFoundException();
        } else {
            ModuleDTO moduleDTO = new ModuleDTO();
            moduleDTO.setId(module.getId());
            moduleDTO.setLibelle(module.getLibelle());
            moduleDTO.setNiveaux(module.getNiveaux());
            return moduleDTO ;
        }
    }

}
