package com.lucky.inventory.util.mapper;

import com.lucky.inventory.dto.InventoryDTO;
import com.lucky.inventory.entity.Inventory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ObjectMapper {
    List<InventoryDTO> inventoryListToDtoList(List<Inventory> inventoryList);

    Inventory inventoryDtoToInventory(InventoryDTO inventoryDTO);
}
