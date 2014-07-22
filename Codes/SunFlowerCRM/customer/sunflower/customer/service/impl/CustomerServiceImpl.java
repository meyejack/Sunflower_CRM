package sunflower.customer.service.impl;

import java.util.List;

import sunflower.customer.dao.CustomerDao;
import sunflower.customer.entity.Customer;
import sunflower.customer.service.CustomerService;


public class CustomerServiceImpl implements CustomerService {
	CustomerDao cd = new CustomerDao();

	@Override
	public Customer getCustomer(String customerID) {
		return cd.getCustomer(customerID);
	}

	@Override
	public boolean addCustomer(Customer customer) {
		return cd.saveCustomer(customer);
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		return cd.updateCustomer(customer);
	}

	@Override
	public boolean dropCustomer(Customer customer) {
		return cd.dropCustomer(customer);
	}

	@Override
	public List<Customer> getNotLostCustomers() {
		return cd.getNotLostCustomers();
	}

	@Override
	public List<Customer> getMayLostCustomers() {
		return cd.getMayLostCustomers();
	}

	@Override
	public List<Customer> getWarnCustomers() {
		return cd.getWarnCustomers();
	}

	@Override
	public List<Customer> getLostPauseCustomers() {
		return cd.getLostPauseCustomers();
	}

}
