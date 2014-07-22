package sunflower.customer.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the record_item database table.
 * 
 */
@Entity
@Table(name="record_item")
public class RecordItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="record_item_id")
	private String recordItemId;

	@Column(name="record_item_count")
	private int recordItemCount;

	@Column(name="record_item_name")
	private String recordItemName;

	@Column(name="record_item_price")
	private double recordItemPrice;

	@Column(name="record_item_total_price")
	private double recordItemTotalPrice;

	@Column(name="record_item_unit")
	private String recordItemUnit;

	//bi-directional many-to-one association to HistoryRecord
	@ManyToOne
	@JoinColumn(name="history_record_id")
	private HistoryRecord historyRecord;

	public RecordItem() {
	}

	public String getRecordItemId() {
		return this.recordItemId;
	}

	public void setRecordItemId(String recordItemId) {
		this.recordItemId = recordItemId;
	}

	public int getRecordItemCount() {
		return this.recordItemCount;
	}

	public void setRecordItemCount(int recordItemCount) {
		this.recordItemCount = recordItemCount;
	}

	public String getRecordItemName() {
		return this.recordItemName;
	}

	public void setRecordItemName(String recordItemName) {
		this.recordItemName = recordItemName;
	}

	public double getRecordItemPrice() {
		return this.recordItemPrice;
	}

	public void setRecordItemPrice(double recordItemPrice) {
		this.recordItemPrice = recordItemPrice;
	}

	public double getRecordItemTotalPrice() {
		return this.recordItemTotalPrice;
	}

	public void setRecordItemTotalPrice(double recordItemTotalPrice) {
		this.recordItemTotalPrice = recordItemTotalPrice;
	}

	public String getRecordItemUnit() {
		return this.recordItemUnit;
	}

	public void setRecordItemUnit(String recordItemUnit) {
		this.recordItemUnit = recordItemUnit;
	}

	public HistoryRecord getHistoryRecord() {
		return this.historyRecord;
	}

	public void setHistoryRecord(HistoryRecord historyRecord) {
		this.historyRecord = historyRecord;
	}

}