package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.repository.ProductoRepository;

@Controller
@RequestMapping("/productos") //http:localhost:8080/productos
public class ProductoController {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@GetMapping("")
	public String home(Model model) {
		//Lo siguiente muestra una lista que sera de productos
		model.addAttribute("productos", productoRepository.findAll()); //A traves del repository trae todos los productos de la bd
		
		return "home";
	}
}
