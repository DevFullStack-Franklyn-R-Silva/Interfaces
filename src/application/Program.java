package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Locadora;
import model.entities.Veiculo;
import model.services.ServicoDeAluguel;
import model.services.ServicoDeImpostoDoBrasil;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			System.out.println("Insira os dados de aluguel");
			System.out.println("Modelo do carro: ");
			String modelo = sc.nextLine();
			
			System.out.println("Escolhido (dia/mês/ano hr:min)");
			Date inicio = sdf.parse(sc.nextLine());
			System.out.println("Entregue (dia/mês/ano hr:min)");
			Date finalizar = sdf.parse(sc.nextLine());
			
			Locadora loca = new Locadora(inicio, finalizar, new Veiculo(modelo));
			
			System.out.println("Entre com preço por hora: ");
			double precoPorHora = sc.nextDouble();
			System.out.println("Entre com preço por dia: ");
			double precoPorDia = sc.nextDouble();
			
			ServicoDeAluguel servicoDeAluguel = new ServicoDeAluguel( precoPorDia, precoPorHora, new ServicoDeImpostoDoBrasil());
			
			servicoDeAluguel.processandoPagamento(loca);
			
			System.out.println("PAGAMENTO: ");
			System.out.println("Pagamento básico: "+String.format("%.2f", loca.getNota().getPagamentoBasico()));
			System.out.println("Imposto: "+String.format("%.2f", loca.getNota().getImposto()));
			System.out.println("Pagamento total: "+String.format("%.2f", loca.getNota().getPagamentoTotal()));
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			sc.close();
		}

	}

}
