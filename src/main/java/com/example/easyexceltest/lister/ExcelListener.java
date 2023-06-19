package com.example.easyexceltest.lister;
 
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import com.example.easyexceltest.bo.ReadDemo;
import com.example.easyexceltest.utils.SqlDemoListHolder;

import java.util.ArrayList;
import java.util.Map;
 
public class ExcelListener extends AnalysisEventListener<ReadDemo> {
    /**
     * 一行一行读
     * @param demo
     * @param analysisContext
     */
 
    @Override
    public void invoke(ReadDemo demo, AnalysisContext analysisContext) {

        ThreadLocal<ArrayList> holder = SqlDemoListHolder.holder;
        ArrayList arrayList = holder.get();
        arrayList.add(demo);


        System.out.println("---"+demo);
    }
 
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        ThreadLocal<ArrayList> holder = SqlDemoListHolder.holder;
        ArrayList arrayList = holder.get();
        arrayList.stream().forEach(e->{
            System.out.println(e);
        });
    }
 
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        ThreadLocal<ArrayList> holder = SqlDemoListHolder.holder;
        ArrayList arrayList = new ArrayList();
        holder.set(arrayList);
        System.out.println("表头="+headMap);
    }
}