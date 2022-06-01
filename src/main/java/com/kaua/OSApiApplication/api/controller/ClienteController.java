/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaua.OSApiApplication.api.controller;

import com.kaua.OSApiApplication.domain.model.Cliente;
import com.kaua.OSApiApplication.domain.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
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
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> listas() {
        return clienteRepository.findAll();
//        return clienteRepository.findByNome("KGe");
//        return clienteRepository.findByNomeContaining("Silva");
    }

    @GetMapping("/clientes/{clienteID}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteID) {

        Optional<Cliente> cliente = clienteRepository.findById(clienteID);

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();

        }

    }
    
    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente){
        
        return clienteRepository.save(cliente);
        
    }
    
    @PutMapping("/clientes/{clienteID}")
    public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteID,
            @RequestBody Cliente cliente){
    
        //Verifica se o cliente existe
        if (!clienteRepository.existsById(clienteID)) {
            return ResponseEntity.notFound().build();
        }
        
        cliente.setId(clienteID);
        cliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente);
        
    }
    
    @DeleteMapping("/clientes/{clienteID}")
    public ResponseEntity<Void> excluir(@PathVariable Long clienteID){
    
        //Verifica se cliente existe ou não
        if (!clienteRepository.existsById(clienteID)){
            return ResponseEntity.notFound().build();
        }
        
        clienteRepository.deleteById(clienteID);
        return ResponseEntity.noContent().build();
        
    }
           

}
