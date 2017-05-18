package service;

import entity.Users;

public interface UserDAO {
	   //用户登录方法
		public boolean  usersLogin(Users u);
		
		//增加用户
		public boolean usersAdd(Users u);
		
		//删除用户
		public boolean usersDelete(Users u);
}
