package in.vikas.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Contact_us_Leads")
public class ContactUsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cId;
	private String cname;
	private String cemail;
	private String cphno;
	
	@CreationTimestamp // used to create created date value.
	@Column(name = "created_date",updatable = false) //user should not modify created date.
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	@Column(name="Updated_date",insertable = false)
	private LocalDateTime updatedDate;

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCphno() {
		return cphno;
	}

	public void setCphno(String cphno) {
		this.cphno = cphno;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "ContactUsEntity [cId=" + cId + ", cname=" + cname + ", cemail=" + cemail + ", cphno=" + cphno
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
	
	

	
	
	
}
