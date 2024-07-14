package com.jspiders.backendpro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jspiders.backendpro.entity.Product;
@Repository
public interface ProRespository extends JpaRepository<Product, Long>{
List<Product> findTheProuctByPrice(double price);
	


    @Query(value = "SELECT product FROM Product product WHERE product.title LIKE %:search% OR product.description LIKE %:search%")
	List<Product> findTheProductByTitleOrDescription(String search);
//    @Query("SELECT p FROM Product p WHERE FUNCTION('MONTH', p.dateOfSale) = :month")
//    List<Product> findProductsByMonth(@Param("month") int month);
//    List<Product> findProductsByMonth(String month);
    @Query("SELECT p FROM Product p WHERE FUNCTION('MONTH', p.dateOfSale) = :month")
    List<Product> findProductsByMonth(@Param("month") int month);


//	List<Product> findProductsByMonth(int parseInt);


}


