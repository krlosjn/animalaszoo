package com.wsl.animalszoo.domain;


import javax.persistence.*;

import static com.wsl.animalszoo.utils.VlidateArguments.validateAge;
import static com.wsl.animalszoo.utils.VlidateArguments.validateAttribute;

@Entity
@Table(name="Animal")
public class Animal {
    public static final String EL_NOMBRE_DEL_ANIMAL_NO_PUEDE_IR_VACIO = "El nombre del animal no puede ir vacio";
    public static final String DEBE_COLOCAR_LA_ESPECIE_DEL_ANIMAL = "Debe colocar la especie del animal";
    public static final String DEBE_COLOCAR_LA_EDAD_DEL_ANIMAL = "Debe colocar la edad del animal";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_animal", nullable = false)
    private Long id;

    @Column(length = 20,nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String specie;

    @Column(nullable = false)
    private int age;

    public Animal() {
    }

    public Animal(Long id, String name, String specie , int age) throws Exception {
        validateAttribute(name, EL_NOMBRE_DEL_ANIMAL_NO_PUEDE_IR_VACIO);
        validateAttribute(specie, DEBE_COLOCAR_LA_ESPECIE_DEL_ANIMAL);
        validateAge(age, DEBE_COLOCAR_LA_EDAD_DEL_ANIMAL);
        this.id=id;
        this.name=name;
        this.specie=specie;
        this.age=age;
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
