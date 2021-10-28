package com.ironhack.opportunityservice;

import com.ironhack.opportunityservice.dao.Opportunity;
import com.ironhack.opportunityservice.enums.Truck;
import com.ironhack.opportunityservice.exceptions.ExceedsMaxLength;
import com.ironhack.opportunityservice.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Data {

    @Autowired
    OpportunityRepository opportunityRepository;

    public void populate() throws ExceedsMaxLength {
        List<Opportunity> opportunities = opportunityRepository.saveAll(List.of(
                new Opportunity(Truck.FLATBED, 10, 1l, 1l),
                new Opportunity(Truck.BOX, 1150, 2l, 2l),
                new Opportunity(Truck.HYBRID, 1, 3l, 1l)

        ));

    }
}
