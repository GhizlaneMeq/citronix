package com.example.citronix.mapper;

import com.example.citronix.dto.Tree.TreeCreateDTO;
import com.example.citronix.entity.Tree;
import com.example.citronix.vm.TreeVm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TreeMapper {
    Tree toTree(TreeCreateDTO treeCreateDTO);
    TreeVm toTreeVm(Tree tree);

}
