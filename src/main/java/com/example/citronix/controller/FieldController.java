package com.example.citronix.controller;

import com.example.citronix.dto.field.FieldCreateDTO;
import com.example.citronix.entity.Field;
import com.example.citronix.mapper.FieldMapper;
import com.example.citronix.service.FieldService;
import com.example.citronix.vm.FieldVm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/vi")
@RequiredArgsConstructor
public class FieldController {

    private final FieldService fieldService;
    private final FieldMapper fieldMapper;
    @PostMapping("/fields")
    public ResponseEntity<FieldVm> create (@Valid @RequestBody FieldCreateDTO fieldCreateDTO){
        Field field = fieldService.save(fieldCreateDTO);
        FieldVm fieldVm = fieldMapper.toFieldVm(field);
        return ResponseEntity.status(HttpStatus.CREATED).body(fieldVm);
    }
}
