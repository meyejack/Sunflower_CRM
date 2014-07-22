package sunflower.customer.service;

import sunflower.customer.entity.ContactRecord;

public interface ContactRecordService {
	public ContactRecord getContactRecord(String contactRecordID);

	public boolean addContactRecord(ContactRecord contactRecord);

	public boolean updateContactRecord(ContactRecord contactRecord);

	public boolean deleteContactRecord(ContactRecord contactRecord);

}
