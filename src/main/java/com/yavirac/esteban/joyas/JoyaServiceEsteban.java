package com.yavirac.esteban.joyas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class JoyaServiceEsteban {
    @Autowired
    private JoyaRepositoryEsteban joyaRepositoryEsteban;

    @Transactional
    public JoyaEntityEsteban createJoyaEsteban(JoyaEntityEsteban joyaEsteban) {
        // Validación de campos obligatorios
        if (joyaEsteban.getPrecio() == null) {
            throw new IllegalArgumentException("El precio no puede estar vacío");
        }
        if (joyaEsteban.getFecha_creacion() == null) {
            throw new IllegalArgumentException("La fecha de creación no puede ir vacia");
        }
        if (joyaEsteban.getDisponible() == null) {
            throw new IllegalArgumentException("El campo de disponibilidad no puede estar vacío");
        }
        if (joyaEsteban.getNombre() == null) {
            throw new IllegalArgumentException("El nombre de la joya no puede estar vacío");
        }
        
        // Guardar el detalle
        return joyaRepositoryEsteban.save(joyaEsteban);
    }   

    @Transactional
    public List<JoyaEntityEsteban> getAllJoyaEsteban() {
        return joyaRepositoryEsteban.findAll();
    }

    @Transactional
    public JoyaEntityEsteban getByIdJoyaEsteban(Long id_joya) {
        return joyaRepositoryEsteban.findById(id_joya)
                .orElseThrow(() -> new RuntimeException("Joya-Esteban no encontrada"));
    }

    @Transactional
    public JoyaEntityEsteban updateJoyaEsteban(Long id_joya, JoyaEntityEsteban joyaEstebanDetails) {
        JoyaEntityEsteban joya = joyaRepositoryEsteban.findById(id_joya)
                .orElseThrow(() -> new RuntimeException("Joya-Esteban no encontrada"));

        joya.setPrecio(joyaEstebanDetails.getPrecio());
        joya.setFecha_creacion(joyaEstebanDetails.getFecha_creacion());
        joya.setDisponible(joyaEstebanDetails.getDisponible());
        joya.setNombre(joyaEstebanDetails.getNombre());

        return joyaRepositoryEsteban.save(joya);
    }

    @Transactional
    public void deleteJoyaEsteban(String nombre) {
        JoyaEntityEsteban joya = joyaRepositoryEsteban.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("Joya-Esteban no encontrada con el nombre: " + nombre));
        joyaRepositoryEsteban.delete(joya);
    }
}
