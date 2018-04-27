package sql.mapper.i;

import java.util.List;

import sql.pojo.HzBom2YEntity;

public interface HzBom2YEntityMapper {

	int deleteByPrimaryKey(String puid);

	int insert(HzBom2YEntity record);

	int insertSelective(HzBom2YEntity record);

	int insertByBatch(List<HzBom2YEntity> record);

	HzBom2YEntity selectByPrimaryKey(String puid);

	int updateByPrimaryKeySelective(HzBom2YEntity record);

	int updateByPrimaryKeyWithBLOBs(HzBom2YEntity record);

	int updateByPrimaryKey(HzBom2YEntity record);
}