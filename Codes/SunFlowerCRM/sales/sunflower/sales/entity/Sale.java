package sunflower.sales.entity;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import sunflower.user.entity.User;

/**
 * The persistent class for the sales database table.
 * 
 */
@Entity
@Table(name = "sales")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "sales_id")
	private String salesId;

	@Column(name = "sales_brief_intro")
	private String salesBriefIntro;

	@Column(name = "sales_contact_person")
	private String salesContactPerson;

	@Column(name = "sales_contact_tel")
	private String salesContactTel;

	@Temporal(TemporalType.DATE)
	@Column(name = "sales_create_time")
	private Date salesCreateTime;

	@Column(name = "sales_customer_name")
	private String salesCustomerName;

	@Lob
	@Column(name = "sales_description")
	private String salesDescription;

	@Column(name = "sales_source")
	private String salesSource;

	@Column(name = "sales_state")
	private int salesState;

	@Column(name = "sales_success_prob")
	private int salesSuccessProb;

	// bi-directional many-to-one association to Plan
	@OneToMany(mappedBy = "sale")
	private List<Plan> plans;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "create_user_id")
	private User user1;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "responsible_user_id")
	private User user2;

	public Sale() {
	}

//	public Sale(String salesBriefIntro, String salesContactPerson,
//			String salesContactTel, Date salesCreateTime,
//			String salesCustomerName, String salesDescription,
//			String salesSource, int salesState, int salesSuccessProb) {
//		super();
//		this.salesBriefIntro = salesBriefIntro;
//		this.salesContactPerson = salesContactPerson;
//		this.salesContactTel = salesContactTel;
//		this.salesCreateTime = salesCreateTime;
//		this.salesCustomerName = salesCustomerName;
//		this.salesDescription = salesDescription;
//		this.salesSource = salesSource;
//		this.salesState = salesState;
//		this.salesSuccessProb = salesSuccessProb;
//	}

	public Sale(String salesBriefIntro,
			String salesContactPerson, String salesContactTel,
			 String salesCustomerName,
			String salesDescription, String salesSource, int salesState,
			int salesSuccessProb, User user1, User user2) {
		super();
		this.salesBriefIntro = salesBriefIntro;
		this.salesContactPerson = salesContactPerson;
		this.salesContactTel = salesContactTel;
		this.salesCreateTime = new Date();
		this.salesCustomerName = salesCustomerName;
		this.salesDescription = salesDescription;
		this.salesSource = salesSource;
		this.salesState = salesState;
		this.salesSuccessProb = salesSuccessProb;
		this.user1 = user1;
		this.user2 = user2;
	}

	public String getSalesId() {
		return this.salesId;
	}

	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}

	public String getSalesBriefIntro() {
		return this.salesBriefIntro;
	}

	public void setSalesBriefIntro(String salesBriefIntro) {
		this.salesBriefIntro = salesBriefIntro;
	}

	public String getSalesContactPerson() {
		return this.salesContactPerson;
	}

	public void setSalesContactPerson(String salesContactPerson) {
		this.salesContactPerson = salesContactPerson;
	}

	public String getSalesContactTel() {
		return this.salesContactTel;
	}

	public void setSalesContactTel(String salesContactTel) {
		this.salesContactTel = salesContactTel;
	}

	public Date getSalesCreateTime() {
		return this.salesCreateTime;
	}

	public void setSalesCreateTime(Date salesCreateTime) {
		this.salesCreateTime = salesCreateTime;
	}

	public String getSalesCustomerName() {
		return this.salesCustomerName;
	}

	public void setSalesCustomerName(String salesCustomerName) {
		this.salesCustomerName = salesCustomerName;
	}

	public String getSalesDescription() {
		return this.salesDescription;
	}

	public void setSalesDescription(String salesDescription) {
		this.salesDescription = salesDescription;
	}

	public String getSalesSource() {
		return this.salesSource;
	}

	public void setSalesSource(String salesSource) {
		this.salesSource = salesSource;
	}

	public int getSalesState() {
		return this.salesState;
	}

	public void setSalesState(int salesState) {
		this.salesState = salesState;
	}

	public int getSalesSuccessProb() {
		return this.salesSuccessProb;
	}

	public void setSalesSuccessProb(int salesSuccessProb) {
		this.salesSuccessProb = salesSuccessProb;
	}

	public List<Plan> getPlans() {
		return this.plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

	public Plan addPlan(Plan plan) {
		getPlans().add(plan);
		plan.setSale(this);

		return plan;
	}

	public Plan removePlan(Plan plan) {
		getPlans().remove(plan);
		plan.setSale(null);

		return plan;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}