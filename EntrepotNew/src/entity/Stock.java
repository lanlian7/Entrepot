package entity;
//库存类
public class Stock {
  private long id;
  private String Material_Number;
  private String Name;
  private String Specification;
  private long Number;
  private String Unit;
  private double UnitPrice;
  private double AmountMoney;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
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
public double getUnitPrice() {
	return UnitPrice;
}
public void setUnitPrice(double unitPrice) {
	UnitPrice = unitPrice;
}
public double getAmountMoney() {
	return AmountMoney;
}
public void setAmountMoney(double amountMoney) {
	AmountMoney = amountMoney;
}
@Override
public String toString() {
	return "Stock [id=" + id + ", Material_Number=" + Material_Number + ", Name=" + Name + ", Specification="
			+ Specification + ", Number=" + Number + ", Unit=" + Unit + ", UnitPrice=" + UnitPrice + ", AmountMoney="
			+ AmountMoney + "]";
}
public Stock(long id, String material_Number, String name, String specification, long number, String unit,
		double unitPrice, double amountMoney) {
	super();
	this.id = id;
	Material_Number = material_Number;
	Name = name;
	Specification = specification;
	Number = number;
	Unit = unit;
	UnitPrice = unitPrice;
	AmountMoney = amountMoney;
}
public Stock() {
	super();
}
  
}
