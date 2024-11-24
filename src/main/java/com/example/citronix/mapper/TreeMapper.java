package com.example.citronix.mapper;

import com.example.citronix.dto.Tree.TreeCreateDTO;
import com.example.citronix.dto.Tree.TreeUpdateDTO;
import com.example.citronix.entity.Tree;
import com.example.citronix.vm.TreeVm;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface TreeMapper {
    Tree toTree(TreeCreateDTO treeCreateDTO);
    TreeVm toTreeVm(Tree tree);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Tree partialUpdate(TreeUpdateDTO treeUpdateDto, @MappingTarget Tree tree);

}
