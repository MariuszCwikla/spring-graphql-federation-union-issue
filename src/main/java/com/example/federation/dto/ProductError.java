package com.example.federation.dto;

import lombok.Data;

@Data
public class ProductError implements ProductResult{
	String reason;
}