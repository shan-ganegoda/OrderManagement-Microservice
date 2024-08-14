package com.lucky.inventory.controller;

import com.lucky.inventory.dto.InventoryDTO;
import com.lucky.inventory.entity.Inventory;
import com.lucky.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventories")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    public List<InventoryDTO> getAll(){
        return inventoryService.getAll();
    }

    @PostMapping
    public InventoryDTO create(@RequestBody InventoryDTO inventoryDTO){
        return inventoryService.save(inventoryDTO);
    }

    @PutMapping
    public InventoryDTO update(@RequestBody InventoryDTO inventoryDTO){
        return inventoryService.update(inventoryDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        inventoryService.delete(id);
    }
}
