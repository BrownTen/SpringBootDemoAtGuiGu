package com.wyt.springboot.controller;

import com.wyt.springboot.dao.DepartmentDao;
import com.wyt.springboot.dao.EmployeeDao;
import com.wyt.springboot.entities.Department;
import com.wyt.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        //thymeleaf会自动拼串
        //"classpath:/templates/xxx.html"
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面,查出所有的部门,在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工添加功能
    @PostMapping("/emp")
    //SpringMvc自动将请求参数和入参对象的属性进行一一绑定,要求了请求参数的名字和javaBean入参的对象里面的属性名是一样的
    public String addEmp(Employee employee){
        //保存员工
        employeeDao.save(employee);
        //来到员工列表页面
        //redirect:表示重定向到一个地址,/代表当前项目路径
        //forward:表示转发到一个地址
        return "redirect:/emps";
    }

    //来到修改页面,查出当前员工,在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //页面要显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面(add时修改添加二合一的页面)
        return "emp/add";
    }

    //员工修改,需要提交员工id
    @PutMapping("/emp")
    public String updateEmple(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
