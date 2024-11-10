package com.donatoordep.mechanical_api.mappers;

import com.donatoordep.mechanical_api.dtos.request.ItemUpdateRequestDTO;
import com.donatoordep.mechanical_api.dtos.response.ItemCreateResponseDTO;
import com.donatoordep.mechanical_api.dtos.response.ItemGetAllResponseDTO;
import com.donatoordep.mechanical_api.dtos.response.ProductGetAllResponseDTO;
import com.donatoordep.mechanical_api.entities.Item;

public final class ItemMapper {

    private ItemMapper() {
    }

    public static ItemGetAllResponseDTO fromEntityForGetAllDto(Item item) {
        ProductGetAllResponseDTO response = ProductGetAllResponseDTO.of(item.getProduct().getName(), item.getProduct().getPrice());
        return ItemGetAllResponseDTO.of(response, item.getQuantity(), item.getTotalPrice(), item.getId());
    }

    public static ItemCreateResponseDTO fromEntityForCreateDto(Item item) {
        return ItemCreateResponseDTO.of(item.getId(), item.getProduct().getName(), item.getQuantity(), item.getProduct().getPrice());
    }

    public static Item fromUpdate(ItemUpdateRequestDTO request) {
        return Item.of(request.getId(), request.getName(), request.getPrice(), request.getQuantity());
    }
}
