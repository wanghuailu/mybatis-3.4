package org.apache.ibatis.debug;

/**
 * @author kenny
 * @date 2022-01-11
 */
public interface UserMapper {

    /**
     * 根据id查询
     *
     * @param id 主键
     * @return 用户
     */
    User select(Long id);
}
