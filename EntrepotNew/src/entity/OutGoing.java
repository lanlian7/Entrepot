package entity;

import java.util.Date;

public class OutGoing {
  private long id;
  private String OutGoingID ;  //出库单
  private Date OutDate;  //出库日期
  private String Material_Number;  //料号
  private String Name;  //名称
  private String Specification;  //规格
  private long Number;  //数量
  private String Unit;  //单位
  private String Purpose;  //用途
  private String Material_Department;  //领料部门
  private String Material_Person;   //领料人
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getOutGoingID() {
	return OutGoingID;
}
public void setOutGoingID(String outGoingID) {
	OutGoingID = outGoingID;
}
public Date getOutDate() {
	return OutDate;
}
public void setOutDate(Date outDate) {
	OutDate = outDate;
}
public String getMaterial_Number() {
	return Material_Number;
}
public void setMaterial_Number(String material_Number) {
	Material_Number = material_Number;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getSpecification() {
	return Specification;
}
public void setSpecification(String specification) {
	Specification = specification;
}
public long getNumber() {
	return Number;
}
public void setNumber(long number) {
	Number = number;
}
public String getUnit() {
	return Unit;
}
public void setUnit(String unit) {
	Unit = unit;
}
public String getPurpose() {
	return Purpose;
}
public void setPurpose(String purpose) {
	Purpose = purpose;
}
public String getMaterial_Department() {
	return Material_Department;
}
public void setMaterial_Department(String material_Department) {
	Material_Department = material_Department;
}
public String getMaterial_Person() {
	return Material_Person;
}
public void setMaterial_Person(String material_Person) {
	Material_Person = material_Person;
}
public OutGoing(long id, String outGoingID, Date outDate, String material_Number, String name, String specification,
		long number, String unit, String purpose, String material_Department, String material_Person) {
	super();
	this.id = id;
	OutGoingID = outGoingID;
	OutDate = outDate;
	Material_Number = material_Number;
	Name = name;
	Specification = specification;
	Number = number;
	Unit = unit;
	Purpose = purpose;
	Material_Department = material_Department;
	Material_Person = material_Person;
}
@Override
public String toString() {
	return "OutGoing [id=" + id + ", OutGoingID=" + OutGoingID + ", OutDate=" + OutDate + ", Material_Number="
			+ Material_Number + ", Name=" + Name + ", Specification=" + Specification + ", Number=" + Number + ", Unit="
			+ Unit + ", Purpose=" + Purpose + ", Material_Department=" + Material_Department + ", Material_Person="
			+ Material_Person + "]";
}
public OutGoing() {
	super();
}
}
