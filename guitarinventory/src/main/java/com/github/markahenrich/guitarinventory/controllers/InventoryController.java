package com.github.markahenrich.guitarinventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
