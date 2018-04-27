package sql.mapper.i;

import java.util.List;

import sql.pojo.HzTempDocumentRecord;
import sql.pojo.HzTempMainRecord;

public interface HzTempDocumentRecordMapper {

	int deleteByPrimaryKey(Long id);

	int insert(HzTempDocumentRecord record);

	int insertSelective(HzTempDocumentRecord record);

	List<HzTempDocumentRecord> selectByMainRecord(HzTempMainRecord mainRecord);

	HzTempDocumentRecord selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(HzTempDocumentRecord record);

	int updateByPrimaryKey(HzTempDocumentRecord record);
}