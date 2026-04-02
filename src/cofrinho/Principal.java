package cofrinho;

import java.text.DecimalFormat; // importacao de classe para formatar numero decimal -> limitar as casas decimais para 2 apenas
import java.util.Scanner;

import cofrinho.Cofrinho.TipoMoeda;

public class Principal {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		
		Cofrinho cofrinho = new Cofrinho();
		
		DecimalFormat dfValorTotal = new DecimalFormat("#0.00"); // estabelecendo formato desejado para numeros decimais
		
		int opcao; // variavel que guardará a opcao ( de 0 a 4 validas) escolhida pelo usuario
		
		System.out.println("Menu moedas");
		System.out.println("1-Adicionar");
		System.out.println("2-Remover");
		System.out.println("3-Listar todas as moedas");
		System.out.println("4-Total convertido");
		System.out.println("0-Encerrar");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		opcao=teclado.nextInt();
	
		int tipoMoeda;
		double valor;
		TipoMoeda moeda;
		
		while (opcao !=0) { // laço principal
			
			switch(opcao) {
			
			case 1:
				tipoMoeda = 0;
				while(tipoMoeda > 3 || tipoMoeda <= 0) {
					System.out.println("1-Dolar");
					System.out.println("2-Euro");
					System.out.println("3-Real");
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					tipoMoeda = teclado.nextInt();
				}
					System.out.println("Valor que deseja adicionar: ");
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					valor = teclado.nextDouble();
					
					moeda = null;
					if(tipoMoeda==1) {
						moeda = TipoMoeda.Dolar;
					}
					else if(tipoMoeda==2) {
						moeda = TipoMoeda.Euro;
					}
					else {
						moeda = TipoMoeda.Real;
					}
					cofrinho.adicionar(moeda, valor);
					
					break;
				
				
			case 2:
				tipoMoeda = 0;
				while(tipoMoeda>3 || tipoMoeda<=0) {
					System.out.println("1-Dolar");
					System.out.println("2-Euro");
					System.out.println("3-Real");
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					tipoMoeda = teclado.nextInt();
				}
					System.out.println("Valor que deseja retirar: ");
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					valor = teclado.nextDouble();
					
					moeda = null;
					if(tipoMoeda==1) {
						moeda = TipoMoeda.Dolar;
					}
					else if(tipoMoeda==2) {
						moeda = TipoMoeda.Euro;
					}
					else {
						moeda = TipoMoeda.Real;
					}
					cofrinho.remover(moeda, valor);
					
					break;
				
			case 3:
				cofrinho.listarMoedas();
				break;
				
			case 4:
				System.out.println("Total convertido: R$" + dfValorTotal.format(cofrinho.totalConvertido())); // print do resultado total com a formatacao para numero decimais ja definida (2 casas decimais)
				break;
			default:
				System.out.println("Opcao Invalida!");
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				break;
			}
			System.out.println("Menu moedas");
			System.out.println("1-Adicionar");
			System.out.println("2-Remover");
			System.out.println("3-Listar todas as moedas");
			System.out.println("4-Total convertido");
			System.out.println("0-Encerrar");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			opcao=teclado.nextInt();
			
		}
		teclado.close();	}
	
}
