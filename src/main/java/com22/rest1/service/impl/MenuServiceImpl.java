package com22.rest1.service.impl;

import com22.rest1.dto.SimpleResponse;
import com22.rest1.dto.menuDto.MenuRequest;
import com22.rest1.dto.menuDto.MenuResponse;
import com22.rest1.entity.Menu;
import com22.rest1.globalException.NotFoundException;
import com22.rest1.repository.MenuRepository;
import com22.rest1.repository.RestaurantRepository;
import com22.rest1.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;


    @Override
    public List<MenuResponse> getAll() {
        List<Menu> menus = menuRepository.findAll();
        List<MenuResponse> menuResponses = new ArrayList<>();
        for (Menu menu : menus) {
            menuResponses.add(MenuResponse.entityToResponse(menu));
        }
        return menuResponses;
//        return menuRepository.getAll();
    }

    @Override
    public MenuResponse getById(Long id) {
        Menu menu = menuRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Menu not found with id " + id)
        );
        return MenuResponse.entityToResponse(menu);
    }

    @Override
    public SimpleResponse save(MenuRequest menuRequest) {
        Menu menu = menuRequest.buildMenu();
        menuRepository.save(menu);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("menu saved")
                .build();
    }

    @Override
    public SimpleResponse update(Long id, MenuRequest menuRequest) {
        Menu menu = menuRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Menu not found with id " + id)
        );
        menuRepository.save(menuRequest.buildMenuForUpdate(menu));
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("menu updated")
                .build();
    }

    @Override
    public SimpleResponse delete(Long id) {
        Menu menu = menuRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Menu not found with id " + id)
        );
        menuRepository.delete(menu);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Menu deleted with id " + id)
                .build();
    }
}
