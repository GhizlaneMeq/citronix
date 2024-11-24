package com.example.citronix.mapper;

import com.example.citronix.dto.harvest.HarvestCreateDTO;
import com.example.citronix.entity.Harvest;
import com.example.citronix.entity.HarvestDetails;
import com.example.citronix.vm.HarvestDetailsVm;
import com.example.citronix.vm.HarvestVm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HarvestMapper {
    Harvest toHarvest(HarvestCreateDTO harvestCreateDTO);
    @Mapping(target = "harvestDetails", source = "harvestDetails")
    HarvestVm toResponse(Harvest harvest);

    @Mapping(source = "tree.id", target = "treeId")
    @Mapping(source = "tree.plantationDate", target = "treePlantationDate")
    HarvestDetailsVm toResponse(HarvestDetails harvestDetails);

    List<HarvestDetailsVm> toResponse(List<HarvestDetailsVm> harvestDetails);

}
