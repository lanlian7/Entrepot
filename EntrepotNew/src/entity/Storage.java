package entity;

import java.util.Date;

public class Storage {
	private long id;  //编号
	private String storageID;  //入库单号
	private Date Warehouse_Date; //入库日期
	private String Supplier;   //供应商
	private String Material_Number; //料号
	private String Name;  //名称
	private String Specifications;  //规格
	private long  Number;  //数量
	private String Unit;  //单位
	private double UnitPrice;  //单价
    private double Amount_money;  //金额
    private String WarehousePerson;  //入库人员
    private String Position_selection;  //仓位选择
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Date getWarehouse_Date() {
		return Warehouse_Date;
	}
	public void setWarehouse_Date(Date warehouse_Date) {
		Warehouse_Date = warehouse_Date;
	}
	public String getSupplier() {
		return Supplier;
	}
	public void setSupplier(String supplier) {
		Supplier = supplier;
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
	public String getSpecifications() {
		return Specifications;
	}
	public void setSpecifications(String specifications) {
		Specifications = specifications;
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
	public double getAmount_money() {
		return Amount_money;
	}
	public void setAmount_money(double amount_money) {
		Amount_money = amount_money;
	}
	public String getWarehousePerson() {
		return WarehousePerson;
	}
	public void setWarehousePerson(String warehousePerson) {
		WarehousePerson = warehousePerson;
	}
	public String getPosition_selection() {
		return Position_selection;
	}
	public void setPosition_selection(String position_selection) {
		Position_selection = position_selection;
	}
	@Override
	public String toString() {
		return "Storage [id=" + id + ", StorageID=" + storageID + ", Warehouse_Date=" + Warehouse_Date + ", Supplier="
				+ Supplier + ", Material_Number=" + Material_Number + ", Name=" + Name + ", Specifications="
				+ Specifications + ", Number=" + Number + ", Unit=" + Unit + ", UnitPrice=" + UnitPrice
				+ ", Amount_money=" + Amount_money + ", WarehousePerson=" + WarehousePerson + ", Position_selection="
				+ Position_selection + "]";
	}
	public Storage(long id, String storageID, Date warehouse_Date, String supplier, String material_Number, String name,
			String specifications, long number, String unit, double unitPrice, double amount_money,
			String warehousePerson, String position_selection) {
		super();
		this.id = id;
		storageID = storageID;
		Warehouse_Date = warehouse_Date;
		Supplier = supplier;
		Material_Number = material_Number;
		Name = name;
		Specifications = specifications;
		Number = number;
		Unit = unit;
		UnitPrice = unitPrice;
		Amount_money = amount_money;
		WarehousePerson = warehousePerson;
		Position_selection = position_selection;
	}
	public Storage() {
		super();
	}
	public String getStorageID() {
		return storageID;
	}
	public void setStorageID(String storageID) {
		this.storageID = storageID;
	}
    
}
