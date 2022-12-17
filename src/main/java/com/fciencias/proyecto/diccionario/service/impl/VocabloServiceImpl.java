package com.fciencias.proyecto.diccionario.service.impl;

import com.fciencias.proyecto.diccionario.entity.Vocablo;
import com.fciencias.proyecto.diccionario.exception.AlreadyExistsException;
import com.fciencias.proyecto.diccionario.exception.ResourceNotFoundException;
import com.fciencias.proyecto.diccionario.payload.VocabloDto;
import com.fciencias.proyecto.diccionario.repository.VocabloRepository;
import com.fciencias.proyecto.diccionario.service.VocabloService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VocabloServiceImpl implements VocabloService {

  private final VocabloRepository vocabloRepository;
  private final ModelMapper mapper;

  public VocabloServiceImpl(VocabloRepository vocabloRepository, ModelMapper mapper) {
    this.vocabloRepository = vocabloRepository;
    this.mapper = mapper;
  }

  @Override
  public VocabloDto createVocablo(VocabloDto vocabloDto) {
    if(vocabloRepository.findById(vocabloDto.getVocablo()).isPresent()) {
      throw new AlreadyExistsException("Vocablo", "id", vocabloDto.getVocablo());
    }
    Vocablo vocabloSave = mapToEntity(vocabloDto);
    Vocablo newVocablo = vocabloRepository.save(vocabloSave);
    return mapToDTO(newVocablo);
  }

  @Override
  public List<VocabloDto> getAllVocablos() {
    List<Vocablo> vocablos = vocabloRepository.findAll();
    return vocablos.stream().map(this::mapToDTO).collect(Collectors.toList());
  }

  @Override
  public VocabloDto getVocabloById(String vocablo) {
    Vocablo vocablo1 = vocabloRepository.findById(vocablo)
        .orElseThrow(() -> new ResourceNotFoundException("Vocablo", "id", vocablo));
    return mapToDTO(vocablo1);
  }

  // TODO
  @Override
  public VocabloDto updateVocablo(VocabloDto vocabloDto, String vocablo) {
    Vocablo vocablo1 = vocabloRepository.findById(vocablo)
        .orElseThrow(() -> new ResourceNotFoundException("Vocablo", "id", vocablo));
    vocablo1.setVocablo(vocabloDto.getVocablo());
    vocablo1.setCategoria(vocabloDto.getCategoria());
    vocablo1.setMateria(vocabloDto.getMateria());
    vocablo1.setAcepcion(vocabloDto.getAcepcion());
    vocablo1.setDerivadas(vocabloDto.getDerivadas());
    vocablo1.setSinonimos(vocabloDto.getSinonimos());
    Vocablo vocabloActualizado = vocabloRepository.save(vocablo1);
    return mapToDTO(vocabloActualizado);
  }

  @Override
  public void deleteVocabloById(String vocablo) {
    Vocablo vocablo1 = vocabloRepository.findById(vocablo)
        .orElseThrow(() -> new ResourceNotFoundException("Vocablo", "id", vocablo));
    vocabloRepository.delete(vocablo1);
  }

  private Vocablo mapToEntity(VocabloDto vocabloDto) {
    return mapper.map(vocabloDto, Vocablo.class);
  }

  private VocabloDto mapToDTO(Vocablo vocablo) {
    return mapper.map(vocablo, VocabloDto.class);
  }
}
