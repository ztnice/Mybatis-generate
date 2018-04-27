package sql.mapper.i;

import sql.pojo.HzTempMainRecord;

public interface HzTempMainRecordMapper {

	int deleteByPrimaryKey(Object processNum);

	int insert(HzTempMainRecord record);

	int insertSelective(HzTempMainRecord record);

	HzTempMainRecord selectByPrimaryKey(String processNum);

	int updateByPrimaryKeySelective(HzTempMainRecord record);

	int updateByPrimaryKey(HzTempMainRecord record);
}