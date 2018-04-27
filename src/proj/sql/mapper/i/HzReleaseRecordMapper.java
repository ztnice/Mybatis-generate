package sql.mapper.i;

import sql.pojo.HzReleaseRecord;

public interface HzReleaseRecordMapper {


	int deleteByPrimaryKey(String recordCode);

	int insert(HzReleaseRecord record);

	int insertSelective(HzReleaseRecord record);


	HzReleaseRecord selectByPrimaryKey(String recordCode);

	HzReleaseRecord selectByOaProNum(String oaProcessNum);

	int updateByPrimaryKeySelective(HzReleaseRecord record);

	int updateByPrimaryKey(HzReleaseRecord record);
}