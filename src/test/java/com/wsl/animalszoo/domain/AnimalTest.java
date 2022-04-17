package com.wsl.animalszoo.domain;

import com.wsl.animalszoo.AnimalTestDataBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {


    public static final String EL_ANIMAL_TIENE_EL_NOMBRE_NULO = "El animal tiene el nombre nulo";
    public static final String LA_ESPECIE_ESTA_NULA = "La especie está nula";
    public static final String LA_EDAD_NO_PUEDE_SER_CERO = "La edad no puede ser cero";


    @Test
    public void validateNameNull() throws Exception {
        //arange
        AnimalTestDataBuilder animal= new AnimalTestDataBuilder().withtName(null);
        //act-assert
        try{
            animal.build();
            fail();
        }catch (Exception e){
            System.out.println(EL_ANIMAL_TIENE_EL_NOMBRE_NULO);
        }
    }

    @Test
    public void validateSpecieNull() throws Exception{
        //arrange
        AnimalTestDataBuilder animal = new AnimalTestDataBuilder().withSpecie(null);
        //act-assert
        try{
            animal.build();
            fail();
        }catch(Exception e){
            System.out.println(LA_ESPECIE_ESTA_NULA);
        }
    }


    @Test
    public void validateAgeZero() throws  Exception{
        //arrange
        AnimalTestDataBuilder animal= new AnimalTestDataBuilder().withAge(-1);
        //act-assert
        try{
            animal.build();
            fail();
        }catch (Exception e){
            System.out.println(LA_EDAD_NO_PUEDE_SER_CERO);
        }

    }

    @Test
    public void nameAnimalCorrect() throws  Exception{
        //arrange
        Animal animal = new AnimalTestDataBuilder().withtName("Leon").build();
        //act--assert
        assertEquals("Leon",animal.getName());
    }

    @Test
    public void specieAnimalCorrect() throws Exception{
        //arrange
        Animal animal = new AnimalTestDataBuilder().withSpecie("Felino").build();
        //act--assert
        assertEquals("Felino",animal.getSpecie());
    }

    @Test
    public void ageAnimalCorrect() throws Exception{
        //arrange
        Animal animal= new AnimalTestDataBuilder().withAge(1).build();
        //act--assert
        assertEquals(1,animal.getAge());
    }
}