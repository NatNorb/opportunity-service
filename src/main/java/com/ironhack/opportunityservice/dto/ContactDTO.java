package com.ironhack.opportunityservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {

    protected String name;
    protected String phoneNumber;
    protected String email;
    protected String companyName;

    /*@ManyToOne
    @JoinColumn(name = "sales_rep_id", referencedColumnName = "id")
    private SalesRep salesRep;
*/
//    @ManyToOne
//    @JoinColumn(name = "account_id", referencedColumnName = "id")
//    private AccountDTO account;
//
//    @LazyCollection(LazyCollectionOption.FALSE)
//    @OneToMany(mappedBy = "decisionMaker")
//    private List<Opportunity> opportunity = new ArrayList<>();
}
