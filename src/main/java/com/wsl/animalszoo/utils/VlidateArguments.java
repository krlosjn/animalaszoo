package com.wsl.animalszoo.utils;

import com.wsl.animalszoo.exception.AnimalException;

public class VlidateArguments {

    public static void validateAttribute(Object object, String message) throws Exception {
        if(object==null || object==""){
            throw new AnimalException(message);
        }
    }

    public static void validateAge(int number, String message) throws Exception{
        if(number<0 || number>100){
            throw new AnimalException(message);
        }
    }


}

