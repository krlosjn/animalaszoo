package com.wsl.animalszoo.repository;

import com.wsl.animalszoo.domain.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {
    boolean existsAnimalById(Long aLong);

    @Query("SELECT a FROM Animal a WHERE a.name=?1")
    Animal findAnimalByName(String name);
}
