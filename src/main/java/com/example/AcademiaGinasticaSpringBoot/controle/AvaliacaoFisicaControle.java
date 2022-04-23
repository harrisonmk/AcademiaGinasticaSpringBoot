package com.example.AcademiaGinasticaSpringBoot.controle;

import com.example.AcademiaGinasticaSpringBoot.modelo.AvaliacaoFisica;
import com.example.AcademiaGinasticaSpringBoot.modelo.form.AvaliacaoFisicaForm;
import com.example.AcademiaGinasticaSpringBoot.servico.impl.AvaliacaoFisicaServicoImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaControle {

    @Autowired
    private AvaliacaoFisicaServicoImpl service;

    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
        return service.create(form);
    }

    @GetMapping
    public List<AvaliacaoFisica> getAll() {
        return service.getAll();
    }

}
