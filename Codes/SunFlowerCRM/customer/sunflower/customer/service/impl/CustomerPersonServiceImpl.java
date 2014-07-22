package sunflower.customer.service.impl;

import sunflower.customer.dao.CustomerPersonDao;
import sunflower.customer.entity.CustomerPerson;
import sunflower.customer.service.CustomerPersonService;

public class CustomerPersonServiceImpl implements CustomerPersonService {
	CustomerPersonDao cpd = new CustomerPersonDao();

	@Override
	public CustomerPerson getCustomerPerson(String customerPersonID) {
		return cpd.getCustomerPerson(customerPersonID);
	}

	@Override
	public boolean addCustomerPerson(CustomerPerson customerPerson) {
		return cpd.saveCustomerPerson(customerPerson);
	}

	@Override
	public boolean updateCustomerPerson(CustomerPerson customerPerson) {
		return cpd.updateCustomerPerson(customerPerson);
	}

	@Override
	public boolean deleteCustomerPerson(CustomerPerson customerPerson) {
		return cpd.deleteCustomerPerson(customerPerson);
	}

}
