package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import entity.Stock;
import entity.Users;
import net.sf.json.JSONObject;
import service.StockDAO;
import service.UserDAO;
import service.impl.StockDAOImpl;
import service.impl.UserDAOImpl;


public class UsersAction extends SuperAction implements ModelDriven<Users>{
	private static final long serialVersionUID =1L;
   private Users user=new Users();
   
   public String execute(){
	   UserDAO udao=new UserDAOImpl();
	   if(udao.usersLogin(user)){
		   session.setAttribute("loginUserName", user.getUsername());
		   return "login_success";
	   }
	   else
	   {
		   return "login_failure";
	   }
   }
   @SkipValidation
   public String loginOut(){
	   if(session.getAttribute("loginUserName")!=null){
		   session.removeAttribute("loginUserName");
	   }
	   return "logout_success";
   }
   
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		//����û�������Ϊ��
	   if("".equals(user.getUsername().trim())){
		   this.addFieldError("usernameError", "用户名不存在");
		   System.out.println("用户名不存在");
	   }
	   //������볤���Ƿ�С��6λ
	   if(user.getPassword().length()<6){
		   this.addFieldError("passwordError","密码不能小于六位数");
		   System.out.println("密码错误");
	   }
	}
   
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}


}
