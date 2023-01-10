package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Producto;

//Hereda todos los metodos crud
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
