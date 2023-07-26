package org.apache.ibatis.debug;

import org.apache.ibatis.annotations.Param;

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

    void update(@Param("id") Long id, @Param("age") int age);
}
