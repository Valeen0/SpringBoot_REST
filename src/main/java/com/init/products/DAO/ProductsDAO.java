package com.init.products.DAO;

import org.springframework.data.jpa.repository.*;
import com.init.products.entitys.Product;

public interface ProductsDAO extends JpaRepository<Product, Long> {
	
	

}
