package sunflower.sales.service;

import java.util.List;

import sunflower.sales.entity.Sale;
import sunflower.user.entity.User;

public interface SaleService {
	public boolean addSale(Sale sale);

	public Sale getSale(String saleID);

	public boolean updateSale(Sale sale);

	public boolean dropSale(Sale sale);

	public List<Sale> getAvailSales(); // 获取可用的机会,包括未指派与已指派

	public List<Sale> getFreeSales(); // 获取未指派的机会

	public List<Sale> getAppointedSales();// 获取已指派的机会
	
	public List<Sale> getManagerSales(User user);
}
