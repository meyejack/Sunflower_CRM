package sunflower.business.service;

import java.util.List;

import sunflower.business.entity.Business;


public interface BusinessService {
	public Business getBusiness(String businessID);

	public boolean addBusiness(Business business);

	public boolean updateBusiness(Business business);

	public boolean dropBusiness(Business business);

	public List<Business> getAvailBusinesss();

}
