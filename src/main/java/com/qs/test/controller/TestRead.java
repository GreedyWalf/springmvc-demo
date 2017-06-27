package com.qs.test.controller;

        import org.apache.poi.hssf.usermodel.HSSFDateUtil;
        import org.apache.poi.ss.usermodel.Cell;
        import org.apache.poi.ss.usermodel.Row;
        import org.apache.poi.ss.usermodel.Sheet;
        import org.apache.poi.ss.usermodel.Workbook;
        import org.apache.poi.xssf.usermodel.XSSFWorkbook;
        import test.apache.poi.CourseInfo;

        import java.io.File;
        import java.io.FileInputStream;
        import java.text.DateFormat;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;

/**
 * POI支持excel文件读取（支持高版本的excel）
 *
 * Created by QinYupeng on 2017/6/27.
 */
public class TestRead {
    public static void main(String[] args) throws Exception {
        readExcel();
        System.out.println("====>>>>读取excel文件成功！");
    }


    public static List<CourseInfo> readExcel() throws Exception {
        String filePath = "D:\\studyDir\\springmvc-demo\\src\\main\\resources\\excel\\updateCourseInfo.xlsx";
        File file = new File(filePath);
        //1. 将需要读取的excel文档序列化为字节流
        FileInputStream inputStream = new FileInputStream(file);

        //2. 构建workbook文档对象
        Workbook workbook = new XSSFWorkbook(inputStream);
        System.out.println(workbook);

        //3. 获取excel中指定sheet页
        Sheet sheet = workbook.getSheetAt(0);
//        sheet = workbook.getSheet("Sheet1");

        //4. 获取sheet页中的行
        int rowNum = sheet.getLastRowNum();  //类似数组的索引，从0开始计数；
//        int physicalRowNums = sheet.getPhysicalNumberOfRows();  //实际的行数，从1开始计数；

        //5. 遍历行读取每列的数据
        List<CourseInfo> courseInfoList = new ArrayList<CourseInfo>();
        for (int i = 1; i <= rowNum; i++) {
            CourseInfo courseInfo = new CourseInfo();
            Row row = sheet.getRow(i);

            //课程id
            Cell cell = row.getCell(0);
            String courseId = getCellValue(cell);
            courseInfo.setCourseId(courseId);

            //课程名称
            Cell cell1 = row.getCell(1);
            String courseTitle = getCellValue(cell1);
            courseInfo.setCourseTitle(courseTitle);

            //课程编号
            Cell cell2= row.getCell(2);
            String courseCode = getCellValue(cell2);
            courseInfo.setCourseCode(courseCode);

            //学时
            Cell cell3 = row.getCell(3);
            Double coursePeriod = Double.parseDouble(getCellValue(cell3));
            courseInfo.setCoursePeriod(coursePeriod);

            //学分
            Cell cell4 = row.getCell(4);
            Double courseScore = Double.parseDouble(getCellValue(cell4));
            courseInfo.setCourseScore(courseScore);
            courseInfoList.add(courseInfo);
        }

        System.out.println(courseInfoList);
        return courseInfoList;
    }


    /**
     * 工具类：获取单元格中文本内容
     * @param cell 单元格对象
     * @return 单元格中文本内容
     */
    public static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }

        switch (cell.getCellType()) {
            //数值类型0（日期类型也是数值类型）
            case Cell.CELL_TYPE_NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    Date d = cell.getDateCellValue();
                    DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                    cellValue = formater.format(d);
                } else {
                    cellValue = "" + cell.getNumericCellValue();
                }
                break;

            //文本型1
            case Cell.CELL_TYPE_STRING:
                cellValue = cell.getStringCellValue();
                break;

            //公式型2
            case Cell.CELL_TYPE_FORMULA:
                cellValue = "" + cell.getCellFormula();
                break;

            //空白3
            case Cell.CELL_TYPE_BLANK:
                cellValue = "" + cell.getStringCellValue();
                break;

            //布尔型4
            case Cell.CELL_TYPE_BOOLEAN:
                cellValue = "" + cell.getBooleanCellValue();
                break;

            //其他
            default:
                throw new RuntimeException("Failed to access cell of  value");
        }

        return cellValue.trim();
    }
}
