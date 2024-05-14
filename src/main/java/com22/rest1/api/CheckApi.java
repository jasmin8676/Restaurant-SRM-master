package com22.rest1.api;


import com22.rest1.dto.SimpleResponse;
import com22.rest1.dto.checkDto.CheckRequest;
import com22.rest1.dto.checkDto.CheckResponse;
import com22.rest1.service.CheckService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/checks")
@RestController
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class CheckApi {

    private final CheckService checkService;

    @GetMapping
    @Operation(summary = "to get all checks")
    List<CheckResponse> getAll(){
        return checkService.getAll();
    }

    @GetMapping("/getById")
    @Operation(summary = "to get check by id")
    CheckResponse getById(@RequestParam Long id){
        return checkService.getById(id);
    }

    @PostMapping
    @Operation(summary = "to create new check")
    SimpleResponse save(@RequestBody CheckRequest checkRequest){
        return checkService.save(checkRequest);
    }

    @PutMapping()
    @Operation(summary = "to update a check")
    SimpleResponse update(@RequestParam Long id,
                          @RequestBody CheckRequest checkRequest){
        return checkService.update(id, checkRequest);
    }

    @DeleteMapping()
    @Operation(summary = "to delete a check")
    SimpleResponse delete(@RequestParam Long id){
        return checkService.delete(id);
    }

}
