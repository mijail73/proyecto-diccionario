package com.fciencias.proyecto.diccionario.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "vocablo")
public class Vocablo {
  @Id
  private String vocablo;
  private String categoria;
  private String materia;
  private String acepcion;
  private String derivadas;
  private String sinonimos;
}
