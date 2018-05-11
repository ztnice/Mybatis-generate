package sql.mapper.cfg.i;

import sql.pojo.cfg.HzCfg0ColorSet;

import java.util.List;

public interface HzCfg0ColorSetMapper {

    int deleteByPrimaryKey(String puid);

    int insert(HzCfg0ColorSet record);

    List<HzCfg0ColorSet> selectAll();

    int insertSelective(HzCfg0ColorSet record);

    HzCfg0ColorSet selectByPrimaryKey(String puid);

    int updateByPrimaryKeySelective(HzCfg0ColorSet record);

    int updateByPrimaryKey(HzCfg0ColorSet record);
}