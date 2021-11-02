package com.ironhack.opportunityservice.dao;

import com.ironhack.opportunityservice.dto.OpportunityDTO;
import com.ironhack.opportunityservice.enums.Status;
import com.ironhack.opportunityservice.enums.Truck;
import com.ironhack.opportunityservice.exceptions.ExceedsMaxLength;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "opportunity")
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // This sets the status to Enum Open whenever an opportunity object is created
    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Truck product;
    private Integer quantity;


//    @ManyToOne
//    @JoinColumn(name = "decision_maker", referencedColumnName = "id")
    private Long decisionMaker;

//    @ManyToOne
//    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Long accountId;


//    @ManyToOne
//    @JoinColumn(name = "sales_rep_id", referencedColumnName = "id")
    private Long salesRepId;



    public Opportunity(Truck product, int quantity, Long decisionMaker, Long accountId, Long salesRepId) {
        this.status = Status.OPEN;
        setTruck(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setAccountId(accountId);
        setSalesRepId(salesRepId);
    }

    public Opportunity(Status status, Truck product, int quantity, Long decisionMaker, Long accountId, Long salesRepId)  {
        setStatus(status);
        setTruck(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setAccountId(accountId);
        setSalesRepId(salesRepId);
    }


    public Truck getProduct() {
        return product;
    }

    public void setTruck(Truck product) {
        this.product = product;
    }

    public void setQuantity(int quantity)  {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive. Please try again.");
        }
        this.quantity = quantity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
