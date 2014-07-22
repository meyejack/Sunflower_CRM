package sunflower.business.service;

import java.util.List;

import sunflower.business.entity.BusinessDistribution;


public interface BusinessDistributionService {
	public BusinessDistribution getBusinessDistribution(
			String businessDistributionID);

	public boolean addBusinessDistribution(
			BusinessDistribution businessDistribution);

	public boolean updateBusinessDistribution(
			BusinessDistribution businessDistribution);

	public List<BusinessDistribution> getAllBusinessDistributions();

	public List<BusinessDistribution> getNewBusinessDistributions();

	public List<BusinessDistribution> getDistributedBusinessDistributions();

	public List<BusinessDistribution> getDealedBusinessDistributions();

	public List<BusinessDistribution> getFinishedBusinessDistributions();
}
