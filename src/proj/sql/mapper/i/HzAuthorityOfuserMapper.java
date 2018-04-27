package sql.mapper.i;

import java.util.List;

import sql.pojo.GrantUser;
import sql.pojo.HzAuthorityOfuser;

public interface HzAuthorityOfuserMapper {


	int deleteByPrimaryKey(Long puid);

	int insert(HzAuthorityOfuser record);

	int insertSelective(HzAuthorityOfuser record);


	List<HzAuthorityOfuser> selectAuthosByUser(GrantUser user);

	HzAuthorityOfuser selectByPrimaryKey(Long puid);

	int updateByPrimaryKeySelective(HzAuthorityOfuser record);

	int updateByPrimaryKey(HzAuthorityOfuser record);
}