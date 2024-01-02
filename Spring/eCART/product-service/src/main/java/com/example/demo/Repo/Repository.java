package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Product;

public interface Repository extends JpaRepository<Product, Integer> {

}
