package com22.rest1.dto.menuDto;

import com22.rest1.entity.Menu;
import lombok.Builder;


import java.math.BigDecimal;

@Builder
public record MenuResponse(
        Long id,
        String name,
        String image,
        BigDecimal price,
        String description,
        boolean isVegetarian
) {

    public static MenuResponse entityToResponse(Menu menu){
        return MenuResponse.builder()
                .id(menu.getId())
                .name(menu.getName())
                .image(menu.getImage())
                .price(menu.getPrice())
                .description(menu.getDescription())
                .isVegetarian(menu.isVegetarian())
                .build();
    }
//    public static MenuResponse entityToResponse(Menu menu) {
//        MenuResponse menuResponse = new MenuResponse(menu);
//        menuResponse.menu.setName(menu.getName());
//        menuResponse.menu.setImage(menu.getImage());
//        menuResponse.menu.setPrice(menu.getPrice());
//        menuResponse.menu.setDescription(menu.getDescription());
//        menuResponse.menu.setVegetarian(menu.isVegetarian());
//        return menuResponse;
//    }
}
