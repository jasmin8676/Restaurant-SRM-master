package com22.rest1.api;

import com22.rest1.dto.SimpleResponse;
import com22.rest1.dto.menuDto.MenuRequest;
import com22.rest1.dto.menuDto.MenuResponse;
import com22.rest1.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class MenuApi {

    private final MenuService menuService;

    @GetMapping
    @Operation(summary = "to get all menu")
    List<MenuResponse> getAll() {
        return menuService.getAll();
    }

    @GetMapping("/getById")
    @Operation(summary = "to get meny by id")
    MenuResponse getById(@RequestParam Long id) {
        return menuService.getById(id);
    }

    @PostMapping()
    @Operation(summary = "to create menu")
    SimpleResponse save(@RequestBody MenuRequest menuRequest) {
        return menuService.save(menuRequest);
    }

    @PutMapping()
    @Operation(summary = "to update a menu")
    SimpleResponse update(@RequestParam Long id,
                          @RequestBody MenuRequest menuRequest){
        return menuService.update(id, menuRequest);
    }

    @DeleteMapping()
    @Operation(summary = "to delete a menu")
    SimpleResponse delete(@RequestParam Long id){
        return menuService.delete(id);
    }

}
