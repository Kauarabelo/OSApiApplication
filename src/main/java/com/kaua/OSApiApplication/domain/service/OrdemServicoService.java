/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaua.OSApiApplication.domain.service;

import com.kaua.OSApiApplication.domain.exception.DomainException;
import com.kaua.OSApiApplication.domain.model.OrdemServico;
import com.kaua.OSApiApplication.domain.model.StatusOrdemServico;
import com.kaua.OSApiApplication.domain.repository.OrdemServicoRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author devsys-b
 */
@Service
public class OrdemServicoService {
    
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    
    public OrdemServico salvarFinalizar(OrdemServico ordem){
        
        ordem.setStatus(StatusOrdemServico.FINALIZADA);
        return ordemServicoRepository.save(ordem);
        
    }
    
    public OrdemServico salvarCancelar(OrdemServico ordem){
        
        ordem.setStatus(StatusOrdemServico.CANCELADA);
        return ordemServicoRepository.save(ordem);
        
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
