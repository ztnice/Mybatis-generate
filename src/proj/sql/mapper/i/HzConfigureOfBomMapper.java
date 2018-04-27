package sql.mapper.i;

import java.util.List;

import share.bean.Cfg0OfBomline;

public interface HzConfigureOfBomMapper {
	/***
	 * 批量插入
	 * 
	 * @param list
	 *            插入的list
	 * @return
	 */
	int insertByBatch(List<Cfg0OfBomline> list);

}