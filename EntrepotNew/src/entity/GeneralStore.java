package entity;

public class GeneralStore {
  private long id;
  private String name;   //仓位名称
  private String Description;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
@Override
public String toString() {
	return "GeneralStore [id=" + id + ", GSName=" + name + ", Description=" + Description + "]";
}
public GeneralStore(long id, String gSName, String description) {
	super();
	this.id = id;
	name = gSName;
	Description = description;
}
public GeneralStore() {
	super();
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
  
  
}
