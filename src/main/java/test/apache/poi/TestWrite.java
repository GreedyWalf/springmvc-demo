package test.apache.poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 *  POI支持excel文件写入（支持高版本的excel）
 *
 * Created by QinYupeng on 2017/6/27.
 */
public class TestWrite {

    public static void main(String[] args) throws Exception {
        writeExcel();
        System.out.println("====>>>生成excel成功");
    }


    public static  void writeExcel() throws Exception {
        //1. 指定写入excel文件位置及文件名
        File file = new File("D:/addCourseInfo.xlsx");
        FileOutputStream outputStream = new FileOutputStream(file);
        List<CourseInfo> courseInfoList = TestRead.readExcel();

        //2. 创建workbook对象，将实体数据封装在工作簿对象中；
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        for (int i = 0; i < courseInfoList.size(); i++) {
            CourseInfo ci = courseInfoList.get(i);
            if (ci == null) {
                continue;
            }

            Row row = sheet.createRow(i);
            //课程编号
            row.createCell(0, Cell.CELL_TYPE_STRING).setCellValue(ci.getCourseCode());
            //课程标题
            row.createCell(1, Cell.CELL_TYPE_STRING).setCellValue(ci.getCourseTitle());
            //学时
            row.createCell(2, Cell.CELL_TYPE_STRING).setCellValue(ci.getCoursePeriod());
            //学分
            row.createCell(3, Cell.CELL_TYPE_STRING).setCellValue(ci.getCourseScore());
        }

        //3. 将workbook对象数据写入到输出字节流中，生成excel文件
        workbook.write(outputStream);
        outputStream.close();
    }
}


