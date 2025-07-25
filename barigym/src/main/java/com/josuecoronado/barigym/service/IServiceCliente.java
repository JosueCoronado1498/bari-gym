package com.josuecoronado.barigym.service;

import com.josuecoronado.barigym.model.Cliente;

import java.util.List;

public interface IServiceCliente {

    //crear un cliente
    public void saveCliente(Cliente cliente);

    //traer clientes
    public List<Cliente> getClientes();

    //traer cliente por id
    public Cliente findCliente(Long id);

    //eliminar un cliente por id
    public void deleteCliente(Long id);

    //editar un cliente
    void editCliente(Cliente cliente);

}
