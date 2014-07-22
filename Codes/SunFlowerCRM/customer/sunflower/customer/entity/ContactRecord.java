package sunflower.customer.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the contact_record database table.
 * 
 */
@Entity
@Table(name = "contact_record")
public class ContactRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "contact_record_id")
	private String contactRecordId;

	@Temporal(TemporalType.DATE)
	@Column(name = "contact_record_date")
	private Date contactRecordDate;

	@Lob
	@Column(name = "contact_record_info")
	private String contactRecordInfo;

	@Column(name = "contact_record_introduction")
	private String contactRecordIntroduction;

	@Column(name = "contact_record_location")
	private String contactRecordLocation;

	@Column(name = "contact_record_memo")
	private String contactRecordMemo;

	// bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public ContactRecord() {
	}

	public ContactRecord(String contactRecordInfo,
			String contactRecordIntroduction, String contactRecordLocation,
			String contactRecordMemo, Customer customer) {
		super();
		this.contactRecordInfo = contactRecordInfo;
		this.contactRecordIntroduction = contactRecordIntroduction;
		this.contactRecordLocation = contactRecordLocation;
		this.contactRecordMemo = contactRecordMemo;
		this.customer = customer;

		this.contactRecordDate = new Date();
	}

	public String getContactRecordId() {
		return this.contactRecordId;
	}

	public void setContactRecordId(String contactRecordId) {
		this.contactRecordId = contactRecordId;
	}

	public Date getContactRecordDate() {
		return this.contactRecordDate;
	}

	public void setContactRecordDate(Date contactRecordDate) {
		this.contactRecordDate = contactRecordDate;
	}

	public String getContactRecordInfo() {
		return this.contactRecordInfo;
	}

	public void setContactRecordInfo(String contactRecordInfo) {
		this.contactRecordInfo = contactRecordInfo;
	}

	public String getContactRecordIntroduction() {
		return this.contactRecordIntroduction;
	}

	public void setContactRecordIntroduction(String contactRecordIntroduction) {
		this.contactRecordIntroduction = contactRecordIntroduction;
	}

	public String getContactRecordLocation() {
		return this.contactRecordLocation;
	}

	public void setContactRecordLocation(String contactRecordLocation) {
		this.contactRecordLocation = contactRecordLocation;
	}

	public String getContactRecordMemo() {
		return this.contactRecordMemo;
	}

	public void setContactRecordMemo(String contactRecordMemo) {
		this.contactRecordMemo = contactRecordMemo;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}