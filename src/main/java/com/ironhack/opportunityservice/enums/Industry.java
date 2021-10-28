package com.ironhack.opportunityservice.enums;

import com.ironhack.opportunityservice.exceptions.EmptyStringException;
import com.ironhack.opportunityservice.exceptions.InvalidEnumException;

public enum Industry {
    PRODUCE, ECOMMERCE, MEDICAL, OTHER, MANUFACTURING;

    public static Industry getIndustry(String industry) throws EmptyStringException, InvalidEnumException {

        switch(industry){
            case "":
                throw new EmptyStringException("No industry input. Please, try again.");
            case "PRODUCE":
                return Industry.PRODUCE;
            case "ECOMMERCE":
                return Industry.ECOMMERCE;
            case "MEDICAL":
                return Industry.MEDICAL;
            case "OTHER":
                return Industry.OTHER;
            case "MANUFACTURING":
                return Industry.MANUFACTURING;
            default:
                throw new InvalidEnumException("Invalid industry input. Please, try again.");
        }
    }
}
