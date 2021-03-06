package report.action;

import java.io.File;  
import java.io.IOException;  
import java.io.OutputStream; 
import java.util.Date;  
import java.util.List;   
import org.springframework.context.annotation.Scope;  
import org.springframework.stereotype.Component;  
  

import action.SuperAction;
import entity.GeneralStore;
import entity.Storage;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.Alignment;
import jxl.write.Colour;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.NumberFormat;
import jxl.write.VerticalAlignment;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import service.GeneralStoreDAO;
import service.StorageDAO;
import service.impl.GeneralStoreDAOImpl;
import service.impl.StorageDAOImpl;  
  
@SuppressWarnings("deprecation")
@Component("StorageReportAction")  
@Scope("prototype")  
public class StoreReportAction extends SuperAction {  
  
    private static final long serialVersionUID = 1L;  
 
  
    public String exportExcel() throws RowsExceededException, WriteException, IOException{

        //获得输出流，该输出流的输出介质是客户端浏览器  
          
          OutputStream output=response.getOutputStream();  
          
          response.reset();  
          
          response.setHeader("Content-disposition","attachment;           filename=store.xls");  
          
          response.setContentType("application/msexcel");  
          
          //创建可写入的Excel工作薄，且内容将写入到输出流，并通过输出流输出给客户端浏览  
          
          WritableWorkbook wk=Workbook.createWorkbook(output);  
          
          
        ///创建可写入的Excel工作表  
          
            WritableSheet sheet=wk.createSheet("总仓信息表", 0);  
          
        //把单元格（column, row）到单元格（column1, row1）进行合并。  
          
        //mergeCells(column, row, column1, row1);  
          
          sheet.mergeCells(0,0, 2,0);//单元格合并方法  
          
        //创建WritableFont 字体对象，参数依次表示黑体、字号12、粗体、非斜体、不带下划线、亮蓝色  
          
        WritableFont titleFont=new WritableFont(WritableFont.createFont("黑体"),12,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.LIGHT_BLUE);  
          
        //创建WritableCellFormat对象，将该对象应用于单元格从而设置单元格的样式  
          
        WritableCellFormat titleFormat=new WritableCellFormat();  
          
        //设置字体格式  
          
        titleFormat.setFont(titleFont);  
          
        //设置文本水平居中对齐  
          
        titleFormat.setAlignment(Alignment.CENTRE);  
          
        //设置文本垂直居中对齐  
          
        titleFormat.setVerticalAlignment(VerticalAlignment.CENTRE);  
          
        //设置背景颜色  
          
        titleFormat.setBackground(Colour.GRAY_25);  
          
        //设置自动换行  
          
        titleFormat.setWrap(true);  
          
        //添加Label对象，参数依次表示在第一列，第一行，内容，使用的格式  
          
        Label lab_00=new Label(0,0,"入库信息一览表",titleFormat);  
          
        //将定义好的Label对象添加到工作表上，这样工作表的第一列第一行的内容为‘学员考试成绩一览表’并应用了titleFormat定义的样式  
          
        sheet.addCell(lab_00);  
          
        WritableCellFormat cloumnTitleFormat=new WritableCellFormat();  
          
        cloumnTitleFormat.setFont(new WritableFont(WritableFont.createFont("宋体"),10,WritableFont.BOLD,false));  
          
        cloumnTitleFormat.setAlignment(Alignment.CENTRE);  
        Label lab_01=new Label(0,1,"名称",cloumnTitleFormat);   
        Label lab_11=new Label(1,1,"描述",cloumnTitleFormat);  
          
          sheet.addCell(lab_01);  
          sheet.addCell(lab_11);  
          
        //定义数字格式  
          
        NumberFormat nf=new NumberFormat("0.00");  
          
        WritableCellFormat wcf=new WritableCellFormat(nf);  
          
        //类似于Label对象，区别Label表示文本数据，Number表示数值型数据  
          
        Number numlab_22=new Number(2,2,78,wcf);  
          
        sheet.addCell(numlab_22);  
          
        sheet.addCell(new Number(3,2,87,new WritableCellFormat(new NumberFormat("#.##") )));  
          
        //定义日期格式  
          
        DateFormat df=new DateFormat("yyyy-MM-dd hh:mm:ss");  
          
        //创建WritableCellFormat对象  
          
        WritableCellFormat datewcf=new WritableCellFormat(df);  
          
        //类似于Label对象，区别Label表示文本数据，DateTime表示日期型数据  
          
        DateTime dtLab_42=new DateTime(4,2,new Date(),datewcf);  
          
        sheet.addCell(dtLab_42);     
          
         GeneralStoreDAO dao=new GeneralStoreDAOImpl();
         List<GeneralStore> list=dao.queryAllGS();
        for(int i=0;i<list.size();i++){
      	  sheet.addCell(new Label(0,i+2,list.get(i).getName(),cloumnTitleFormat));
      	  sheet.addCell(new Label(1,i+2,list.get(i).getDescription(),cloumnTitleFormat));
        }
        
        
        //将定义的工作表输出到之前指定的介质中（这里是客户端浏览器）  
          
        wk.write();  
          
        //操作完成时，关闭对象，释放占用的内存空间     
          
        wk.close();  
        //　加下划线这部分代码是B/S模式中采用的输出方式，而不是输出到本地指定的磁盘目录。该代码表示将temp.xls的Excel文件通过应答实体（response）输出给请求的客户端浏览器，下载到客户端本地（保存或直接打开）。若要直接输出到磁盘文件可采用下列代码替换加下划线这部分代码  
        File file=new File("D://temp.xls");  
        WritableWorkbook wwb = Workbook.createWorkbook(file);   
        return "excel";
    	
    }
} 