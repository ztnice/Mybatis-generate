package sql.mapper.i;

import java.util.List;

import sql.pojo.SuppliersHistory;

public interface SuppliersHistoryMapper {

	int deleteByPrimaryKey(Long historyId);

	int insert(SuppliersHistory record);

	int insertSelective(SuppliersHistory record);

	List<SuppliersHistory> selectAll();

	SuppliersHistory selectByPrimaryKey(Long historyId);

	int updateByPrimaryKeySelective(SuppliersHistory record);

	int updateByPrimaryKey(SuppliersHistory record);
}