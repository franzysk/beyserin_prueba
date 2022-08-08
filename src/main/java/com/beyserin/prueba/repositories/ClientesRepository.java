package com.beyserin.prueba.repositories;

import com.beyserin.prueba.models.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ClientesRepository extends PagingAndSortingRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c WHERE c.tipoDocumento = :tipoDocumento AND c.numeroDocumento = :numeroDocumento")
    Optional<Cliente> obtenerCliente(char tipoDocumento, String numeroDocumento);
}
