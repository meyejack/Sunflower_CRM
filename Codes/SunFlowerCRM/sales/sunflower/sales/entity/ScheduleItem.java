package sunflower.sales.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the schedule_item database table.
 * 
 */
@Entity
@Table(name="schedule_item")
public class ScheduleItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="schedule_id")
	private String scheduleId;

	@Column(name="schedule_content")
	private String scheduleContent;

	@Column(name="schedule_memo")
	private String scheduleMemo;

	@Temporal(TemporalType.DATE)
	@Column(name="schedule_time")
	private Date scheduleTime;

	//bi-directional many-to-one association to Plan
	@ManyToOne
	@JoinColumn(name="plan_id")
	private Plan plan;

	public ScheduleItem() {
	}

	public ScheduleItem(String scheduleContent, String scheduleMemo, Plan plan) {
		super();
		this.scheduleContent = scheduleContent;
		this.scheduleMemo = scheduleMemo;
		this.plan = plan;
		this.scheduleTime=new Date();
	}

	public String getScheduleId() {
		return this.scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getScheduleContent() {
		return this.scheduleContent;
	}

	public void setScheduleContent(String scheduleContent) {
		this.scheduleContent = scheduleContent;
	}

	public String getScheduleMemo() {
		return this.scheduleMemo;
	}

	public void setScheduleMemo(String scheduleMemo) {
		this.scheduleMemo = scheduleMemo;
	}

	public Date getScheduleTime() {
		return this.scheduleTime;
	}

	public void setScheduleTime(Date scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

}