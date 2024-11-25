package org.example.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UnidadMedida {
    private Long id;
    private String denominacion;

    public UnidadMedida(Long id, String denominacion) {
        this.id = id;
        this.denominacion = denominacion;
    }
}
