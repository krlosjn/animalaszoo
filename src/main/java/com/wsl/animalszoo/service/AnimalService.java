package com.wsl.animalszoo.service;

import com.wsl.animalszoo.domain.Animal;
import com.wsl.animalszoo.exception.AnimalException;
import com.wsl.animalszoo.message.AnimalMessageResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AnimalService {
    ResponseEntity<AnimalMessageResponse> saveAnimal(Animal animal);
    ResponseEntity<AnimalMessageResponse> findAnimalById(Long id);
    List<Animal> findAllsAnimal() throws AnimalException;
    Animal findAnimalByName(String name);
    ResponseEntity<AnimalMessageResponse> updateAnimal(Animal animal, Long id);
    ResponseEntity<AnimalMessageResponse> deleteAnimal(Long id);
}
