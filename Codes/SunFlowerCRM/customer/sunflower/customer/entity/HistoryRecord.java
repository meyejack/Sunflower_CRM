package sunflower.customer.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the history_record database table.
 * 
 */
@Entity
@Table(name="history_record")
public class HistoryRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="history_record_id")
	private String historyRecordId;

	@Temporal(TemporalType.DATE)
	@Column(name="history_record_date")
	private Date historyRecordDate;

	@Column(name="history_record_delivery_address")
	private String historyRecordDeliveryAddress;

	@Column(name="history_record_status")
	private int historyRecordStatus;

	//bi-directional many-to-one association to RecordItem
	@OneToMany(mappedBy="historyRecord")
	private List<RecordItem> recordItems;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	public HistoryRecord() {
	}

	public String getHistoryRecordId() {
		return this.historyRecordId;
	}

	public void setHistoryRecordId(String historyRecordId) {
		this.historyRecordId = historyRecordId;
	}

	public Date getHistoryRecordDate() {
		return this.historyRecordDate;
	}

	public void setHistoryRecordDate(Date historyRecordDate) {
		this.historyRecordDate = historyRecordDate;
	}

	public String getHistoryRecordDeliveryAddress() {
		return this.historyRecordDeliveryAddress;
	}

	public void setHistoryRecordDeliveryAddress(String historyRecordDeliveryAddress) {
		this.historyRecordDeliveryAddress = historyRecordDeliveryAddress;
	}

	public int getHistoryRecordStatus() {
		return this.historyRecordStatus;
	}

	public void setHistoryRecordStatus(int historyRecordStatus) {
		this.historyRecordStatus = historyRecordStatus;
	}

	public List<RecordItem> getRecordItems() {
		return this.recordItems;
	}

	public void setRecordItems(List<RecordItem> recordItems) {
		this.recordItems = recordItems;
	}

	public RecordItem addRecordItem(RecordItem recordItem) {
		getRecordItems().add(recordItem);
		recordItem.setHistoryRecord(this);

		return recordItem;
	}

	public RecordItem removeRecordItem(RecordItem recordItem) {
		getRecordItems().remove(recordItem);
		recordItem.setHistoryRecord(null);

		return recordItem;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}