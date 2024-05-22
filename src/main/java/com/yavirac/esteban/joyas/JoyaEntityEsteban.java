package com.yavirac.esteban.joyas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

import com.yavirac.esteban.catalogo.CatalogoEntityEsteban;

@Entity
@Data
@Table (name = "joya_esteban")
public class JoyaEntityEsteban {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_joya;

    private Double precio;
    private Date fecha_creacion;
    private Boolean disponible;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_catalogo")
    private CatalogoEntityEsteban catalogo;
}
