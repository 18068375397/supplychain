package com.xinyonghang.supplychain.utils;

import com.xinyonghang.supplychain.model.ExcelData;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 操作Excel表格的功能类
 */
public class ExcelUtil {

    /**
     * 读入excel文件，解析后返回
     * 备注 只能读取标准格式
     *
     * @param resource
     * @return
     * @throws IOException
     */
    public static List<String[]> readExcel(String resource, Integer cellRead) throws IOException {
        InputStream is = new FileInputStream(resource);
        // 获得Workbook工作薄对象
        XSSFWorkbook workbook = new XSSFWorkbook(is);
        // 创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
        List<String[]> list = new ArrayList<String[]>();
        if (workbook != null) {
            for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
                // workbook.getSheet("菜单");
                // 获得当前sheet工作表
                XSSFSheet sheet = workbook.getSheetAt(sheetNum);
                if (sheet == null) {
                    continue;
                }
                // 获得当前sheet的开始行
                int firstRowNum = sheet.getFirstRowNum();
                // 获得当前sheet的结束行
                int lastRowNum = sheet.getLastRowNum();
                // 循环除了第一行的所有行
                for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
                    // 获得当前行
                    XSSFRow row = sheet.getRow(rowNum);
                    if (row == null) {
                        continue;
                    }
                    // 获得当前行的开始列
                    int firstCellNum = row.getFirstCellNum();
                    // 获得当前行的列数
                    int lastCellNum = row.getLastCellNum();
                    String[] cells = new String[row.getLastCellNum()];
                    // 循环当前行
                    for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
                        XSSFCell cell = row.getCell(cellNum);
                        cells[cellNum] = getCellValue(cellNum, cell);
                    }
                    list.add(cells);
                }
            }
            workbook.close();
            is.close();
        }
        return list;
    }

    public static String getCellValue(int cellNum, XSSFCell cell) {
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }

        CellType ct = cell.getCellTypeEnum();
        if (CellType.STRING == ct) {
            return cell.getStringCellValue();
        } else if (CellType.BLANK == ct) {
            return "";
        } else if (CellType.BOOLEAN == ct) {
            return cell.getBooleanCellValue() + "";
        } else if (CellType.NUMERIC == ct) {
            return cell.getNumericCellValue() + "";
        } else if (CellType._NONE == ct) {
            return "";
        }

        return cell.getStringCellValue();
    }

    /**
     * 导出excel<br>
     * <pre>
     * <b>数据组装例子</b><br>
     * ExcelData excelData = new ExcelData();
     * excelData.setPath("d://excel")
     * excelData.setFileName("文件.xls");
     * // 每个sheet的名字
     * excelData.setSheets(new String[] { "学生表", "成绩表" });
     * // 每个sheet正文中的标题
     * excelData.setTitles(new String[] { "学生资料汇总", "学生成绩汇总" });
     * List<String[]> columnsList = new ArrayList<String[]>();
     * // 第一个sheet的标题
     * columnsList.add(new String[] { "用户名", "邮箱", "昵称" });
     * // 第二个sheet的标题
     * columnsList.add(new String[] { "语文", "数学", "外语" });
     * excelData.setColumnsList(columnsList);
     *
     * List<List<String[]>> datasList = new ArrayList<List<String[]>>();
     * // 第一个sheet的数据
     * List<String[]> datas1 = new ArrayList<String[]>();
     * datas1.add(new String[] { "马云", "tsy@163.com", "云云" });
     * datas1.add(new String[] { "马化腾", "lyf@163.com", "腾腾" });
     * datas1.add(new String[] { "范冰冰", "fbb@163.com", "冰冰" });
     * datas1.add(new String[] { "罗永浩", "ym@163.com", "浩浩" });
     * datas1.add(new String[] { "王思聪", "zs@163.com", "聪聪" });
     * datasList.add(datas1);
     *
     * // 第二个sheet的数据
     * List<String[]> datas2 = new ArrayList<String[]>();
     * datas2.add(new String[] { "95", "97", "94" });
     * datas2.add(new String[] { "85", "87", "84" });
     * datas2.add(new String[] { "75", "77", "74" });
     * datas2.add(new String[] { "65", "67", "64" });
     * datas2.add(new String[] { "55", "57", "54" });
     * datasList.add(datas2);
     *
     * excelData.setDatasList(datasList);
     * </pre>
     */
    public static String exportExcel(ExcelData excelData) throws Exception {
        File filePath = new File(excelData.getPath());
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        File file = new File(excelData.getPath() + "/" + excelData.getFileName());
        FileOutputStream fos = new FileOutputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook();
        String[] sheets = excelData.getSheets();
        String[] titles = excelData.getTitles();
        List<String[]> columnsList = excelData.getColumnsList();
        List<List<String[]>> datasList = excelData.getDatasList();
        for (int i = 0; i < sheets.length; i++) {

            XSSFSheet sheet = workbook.createSheet(sheets[i]);
            XSSFCell cell = sheet.createRow(0).createCell(0);
            cell.setCellValue(titles[i]);
            XSSFCellStyle titileStyle = workbook.createCellStyle();
            titileStyle.setAlignment(HorizontalAlignment.CENTER);
            titileStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            cell.setCellStyle(titileStyle);
            String[] columns = (String[]) columnsList.get(i);
            List<String[]> datas = (List) datasList.get(i);
            CellRangeAddress cra = new CellRangeAddress(0, 0, 0, columns.length - 1);
            sheet.addMergedRegion(cra);
            XSSFRow titleRow = sheet.createRow(1);
            for (int j = 0; j < columns.length; j++) {
                XSSFCell columnCell = titleRow.createCell(j);
                columnCell.setCellValue(columns[j]);
            }
            for (int j = 0; j < datas.size(); j++) {
                XSSFRow dataRow = sheet.createRow(2 + j);
                String[] data = (String[]) datas.get(j);
                for (int k = 0; k < data.length; k++) {
                    XSSFCell columnCell = dataRow.createCell(k);
                    columnCell.setCellValue(data[k]);
                }
            }
        }
        workbook.write(fos);
        workbook.close();
        fos.close();
        String apath = file.getAbsolutePath();
        return apath;

    }


    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        File directory = new File("");//参数为空
        String courseFile = directory.getCanonicalPath();
        System.out.println(courseFile);
        courseFile = courseFile + "/supplychain-utils/src/main/resources/generator/template/系统菜单.xlsx";


        List<String[]> list = readExcel(courseFile, 4);


        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://192.168.3.222:1433;DatabaseName=ERP";
        String user = "testERP";
        String passwd = "testERP";
        Connection conn = null;
        Statement stmt = null;

        Class.forName(driverName);
        conn = DriverManager.getConnection(url, user, passwd);
        conn.setAutoCommit(false);
        // conn.setAutoCommit(false); // 自动提交设置为false
        stmt = conn.createStatement();

        String deleteSql = "DELETE FROM  MK_MENU";
        stmt.addBatch(deleteSql);
        for (String[] s : list) {
            // 系统ID level 父类ID 名称 类型 连接地址  管理员权限	普通用户权限
            String insertSql = "insert into MK_MENU(MENU_ID,MENU_NAME,PARENT_ID,MENU_URL) VALUES ('"
                    + s[0] + "','" + s[1] + "','" + s[2] + "','" + s[3] + "')";
            stmt.addBatch(insertSql);
            System.out.println(insertSql);
        }

        stmt.executeBatch();
        conn.commit();
        stmt.close();
        conn.close();


