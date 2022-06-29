package entities;

import java.util.ArrayList;
import java.util.List;

public class TaxPayer {

	private Double salaryIncome;
	private Double serviceIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;

	private Double salaryTax; // imposto sobre salario
	private Double servicesTax; // imposto sobre serviços
	private Double capitalTax; // imposto sobre capital
	private Double grossTax; // imposto bruto total
	private Double taxRebate; // abatimento de cada um
	private Double netTax; // imposto liquido

	public TaxPayer() {
	}

	public TaxPayer(Double salaryIncome, Double serviceIncome, Double capitalIncome, Double healthSpending,
			Double educationSpending) {
		super();
		this.salaryIncome = salaryIncome;
		this.serviceIncome = serviceIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryTax() {
		Double mounth = salaryIncome / 12;
		if (mounth < 3000.0) {
			return salaryTax = 0.0;
		} else if (mounth > 3000.0 && mounth <= 5000.0) {
			return salaryTax = 10.0 * salaryIncome / 100.0;
		} else if (mounth > 5000.0) {
			return salaryTax = 20.0 * salaryIncome / 100.0;
		}
		return salaryTax;
	}

	public Double getServicesTax() {
		return servicesTax = serviceIncome * (15.0 / 100.0);
	}

	public Double getCapitalTax() {
		return capitalTax = capitalIncome * (20.0 / 100.0);
	}

	public Double getGrossTax() {
		return grossTax = getCapitalTax() + getSalaryTax() + getServicesTax();
	}

	public Double getTaxRebate() {
		Double porcentagem = grossTax * 0.3;
		if (healthSpending + educationSpending <= porcentagem) {
			return taxRebate = healthSpending + educationSpending;
		} else if (healthSpending + educationSpending > porcentagem) {
			return taxRebate = porcentagem;
		}
		return taxRebate;
	}

	public Double getNetTax() {
		return netTax = getGrossTax() - getTaxRebate();
	}

}
