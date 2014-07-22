package sunflower.customer.service;

import java.util.List;

import sunflower.customer.entity.CustomerLostPause;


public interface CustomerLostPauseService {
	public boolean addCustomerLostPause(CustomerLostPause customerLostPause);

	public boolean updateCustomerLostPause(CustomerLostPause customerLostPause);

	public List<CustomerLostPause> getAllCustomerLostPauses();

}
