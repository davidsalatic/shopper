package com.shopper.shopper.repository;

import com.shopper.shopper.model.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopperRepository extends JpaRepository<Shopper, String> {
    boolean existsByEmail(String email);
}
