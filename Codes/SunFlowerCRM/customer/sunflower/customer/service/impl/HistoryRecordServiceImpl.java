package sunflower.customer.service.impl;

import java.util.List;

import sunflower.customer.dao.HistoryRecordDao;
import sunflower.customer.entity.Customer;
import sunflower.customer.entity.HistoryRecord;
import sunflower.customer.service.HistoryRecordService;

public class HistoryRecordServiceImpl implements HistoryRecordService {
	HistoryRecordDao hrd = new HistoryRecordDao();
	@Override
	public HistoryRecord getHistoryRecord(String historyRecordID) {
		return hrd.getHistoryRecord(historyRecordID);
	}

	@Override
	public List<HistoryRecord> getCustomerHistoryRecords(Customer customer) {
		return hrd.getCustomerHistoryRecords(customer);
	}

}
