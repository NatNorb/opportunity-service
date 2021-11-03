package com.ironhack.opportunityservice;

import com.ironhack.opportunityservice.dao.Opportunity;
import com.ironhack.opportunityservice.enums.Status;
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
        opportunityRepository.save(new Opportunity(Status.OPEN, Truck.FLATBED, 1, 1l, 2l, 1l));
        opportunityRepository.save(new Opportunity(Status.CLOSED_LOST,Truck.BOX, 2, 2l, 2l, 2l));
        opportunityRepository.save(new Opportunity(Status.CLOSED_LOST,Truck.HYBRID, 3, 3l, 3l, 1l));
        opportunityRepository.save(new Opportunity(Status.OPEN,Truck.BOX, 4, 4l, 3l, 2l));
        opportunityRepository.save(new Opportunity(Status.CLOSED_WON,Truck.HYBRID, 5, 3l, 3l, 1l));
        opportunityRepository.save(new Opportunity(Status.CLOSED_WON,Truck.FLATBED, 10, 1l, 1l, 1l));
        opportunityRepository.save(new Opportunity(Status.OPEN,Truck.BOX, 11, 2l, 2l, 2l));
        opportunityRepository.save(new Opportunity(Status.OPEN,Truck.HYBRID, 15, 3l, 4l, 1l));

       /* List<Opportunity> opportunities = opportunityRepository.saveAll(List.of(
                new Opportunity(Status.OPEN, Truck.FLATBED, 1, 1l, 2l, 1l),
                new Opportunity(Status.CLOSED_LOST,Truck.BOX, 2, 2l, 2l, 2l),
                new Opportunity(Status.CLOSED_LOST,Truck.HYBRID, 3, 3l, 3l, 1l),
                new Opportunity(Status.OPEN,Truck.BOX, 4, 4l, 3l, 2l),
                new Opportunity(Status.CLOSED_WON,Truck.HYBRID, 5, 3l, 3l, 1l),
                new Opportunity(Status.CLOSED_WON,Truck.FLATBED, 10, 1l, 1l, 1l),
                new Opportunity(Status.OPEN,Truck.BOX, 11, 2l, 2l, 2l),
                new Opportunity(Status.OPEN,Truck.HYBRID, 15, 3l, 4l, 1l)
        ));*/

    }
}
