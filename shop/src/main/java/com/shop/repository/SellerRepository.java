package com.shop.repository;

import com.shop.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller, Long>,
        QuerydslPredicateExecutor<Seller> {

        List<Seller> findBySellerName(String sellerName);

        List<Seller> findBySellerNameOrSellingItemNum(String sellerName, Integer sellingItemNum);

        List<Seller> findBySellerGradeLessThan(Double sellerGrade);

        List<Seller> findBySellerGradeLessThanOrderBySellerGradeDesc(Double sellerGrade);

        @Query("select i from Seller i where i.sellerName like %:sellerName% order by i.sellerGrade desc")
        List<Seller> findBySellerNameByQuery(@Param("sellerName") String sellerName);

        @Query(value="select * from seller i where i.seller_name like %:sellerName% order by i.seller_grade desc", nativeQuery = true)
        List<Seller> findBySellerNameByNative(@Param("sellerName") String sellerName);
}
