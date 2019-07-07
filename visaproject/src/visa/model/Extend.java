package visa.model;

public class Extend {
	
	private int id,extday,days,extvisa,vtype;
	private String user,country,vvtype,ivisa,exvisa,eextvisa;
	private double ctotal,dcharge,total,etotal,extotal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExtday() {
		return extday;
	}

	public void setExtday(int extday) {
		this.extday = extday;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getVvtype() {
		return vvtype;
	}

	public void setVvtype(String vvtype) {
		this.vvtype = vvtype;
	}

	public String getIvisa() {
		return ivisa;
	}

	public void setIvisa(String ivisa) {
		this.ivisa = ivisa;
	}

	public String getExvisa() {
		return exvisa;
	}

	public void setExvisa(String exvisa) {
		this.exvisa = exvisa;
	}

	public double getCtotal() {
		return ctotal;
	}

	public void setCtotal(double ctotal) {
		this.ctotal = ctotal;
	}

	public int getExtvisa() {
		return extvisa;
	}

	public void setExtvisa(int extvisa) {
		this.extvisa = extvisa;
	}

	public String getEextvisa() {
		return eextvisa;
	}

	public void setEextvisa(String eextvisa) {
		this.eextvisa = eextvisa;
	}

	public int getVtype() {
		return vtype;
	}

	public void setVtype(int vtype) {
		this.vtype = vtype;
	}

	public double getDcharge() {
		return dcharge;
	}

	public void setDcharge(double dcharge) {
		this.dcharge = dcharge;
	}

	public double getTotal() {
		return total=getDcharge()*getExtday();
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getEtotal() {
		return etotal;
	}

	public void setEtotal(double etotal) {
		this.etotal = etotal;
	}

	public double getExtotal() {
		return extotal=getCtotal()+getEtotal();
	}

	public void setExtotal(double extotal) {
		this.extotal = extotal;
	}

}
