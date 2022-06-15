/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaua.OSApiApplication.domain.service;

import com.kaua.OSApiApplication.domain.model.OrdemServico;
import com.kaua.OSApiApplication.domain.model.StatusOrdemServico;
import com.kaua.OSApiApplication.domain.repository.OrdemServicoRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author devsys-b
 */
@Service
public class OrdemServicoService {
    
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    
    public ResponseEntity<OrdemServico> salvarFinalizar(OrdemServico ordemServico){
        
        ordemServico.setStatus(StatusOrdemServico.FINALIZADA);
        ordemServico.setDataFinalizacao(LocalDateTime.now());  
        ordemServicoRepository.save(ordemServico);
        return ResponseEntity.ok(ordemServico);
    }
    
    public ResponseEntity<OrdemServico> salvarCancelar(OrdemServico ordemServico){
        ordemServico.setStatus(StatusOrdemServico.CANCELADA);
        ordemServicoRepository.save(ordemServico);
        return ResponseEntity.ok(ordemServico);
    }
    
    public OrdemServico criar (OrdemServico ordemServico){
        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(LocalDateTime.now());  
        
        return ordemServicoRepository.save(ordemServico);
    }
    
    public List<OrdemServico> listar(){
        return ordemServicoRepository.findAll();
    }
    
}
