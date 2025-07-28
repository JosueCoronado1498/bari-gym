package com.josuecoronado.barigym.controller;

import com.josuecoronado.barigym.model.Cliente;
import com.josuecoronado.barigym.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClienteWebController {

    @Autowired
    private IClienteService clienteServ;

    // Página de inicio o lista de clientes
    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        List<Cliente> lista = clienteServ.getClientes();
        model.addAttribute("clientes", lista);
        return "clientes"; // se refiere a clientescliente.html en templates/
    }

    // Mostrar formulario de nuevo cliente
    @GetMapping("/clientes/crear")
    public String mostrarFormularioNuevoCliente(Model model) {
        Cliente nuevoCliente = new Cliente();
        model.addAttribute("cliente", nuevoCliente);
        return "nuevo-cliente"; // se refiere a nuevo-clientes.html en templates/
    }

    // Guardar cliente enviado desde el formulario
    @PostMapping("/clientes/guardar")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteServ.saveCliente(cliente);
        return "redirect:/clientes"; // redirecciona a la lista de clientes
    }

    // Mostrar formulario de edición
    @GetMapping("/clientes/editar/{id}")
    public String mostrarFormularioEditarCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteServ.findCliente(id);
        model.addAttribute("cliente", cliente);
        return "editar-cliente"; // editar-clientes.html
    }

    // Eliminar cliente
    @GetMapping("/clientes/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteServ.deleteCliente(id);
        return "redirect:/clientes";
    }

}
