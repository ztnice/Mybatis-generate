package sql.mapper.i;

import sql.pojo.UserAuthorization;

public interface UserAuthorizationMapper {

	int deleteByPrimaryKey(Short authorizationId);

	int insert(UserAuthorization record);

	int insertSelective(UserAuthorization record);

	UserAuthorization selectByPrimaryKey(Short authorizationId);

	int updateByPrimaryKeySelective(UserAuthorization record);

	int updateByPrimaryKey(UserAuthorization record);
}