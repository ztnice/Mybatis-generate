package sql.mapper.i;

import java.util.List;

import share.bean.Cfg0OfBomline;

public interface HzConfigureOfBomMapper {
	/***
	 * ��������
	 * 
	 * @param list
	 *            �����list
	 * @return
	 */
	int insertByBatch(List<Cfg0OfBomline> list);

}