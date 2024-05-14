package com22.rest1.service.impl;

import com22.rest1.dto.SimpleResponse;
import com22.rest1.dto.checkDto.CheckRequest;
import com22.rest1.dto.checkDto.CheckResponse;
import com22.rest1.entity.Check;
import com22.rest1.globalException.NotFoundException;
import com22.rest1.repository.CheckRepository;
import com22.rest1.service.CheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckServiceImpl implements CheckService {
    private final CheckRepository checkRepository;

    @Override
    public List<CheckResponse> getAll() {
        return checkRepository.getAll();
    }

    @Override
    public CheckResponse getById(Long id) {
        Check check = checkRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Check not found with id " + id)
        );
        return CheckResponse.entityToResponse(check);
    }

    @Override
    public SimpleResponse save(CheckRequest checkRequest) {
        checkRepository.save(checkRequest.requestToEntity());
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Check saved with ")
                .build();
    }

    @Override
    public SimpleResponse update(Long id, CheckRequest checkRequest) {
        Check check = checkRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Check not found with id " + id)
        );
        checkRepository.save(checkRequest.requestToEntityForUpdate(check));
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Check updated with id " + check.getId())
                .build();
    }

    @Override
    public SimpleResponse delete(Long id) {
        Check check = checkRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Check not found with id " + id)
        );
        checkRepository.deleteById(id);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Check deleted with id " + check.getId())
                .build();
    }
}
