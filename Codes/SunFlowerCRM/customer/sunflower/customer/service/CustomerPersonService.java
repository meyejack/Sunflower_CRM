package sunflower.customer.service;

import sunflower.customer.entity.CustomerPerson;

public interface CustomerPersonService {
	public CustomerPerson getCustomerPerson(String customerPersonID);

	public boolean addCustomerPerson(CustomerPerson customerPerson);

	public boolean updateCustomerPerson(CustomerPerson customerPerson);

	public boolean deleteCustomerPerson(CustomerPerson customerPerson);

}
