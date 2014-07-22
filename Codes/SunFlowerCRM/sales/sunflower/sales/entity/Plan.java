package sunflower.sales.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the plan database table.
 * 
 */
@Entity
public class Plan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="plan_id")
	private String planId;

	@Temporal(TemporalType.DATE)
	@Column(name="plan_date")
	private Date planDate;

	@Column(name="plan_state")
	private int planState;

	//bi-directional many-to-one association to Sale
	@ManyToOne
	@JoinColumn(name="sales_id")
	private Sale sale;

	//bi-directional many-to-one association to ScheduleItem
	@OneToMany(mappedBy="plan")
	private List<ScheduleItem> scheduleItems;

	public Plan() {
	}

	public Plan(Sale sale) {
		super();
		this.sale = sale;
		this.planDate = new Date();
		this.planState=0;//初建
	}

	public String getPlanId() {
		return this.planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public Date getPlanDate() {
		return this.planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public int getPlanState() {
		return this.planState;
	}

	public void setPlanState(int planState) {
		this.planState = planState;
	}

	public Sale getSale() {
		return this.sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public List<ScheduleItem> getScheduleItems() {
		return this.scheduleItems;
	}

	public void setScheduleItems(List<ScheduleItem> scheduleItems) {
		this.scheduleItems = scheduleItems;
	}

	public ScheduleItem addScheduleItem(ScheduleItem scheduleItem) {
		getScheduleItems().add(scheduleItem);
		scheduleItem.setPlan(this);

		return scheduleItem;
	}

	public ScheduleItem removeScheduleItem(ScheduleItem scheduleItem) {
		getScheduleItems().remove(scheduleItem);
		scheduleItem.setPlan(null);

		return scheduleItem;
	}

}