package com.wyt.springboot.mapper;

import com.wyt.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DepartmentMapper {
    @Select("select * from department where id = #{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id = #{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update deptartment set department_name = #{departmentName} where id = #{id}")
    public int updateDept(Department department);
}
