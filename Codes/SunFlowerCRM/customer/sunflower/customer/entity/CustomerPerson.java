package sunflower.customer.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customer_person database table.
 * 
 */
@Entity
@Table(name="customer_person")
public class CustomerPerson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customer_person_id")
	private String customerPersonId;

	@Column(name="customer_person_memo")
	private String customerPersonMemo;

	@Column(name="customer_person_mobile")
	private String customerPersonMobile;

	@Column(name="customer_person_name")
	private String customerPersonName;

	@Column(name="customer_person_position")
	private String customerPersonPosition;

	@Column(name="customer_person_sex")
	private int customerPersonSex;

	@Column(name="customer_person_tel")
	private String customerPersonTel;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	public CustomerPerson() {
	}

	public String getCustomerPersonId() {
		return this.customerPersonId;
	}

	public void setCustomerPersonId(String customerPersonId) {
		this.customerPersonId = customerPersonId;
	}

	public String getCustomerPersonMemo() {
		return this.customerPersonMemo;
	}

	public void setCustomerPersonMemo(String customerPersonMemo) {
		this.customerPersonMemo = customerPersonMemo;
	}

	public String getCustomerPersonMobile() {
		return this.customerPersonMobile;
	}

	public void setCustomerPersonMobile(String customerPersonMobile) {
		this.customerPersonMobile = customerPersonMobile;
	}

	public String getCustomerPersonName() {
		return this.customerPersonName;
	}

	public void setCustomerPersonName(String customerPersonName) {
		this.customerPersonName = customerPersonName;
	}

	public String getCustomerPersonPosition() {
		return this.customerPersonPosition;
	}

	public void setCustomerPersonPosition(String customerPersonPosition) {
		this.customerPersonPosition = customerPersonPosition;
	}

	public int getCustomerPersonSex() {
		return this.customerPersonSex;
	}

	public void setCustomerPersonSex(int customerPersonSex) {
		this.customerPersonSex = customerPersonSex;
	}

	public String getCustomerPersonTel() {
		return this.customerPersonTel;
	}

	public void setCustomerPersonTel(String customerPersonTel) {
		this.customerPersonTel = customerPersonTel;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}