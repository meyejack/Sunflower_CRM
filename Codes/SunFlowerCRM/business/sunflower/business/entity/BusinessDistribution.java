package sunflower.business.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import sunflower.customer.entity.Customer;



/**
 * The persistent class for the business_distribution database table.
 * 
 */
@Entity
@Table(name="business_distribution")
public class BusinessDistribution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="business_distribution_id")
	private String businessDistributionId;

	@Column(name="business_disrtibution_satisfaction")
	private int businessDisrtibutionSatisfaction;

	@Temporal(TemporalType.DATE)
	@Column(name="business_distribution_date")
	private Date businessDistributionDate;

	@Lob
	@Column(name="business_distribution_memo")
	private String businessDistributionMemo;

	@Temporal(TemporalType.DATE)
	@Column(name="business_distribution_process_date")
	private Date businessDistributionProcessDate;

	@Column(name="business_distribution_state")
	private int businessDistributionState;

	//bi-directional many-to-one association to Business
	@ManyToOne
	@JoinColumn(name="business_id")
	private Business business;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	public BusinessDistribution() {
	}

	public String getBusinessDistributionId() {
		return this.businessDistributionId;
	}

	public void setBusinessDistributionId(String businessDistributionId) {
		this.businessDistributionId = businessDistributionId;
	}

	public int getBusinessDisrtibutionSatisfaction() {
		return this.businessDisrtibutionSatisfaction;
	}

	public void setBusinessDisrtibutionSatisfaction(int businessDisrtibutionSatisfaction) {
		this.businessDisrtibutionSatisfaction = businessDisrtibutionSatisfaction;
	}

	public Date getBusinessDistributionDate() {
		return this.businessDistributionDate;
	}

	public void setBusinessDistributionDate(Date businessDistributionDate) {
		this.businessDistributionDate = businessDistributionDate;
	}

	public String getBusinessDistributionMemo() {
		return this.businessDistributionMemo;
	}

	public void setBusinessDistributionMemo(String businessDistributionMemo) {
		this.businessDistributionMemo = businessDistributionMemo;
	}

	public Date getBusinessDistributionProcessDate() {
		return this.businessDistributionProcessDate;
	}

	public void setBusinessDistributionProcessDate(Date businessDistributionProcessDate) {
		this.businessDistributionProcessDate = businessDistributionProcessDate;
	}

	public int getBusinessDistributionState() {
		return this.businessDistributionState;
	}

	public void setBusinessDistributionState(int businessDistributionState) {
		this.businessDistributionState = businessDistributionState;
	}

	public Business getBusiness() {
		return this.business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}