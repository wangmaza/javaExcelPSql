package com.example.easyexceltest.lister;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.easyexceltest.bo.SqlDemo;

import java.io.*;
import java.util.Map;

public class SelfExcelListener extends AnalysisEventListener<SqlDemo> {
    /**
     * 一行一行读
     *
     * @param demo
     * @param analysisContext
     */

    @Override
    public void invoke(SqlDemo demo, AnalysisContext analysisContext) {
        //1.读取sql
        String ssql = null;
        try {
            ssql = readBuffer("D:/temp/onlyoneweek.sql");

            //2.拼接sql
            String a = ssql.replace("aaaa", demo.getName());

            String b = a.replace("bbbb", fenGeFu(demo.getNotSelfCardcode()));
            String cccc = b.replace("cccc", demo.getNotSelfPraCode()==null?"":demo.getNotSelfPraCode());

            String dddd = cccc.replace("dddd", demo.getCode());

            //3.生成文件
            writerfile("D:/temp/"+demo.getName()+".sql", dddd);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //分割符
    public String fenGeFu(String orign){
        String s = "";
        if (orign.contains(",")) {
            String[] split = orign.split(",");
            for (int i = 0; i < split.length; i++) {
                if (i != (split.length - 1)) {
                    s = s + split[i] + "','";
                }else {
                    s = s + split[i];
                }
            }
        }
        return s;
    }

    void writerfile(String filename, String content) throws Exception {
        Writer writer = null;
        try {
            File file = new File(filename);
            //创建文件
            if (!file.exists()) {
                file.createNewFile();
            }
            //实例化writer对象
            writer = new FileWriter(file);
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭writer对象
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String readBuffer(String filePath) throws Exception {
        File file = new File(filePath);
        FileInputStream fis = null;
        String sql = null;
        try {
            fis = new FileInputStream(file);
            byte[] buf = new byte[102400];//长度可以定义成1024的整数倍。
            int len = 0;
            while ((len = fis.read(buf)) != -1) {
                sql = new String(buf, 0, len);
            }
        } catch (Exception e) {

        } finally {
            fis.close();
        }

        return sql;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("----");
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头=" + headMap);
    }
}