package com.example.AcademiaGinasticaSpringBoot.controle;

import com.example.AcademiaGinasticaSpringBoot.modelo.Matricula;
import com.example.AcademiaGinasticaSpringBoot.modelo.form.MatriculaForm;
import com.example.AcademiaGinasticaSpringBoot.servico.impl.MatriculaServicoImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "Api Rest Matriculas")
@RestController
@RequestMapping("/matriculas")
public class MatriculaControle {

    @Autowired
    private MatriculaServicoImpl service;

    
    @Operation(summary="Insere uma matricula")
    @PostMapping
    public Matricula create(@Valid @RequestBody MatriculaForm form) {
        return service.create(form);
    }

    
    @Operation(summary="Retorna uma lista de Matriculas")
    @GetMapping
    public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
        return service.getAll(bairro);
    }

}
