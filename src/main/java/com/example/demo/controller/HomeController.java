package com.example.demo.controller; // Define en qué paquete está el archivo

import org.springframework.stereotype.Controller; // Para marcar que es un controller de vistas
import org.springframework.ui.Model;           // Para enviar datos a la vista
import org.springframework.web.bind.annotation.GetMapping; // Para mapear rutas
import com.example.demo.repository.ProductoRepository;   // Para acceder a la base de datos

@Controller // Indica que esta clase maneja vistas HTML
public class HomeController {

    private final ProductoRepository repo; // Repositorio para acceder a productos

    public HomeController(ProductoRepository repo) {
        this.repo = repo; // Inyectamos el repositorio vía constructor
    }

    @GetMapping("/") // Ruta principal: http://localhost:8082/
    public String index(Model model) {
        model.addAttribute("productos", repo.findAll()); // Enviamos todos los productos a la vista
        return "inicio"; // Busca index.html en src/main/resources/templates
    }
}
