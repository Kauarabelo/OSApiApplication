/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaua.OSApiApplication.api.controller;

import com.kaua.OSApiApplication.domain.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author devsys-b
 */
@RestController
public class ClienteController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/clientes")
    public List<Cliente> listas() {

        //Linguagem JPQL (tipo SQL só que do Jakarta)
        return manager.createQuery("from Cliente", Cliente.class)
                .getResultList();
    }

}
