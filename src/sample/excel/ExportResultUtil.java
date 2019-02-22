package sample.excel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import db.StoreUtils;
import model.TableResult;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rockywoo on 2019/2/22.
 */
public class ExportResultUtil {

    public static void main(String[] args) {
        TableResult tableResult=new TableResult();
        tableResult.setCol1("1");
        tableResult.setCol2("2");
        tableResult.setCol3("3");
        tableResult.setCol4("4");
        tableResult.setCol5("5");
        tableResult.setCol6("6");
        tableResult.setCol7("7");
        StoreUtils.tableResult1.add(tableResult);
        StoreUtils.tableResult2.add(tableResult);
        StoreUtils.tableResult3.add(tableResult);
        ExportResultUtil.export("/Users/rockywoo/dev/dddd.xls");
    }


    public static void export(String filePath){
        try (
                OutputStream out = new FileOutputStream(filePath)) {
            List<Map<String, Object>> exportSheets = new ArrayList<>();
            Map<String, Object> sheetMap = new HashMap<>();
            ExportParams exportParams = new ExportParams();
            exportParams.setSheetName("Balanced");
            sheetMap.put("title", exportParams);
            sheetMap.put("entity", TableResult.class);
            sheetMap.put("data", StoreUtils.tableResult1);
            exportSheets.add(sheetMap);

            exportParams = new ExportParams();
            sheetMap = new HashMap<>();
            exportParams.setSheetName("Academics-focused");
            sheetMap.put("title", exportParams);
            sheetMap.put("entity", TableResult.class);
            sheetMap.put("data", StoreUtils.tableResult2);
            exportSheets.add(sheetMap);

            exportParams = new ExportParams();
            sheetMap = new HashMap<>();
            exportParams.setSheetName("Personality-focused");
            sheetMap.put("title", exportParams);
            sheetMap.put("entity", TableResult.class);
            sheetMap.put("data", StoreUtils.tableResult3);
            exportSheets.add(sheetMap);
            Workbook workbook = ExcelExportUtil.exportExcel(exportSheets, ExcelType.HSSF);
            try {
                workbook.write(out);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
