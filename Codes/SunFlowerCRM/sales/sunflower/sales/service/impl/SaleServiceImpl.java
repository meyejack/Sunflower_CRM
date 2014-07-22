package sunflower.sales.service.impl;

import java.util.List;

import sunflower.sales.dao.SaleDao;
import sunflower.sales.entity.Sale;
import sunflower.sales.service.SaleService;
import sunflower.user.entity.User;

public class SaleServiceImpl implements SaleService {
	SaleDao saleDao = new SaleDao();

	@Override
	public boolean addSale(Sale sale) {
		return saleDao.saveSale(sale);
	}

	@Override
	public Sale getSale(String saleID) {
		return saleDao.getSale(saleID);
	}

	@Override
	public boolean updateSale(Sale sale) {
		return saleDao.updateSale(sale);
	}

	@Override
	public boolean dropSale(Sale sale) {
		return saleDao.dropSale(sale);
	}

	@Override
	public List<Sale> getAvailSales() {
		return saleDao.getAvailSales();
	}

	@Override
	public List<Sale> getFreeSales() {
		return saleDao.getFreeSales();
	}

	@Override
	public List<Sale> getAppointedSales() {
		return saleDao.getAppointedSales();
	}

	@Override
	public List<Sale> getManagerSales(User user) {
		return saleDao.getManagerSales(user);
	}

}
