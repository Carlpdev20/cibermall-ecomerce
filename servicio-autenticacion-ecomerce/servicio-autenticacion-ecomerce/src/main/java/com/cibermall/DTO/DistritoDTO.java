package com.cibermall.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistritoDTO {
    private Integer idDistrito;
    private String nombre;
    private Double costoEnvio;
}
