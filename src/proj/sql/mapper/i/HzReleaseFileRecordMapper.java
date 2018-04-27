package sql.mapper.i;

import sql.pojo.HzReleaseFileRecord;

public interface HzReleaseFileRecordMapper {


    int insert(HzReleaseFileRecord record);

    int insertSelective(HzReleaseFileRecord record);


}