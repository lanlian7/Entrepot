package entity;

public class Users {
     private long id;
     private String username;
     private String password;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String user) {
		this.username = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Users(long id, String user, String password) {
		this.id = id;
		this.username = user;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", user=" + username + ", password=" + password + "]";
	}
    public Users(){
    	
    }
}
