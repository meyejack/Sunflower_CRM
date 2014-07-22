package sunflower.customer.service;

import java.util.List;

import sunflower.customer.entity.Customer;


public interface CustomerService {
	public Customer getCustomer(String customerID);

	public boolean addCustomer(Customer customer);

	public boolean updateCustomer(Customer customer);

	public boolean dropCustomer(Customer customer);

	public List<Customer> getNotLostCustomers();

	public List<Customer> getMayLostCustomers();

	public List<Customer> getWarnCustomers();

	public List<Customer> getLostPauseCustomers();
}
