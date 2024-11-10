package com.donatoordep.mechanical_api.repositories;

import com.donatoordep.mechanical_api.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepositorySpecification extends JpaRepository<Item, Long> {

    @Query("SELECT i FROM Item i WHERE UPPER(i.product.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    List<Item> findByName(String name);
}