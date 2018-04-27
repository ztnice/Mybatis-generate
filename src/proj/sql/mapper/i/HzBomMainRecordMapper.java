package sql.mapper.i;

import sql.pojo.HZBomMainRecord;

public interface HzBomMainRecordMapper {

	int deleteByPrimaryKey(String puid);

	int deleteByOrgPuid(HZBomMainRecord puid);

	int insert(HZBomMainRecord record);

	int insertSelective(HZBomMainRecord record);

	HZBomMainRecord selectByPrimaryKey(String puid);

	HZBomMainRecord selectByOrgPuid(String puid);

	int updateByPrimaryKeySelective(HZBomMainRecord record);

	int updateByPrimaryKey(HZBomMainRecord record);
}