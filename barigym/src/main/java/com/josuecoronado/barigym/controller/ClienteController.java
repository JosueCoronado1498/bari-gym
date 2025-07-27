package com.josuecoronado.barigym.controller;

import com.josuecoronado.barigym.model.Cliente;
import com.josuecoronado.barigym.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService clienteServ;

    @PostMapping("/clientes/crear")
    public String saveCliente(@RequestBody Cliente cliente){
        clienteServ.saveCliente(cliente);

        return "Cliente creado correctamente";
    }

    @GetMapping("/clientes/traer")
    public List<Cliente> getClientes(){
        return clienteServ.getClientes();
    }

    @GetMapping("/clientes/traer/{id}")
    public Cliente findCliente(@PathVariable Long id){
        return clienteServ.findCliente(id);
    }

    @DeleteMapping("/clientes/eliminar/{id}")
    public String deleteCliente(@PathVariable Long id){
        clienteServ.deleteCliente(id);

        return "El cliente se elimino correctamente";
    }

    @PutMapping("/clientes/editar")
    public Cliente ediarCliente(@RequestBody Cliente cliente){
        clienteServ.editCliente(cliente);

        return clienteServ.findCliente(cliente.getId());
    }

}
