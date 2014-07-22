package sunflower.customer.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the customer_lost_pause database table.
 * 
 */
@Entity
@Table(name = "customer_lost_pause")
public class CustomerLostPause implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "customer_lost_pause_id")
	private String customerLostPauseId;

	@Lob
	@Column(name = "customer_lost_pause_reason")
	private String customerLostPauseReason;
	@Column(name = "customer_lost_pause_method")
	private String customerLostPauseMethod;
	// bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public CustomerLostPause() {
	}

	public String getCustomerLostPauseId() {
		return this.customerLostPauseId;
	}

	public void setCustomerLostPauseId(String customerLostPauseId) {
		this.customerLostPauseId = customerLostPauseId;
	}

	public String getCustomerLostPauseReason() {
		return this.customerLostPauseReason;
	}

	public void setCustomerLostPauseReason(String customerLostPauseReason) {
		this.customerLostPauseReason = customerLostPauseReason;
	}

	public String getCustomerLostPauseMethod() {
		return this.customerLostPauseMethod;
	}

	public void setCustomerLostPauseMethod(String customerLostPauseMethod) {
		this.customerLostPauseMethod = customerLostPauseMethod;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}