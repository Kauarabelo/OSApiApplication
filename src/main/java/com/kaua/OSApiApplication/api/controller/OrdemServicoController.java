/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaua.OSApiApplication.api.controller;

import com.kaua.OSApiApplication.domain.model.OrdemServico;
import com.kaua.OSApiApplication.domain.repository.OrdemServicoRepository;
import com.kaua.OSApiApplication.domain.service.OrdemServicoService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author devsys-b
 */
@RestController
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;
    
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @GetMapping("/ordem-servico")
    public List<OrdemServico> listas() {
        return ordemServicoService.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico criar(@RequestBody OrdemServico ordemServico) {
        return ordemServicoService.criar(ordemServico);
    }

    @PutMapping("/ordem-servico/finalizar/{ordemID}")
    public ResponseEntity<OrdemServico> finalizar(@Valid @PathVariable Long ordemID, OrdemServico ordemServico) {

        //Verifica se existe a ordem de servico
        if(!ordemServicoRepository.existsById(ordemID)){
            return ResponseEntity.notFound().build();
        }
        
        ordemServico.setId(ordemID);
        ordemServico = ordemServicoService.salvarFinalizar(ordemServico);
        return ResponseEntity.ok(ordemServico);
    }

    @PutMapping("/ordem-servico/cancelar/{ordemID}")
    public ResponseEntity<OrdemServico> cancelar(@Valid @PathVariable Long ordemID, OrdemServico ordemServico) {

        //Verifica se existe a ordem de servico
        if(!ordemServicoRepository.existsById(ordemID)){
            return ResponseEntity.notFound().build();
        }
        
        ordemServico.setId(ordemID);
        ordemServico = ordemServicoService.salvarCancelar(ordemServico);
        return ResponseEntity.ok(ordemServico);
    }

}
