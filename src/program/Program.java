package program;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		List<TaxPayer> taxPayers = new ArrayList<>();

		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = sc.nextInt();
		System.out.println();

		for (int i = 0; i < n; i++) {

			System.out.println("Digite os dados do " + (i + 1) + "o contribuinte:");
			System.out.println();
			System.out.print("Renda anual com salário: ");
			Double salaryIncome = sc.nextDouble();

			System.out.print("Renda anual com prestação de serviço: ");
			Double serviceIncoming = sc.nextDouble();

			System.out.print("Renda anual com ganho de capital: ");
			Double capital = sc.nextDouble();

			System.out.print("Gastos médicos: ");
			Double medico = sc.nextDouble();

			System.out.print("Gastos educacionais: ");
			Double educa = sc.nextDouble();

			TaxPayer taxpayer = new TaxPayer(salaryIncome, serviceIncoming, capital, medico, educa);
			taxPayers.add(taxpayer);
			System.out.println("---------------------------------");

		}

		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Resumo do " + (i + 1) + "o contribuinte:");

			System.out.printf("\nImposto bruto total: %.2f", taxPayers.get(i).getGrossTax());
			System.out.printf("\nAbatimento: %.2f", taxPayers.get(i).getTaxRebate());
			System.out.printf("\nImposto devido: %.2f", taxPayers.get(i).getNetTax());

			System.out.println();
		}

		sc.close();

	}

}
