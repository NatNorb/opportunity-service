package com.ironhack.opportunityservice.repository;


import com.ironhack.opportunityservice.enums.Countries;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient("account-service")
public interface AccountServiceProxy {


    @GetMapping("/accounts/industry/{industry}")
    public List<Long> listIdByIndustry(@PathVariable String industry);

    @GetMapping("/accounts/country/{country}")
    public List<Long> listIdByCountry(@PathVariable Countries country);

    @GetMapping("/accounts/cityName/{city}")
    public List<Long> listIdByCity(@PathVariable String city);


}
