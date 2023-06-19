package com.example.easyexceltest;

import com.example.easyexceltest.utils.StringUtils;
import org.junit.jupiter.api.Test;

import java.io.File;

public class MergeFileToString {

    @Test
    public void merge() throws Exception{
        //1.一个stringbuider
        StringBuilder stringBuilder = new StringBuilder();
        //2.遍历文件夹，并读出内容，追加到string
        String filePath="D:\\Temp\\sql";
        File file=new File(filePath);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            File file1 = files[i];
            String content = StringUtils.readBuffer(file1.getPath());
            content+="union all \r\n";
            stringBuilder.append(content);
        }
        System.out.println(stringBuilder);
    }
}
