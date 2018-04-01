package com.example.controllers;


import com.example.dto.MessageDTO;
import com.example.dto.PropositionDTO;
import com.example.models.Proposition;
import com.example.service.PropositionServiceImpl;
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
@RequestMapping("/api/propositions")
public class PropositionController {
    @Autowired
    private PropositionServiceImpl service;
    @Autowired
    private MessageSource messageSource;


    @RequestMapping(method = RequestMethod.GET)
    public List<PropositionDTO> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PropositionDTO findOne(@PathVariable Long id) {
        Proposition proposition=service.findOneSafe(id);
        return service.propositionToDto(proposition);
    }

    @RequestMapping(method = RequestMethod.POST)
    public PropositionDTO create(@Valid @RequestBody PropositionDTO dto) {
        return service.create(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public PropositionDTO update(@PathVariable Long id, @Valid @RequestBody PropositionDTO dto) {
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
