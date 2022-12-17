package com.fciencias.proyecto.diccionario.service;

import com.fciencias.proyecto.diccionario.payload.VocabloDto;
import com.fciencias.proyecto.diccionario.payload.VocabloResponse;

import java.util.List;

public interface VocabloService {
  VocabloDto createVocablo(VocabloDto vocabloDto);
  //VocabloResponse getAllVocablos(int pageNo, int pageSize, String sortBy, String sortDir);
  List<VocabloDto> getAllVocablos();
  VocabloDto getVocabloById(String vocablo);
  VocabloDto updateVocablo(VocabloDto vocabloDto, String vocablo);
  void deleteVocabloById(String vocablo);
}
