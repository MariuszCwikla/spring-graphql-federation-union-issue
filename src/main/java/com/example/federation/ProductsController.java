package com.example.federation;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.example.federation.dto.Product;
import com.example.federation.dto.ProductError;
import com.example.federation.dto.ProductResult;

@Controller
public class ProductsController {

	@MutationMapping(name="createProduct")
	public ProductResult createProduct(@Argument String symbol) {
		if (symbol.matches("P\\d{2}")) {
			Product p = new Product();
			p.setSymbol(symbol);
			return p;
		} else {
			ProductError error = new ProductError();
			error.setReason("invalid code");
			return error;
		}
	}
}
