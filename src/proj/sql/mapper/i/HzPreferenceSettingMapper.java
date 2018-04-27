package sql.mapper.i;

import sql.pojo.HzPreferenceSetting;

public interface HzPreferenceSettingMapper {

    int deleteByPrimaryKey(Long puid);

    int insert(HzPreferenceSetting record);

    int insertSelective(HzPreferenceSetting record);


    HzPreferenceSetting selectByPrimaryKey(Long puid);

    int updateByPrimaryKeySelective(HzPreferenceSetting record);

    int updateByPrimaryKeyWithBLOBs(HzPreferenceSetting record);

    int updateByPrimaryKey(HzPreferenceSetting record);
}