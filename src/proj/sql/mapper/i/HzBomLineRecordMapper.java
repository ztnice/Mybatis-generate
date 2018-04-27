package sql.mapper.i;

import java.util.List;

import sql.pojo.HzBomLineRecord;

public interface HzBomLineRecordMapper {

	int deleteByPrimaryKey(String puid);

	int insert(HzBomLineRecord record);

	int insertByBatch(List<HzBomLineRecord> record);

	int insertSelective(HzBomLineRecord record);

	HzBomLineRecord selectByPrimaryKey(HzBomLineRecord puid);

	List<HzBomLineRecord> selectByBomDigifaxId(HzBomLineRecord puid);

	int updateByPrimaryKeySelective(HzBomLineRecord record);

	int updateByPrimaryKeyWithBLOBs(HzBomLineRecord record);

	int updateByPrimaryKey(HzBomLineRecord record);
}