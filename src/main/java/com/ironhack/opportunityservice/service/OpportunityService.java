package com.ironhack.opportunityservice.service;

import com.ironhack.opportunityservice.dto.OpportunityDTO;
import com.ironhack.opportunityservice.repository.OpportunityRepository;
import com.ironhack.opportunityservice.dao.Opportunity;
import com.ironhack.opportunityservice.enums.Status;
import com.ironhack.opportunityservice.exceptions.EmptyStringException;
import com.ironhack.opportunityservice.exceptions.ExceedsMaxLength;
import com.ironhack.opportunityservice.exceptions.InvalidEnumException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class OpportunityService {

    @Autowired
    OpportunityRepository opportunityRepository;


    public Opportunity changeStatus(Long id, String status) throws ExceedsMaxLength, EmptyStringException, InvalidEnumException {
        Optional<Opportunity> opp = opportunityRepository.findById(id);

        if(opp.isPresent()){
            Status newStatus = Status.getStatus(status);
            opp.get().setStatus(newStatus);
            opportunityRepository.save(opp.get());
            return opp.get();
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is not enough resources");
        }
    }

    public Opportunity createOpp(OpportunityDTO opportunityDTO){
        Opportunity newOpp = opportunityRepository.save(new Opportunity(opportunityDTO.getProduct(),
                                                                 opportunityDTO.getQuantity(),
                                                                 opportunityDTO.getDecisionMaker(),
                                                                 opportunityDTO.getAccountId(),
                                                                 opportunityDTO.getSalesRepId()));
        return newOpp;
    }

    public void delete(Long id){
        Optional<Opportunity> opp = opportunityRepository.findById(id);
        opportunityRepository.delete(opp.get());
    }


}
