package com.crud.controller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.model.Producto;
import com.crud.repository.ProductoRepository;

@Controller
@RequestMapping("/productos") //http:localhost:8080/productos
public class ProductoController {
	
	private final Logger logg= org.slf4j.LoggerFactory.getLogger(Producto.class);
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@GetMapping("")
	public String home(Model model) {
		//Lo siguiente muestra una lista que sera de productos
		model.addAttribute("productos", productoRepository.findAll()); //A traves del repository trae todos los productos de la bd
		
		return "home";
	}
	
	@GetMapping("/create") //localhost:8080/productos/create
	public String create() {
		return "create";
	}
	
	@PostMapping("/save")
	public String save(Producto producto) {
		logg.info("Informacion del objeto producto, {}", producto);
		productoRepository.save(producto);
		return "redirect:/productos";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model ) {
		Producto p= productoRepository.getOne(id);
		logg.info("Objeto recuperado {}", p);
		model.addAttribute("producto", p);
		return"edit";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		Producto p= productoRepository.getOne(id);
		logg.info("Objeto eliminado {}", p);
		productoRepository.delete(p);
		return"redirect:/productos";
	}
}
