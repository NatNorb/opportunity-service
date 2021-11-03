package com.ironhack.opportunityservice.repository;

import com.ironhack.opportunityservice.dao.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

    //Find opportunity by id
    Optional<Opportunity> findById(Long id);

    List<Opportunity> findBySalesRepId(Long id);

    @Query(value = "SELECT * FROM opportunity WHERE sales_rep_id = :id and status = upper( :status ) ", nativeQuery = true)
    List<Opportunity> findBySalesRepIdAndStatus(@Param("id") Long id, @Param("status") String status);

    @Query(value = "SELECT COUNT(*) FROM opportunity WHERE product = upper( :product )", nativeQuery = true)
    Long countByProduct(@Param("product") String product);

    @Query(value = "SELECT COUNT(*) FROM opportunity WHERE product = upper( :product ) and status = upper( :status ) ", nativeQuery = true)
    Long countByProductAndStatus(@Param("product") String product, @Param("status") String status);

    @Query(value = "SELECT COUNT(*) FROM opportunity WHERE account_id in (:listId) ", nativeQuery = true)
    Long countByCity(List<Long> listId);

    @Query(value = "SELECT COUNT(*) FROM opportunity WHERE account_id in (:listId) and status = :status", nativeQuery = true)
    Long countByCityAndStatus(List<Long> listId, String status);

    @Query(value = "SELECT COUNT(*) FROM opportunity WHERE account_id in (:listId) ", nativeQuery = true)
    Long countByCountry(List<Long> listId);

    @Query(value = "SELECT COUNT(*) FROM opportunity WHERE account_id in (:listId) and status = :status", nativeQuery = true)
    Long countByCountryAndStatus(List<Long> listId, String status);

    @Query(value = "SELECT COUNT(*) FROM opportunity WHERE account_id in (:listId) ", nativeQuery = true)
    Long countOppsByIndustry(@Param("listId") List<Long> listId);

    @Query(value = "SELECT COUNT(*) FROM opportunity WHERE account_id in (:listId) and status = :status", nativeQuery = true)
    Long countByIndustryAndStatus(@Param("listId") List<Long> listId, @Param("status") String status);

    @Query(value = "SELECT AVG(quantity*1.0) FROM opportunity", nativeQuery = true)
    Double meanProductQuantity();

    @Query(value = "SELECT MAX(quantity) FROM opportunity", nativeQuery = true)
    Long maxProductQuantity();

    @Query(value = "SELECT MIN(quantity) FROM opportunity", nativeQuery = true)
    Long minProductQuantity();

    @Query(value = "SELECT MEDIAN(quantity*1.0) FROM opportunity", nativeQuery = true)
    Double medianProductQuantity();

    @Query(value = "SELECT AVG(quantity*1.0) FROM opportunity WHERE account_id = :id ", nativeQuery = true)
    Double meanByAccId(@Param("id") Long id);

    @Query(value = "SELECT MAX(quantity) FROM opportunity WHERE account_id = :id ", nativeQuery = true)
    Long maxByAccId(@Param("id") Long id);

    @Query(value = "SELECT MIN(quantity) FROM opportunity WHERE account_id = :id ", nativeQuery = true)
    Long minByAccId(@Param("id") Long id);

    @Query(value = "SELECT MEDIAN(quantity*1.0) FROM opportunity WHERE account_id = :id ", nativeQuery = true)
    Double medianByAccId(@Param("id") Long id);



}
