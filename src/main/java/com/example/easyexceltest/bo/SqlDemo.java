package com.example.easyexceltest.bo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;


@Data
public class SqlDemo {
    @ExcelProperty(value = "省份",index = 0)
    private String name;

    @ExcelProperty(value = "编码",index = 1)
    private String code;

    @ExcelProperty(value = "自保件身份证编码",index = 2)
    private String selfCardcode;

    @ExcelProperty(value = "自保件执业证编码",index = 3)
    private String selfPraCode;

    @ExcelProperty(value = "非自保件身份证编码",index = 4)
    private String notSelfCardcode;

    @ExcelProperty(value = "非自保件执业证编码",index = 5)
    private String notSelfPraCode;

}
