package com.cibermall.service;

import com.cibermall.dto.ProductRequest;
import com.cibermall.dto.ProductResponse;

public interface ProductService {
	ProductResponse create(ProductRequest request);
	ProductResponse findById(Integer id);
}
