package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entidade.ContratoHora;
import Entidade.Departamento;
import Entidade.Funcionario;
import Entidade.enums.NivelTrabalho;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Entre com o nome do departamento: ");
		String departamento = sc.nextLine();

		System.out.println("Entre com os dados do trabalhador: ");
		System.out.print("Nome: ");
		String nome = sc.nextLine();

		System.out.print("Nivel: ");
		String level = sc.nextLine();

		System.out.print("Salario base: ");
		double salarioBase = sc.nextDouble();

		Funcionario funcionario = new Funcionario(nome, NivelTrabalho.valueOf(level), salarioBase,
				new Departamento(departamento));

		System.out.print("Quantos contratos esse trabalhador vai ter? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Entre com o #" + (i+1) + " contrato: ");
			System.out.print("Data (DD/MM/AAAA): ");
			Date data = sfd.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Duracao (horas): ");
			int hora = sc.nextInt();

			ContratoHora contrato = new ContratoHora(data, valorPorHora, hora);
			funcionario.adicionarContrato(contrato);
		}

		System.out.println();
		System.out.print("Entre com o mes e ano para calcular a renda (MM/AAAA): ");
		String mesEAno = sc.next();
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3));

		System.out.println("Nome: " + funcionario.getNome());
		System.out.println("Departamento: " + funcionario.getDepartamento().getNome());
		System.out.println("Renda para " + mesEAno + ": " + String.format("%.2f", funcionario.renda(ano, mes)));

		sc.close();
	}

}
