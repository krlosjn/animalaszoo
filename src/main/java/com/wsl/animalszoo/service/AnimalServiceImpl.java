package com.wsl.animalszoo.service;

import com.wsl.animalszoo.domain.Animal;
import com.wsl.animalszoo.exception.AnimalException;
import com.wsl.animalszoo.message.AnimalMessageResponse;
import com.wsl.animalszoo.message.AnimalMessageResponseError;
import com.wsl.animalszoo.message.AnimalMessageResponseOk;
import com.wsl.animalszoo.repository.AnimalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

public class AnimalServiceImpl implements AnimalService{

    private AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public ResponseEntity<AnimalMessageResponse> saveAnimal(Animal animal) {

        if(animalRepository.existsAnimalById(animal.getId())){
            String message="El animal con id " + animal.getId() + " Ya se encuentra en el sistema";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new AnimalMessageResponseError(message));
        }
        Animal animalSend= animalRepository.save(animal);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new AnimalMessageResponseOk(Optional.of(animal)));
    }

    @Override
    public ResponseEntity<AnimalMessageResponse> findAnimalById(Long id) {
        if(!animalRepository.existsAnimalById(id)){
            String message="El animal con el id " + id + " no se encuentra en el sistema";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body( new AnimalMessageResponseError(message));
        }
        Optional<Animal> animalFind = animalRepository.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body( new AnimalMessageResponseOk(animalFind));
    }

    @Override
    public List<Animal> findAllsAnimal() throws AnimalException {
        String message="No se encontraron registros de animales en el sistema";
        if(animalRepository.findAll().isEmpty()){
            throw  new AnimalException(message);
        }
        return animalRepository.findAll();
    }

    @Override
    public Animal findAnimalByName(String name) {
        return animalRepository.findAnimalByName(name);
    }

    @Override
    public ResponseEntity<AnimalMessageResponse> updateAnimal(Animal animal, Long id) {
        if(!animalRepository.existsAnimalById(id)){
            String message="El animal con id " + id + " no se estás registado, no se puede actualizar";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new AnimalMessageResponseError(message));
        }

        Animal animalUpdate = animalRepository.findById(id).map((itemAnimal)->{
            itemAnimal.setName(animal.getName());
            itemAnimal.setSpecie(animal.getSpecie());
            itemAnimal.setAge(animal.getAge());
            return animalRepository.save(itemAnimal);
        }).get();

        return ResponseEntity.status(HttpStatus.OK)
                .body(new AnimalMessageResponseOk(Optional.of(animalUpdate)));
    }

    @Override
    public ResponseEntity<AnimalMessageResponse> deleteAnimal(Long id) {

        if(!animalRepository.existsAnimalById(id)){
            String message="El animal con id " + id + " no se puede eliminar por que no está en el sistema";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new AnimalMessageResponseError(message));
        }
        animalRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body( new AnimalMessageResponseOk(id));
    }
}
