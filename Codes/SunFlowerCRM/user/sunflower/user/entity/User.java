package sunflower.user.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import sunflower.business.entity.Business;
import sunflower.customer.entity.Customer;
import sunflower.sales.entity.Sale;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
	private String userId;

	@Column(name="user_account")
	private String userAccount;

	@Column(name="user_department")
	private String userDepartment;

	@Column(name="user_level")
	private int userLevel;

	@Column(name="user_name")
	private String userName;

	@Column(name="user_password")
	private String userPassword;

	@Column(name="user_state")
	private int userState;

	@Column(name="user_telephone")
	private String userTelephone;

	//bi-directional many-to-one association to Business
	@OneToMany(mappedBy="user")
	private List<Business> businesses;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="user")
	private List<Customer> customers;

	//bi-directional many-to-one association to Sale
	//create_user
	@OneToMany(mappedBy="user1")
	private List<Sale> sales1;

	//bi-directional many-to-one association to Sale
	//responsible user
	@OneToMany(mappedBy="user2")
	private List<Sale> sales2;

	public User() {
	}

	public User(String userAccount, String userDepartment,
			int userLevel, String userName, String userPassword, int userState,
			String userTelephone ) {
		super();
		this.userAccount = userAccount;
		this.userDepartment = userDepartment;
		this.userLevel = userLevel;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userState = userState;
		this.userTelephone = userTelephone;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserDepartment() {
		return this.userDepartment;
	}

	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}

	public int getUserLevel() {
		return this.userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserState() {
		return this.userState;
	}

	public void setUserState(int userState) {
		this.userState = userState;
	}

	public String getUserTelephone() {
		return this.userTelephone;
	}

	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}

	public List<Business> getBusinesses() {
		return this.businesses;
	}

	public void setBusinesses(List<Business> businesses) {
		this.businesses = businesses;
	}

	public Business addBusiness(Business business) {
		getBusinesses().add(business);
		business.setUser(this);

		return business;
	}

	public Business removeBusiness(Business business) {
		getBusinesses().remove(business);
		business.setUser(null);

		return business;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setUser(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setUser(null);

		return customer;
	}

	public List<Sale> getSales1() {
		return this.sales1;
	}

	public void setSales1(List<Sale> sales1) {
		this.sales1 = sales1;
	}

	public Sale addSales1(Sale sales1) {
		getSales1().add(sales1);
		sales1.setUser1(this);

		return sales1;
	}

	public Sale removeSales1(Sale sales1) {
		getSales1().remove(sales1);
		sales1.setUser1(null);

		return sales1;
	}

	public List<Sale> getSales2() {
		return this.sales2;
	}

	public void setSales2(List<Sale> sales2) {
		this.sales2 = sales2;
	}

	public Sale addSales2(Sale sales2) {
		getSales2().add(sales2);
		sales2.setUser2(this);

		return sales2;
	}

	public Sale removeSales2(Sale sales2) {
		getSales2().remove(sales2);
		sales2.setUser2(null);

		return sales2;
	}

}