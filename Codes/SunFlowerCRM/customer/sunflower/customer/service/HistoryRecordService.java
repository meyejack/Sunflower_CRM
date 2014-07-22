package sunflower.customer.service;

import java.util.List;

import sunflower.customer.entity.Customer;
import sunflower.customer.entity.HistoryRecord;

public interface HistoryRecordService {
	public HistoryRecord getHistoryRecord(String historyRecordID);

	public List<HistoryRecord> getCustomerHistoryRecords(Customer customer);
}
