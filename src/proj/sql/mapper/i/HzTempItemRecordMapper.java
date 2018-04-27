package sql.mapper.i;

import java.util.List;

import sql.pojo.HzTempItemRecord;
import sql.pojo.HzTempMainRecord;

public interface HzTempItemRecordMapper {


	int deleteByPrimaryKey(Long id);

	int insert(HzTempItemRecord record);

	int insertSelective(HzTempItemRecord record);


	List<HzTempItemRecord> selectByMainRecord(HzTempMainRecord mainRecord);

	HzTempItemRecord selectByPrimaryKey(Long id);


	int updateByPrimaryKeySelective(HzTempItemRecord record);

	int updateByPrimaryKey(HzTempItemRecord record);
}