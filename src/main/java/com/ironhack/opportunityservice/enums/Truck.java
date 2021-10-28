package com.ironhack.opportunityservice.enums;

import com.ironhack.opportunityservice.exceptions.EmptyStringException;
import com.ironhack.opportunityservice.exceptions.InvalidEnumException;

public enum Truck {
    HYBRID, FLATBED, BOX;

    public static Truck getTruck(String product) throws EmptyStringException, InvalidEnumException {

        switch(product){
            case "":
                throw new EmptyStringException("No product input. Please, try again.");
            case "HYBRID":
                return Truck.HYBRID;
            case "FLATBED":
                return Truck.FLATBED;
            case "BOX":
                return Truck.BOX;
            default:
                throw new InvalidEnumException("Invalid product input. Please, try again.");
        }
    }
}
