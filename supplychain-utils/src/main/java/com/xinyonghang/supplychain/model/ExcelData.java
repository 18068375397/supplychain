package com.xinyonghang.supplychain.model;


import java.util.List;

public class ExcelData {
    private String fileName;
    private String[] sheets;
    private String[] titles;
    private List<String[]> columnsList;
    private List<List<String[]>> datasList;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String[] getTitles() {

        return this.titles;

    }


    public void setTitles(String[] titles) {

        this.titles = titles;

    }


    public String getFileName() {

        return this.fileName;

    }


    public void setFileName(String fileName) {

        this.fileName = fileName;

    }


    public String[] getSheets() {

        return this.sheets;

    }


    public void setSheets(String[] sheets) {

        this.sheets = sheets;

    }


    public List<String[]> getColumnsList() {

        return this.columnsList;

    }


    public void setColumnsList(List<String[]> columnsList) {

        this.columnsList = columnsList;

    }


    public List<List<String[]>> getDatasList() {

        return this.datasList;

    }


    public void setDatasList(List<List<String[]>> datasList) {

        this.datasList = datasList;

    }

}

