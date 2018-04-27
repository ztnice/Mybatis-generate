package sql.mapper.i;

import java.util.List;

import sql.pojo.Suppliers;

public interface SuppliersMapper {
	int deleteByCode(Suppliers example);

	int deleteByPrimaryKey(Long suppliersId);

	int insert(Suppliers record);

	int insertSelective(Suppliers record);

	Suppliers selectByPrimaryKey(Long suppliersId);

	List<Suppliers> selectAll();

	Suppliers selectByCode(String suppliersCode);

	Suppliers selectByCode2(Suppliers suppliersCode);

	Suppliers selectByName(String suppliersName);

	int updateByPrimaryKeySelective(Suppliers record);

	int updateByPrimaryKey(Suppliers record);
}