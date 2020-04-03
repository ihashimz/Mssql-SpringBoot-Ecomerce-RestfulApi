package com.dbp.ecommapp.repository;

 import com.dbp.ecommapp.entity.Seller;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Long> {
}
