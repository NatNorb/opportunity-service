package com.ironhack.opportunityservice.dto;

import com.ironhack.opportunityservice.enums.Status;
import com.ironhack.opportunityservice.enums.Truck;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Setter
@Getter

public class OpportunityDTO {
    private Status status;
    private Truck product;
    private Integer quantity;
    private Long decisionMaker;
    private Long accountId;
    private Long salesRepId;


}
