package com.csdn.demo.sys.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.csdn.demo.sys.dto.TreeDTO;
import com.csdn.demo.sys.entity.Tree;
@Component
public class TreeMapperImpl implements TreeMapper {

	@Override
	public TreeDTO treeToTreeDTO(Tree entity) {
		// TODO Auto-generated method stub
		if(entity ==null) {
			
			return null;
		}
		TreeDTO treeDTO= new TreeDTO();
		treeDTO.setChecked(entity.isChecked());
		treeDTO.setCode(entity.getCode());
		treeDTO.setIcon(entity.getIcon());
		treeDTO.setId(entity.getId());
		treeDTO.setName(entity.getName());
		treeDTO.setpId(entity.getpId());
		treeDTO.setState(entity.getState());
		treeDTO.setTreeOrder(entity.getTreeOrder());
		return treeDTO;
	}

	@Override
	public List<TreeDTO> treesToTressDTOs(List<Tree> treeList) {
		// TODO Auto-generated method stub
		if(treeList ==null) {
			return null;
		}
		if(treeList.size()<1) {
			return new ArrayList<TreeDTO>();
		}
		List<TreeDTO> treeDTOList = new ArrayList<TreeDTO>();
		for(Tree entity : treeList) {
			TreeDTO treeDTO= new TreeDTO();
			treeDTO.setChecked(entity.isChecked());
			treeDTO.setCode(entity.getCode());
			treeDTO.setIcon(entity.getIcon());
			treeDTO.setId(entity.getId());
			treeDTO.setName(entity.getName());
			treeDTO.setpId(entity.getpId());
			treeDTO.setState(entity.getState());
			treeDTO.setTreeOrder(entity.getTreeOrder());
			treeDTOList.add(treeDTO);
		}
		return treeDTOList;
	}

}
