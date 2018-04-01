package com.example.controllers;

import com.example.dto.MessageDTO;
import com.example.dto.ModuleDTO;
import com.example.models.Module;
import com.example.service.ModuleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {
    @Autowired
    private ModuleServiceImpl service;
    @Autowired
    private MessageSource messageSource;


    @RequestMapping(method = RequestMethod.GET)
        public List<ModuleDTO> findAll() {
            return service.findAll();
        }

    // Important: Ne pas supprimer ce bout de code ça nous servira plutard... Sid
/*
    @RequestMapping(method = RequestMethod.GET)
    public List<ModuleDTO> findAll() {
        ModuleDTO m=new ModuleDTO();
        m.setLibelle("test");
        create(m);
        return service.findAll();
    }*/

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModuleDTO findOne(@PathVariable Long id) {
        Module module=service.findOneSafe(id);
        return service.moduleToDto(module);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModuleDTO create(@Valid @RequestBody ModuleDTO dto) {
        return service.create(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ModuleDTO update(@PathVariable Long id, @Valid @RequestBody ModuleDTO dto) {
        return service.update(id, dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MessageDTO handleValidationException(MethodArgumentNotValidException ex) {
        Locale locale = LocaleContextHolder.getLocale();
        String code = ex.getBindingResult().getFieldError().getDefaultMessage();
        return new MessageDTO(messageSource.getMessage(code, null, locale));
    }
}
