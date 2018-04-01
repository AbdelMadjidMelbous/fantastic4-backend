package com.example.controllers;

import com.example.dto.MessageDTO;
import com.example.dto.NiveauDTO;
import com.example.service.NiveauServiceImpl;
import com.example.service.ModuleServiceImpl;
import com.example.models.Niveau;
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
@RequestMapping("/api/niveaux")
public class NiveauController {
    @Autowired
    private NiveauServiceImpl service;
    @Autowired
    private ModuleServiceImpl service2;
    @Autowired
    private MessageSource messageSource;


        @RequestMapping(method = RequestMethod.GET)
        public List<NiveauDTO> findAll() {
            return service.findAll();
        }

    // Important: Ne pas supprimer ce bout de code ça nous servira plutard... Sid

/*    @RequestMapping(method = RequestMethod.GET)
    public List<NiveauDTO> findAll() {
        NiveauDTO n=new NiveauDTO();
        n.setLibelle("level100");
        n.setPoids(5);
        Long idModule=1L;
        n.setModule(service2.findOneSafe(idModule));
        create(n);
        return service.findAll();
    }*/

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public NiveauDTO findOne(@PathVariable Long id) {
        Niveau niveau=service.findOneSafe(id);
        return service.niveauToDto(niveau);
    }
    @RequestMapping(method = RequestMethod.POST)
    public NiveauDTO create(@Valid @RequestBody NiveauDTO dto) {
        return service.create(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public NiveauDTO update(@PathVariable Long id, @Valid @RequestBody NiveauDTO dto) {
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
