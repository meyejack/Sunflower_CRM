package sunflower.customer.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import sunflower.business.entity.BusinessDistribution;
import sunflower.user.entity.User;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customer_id")
	private String customerId;

	@Column(name="customer_address")
	private String customerAddress;

	@Column(name="customer_annual_benefit")
	private int customerAnnualBenefit;

	@Column(name="customer_area")
	private String customerArea;

	@Column(name="customer_bank")
	private String customerBank;

	@Column(name="customer_bank_account")
	private String customerBankAccount;

	@Column(name="customer_corporation")
	private String customerCorporation;

	@Column(name="customer_credit")
	private int customerCredit;

	@Column(name="customer_fax")
	private String customerFax;

	@Column(name="customer_level")
	private String customerLevel;

	@Column(name="customer_license")
	private String customerLicense;

	@Column(name="customer_local_tax_code")
	private String customerLocalTaxCode;

	@Column(name="customer_name")
	private String customerName;

	@Column(name="customer_national_tax_code")
	private String customerNationalTaxCode;

	@Column(name="customer_postcode")
	private String customerPostcode;

	@Column(name="customer_reg_finance")
	private int customerRegFinance;

	@Column(name="customer_satisfaction")
	private int customerSatisfaction;

	@Column(name="customer_state")
	private int customerState;

	@Column(name="customer_telephone")
	private String customerTelephone;

	@Column(name="customer_website")
	private String customerWebsite;

	//bi-directional many-to-one association to BusinessDistribution
	@OneToMany(mappedBy="customer")
	private List<BusinessDistribution> businessDistributions;

	//bi-directional many-to-one association to ContactRecord
	@OneToMany(mappedBy="customer")
	private List<ContactRecord> contactRecords;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;//负责的客户经理

	//bi-directional many-to-one association to CustomerLostPause
	@OneToMany(mappedBy="customer")
	private List<CustomerLostPause> customerLostPauses;

	//bi-directional many-to-one association to CustomerPerson
	@OneToMany(mappedBy="customer")
	private List<CustomerPerson> customerPersons;

	//bi-directional many-to-one association to HistoryRecord
	@OneToMany(mappedBy="customer")
	private List<HistoryRecord> historyRecords;

	public Customer() {
	}
	
	

	public Customer(String customerAddress, int customerAnnualBenefit,
			String customerArea, String customerBank,
			String customerBankAccount, String customerCorporation,
			int customerCredit, String customerFax, String customerLevel,
			String customerLicense, String customerLocalTaxCode,
			String customerName, String customerNationalTaxCode,
			String customerPostcode, int customerRegFinance,
			int customerSatisfaction, String customerTelephone,
			String customerWebsite,
			 User user) {
		super();
		this.customerAddress = customerAddress;
		this.customerAnnualBenefit = customerAnnualBenefit;
		this.customerArea = customerArea;
		this.customerBank = customerBank;
		this.customerBankAccount = customerBankAccount;
		this.customerCorporation = customerCorporation;
		this.customerCredit = customerCredit;
		this.customerFax = customerFax;
		this.customerLevel = customerLevel;
		this.customerLicense = customerLicense;
		this.customerLocalTaxCode = customerLocalTaxCode;
		this.customerName = customerName;
		this.customerNationalTaxCode = customerNationalTaxCode;
		this.customerPostcode = customerPostcode;
		this.customerRegFinance = customerRegFinance;
		this.customerSatisfaction = customerSatisfaction;
		this.customerTelephone = customerTelephone;
		this.customerWebsite = customerWebsite;
		this.user = user;
		
		this.customerState=0;
	}



	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerAddress() {
		return this.customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public int getCustomerAnnualBenefit() {
		return this.customerAnnualBenefit;
	}

	public void setCustomerAnnualBenefit(int customerAnnualBenefit) {
		this.customerAnnualBenefit = customerAnnualBenefit;
	}

	public String getCustomerArea() {
		return this.customerArea;
	}

	public void setCustomerArea(String customerArea) {
		this.customerArea = customerArea;
	}

	public String getCustomerBank() {
		return this.customerBank;
	}

	public void setCustomerBank(String customerBank) {
		this.customerBank = customerBank;
	}

	public String getCustomerBankAccount() {
		return this.customerBankAccount;
	}

	public void setCustomerBankAccount(String customerBankAccount) {
		this.customerBankAccount = customerBankAccount;
	}

	public String getCustomerCorporation() {
		return this.customerCorporation;
	}

	public void setCustomerCorporation(String customerCorporation) {
		this.customerCorporation = customerCorporation;
	}

	public int getCustomerCredit() {
		return this.customerCredit;
	}

	public void setCustomerCredit(int customerCredit) {
		this.customerCredit = customerCredit;
	}

	public String getCustomerFax() {
		return this.customerFax;
	}

	public void setCustomerFax(String customerFax) {
		this.customerFax = customerFax;
	}

	public String getCustomerLevel() {
		return this.customerLevel;
	}

	public void setCustomerLevel(String customerLevel) {
		this.customerLevel = customerLevel;
	}

	public String getCustomerLicense() {
		return this.customerLicense;
	}

	public void setCustomerLicense(String customerLicense) {
		this.customerLicense = customerLicense;
	}

	public String getCustomerLocalTaxCode() {
		return this.customerLocalTaxCode;
	}

	public void setCustomerLocalTaxCode(String customerLocalTaxCode) {
		this.customerLocalTaxCode = customerLocalTaxCode;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerNationalTaxCode() {
		return this.customerNationalTaxCode;
	}

	public void setCustomerNationalTaxCode(String customerNationalTaxCode) {
		this.customerNationalTaxCode = customerNationalTaxCode;
	}

	public String getCustomerPostcode() {
		return this.customerPostcode;
	}

	public void setCustomerPostcode(String customerPostcode) {
		this.customerPostcode = customerPostcode;
	}

	public int getCustomerRegFinance() {
		return this.customerRegFinance;
	}

	public void setCustomerRegFinance(int customerRegFinance) {
		this.customerRegFinance = customerRegFinance;
	}

	public int getCustomerSatisfaction() {
		return this.customerSatisfaction;
	}

	public void setCustomerSatisfaction(int customerSatisfaction) {
		this.customerSatisfaction = customerSatisfaction;
	}

	public int getCustomerState() {
		return this.customerState;
	}

	public void setCustomerState(int customerState) {
		this.customerState = customerState;
	}

	public String getCustomerTelephone() {
		return this.customerTelephone;
	}

	public void setCustomerTelephone(String customerTelephone) {
		this.customerTelephone = customerTelephone;
	}

	public String getCustomerWebsite() {
		return this.customerWebsite;
	}

	public void setCustomerWebsite(String customerWebsite) {
		this.customerWebsite = customerWebsite;
	}

	public List<BusinessDistribution> getBusinessDistributions() {
		return this.businessDistributions;
	}

	public void setBusinessDistributions(List<BusinessDistribution> businessDistributions) {
		this.businessDistributions = businessDistributions;
	}

	public BusinessDistribution addBusinessDistribution(BusinessDistribution businessDistribution) {
		getBusinessDistributions().add(businessDistribution);
		businessDistribution.setCustomer(this);

		return businessDistribution;
	}

	public BusinessDistribution removeBusinessDistribution(BusinessDistribution businessDistribution) {
		getBusinessDistributions().remove(businessDistribution);
		businessDistribution.setCustomer(null);

		return businessDistribution;
	}

	public List<ContactRecord> getContactRecords() {
		return this.contactRecords;
	}

	public void setContactRecords(List<ContactRecord> contactRecords) {
		this.contactRecords = contactRecords;
	}

	public ContactRecord addContactRecord(ContactRecord contactRecord) {
		getContactRecords().add(contactRecord);
		contactRecord.setCustomer(this);

		return contactRecord;
	}

	public ContactRecord removeContactRecord(ContactRecord contactRecord) {
		getContactRecords().remove(contactRecord);
		contactRecord.setCustomer(null);

		return contactRecord;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CustomerLostPause> getCustomerLostPauses() {
		return this.customerLostPauses;
	}

	public void setCustomerLostPauses(List<CustomerLostPause> customerLostPauses) {
		this.customerLostPauses = customerLostPauses;
	}

	public CustomerLostPause addCustomerLostPaus(CustomerLostPause customerLostPaus) {
		getCustomerLostPauses().add(customerLostPaus);
		customerLostPaus.setCustomer(this);

		return customerLostPaus;
	}

	public CustomerLostPause removeCustomerLostPaus(CustomerLostPause customerLostPaus) {
		getCustomerLostPauses().remove(customerLostPaus);
		customerLostPaus.setCustomer(null);

		return customerLostPaus;
	}

	public List<CustomerPerson> getCustomerPersons() {
		return this.customerPersons;
	}

	public void setCustomerPersons(List<CustomerPerson> customerPersons) {
		this.customerPersons = customerPersons;
	}

	public CustomerPerson addCustomerPerson(CustomerPerson customerPerson) {
		getCustomerPersons().add(customerPerson);
		customerPerson.setCustomer(this);

		return customerPerson;
	}

	public CustomerPerson removeCustomerPerson(CustomerPerson customerPerson) {
		getCustomerPersons().remove(customerPerson);
		customerPerson.setCustomer(null);

		return customerPerson;
	}

	public List<HistoryRecord> getHistoryRecords() {
		return this.historyRecords;
	}

	public void setHistoryRecords(List<HistoryRecord> historyRecords) {
		this.historyRecords = historyRecords;
	}

	public HistoryRecord addHistoryRecord(HistoryRecord historyRecord) {
		getHistoryRecords().add(historyRecord);
		historyRecord.setCustomer(this);

		return historyRecord;
	}

	public HistoryRecord removeHistoryRecord(HistoryRecord historyRecord) {
		getHistoryRecords().remove(historyRecord);
		historyRecord.setCustomer(null);

		return historyRecord;
	}

}