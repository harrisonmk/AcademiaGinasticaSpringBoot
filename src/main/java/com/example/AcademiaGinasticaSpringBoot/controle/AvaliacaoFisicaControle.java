package com.example.AcademiaGinasticaSpringBoot.controle;

import com.example.AcademiaGinasticaSpringBoot.modelo.AvaliacaoFisica;
import com.example.AcademiaGinasticaSpringBoot.modelo.form.AvaliacaoFisicaForm;
import com.example.AcademiaGinasticaSpringBoot.servico.impl.AvaliacaoFisicaServicoImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag( name = "Api Rest Avaliacoes")
@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaControle {

    @Autowired
    private AvaliacaoFisicaServicoImpl service;

    
    @Operation(summary="Insere uma avaliacao fisica")
    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
        return service.create(form);
    }

    
    @Operation(summary="Retorna uma lista de avaliacoes fisicas")
    @GetMapping
    public List<AvaliacaoFisica> getAll() {
        return service.getAll();
    }

}
