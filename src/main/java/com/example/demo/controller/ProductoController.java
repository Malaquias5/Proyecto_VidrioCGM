package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.exception.ProductoNotFoundException;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*") // Permite que un frontend (Angular/React) consuma la API en dev
public class ProductoController {

    private final ProductoRepository repo;

    public ProductoController(ProductoRepository repo) {
        this.repo = repo;
    }


    @GetMapping
    public List<Producto> listar() {
        return repo.findAll();
    }

    // 2) Obtener uno por ID
    @GetMapping("/{id}")
    public Producto obtener(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException(id));
    }

    // 3) Crear nuevo
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto p) {
        // Aseguramos que se cree como nuevo (por si viene con id)
        p.setId(0L);
        return repo.save(p);
    }

    // 4) Actualizar existente
    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto p) {
        return repo.findById(id)
            .map(db -> {
                db.setNombre(p.getNombre());
                db.setDescripcion(p.getDescripcion());
                db.setPrecio(p.getPrecio());
                db.setStockActual(p.getStockActual());
                // Actualizar los nuevos campos también
                db.setTipoVidrio(p.getTipoVidrio());
                db.setMedidas(p.getMedidas());
                db.setGrosor(p.getGrosor());
                db.setColor(p.getColor());
                return repo.save(db);
            })
            .orElseThrow(() -> new ProductoNotFoundException(id));
    }

    // 5) Eliminar
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            throw new ProductoNotFoundException(id);
        }
        repo.deleteById(id);
    }
}
