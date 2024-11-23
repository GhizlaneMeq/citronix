package com.example.citronix.controller;


import com.example.citronix.dto.Tree.TreeCreateDTO;
import com.example.citronix.dto.Tree.TreeUpdateDTO;
import com.example.citronix.entity.Tree;
import com.example.citronix.mapper.TreeMapper;
import com.example.citronix.service.TreeService;
import com.example.citronix.vm.TreeVm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi")
@RequiredArgsConstructor
public class TreeController {
    private final TreeService treeService;
    private final TreeMapper treeMapper;

    @PostMapping("/trees")
    public ResponseEntity<TreeVm> create(@Valid @RequestBody TreeCreateDTO treeCreateDto) {
        Tree tree = treeService.save(treeCreateDto);
        TreeVm response = treeMapper.toTreeVm(tree);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @DeleteMapping("/trees/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        treeService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/trees/{id}")
    public ResponseEntity<TreeVm> update(@PathVariable Long id, @Valid @RequestBody TreeUpdateDTO treeUpdateDto) {
        Tree updatedTree = treeService.update(id, treeUpdateDto);
        TreeVm response = treeMapper.toTreeVm(updatedTree);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
