package com.example.citronix.service;

import com.example.citronix.dto.Tree.TreeCreateDTO;
import com.example.citronix.dto.Tree.TreeUpdateDTO;
import com.example.citronix.entity.Field;
import com.example.citronix.entity.Tree;

import java.util.List;

public interface TreeService {
    Tree save(TreeCreateDTO treeCreateDTO) ;
    void delete(Long id);
    Tree update(Long id, TreeUpdateDTO treeUpdateDto);
    Tree findById(Long id);
    double calculateTreeProductivity(Tree tree);
    List<Tree> productiveTreesByField(Field field);
}
