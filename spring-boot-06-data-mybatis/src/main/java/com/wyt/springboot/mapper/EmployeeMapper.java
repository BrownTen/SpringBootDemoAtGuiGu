package com.wyt.springboot.mapper;

import com.wyt.springboot.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insetEmp(Employee employee);
}
