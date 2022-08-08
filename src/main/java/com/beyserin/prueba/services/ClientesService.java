package com.beyserin.prueba.services;

import com.beyserin.prueba.models.entity.Cliente;
import com.beyserin.prueba.repositories.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    public Cliente obtenerCliente(char tipoDocumento, String numeroDocumento) {
        return clientesRepository.obtenerCliente(tipoDocumento, numeroDocumento).orElse(null);
    }
}
