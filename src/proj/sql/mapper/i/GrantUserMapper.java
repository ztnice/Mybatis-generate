package sql.mapper.i;

import sql.pojo.GrantUser;

public interface GrantUserMapper {


    int deleteByPrimaryKey(Long userId);

    int insert(GrantUser record);

    int insertSelective(GrantUser record);


    GrantUser selectByPrimaryKey(Long userId);



    int updateByPrimaryKeySelective(GrantUser record);

    int updateByPrimaryKey(GrantUser record);
}