package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.repository.ProductoRepository;

@Controller
public class VistaProductoController {

	@Autowired
	private ProductoRepository productoRepository;

	@GetMapping("/productos")
	public String mostrarProductos(Model model) {
		model.addAttribute("productos", productoRepository.findAll());
		return "Index";
	}
}
