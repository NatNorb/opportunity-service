package com.ironhack.opportunityservice.controller;

import com.ironhack.opportunityservice.dao.Opportunity;
import com.ironhack.opportunityservice.dto.OpportunityDTO;
import com.ironhack.opportunityservice.enums.Countries;
import com.ironhack.opportunityservice.repository.AccountServiceProxy;
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
    @Autowired
    AccountServiceProxy accountServiceProxy;


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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOppById(@PathVariable Long id) {
        opportunityService.delete(id);
    }

    // REPORTING ROUTES
    @GetMapping("/sales-repAndStatus/{id}/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Opportunity> getBySalesRepIdAndStatus(@PathVariable Long id, @PathVariable String status){
        return opportunityRepository.findBySalesRepIdAndStatus(id, status);
    }

    @GetMapping("/product/{product}")
    public Long countOppsByProduct(@PathVariable String product){
        return opportunityRepository.countByProduct(product);
    }

    @GetMapping("/product")
    public Long countOppsByProductAndStatus(@RequestParam String product, @RequestParam String status){
        return opportunityRepository.countByProductAndStatus(product, status);
    }

    @GetMapping("/location/city/{city}")
    public Long countOppsByCity(@PathVariable(name = "city") String city){
        List<Long> listId = accountServiceProxy.listIdByCity(city);
        return opportunityRepository.countByCity(listId);
    }

    @GetMapping("/location/city")
    public Long countOppsByCityAndStatus(@RequestParam String city, @RequestParam String status){
        List<Long> listId = accountServiceProxy.listIdByCity(city);
        return opportunityRepository.countByCityAndStatus(listId, status);
    }

    @GetMapping("/location/country/{country}")
    public Long countOppsByCountry(@PathVariable(name = "country") Countries country){
        List<Long> listId = accountServiceProxy.listIdByCountry(country);
        return opportunityRepository.countByCountry(listId);
    }

   @GetMapping("/location/country")
    public Long countOppsByCountryAndStatus(@RequestParam Countries country, @RequestParam String status){
       List<Long> listId = accountServiceProxy.listIdByCountry(country);
        return opportunityRepository.countByCountryAndStatus(listId, status);
   }


    @GetMapping("/industry/{industry}")
    public Long countOppsByIndustry(@PathVariable(name = "industry") String industry){
        List<Long> listId = accountServiceProxy.listIdByIndustry(industry);
        return opportunityRepository.countOppsByIndustry(listId);
    }

    @GetMapping("/industry")
    public Long countOppsByIndustryAndStatus(@RequestParam String industry, @RequestParam String status){
        List<Long> listId = accountServiceProxy.listIdByIndustry(industry);
        return opportunityRepository.countByIndustryAndStatus(listId, status);
    }


    @GetMapping("/product/mean")
    public Double findMeanProductQuantity(){
        return opportunityRepository.meanProductQuantity();
    }

    @GetMapping("/product/max")
    public Long findMaxProductQuantity(){
        return opportunityRepository.maxProductQuantity();
    }

    @GetMapping("/product/min")
    public Long findMinProductQuantity(){
        return opportunityRepository.minProductQuantity();
    }

    @GetMapping("/product/median")
    public Double findMedianProductQuantity(){
        return opportunityRepository.medianProductQuantity();
    }

    @GetMapping("/mean/{accountId}")
    public Double findMeanOppsByAccount(@PathVariable(name = "accountId") Long id){
        return opportunityRepository.meanByAccId(id);
    }

    @GetMapping("/max/{accountId}")
    public Long findMaxOppsByAccount(@PathVariable(name = "accountId") Long id){
        return opportunityRepository.maxByAccId(id);
    }

    @GetMapping("/min/{accountId}")
    public Long findMinOppsByAccount(@PathVariable(name = "accountId") Long id){
        return opportunityRepository.minByAccId(id);
    }

    @GetMapping("/median/{accountId}")
    public Double findMedianOppsByAccount(@PathVariable(name = "accountId") Long accountId){
        return opportunityRepository.medianByAccId(accountId);
    }

}
