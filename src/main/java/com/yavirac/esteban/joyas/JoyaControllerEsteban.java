package com.yavirac.esteban.joyas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/joyaEsteban")
@Tag(name = "Controlador de la Joya Esteban")
public class JoyaControllerEsteban {
    @Autowired
    private JoyaServiceEsteban serviceJoyaEsteban;

    @GetMapping
    @Operation(summary = "Consulta de todas la joyas")
    public List<JoyaEntityEsteban> getAllEsteban() {
        return serviceJoyaEsteban.getAllJoyaEsteban();
    }

    @PostMapping
    @Operation(summary = "Crear y guardar una nueva joya")
    public JoyaEntityEsteban createEsteban(@RequestBody JoyaEntityEsteban joya) {
        return serviceJoyaEsteban.createJoyaEsteban(joya);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulta de una joya por ID")
    public JoyaEntityEsteban getByIdEsteban(@PathVariable Long id) {
        return serviceJoyaEsteban.getByIdJoyaEsteban(id);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Edición de los campos de una joya por ID")
    public JoyaEntityEsteban update(@PathVariable Long id, @RequestBody JoyaEntityEsteban joyaDetails) {
        return serviceJoyaEsteban.updateJoyaEsteban(id, joyaDetails);
    }

    @DeleteMapping("/{nombre}")
    @Operation(summary = "Eliminar una joya por su nombre")
    public ResponseEntity<Void> delete(@PathVariable String nombre) {
        serviceJoyaEsteban.deleteJoyaEsteban(nombre);
        return ResponseEntity.noContent().build();
    }
}
