package com.fciencias.proyecto.diccionario.controller;

import com.fciencias.proyecto.diccionario.payload.VocabloDto;
import com.fciencias.proyecto.diccionario.service.VocabloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/vocablos")
@CrossOrigin( origins = "*")
public class VocabloController {
  private final VocabloService vocabloService;

  public VocabloController(VocabloService vocabloService) {
    this.vocabloService = vocabloService;
  }

  @PostMapping(consumes = "multipart/form-data")
  public ResponseEntity<VocabloDto> createVocablo(VocabloDto vocabloDto) {
    return new ResponseEntity<>(vocabloService.createVocablo(vocabloDto), HttpStatus.CREATED);
  }

  @GetMapping
  public List<VocabloDto> getAllVocablos() {
    return vocabloService.getAllVocablos();
  }

  @GetMapping("/{vocablo}")
  public ResponseEntity<VocabloDto> getVocabloById(@PathVariable(name = "vocablo") String vocablo) {
    return ResponseEntity.ok(vocabloService.getVocabloById(vocablo));
  }

  @PutMapping(path ="/{vocablo}",consumes = "multipart/form-data")
  public ResponseEntity<VocabloDto> updateVocablo(VocabloDto vocabloDto, @PathVariable(name = "vocablo") String vocablo) {
    VocabloDto vocabloResponse = vocabloService.updateVocablo(vocabloDto, vocablo);
    return new ResponseEntity<>(vocabloResponse, HttpStatus.OK);
  }

  @DeleteMapping("/{vocablo}")
  public ResponseEntity<String> deleteVocablo(@PathVariable(name = "vocablo") String vocablo) {
    vocabloService.deleteVocabloById(vocablo);
    return new ResponseEntity<>("Post entity deleted successful.", HttpStatus.OK);
  }
}
