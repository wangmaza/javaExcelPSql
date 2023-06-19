package com.example.easyexceltest.bo;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ReadDemo {

    @ExcelProperty(value = "学生编号",index = 0)
    private Integer sno;

    @ExcelProperty(value = "学生姓名",index = 1)
    private String sname;
}
