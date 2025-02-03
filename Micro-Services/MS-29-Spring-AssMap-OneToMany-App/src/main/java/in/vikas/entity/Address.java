package in.vikas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addrId;
	private String city;
	private String state;
	private String country;
	private String addrType;
	
	
	@ManyToOne //ultiple address can belong to one emp
	@JoinColumn(name = "emp_id")
	private Employee emp;


	public Integer getAddrId() {
		return addrId;
	}


	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getAddrType() {
		return addrType;
	}


	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}


	public Employee getEmp() {
		return emp;
	}


	public void setEmp(Employee emp) {
		this.emp = emp;
	}


	@Override
	public String toString() {
		return "Address [addrId=" + addrId + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", addrType=" + addrType + ", emp=" + emp + "]";
	}

	
	
}
