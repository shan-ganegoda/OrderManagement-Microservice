package com.lucky.inventory.service;

import com.lucky.inventory.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {
    List<InventoryDTO> getAll();

    InventoryDTO save(InventoryDTO inventoryDTO);

    InventoryDTO update(InventoryDTO inventoryDTO);

    void delete(Integer id);
}
