package com.example.controllers;

import com.example.dto.MessageDTO;
import com.example.dto.QuestionDTO;
import com.example.dto.ModuleDTO;
//
import com.example.dto.NiveauDTO;
import com.example.models.Niveau;
import com.example.models.Question;
import com.example.models.Module;

import com.example.service.QuestionServiceImpl;
//
import com.example.service.ModuleServiceImpl;
import com.example.service.NiveauServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    @Autowired
    private QuestionServiceImpl service;
    //
    @Autowired
    private ModuleServiceImpl serviceMo;
    @Autowired
    private NiveauServiceImpl  serviceNi;

    @Autowired
    private MessageSource messageSource;


    @RequestMapping(method = RequestMethod.GET)
    public List<QuestionDTO> findAll() {
        return service.findAll();
    }

    // Important: Ne pas supprimer ce bout de code ça nous servira plutard... Sid
/*    @RequestMapping(method = RequestMethod.GET)
    public List<QuestionDTO> findAll() {
        QuestionDTO q=new QuestionDTO();
        q.setEnnonce("wach kayen thema ?");
        q.setReponse("Sayer dayer bel skotch");
        q.setPoids(5);
        Long id_niv=1L;
        q.setNiveau(serviceNi.findOneSafe(id_niv));
        create(q);
    return service.findAll();
    }*/

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public QuestionDTO findOne(@PathVariable Long id) {
        Question question=service.findOneSafe(id);
        return service.questionToDto(question);
    }

    @RequestMapping(method = RequestMethod.POST)
    public QuestionDTO create(@Valid @RequestBody QuestionDTO dto) {
        return service.create(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public QuestionDTO update(@PathVariable Long id, @Valid @RequestBody QuestionDTO dto) {
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
