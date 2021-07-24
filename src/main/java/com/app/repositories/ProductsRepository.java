package com.app.repositories;

import com.app.entities.Products;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Products,Long> {
}
