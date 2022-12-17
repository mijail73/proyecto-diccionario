package com.fciencias.proyecto.diccionario.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class VocabloDto {
  @NotEmpty
  @Size(min = 2, message = "El vocablo debe tener minimo 2 caracteres.")
  private String vocablo;
  @NotEmpty
  @Size(min = 5, message = "La categoria debe tener al menos 5 caracteres.")
  private String categoria;
  @NotEmpty
  @Size(min = 5, message = "La materia debe tener al menos 5 caracteres.")
  private String materia;
  private String acepcion;
  private String derivadas;
  private String sinonimos;
}
