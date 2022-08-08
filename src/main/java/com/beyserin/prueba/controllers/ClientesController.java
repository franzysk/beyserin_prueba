package com.beyserin.prueba.controllers;

import com.beyserin.prueba.models.entity.Cliente;
import com.beyserin.prueba.services.ClientesService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @GetMapping("/{tipoDocumento}/{numeroDocumento}")
    public ResponseEntity<Object> obtenerCliente(
            @PathVariable @Valid @NotNull char tipoDocumento,
            @PathVariable @Valid @NotNull String numeroDocumento) {

        if (tipoDocumento != 'C' && tipoDocumento != 'P')
            return ResponseEntity.badRequest().body("El tipo de documento no es valido");

        Cliente cliente;
        try {
            cliente = clientesService.obtenerCliente(tipoDocumento, numeroDocumento);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al obtener el cliente");
        }

        if (cliente == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(cliente);
    }
}
