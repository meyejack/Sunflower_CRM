package sunflower.business.service.impl;

import java.util.List;

import sunflower.business.dao.BusinessDao;
import sunflower.business.entity.Business;
import sunflower.business.service.BusinessService;


public class BusinessServiceImpl implements BusinessService {
	BusinessDao bd = new BusinessDao();

	@Override
	public Business getBusiness(String businessID) {
		return bd.getBusiness(businessID);
	}

	@Override
	public boolean addBusiness(Business business) {
		return bd.saveBusiness(business);
	}

	@Override
	public boolean updateBusiness(Business business) {
		return bd.updateBusiness(business);
	}

	@Override
	public boolean dropBusiness(Business business) {
		return bd.dropBusiness(business);
	}

	@Override
	public List<Business> getAvailBusinesss() {
		return bd.getAvailBusinesss();
	}

}
