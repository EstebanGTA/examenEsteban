package com.yavirac.esteban.joyas;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface JoyaRepositoryEsteban extends JpaRepository<JoyaEntityEsteban, Long> {
    Optional<JoyaEntityEsteban> findByNombre(String nombre);
    void deleteByNombre(String nombre);
}
