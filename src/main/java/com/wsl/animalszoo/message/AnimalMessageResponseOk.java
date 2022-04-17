package com.wsl.animalszoo.message;

import com.wsl.animalszoo.domain.Animal;

import java.util.Optional;

public class AnimalMessageResponseOk extends AnimalMessageResponse{

    private Long id;
    private String name;
    private String specie;
    private int age;

    public AnimalMessageResponseOk(Long id, String name, String specie, int age) {
        this.id = id;
        this.name = name;
        this.specie = specie;
        this.age = age;
    }

    public AnimalMessageResponseOk(Long id){
        this.id=id;
    }

    public AnimalMessageResponseOk(Optional<Animal> optional){
        this.id=optional.get().getId();
        this.name=optional.get().getName();
        this.specie=optional.get().getSpecie();
        this.age=optional.get().getAge();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
