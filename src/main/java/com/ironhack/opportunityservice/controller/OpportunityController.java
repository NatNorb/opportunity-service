package com.ironhack.opportunityservice.controller;

import com.ironhack.opportunityservice.dao.Opportunity;
import com.ironhack.opportunityservice.dto.OpportunityDTO;
import com.ironhack.opportunityservice.repository.OpportunityRepository;
import com.ironhack.opportunityservice.service.OpportunityService;
import com.ironhack.opportunityservice.exceptions.EmptyStringException;
import com.ironhack.opportunityservice.exceptions.ExceedsMaxLength;
import com.ironhack.opportunityservice.exceptions.InvalidEnumException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/opps")
public class OpportunityController {

    @Autowired
    OpportunityRepository opportunityRepository;
    @Autowired
    OpportunityService opportunityService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Opportunity> getAll(){
        return opportunityRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Opportunity> getById(@PathVariable Long id){
        return opportunityRepository.findById(id);
    }

    @GetMapping("/sales-rep/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Opportunity> getBySalesRepId(@PathVariable Long id){
        return opportunityRepository.findBySalesRepId(id);
    }


    @PutMapping("/{id}/{status}")
    public Opportunity changeStatus(@PathVariable Long id, @PathVariable String status) throws EmptyStringException, InvalidEnumException, ExceedsMaxLength {
        return opportunityService.changeStatus(id, status);
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Opportunity createOpp(@RequestBody OpportunityDTO opportunityDTO){
        return opportunityService.createOpp(opportunityDTO);
    }

    @GetMapping("/sales-repAndStatus/{id}/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Opportunity> getBySalesRepIdAndStatus(@PathVariable Long id, @PathVariable String status){
        return opportunityRepository.findBySalesRepIdAndStatus(id, status);
    }




    /*
    GET MEAN number of Opportunities per Account"
    GET MEDIAN number of Opportunities per Account"
    GET MAXIMUM number of Opportunities per Account"
    GET MINIMUM number of Opportunities per Account

    GET - To check individual Opportunity's details "
    PUT/PATCH - To change Opportunity status to WON"
    PUT/PATCH - To change Opportunity status to LOST"


    Display count of all Opportunities by Sales Representative
    Display count of CLOSED-WON Opportunities by Sales Representative
    Display count of CLOSED-LOST Opportunities by Sales Representative
    Display count of OPEN Opportunities by Sales Representative
    */

}
