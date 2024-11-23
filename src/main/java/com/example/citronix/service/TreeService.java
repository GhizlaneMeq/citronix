package com.example.citronix.service;

import com.example.citronix.dto.Tree.TreeCreateDTO;
import com.example.citronix.entity.Tree;

public interface TreeService {
    Tree save(TreeCreateDTO treeCreateDTO) ;
    void delete(Long id);
    Tree update(Long id, TreeCreateDTO treeUpdateDto);
    Tree findById(Long id);
}