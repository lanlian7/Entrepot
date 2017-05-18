package report.action;
import java.io.File;  
import java.io.IOException;  
import java.io.InputStream;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
  
import javax.servlet.http.HttpServletRequest;  
  
import org.apache.struts2.ServletActionContext;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.context.annotation.Scope;  
import org.springframework.stereotype.Component;  
  
import com.opensymphony.xwork2.ActionSupport;

import entity.Storage;
import net.sf.jxls.transformer.XLSTransformer;
import service.StorageDAO;
import service.impl.StorageDAOImpl;  
  
@Component("StorageReportAction")  
@Scope("prototype")  
public class TestReportAction extends ActionSupport {  
  
    private static final long serialVersionUID = 1L;  
      
    @Autowired  
    private StorageDAO dao; 
      
    private InputStream excelStream;  
    private String fileName="";  
    private String filePath=File.separator+"excelTemplet"+File.separator;  
      
    @SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })  
    public String exportExcel() throws IOException{  
        HttpServletRequest request = ServletActionContext.getRequest();  
        dao=new StorageDAOImpl();
        List<Storage> list= dao.queryAllStorage();
        if ( list == null )  
            return ERROR;  
          
        Map beans = new HashMap();
        beans.put("list", list);  
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
        // 填充报表  
        filePath += "StorageTemplet.xls";  
        fileName = "入库信息报表.xls";  

        beans.put("createDate", df.format(new Date()));  
        String srcFilePath = "E:\\tmp\\StorageTemplet.xls";
        String destFilePath = "E:\\tmp\\simple.xls";
   //     XLSTransformer transformer = new XLSTransformer();  
//        transformer.transformXLS(srcFilePath, beans, destFilePath);  
       new ExcelReport().makeReportFromTemplet(srcFilePath,beans,destFilePath); 
        
        excelStream = new ExcelReport().makeReportFromTemplet(request  
                .getRealPath("/WEB-INF")  
                + filePath, beans);  
     
        if (excelStream == null) {  
            return INPUT;  
        }  
        return "excel";  
    }  
  
    public String getFileName() {  
        fileName = new String(fileName.getBytes());  
        return fileName;  
    }  
      
    public void setFileName(String fileName) {  
        this.fileName = fileName;  
    }  
  
    public String getFilePath() {  
        return filePath;  
    }  
  
    public void setFilePath(String filePath) {  
        this.filePath = filePath;  
    }  
  
    public InputStream getExcelStream() {  
        return excelStream;  
    }  
  
    public void setExcelStream(InputStream excelStream) {  
        this.excelStream = excelStream;  
    }  
      
} 