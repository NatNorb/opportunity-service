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




/*
    //Report Opportunities by SalesRep
   // @Query("SELECT r.repName, COUNT(o) FROM Opportunity o RIGHT JOIN o.salesRep r GROUP BY r.repName ORDER BY r.repName")
    //List<Object[]> findCountOpportunityByRepName();

    //Show all opportunities
    @Query("SELECT o.id, o.status, o.product, o.quantity, c.name FROM Opportunity o JOIN o.decisionMaker c")
    List<Object[]> findAllOpportunities();

    //Report CLOSED-WON, CLOSED-LOST, and OPEN opportunities by SalesRep (takes a parameter argument)
    //@Query("SELECT r.repName, COUNT(o) FROM Opportunity o RIGHT JOIN o.salesRep r WHERE status = :status GROUP BY r.repName ORDER BY r.repName")
    //List<Object[]> findCountOpportunityByRepNameForStatus(@Param("status") String status);

    //Report Opportunities by Product
    @Query("SELECT o.product, count(o) FROM Opportunity o GROUP BY o.product ORDER BY o.product")
    List<Object[]> findCountOppForProduct();

    //Report CLOSED-WON, CLOSED-LOST, and OPEN opportunities by Product (takes a parameter argument)
    @Query("SELECT o.product, COUNT(o) FROM Opportunity o WHERE status = :status GROUP BY o.product ORDER BY o.product")
    List<Object[]> findCountOpportunityByProductForStatus(@Param("status") Enum status);

    //Report Opportunities by Country
   // @Query("SELECT ac.country, COUNT(o) FROM Opportunity o JOIN o.account ac GROUP BY ac.country ORDER BY ac.country")
    //List<Object[]> findCountOppForCountry();

    //Report CLOSED-WON, CLOSED-LOST, and OPEN opportunities by Country (takes a parameter argument)
   // @Query("SELECT ac.country, COUNT(o) FROM Opportunity o JOIN o.account ac  WHERE status = :status  GROUP BY ac.country ORDER BY ac.country")
   // List<Object[]> findCountOpportunityByCountryForStatus(@Param("status") String status);

    //Report Opportunities by City
   // @Query("SELECT ac.city, COUNT(o) FROM Opportunity o JOIN o.account ac GROUP BY ac.city ORDER BY ac.city")
   // List<Object[]> findCountOppForCity();

    //Report CLOSED-WON, CLOSED-LOST, and OPEN opportunities by City (takes a parameter argument)
   // @Query("SELECT ac.city, COUNT(o) FROM Opportunity o JOIN o.account ac  WHERE status = :status  GROUP BY ac.city ORDER BY ac.city")
   // List<Object[]> findCountOpportunityByCityForStatus(@Param("status") String status);

    //Report Opportunities by Industry
   // @Query("SELECT ac.industry, COUNT(o) FROM Opportunity o JOIN o.account ac GROUP BY ac.industry ORDER BY ac.industry")
   // List<Object[]> findCountOppForIndustry();

    //Report CLOSED-WON, CLOSED-LOST, and OPEN opportunities by Industry (takes a parameter argument)
   // @Query("SELECT ac.industry, COUNT(o) FROM Opportunity o JOIN o.account ac  WHERE status = :status  GROUP BY ac.industry ORDER BY ac.industry")
   // List<Object[]> findCountOpportunityByIndustryForStatus(@Param("status") String status);

    //Report mean number of products quantity for all Opportunities
    @Query("SELECT AVG(quantity) FROM Opportunity")
    Optional<Double> findMeanProductQuantity();

    // *** Median Report is needed JPQL can give list of all quantities in an ordered int array, needs a second step to find the median from this ***
    @Query("SELECT quantity FROM Opportunity order by quantity")
    int[]findMedianQuantityStep1();

    //Report Maximum  products quantity for all Opportunities
    @Query("SELECT MAX(quantity) FROM Opportunity")
    Optional<Integer> findMaxProductQuantity();

    //Report Minimum  products quantity for all Opportunities
    @Query("SELECT MIN(quantity) FROM Opportunity")
    Optional<Integer> findMinProductQuantity();

    //Report Mean number of Opportunities associated with an account
    //@Query(value = "select avg(a.count_opportunity) from (select count(distinct id) as count_opportunity from opportunity group by account_id order by count_opportunity) a", nativeQuery = true)
    //Optional<Double>findMeanOpportunitiesPerAccount();

    // *** Median Report is needed JPQL can give list of all opportunitycounts in an ordered int array, needs a second step to find the median from this ***
   // @Query(value = "select count(distinct id) as count_opportunity from opportunity group by account_id order by count_opportunity", nativeQuery = true)
   // int[]findMedianOppsPerAccountStep1();

    //Report Max number of Opportunities associated with an account
   // @Query(value = "select max(a.count_opportunity) from (select count(distinct id) as count_opportunity from opportunity group by account_id order by count_opportunity) a", nativeQuery = true)
   // Optional<Double>findMaxOpportunitiesPerAccount();

    //Report Min number of Opportunities associated with an account
   // @Query(value = "select min(a.count_opportunity) from (select count(distinct id) as count_opportunity from opportunity group by account_id order by count_opportunity) a", nativeQuery = true)
   // Optional<Double>findMinOpportunitiesPerAccount();

*/

}
