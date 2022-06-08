/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaua.OSApiApplication.api.controller;

import com.kaua.OSApiApplication.domain.model.OrdemServico;
import com.kaua.OSApiApplication.domain.service.OrdemServicoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author devsys-b
 */

@RestController
public class OrdemServicoController {
    
    @Autowired
    private OrdemServicoService ordemServicoService;
    
    @GetMapping("/ordem-servico")
    public List<OrdemServico> listas(){
        return ordemServicoService.listar();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico criar (@RequestBody OrdemServico ordemServico) {
        return ordemServicoService.criar(ordemServico);
    }
    
    
}
