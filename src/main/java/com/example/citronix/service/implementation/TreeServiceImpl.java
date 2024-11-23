package com.example.citronix.service.implementation;

import com.example.citronix.dto.Tree.TreeCreateDTO;
import com.example.citronix.entity.Field;
import com.example.citronix.entity.Tree;
import com.example.citronix.exception.Tree.OutOfSpaceException;
import com.example.citronix.mapper.TreeMapper;
import com.example.citronix.repository.TreeRepository;
import com.example.citronix.service.FieldService;
import com.example.citronix.service.TreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    }

    @Override
    public Tree update(Long id, TreeCreateDTO treeUpdateDto) {
        return null;
    }

    @Override
    public Tree findById(Long id) {
        return null;
    }
}
