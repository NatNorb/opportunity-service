package com.ironhack.opportunityservice.dto;

import com.ironhack.opportunityservice.enums.Industry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private Industry industry;
    private Integer employeeCount;
    private String city;
    private String country;

//    @LazyCollection(LazyCollectionOption.FALSE)
//    @OneToMany(mappedBy = "account")
//    private List<ContactDTO> contactList = new ArrayList<>();
//
//    @LazyCollection(LazyCollectionOption.FALSE)
//    @OneToMany(mappedBy = "account")
//    private List<Opportunity> opportunityList = new ArrayList<>();

}
