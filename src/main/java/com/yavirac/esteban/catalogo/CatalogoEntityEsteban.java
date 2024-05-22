package com.yavirac.esteban.catalogo;

import java.util.Set;

import com.yavirac.esteban.joyas.JoyaEntityEsteban;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name = "catalogo_esteban")
public class CatalogoEntityEsteban {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_catalogo;

    @OneToMany(mappedBy = "catalogo")
    private Set<JoyaEntityEsteban> detalle;
}
