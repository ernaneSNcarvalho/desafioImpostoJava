package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Renda anual com salário: ");
		double rendaAnual = sc.nextDouble();		
		System.out.print("Renda anual com prestação de serviços: ");
		double rendaServicos = sc.nextDouble();
		System.out.print("Renda anual com ganho de capital: ");
		double rendaCapital = sc.nextDouble();		
		System.out.print("Gastos médicos:  ");
		double gastosMedicos = sc.nextDouble();		
		System.out.print("Gastos educacionais: ");
		double gastoEducacional = sc.nextDouble();
		
		double dedutiveis = gastosMedicos + gastoEducacional;		
		
		double salarioMensal = rendaAnual / 12;
		double imposto = 0.0;
		double impostoServico = 0.0;
		double impostoCapital = 0.0;
		double impostoDedutivel = 0.0;
		double maximoDedutivel = 0.0;
		double impostoBrutoTotal = 0.0;
		
		if(salarioMensal < 3000.0) {
			System.out.println("ISENTO");
		}else if(salarioMensal < 5000.0) {
			imposto = rendaAnual * 0.10;
		}else if(salarioMensal >= 5000.0) {
			imposto = rendaAnual * 0.20;
		}		
		
		if(rendaServicos > 0.0 || rendaCapital > 0.0) {
			impostoServico = rendaServicos * 0.15;
			impostoCapital = rendaCapital * 0.20;
		}
		
		impostoBrutoTotal = impostoServico + impostoCapital + imposto;	
		maximoDedutivel = impostoBrutoTotal * 0.30;
		
		if(dedutiveis < impostoBrutoTotal * 0.3) {
			impostoDedutivel = dedutiveis;
		}else {
			impostoDedutivel = impostoBrutoTotal * 0.30;
		}
		System.out.println(maximoDedutivel);
		
		double impostoDevido = impostoBrutoTotal - maximoDedutivel;
		
		System.out.println("RELATORIO DE IMPOSTO DE RENDA: ");
		System.out.println("CONSOLIDADO DE RENDA: ");
		
		System.out.printf("Imposto sobre salário: %.2f%n", imposto);
		System.out.printf("Imposto sobre serviços: %.2f%n", impostoServico);
		System.out.printf("Imposto sobre ganho de capital: %.2f%n", impostoCapital);
		
		System.out.println("DEDUÇÕES: ");
		System.out.printf("Máximo dedutível: %.2f%n", maximoDedutivel);
		System.out.printf("Gastos dedutíveis: %.2f%n", impostoDedutivel);
		
		System.out.println("RESUMO: ");
		System.out.printf("Imposto bruto total: %.2f%n", impostoBrutoTotal);
		System.out.printf("Abatimento: %.2f%n", impostoDedutivel);
		System.out.printf("Imposto devido: %.2f%n", impostoDevido);		
		
		sc.close();
	}

}
