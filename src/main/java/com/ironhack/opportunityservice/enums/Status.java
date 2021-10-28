package com.ironhack.opportunityservice.enums;

import com.ironhack.opportunityservice.exceptions.EmptyStringException;
import com.ironhack.opportunityservice.exceptions.InvalidEnumException;

public enum Status {
    OPEN, CLOSED_WON, CLOSED_LOST;

    public static Status getStatus(String status) throws EmptyStringException, InvalidEnumException {

        switch(status){
            case "":
                throw new EmptyStringException("No status input. Please, try again.");
            case "open":
                return Status.OPEN;
            case "won":
                return Status.CLOSED_WON;
            case "lost":
                return Status.CLOSED_LOST;
            default:
                throw new InvalidEnumException("Invalid status. Please, try again.");
        }
    }
}
