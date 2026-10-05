package com.duoc.RopaStoreValidation.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.duoc.RopaStoreValidation.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    Optional<Cliente> findByRut(String rut);
    
}
