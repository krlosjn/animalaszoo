package com.wsl.animalszoo;

import com.wsl.animalszoo.domain.Animal;

public class AnimalTestDataBuilder {

    private Long id;
    private String name;
    private String specie;
    private int age;

    public AnimalTestDataBuilder() {
        this.id = 1L;
        this.name="Perro";
        this.specie="Canino";
        this.age=15;
    }

    public AnimalTestDataBuilder withId(Long id){
        this.id=id;
        return this;
    }

    public AnimalTestDataBuilder withtName(String name){
        this.name=name;
        return this;
    }

    public AnimalTestDataBuilder withSpecie(String specie){
        this.specie=specie;
        return this;
    }


    public AnimalTestDataBuilder withAge(int age){
        this.age=age;
        return this;
    }

    public Animal build() throws Exception{
        return new Animal(id,name,specie,age);
    }
}
