package sunflower.business.service.impl;

import java.util.List;

import sunflower.business.dao.BusinessDistributionDao;
import sunflower.business.entity.BusinessDistribution;
import sunflower.business.service.BusinessDistributionService;


public class BusinessDistributionServiceImpl implements
		BusinessDistributionService {
	BusinessDistributionDao bdd = new BusinessDistributionDao();

	@Override
	public BusinessDistribution getBusinessDistribution(
			String businessDistributionID) {
		return bdd.getBusinessDistribution(businessDistributionID);
	}

	@Override
	public boolean addBusinessDistribution(
			BusinessDistribution businessDistribution) {
		return bdd.saveBusinessDistribution(businessDistribution);
	}

	@Override
	public boolean updateBusinessDistribution(
			BusinessDistribution businessDistribution) {
		return bdd.updateBusinessDistribution(businessDistribution);
	}

	@Override
	public List<BusinessDistribution> getAllBusinessDistributions() {
		return bdd.getAllBusinessDistributions();
	}

	@Override
	public List<BusinessDistribution> getNewBusinessDistributions() {
		return bdd.getNewBusinessDistributions();
	}

	@Override
	public List<BusinessDistribution> getDistributedBusinessDistributions() {
		return bdd.getDistributedBusinessDistributions();
	}

	@Override
	public List<BusinessDistribution> getDealedBusinessDistributions() {
		return bdd.getDealedBusinessDistributions();
	}

	@Override
	public List<BusinessDistribution> getFinishedBusinessDistributions() {
		return bdd.getFinishedBusinessDistributions();
	}

}
