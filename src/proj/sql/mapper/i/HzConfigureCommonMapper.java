package sql.mapper.i;

import java.util.List;

import sql.pojo.HzConfigureCommon;

public interface HzConfigureCommonMapper {

	List<HzConfigureCommon> selectLvl2FromItem(HzConfigureCommon itemId);

	List<HzConfigureCommon> selectLvl3FromLvl2(HzConfigureCommon itemId);

	List<HzConfigureCommon> selectModelCfgByItemPuid(HzConfigureCommon itemId);

	List<HzConfigureCommon> selectModelByItemId(HzConfigureCommon itemId);

}