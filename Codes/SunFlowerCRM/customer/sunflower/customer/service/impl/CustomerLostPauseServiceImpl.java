package sunflower.customer.service.impl;

import java.util.List;

import sunflower.customer.dao.CustomerLostPauseDao;
import sunflower.customer.entity.CustomerLostPause;
import sunflower.customer.service.CustomerLostPauseService;


public class CustomerLostPauseServiceImpl implements CustomerLostPauseService {
	CustomerLostPauseDao clpd = new CustomerLostPauseDao();

	@Override
	public boolean addCustomerLostPause(CustomerLostPause customerLostPause) {
		return clpd.saveCustomerLostPause(customerLostPause);
	}

	@Override
	public boolean updateCustomerLostPause(CustomerLostPause customerLostPause) {
		return clpd.updateCustomerLostPause(customerLostPause);
	}

	@Override
	public List<CustomerLostPause> getAllCustomerLostPauses() {
		return clpd.getAllCustomerLostPauses();
	}

}
