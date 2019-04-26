package com.wyt.springboot;

import com.wyt.springboot.bean.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot06DataMybatisApplicationTests {

    @Test
    public void contextLoads() {
        Department department = new Department();
        department.setDepartmentName("123");
        department.setId(1);
        System.out.println(department);
    }

}
