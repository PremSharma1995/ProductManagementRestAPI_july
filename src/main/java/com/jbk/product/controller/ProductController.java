package com.jbk.product.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jbk.product.entity.Product;
import com.jbk.product.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping(value = "/saveProduct")
	public ResponseEntity<Boolean> saveProduct(@Valid @RequestBody Product product) {

		boolean isAdded = service.saveProduct(product);
		if (isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.INTERNAL_SERVER_ERROR);
			// throw new ProductNotFoundException("Product Not Found For Save"
			// +saveProduct);
		}
	}

	@PostMapping(value = "/uploadSheet")
	public ResponseEntity<String> uploadSheet(@RequestParam CommonsMultipartFile file) {
		System.out.println(file.getOriginalFilename());
		return null;

	}

	@PostMapping(value = "/uploadSheet")
	public ResponseEntity<Integer> uploadSheet(@RequestParam CommonsMultipartFile file, HttpSession session) {

		int count = service.uploadSheet(file, session);
		return new ResponseEntity<Integer>(count, HttpStatus.OK);

	}
}
