package com.donatoordep.mechanical_api.services;

import com.donatoordep.mechanical_api.dtos.request.ItemCreateRequestDTO;
import com.donatoordep.mechanical_api.dtos.request.ItemUpdateRequestDTO;
import com.donatoordep.mechanical_api.dtos.response.ItemCreateResponseDTO;
import com.donatoordep.mechanical_api.dtos.response.ItemGetAllResponseDTO;
import com.donatoordep.mechanical_api.entities.Item;
import com.donatoordep.mechanical_api.mappers.ItemMapper;
import com.donatoordep.mechanical_api.repositories.impl.ItemRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepositoryImpl repository;

    @Autowired
    public ItemService(ItemRepositoryImpl repository) {
        this.repository = repository;
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public List<ItemGetAllResponseDTO> findByName(String name) {
        return repository.findByName(name).stream().map(ItemMapper::fromEntityForGetAllDto).toList();
    }

    @Transactional
    public List<ItemGetAllResponseDTO> updateItem(ItemUpdateRequestDTO request) {
        Optional<Item> entity = repository.findById(request.getId());
        if (entity.isPresent()) {
            repository.save(ItemMapper.fromUpdate(request));
        }
        return getAll();
    }

    @Transactional
    public ItemCreateResponseDTO createProduct(ItemCreateRequestDTO request) {
        Item item = Item.of(request.getName(), request.getPrice(), request.getQuantity());
        return ItemMapper.fromEntityForCreateDto(repository.save(item));
    }

    @Transactional(readOnly = true)
    public List<ItemGetAllResponseDTO> getAll() {
        return repository.findAll().stream().map(ItemMapper::fromEntityForGetAllDto).toList();
    }
}