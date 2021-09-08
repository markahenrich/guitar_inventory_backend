package com.github.markahenrich.guitarinventory.controllers;

import com.github.markahenrich.guitarinventory.models.Guitar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/")
public class InventoryController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/guitars")
    public List<String> getAllGuitars() {
        String sql = "SELECT model_name FROM guitar_inventory.guitar_model;";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
           return rs.getString("model_name");
        });
    }

    @GetMapping("/manufacturers")
    public List<String> getAllManufacturers() {
        String sql = "SELECT m_name FROM guitar_inventory.manufacturer;";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
           return rs.getString("m_name");
        });
    }

    @GetMapping("/all")
    public List<String> getAll() {
        String sql = "SELECT Make, Model FROM guitar_inventory.all_makes_and_models";

        return jdbcTemplate.query(sql, (rs, row) -> {
            return rs.getString("Make") + " " + rs.getString("Model");
        });
    }

    @PostMapping("/guitar")
    public void postGuitar(@RequestBody Guitar guitar) {
        String sql = "INSERT INTO guitar_inventory.guitar_model " +
                     "(m_id, model_name, model_year, color, price) " +
                     "VALUES (?, ?, ?, ?, ?)";
        System.out.println(guitar.getModelName());

        jdbcTemplate.update(sql, guitar.getManufacturerId(), guitar.getModelName(),
                guitar.getModelYear(), guitar.getColor(), guitar.getPrice());
    }

    @PutMapping("/guitar/")
    public void updateGuitar() {
        // TODO: method body
    }

    @DeleteMapping("guitar/{id}")
    public void deleteGuitar(@PathVariable Integer id) {
        String sql = "DELETE FROM guitar_inventory.guitar_model WHERE g_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
