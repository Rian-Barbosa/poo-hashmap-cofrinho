package cofrinho;

import java.util.HashMap;

import java.util.Map;

public class Cofrinho {

	Map<TipoMoeda, Double> listaMoedas = new HashMap<>();
	enum TipoMoeda {

		Dolar(5.3), 
		Euro(6.1), 
		Real(1.0);
		
		private final double TAXACONVERSAO;
		
		TipoMoeda(double TAXACONVERSAO){
			this.TAXACONVERSAO = TAXACONVERSAO;
		}
		
		public double getTaxaConversao() {
			return TAXACONVERSAO;
		}
	}
	public void adicionar(TipoMoeda moeda, Double valor) {
		listaMoedas.merge(moeda, valor, Double::sum);
	}
	public void remover(TipoMoeda moeda, Double valor) {
		listaMoedas.merge(moeda, valor, (a, b) -> Math.max(0,  a - b));
	}
	public void listarMoedas() {
		for(Map.Entry<TipoMoeda, Double> entry : listaMoedas.entrySet()) {
			System.out.println(entry.getKey() + " | Saldo: " + entry.getValue());
		}
	}
	
	
	public double totalConvertido() {
		double totalC = 0;
		
		for(Map.Entry<TipoMoeda, Double> entry : listaMoedas.entrySet()) {
			totalC += entry.getValue() * entry.getKey().getTaxaConversao();
		}
		
		return totalC;
	}
}