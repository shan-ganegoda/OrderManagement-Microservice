package com.lucky.inventory.service;

import com.lucky.inventory.dto.InventoryDTO;
import com.lucky.inventory.entity.Inventory;
import com.lucky.inventory.repository.InventoryRepository;
import com.lucky.inventory.util.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceIMPL implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<InventoryDTO> getAll() {
        List<Inventory> inventoryList = inventoryRepository.findAll();
        if(!inventoryList.isEmpty()) {
            return objectMapper.inventoryListToDtoList(inventoryList);
        }else{
            return null;
        }
    }

    @Override
    public InventoryDTO save(InventoryDTO inventoryDTO) {
        Inventory in = objectMapper.inventoryDtoToInventory(inventoryDTO);
        inventoryRepository.save(in);
        return inventoryDTO;
    }

    @Override
    public InventoryDTO update(InventoryDTO inventoryDTO) {
       if(inventoryRepository.existsById(inventoryDTO.getId())) {
           Inventory in = objectMapper.inventoryDtoToInventory(inventoryDTO);
           inventoryRepository.save(in);
           return inventoryDTO;
       }else{
           return null;
       }
    }

    @Override
    public void delete(Integer id) {
        Inventory inventory = inventoryRepository.findById(id).orElseThrow(null);
        inventoryRepository.delete(inventory);
    }
}
