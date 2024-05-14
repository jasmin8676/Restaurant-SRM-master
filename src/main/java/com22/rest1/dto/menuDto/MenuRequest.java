package com22.rest1.dto.menuDto;

import lombok.Builder;
import com22.rest1.entity.Menu;

import java.math.BigDecimal;

@Builder
public record MenuRequest(
        String name,
        String image,
        BigDecimal price,
        String description,
        boolean isVegetarian
) {

    public Menu buildMenu(){
        return Menu.builder()
                .name(this.name)
                .image(this.image)
                .price(this.price)
                .description(this.description())
                .isVegetarian(this.isVegetarian)
                .build();
    }
    public Menu buildMenuForUpdate(Menu menu){
        menu.setName(this.name);
        menu.setImage(this.image);
        menu.setPrice(this.price);
        menu.setDescription(this.description);
        menu.setVegetarian(this.isVegetarian);
        return menu;
    }
//    public Menu buildMenu(){
//        return Menu.builder()
//                .name(this.menu.getName())
//                .image(this.menu.getImage())
//                .price(this.menu.getPrice())
//                .description(this.menu.getDescription())
//                .isVegetarian(this.menu.isVegetarian())
//                .build();
//    }
//
//    public Menu buildMenuForUpdate(Menu menu){
//        menu.setName(this.menu.getName());
//        menu.setImage(this.menu.getImage());
//        menu.setPrice(this.menu.getPrice());
//        menu.setDescription(this.menu.getDescription());
//        menu.setVegetarian(this.menu.isVegetarian());
//        return menu;
//    }
}
