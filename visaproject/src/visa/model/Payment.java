package visa.model;

public class Payment {
	
	private int cid,id,days,vtype;
	private double scharge,dcharge,total,ctotal;
	private String user,vvtype,country,ivisa,exvisa;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getVtype() {
		return vtype;
	}
	public void setVtype(int vtype) {
		this.vtype = vtype;
	}
	public double getScharge() {
		return scharge;
	}
	public void setScharge(double scharge) {
		this.scharge = scharge;
	}
	
	public double getTotal() {
		return total=getScharge()+(getDcharge()*getDays());
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getDcharge() {
		return dcharge;
	}
	public void setDcharge(double dcharge) {
		this.dcharge = dcharge;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getVvtype() {
		return vvtype;
	}
	public void setVvtype(String vvtype) {
		this.vvtype = vvtype;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getCtotal() {
		return ctotal;
	}
	public void setCtotal(double ctotal) {
		this.ctotal = ctotal;
	}
	public String getExvisa() {
		return exvisa;
	}
	public void setExvisa(String exvisa) {
		this.exvisa = exvisa;
	}
	public String getIvisa() {
		return ivisa;
	}
	public void setIvisa(String ivisa) {
		this.ivisa = ivisa;
	}
	
	

}