//        ExcelData excelData = new ExcelData();
//        excelData.setPath("d://excel");
//
//        excelData.setFileName("文件.xls");
//        // 每个sheet的名字
//        excelData.setSheets(new String[]{"学生表", "成绩表"});
//        // 每个sheet正文中的标题
//        excelData.setTitles(new String[]{"学生资料汇总", "学生成绩汇总"});
//        List<String[]> columnsList = new ArrayList<String[]>();
//        // 第一个sheet的标题
//        columnsList.add(new String[]{"用户名", "邮箱", "昵称"});
//        // 第二个sheet的标题
//        columnsList.add(new String[]{"语文", "数学", "外语"});
//        excelData.setColumnsList(columnsList);
//
//        List<List<String[]>> datasList = new ArrayList<List<String[]>>();
//        // 第一个sheet的数据
//        List<String[]> datas1 = new ArrayList<String[]>();
//        datas1.add(new String[]{"马云", "tsy@163.com", "云云"});
//        datas1.add(new String[]{"马化腾", "lyf@163.com", "腾腾"});
//        datas1.add(new String[]{"范冰冰", "fbb@163.com", "冰冰"});
//        datas1.add(new String[]{"罗永浩", "ym@163.com", "浩浩"});
//        datas1.add(new String[]{"王思聪", "zs@163.com", "聪聪"});
//        datasList.add(datas1);
//
//        // 第二个sheet的数据
//        List<String[]> datas2 = new ArrayList<String[]>();
//        datas2.add(new String[]{"95", "97", "94"});
//        datas2.add(new String[]{"85", "87", "84"});
//        datas2.add(new String[]{"75", "77", "74"});
//        datas2.add(new String[]{"65", "67", "64"});
//        datas2.add(new String[]{"55", "57", "54"});
//        datasList.add(datas2);
//
//        excelData.setDatasList(datasList);
//
//        try {
//            exportExcel(excelData);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}