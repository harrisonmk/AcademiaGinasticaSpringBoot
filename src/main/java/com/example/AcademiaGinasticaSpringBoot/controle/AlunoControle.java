package com.example.AcademiaGinasticaSpringBoot.controle;

import com.example.AcademiaGinasticaSpringBoot.modelo.Aluno;
import com.example.AcademiaGinasticaSpringBoot.modelo.AvaliacaoFisica;
import com.example.AcademiaGinasticaSpringBoot.modelo.form.AlunoForm;
import com.example.AcademiaGinasticaSpringBoot.servico.impl.AlunoServicoImpl;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoControle {

    @Autowired
    private AlunoServicoImpl service;

    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form) {
        return service.create(form);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
        return service.getAllAvaliacaoFisicaId(id);
    }

    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNacimento) {
        return service.getAll(dataDeNacimento);
    }

}
