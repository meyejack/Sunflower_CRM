package sunflower.business.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import sunflower.user.entity.User;


/**
 * The persistent class for the business database table.
 * 
 */
@Entity
public class Business implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="business_id")
	private String businessId;

	@Temporal(TemporalType.DATE)
	@Column(name="business_create_date")
	private Date businessCreateDate;

	@Column(name="business_introduction")
	private String businessIntroduction;

	@Lob
	@Column(name="business_memo")
	private String businessMemo;

	@Column(name="business_state")
	private int businessState;

	@Column(name="business_type")
	private String businessType;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	//bi-directional many-to-one association to BusinessDistribution
	@OneToMany(mappedBy="business")
	private List<BusinessDistribution> businessDistributions;

	public Business() {
	}

	public String getBusinessId() {
		return this.businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public Date getBusinessCreateDate() {
		return this.businessCreateDate;
	}

	public void setBusinessCreateDate(Date businessCreateDate) {
		this.businessCreateDate = businessCreateDate;
	}

	public String getBusinessIntroduction() {
		return this.businessIntroduction;
	}

	public void setBusinessIntroduction(String businessIntroduction) {
		this.businessIntroduction = businessIntroduction;
	}

	public String getBusinessMemo() {
		return this.businessMemo;
	}

	public void setBusinessMemo(String businessMemo) {
		this.businessMemo = businessMemo;
	}

	public int getBusinessState() {
		return this.businessState;
	}

	public void setBusinessState(int businessState) {
		this.businessState = businessState;
	}

	public String getBusinessType() {
		return this.businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<BusinessDistribution> getBusinessDistributions() {
		return this.businessDistributions;
	}

	public void setBusinessDistributions(List<BusinessDistribution> businessDistributions) {
		this.businessDistributions = businessDistributions;
	}

	public BusinessDistribution addBusinessDistribution(BusinessDistribution businessDistribution) {
		getBusinessDistributions().add(businessDistribution);
		businessDistribution.setBusiness(this);

		return businessDistribution;
	}

	public BusinessDistribution removeBusinessDistribution(BusinessDistribution businessDistribution) {
		getBusinessDistributions().remove(businessDistribution);
		businessDistribution.setBusiness(null);

		return businessDistribution;
	}

}