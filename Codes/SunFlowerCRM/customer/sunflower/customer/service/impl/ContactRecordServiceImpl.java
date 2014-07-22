package sunflower.customer.service.impl;

import sunflower.customer.dao.ContactRecordDao;
import sunflower.customer.entity.ContactRecord;
import sunflower.customer.service.ContactRecordService;

public class ContactRecordServiceImpl implements ContactRecordService {
	ContactRecordDao crd = new ContactRecordDao();

	@Override
	public ContactRecord getContactRecord(String contactRecordID) {
		return crd.getContactRecord(contactRecordID);
	}

	@Override
	public boolean addContactRecord(ContactRecord contactRecord) {
		return crd.saveContactRecord(contactRecord);
	}

	@Override
	public boolean updateContactRecord(ContactRecord contactRecord) {
		return crd.updateContactRecord(contactRecord);
	}

	@Override
	public boolean deleteContactRecord(ContactRecord contactRecord) {
		return crd.deleteContactRecord(contactRecord);
	}

}
