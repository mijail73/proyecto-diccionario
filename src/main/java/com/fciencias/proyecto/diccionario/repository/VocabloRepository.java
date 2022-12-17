package com.fciencias.proyecto.diccionario.repository;

import com.fciencias.proyecto.diccionario.entity.Vocablo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VocabloRepository extends JpaRepository<Vocablo, String> {
}
