package com.example.citronix.service.implementation;

import com.example.citronix.dto.Tree.TreeCreateDTO;
import com.example.citronix.dto.Tree.TreeUpdateDTO;
import com.example.citronix.entity.Field;
import com.example.citronix.entity.Tree;
import com.example.citronix.exception.Tree.OutOfSpaceException;
import com.example.citronix.exception.Tree.TreeNotFoundException;
import com.example.citronix.mapper.TreeMapper;
import com.example.citronix.repository.TreeRepository;
import com.example.citronix.service.FieldService;
import com.example.citronix.service.TreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TreeServiceImpl implements TreeService {
    private final TreeRepository treeRepository;
    private final TreeMapper treeMapper;
    private final FieldService fieldService;

    @Override
    public Tree save(TreeCreateDTO treeCreateDTO) {
        Field field = fieldService.findById(treeCreateDTO.getFieldId());
        Long totalTreesPerField = treeRepository.countByField(field);
        double maxTreesPerField = field.getArea() * 10 / 1000;

        if (totalTreesPerField + 1 > maxTreesPerField) {
            throw new OutOfSpaceException("there is no available space for this tree!");
        }

        Tree tree = treeMapper.toTree(treeCreateDTO);

        tree.setField(field);

        return treeRepository.save(tree);
    }

    @Override
    public void delete(Long id) {
        Tree tree = findById(id);
        treeRepository.delete(tree);
    }

    @Override
    public Tree update(Long id, TreeUpdateDTO treeUpdateDto) {
        Tree existingTree = findById(id);
        Tree updateTree = treeMapper.partialUpdate(treeUpdateDto, existingTree);
        updateTree.setField(existingTree.getField());
        return treeRepository.save(updateTree);
    }

    @Override
    public Tree findById(Long id) {
         return treeRepository.findById(id)
                 .orElseThrow(() -> new TreeNotFoundException("Tree with id : " + id + " not found"));
    }

    @Override
    public double calculateTreeProductivity(Tree tree) {
        if (tree == null || tree.getPlantationDate() == null) {
            throw new IllegalArgumentException("Tree or plantation date cannot be null");
        }

        int currentYear = java.time.Year.now().getValue();
        int plantationYear = tree.getPlantationDate().getYear();
        int treeAge = currentYear - plantationYear;

        if (treeAge < 3) {
            return 2.5;
        } else if (treeAge >= 3 && treeAge <= 10) {
            return 12.0;
        } else if (treeAge > 10 && treeAge <= 20) {
            return 20.0;
        } else {
            return 0.0;
        }
    }


    @Override
    public List<Tree> productiveTreesByField(Field field) {
        if (field == null) {
            throw new IllegalArgumentException("Field cannot be null");
        }

        LocalDateTime twentyYearsAgo = LocalDateTime.now().minusYears(20);

        return treeRepository.findByFieldAndPlantationDateAfter(field, twentyYearsAgo);
    }

}
