package model.services;

import model.entities.Locadora;
import model.entities.NotaDePagamento;

public class ServicoDeAluguel {

	private Double precoPorDia;
	private Double precoPorHora;

	private ServicoDeImpostoDoBrasil servicoDeImposto;

	public ServicoDeAluguel() {
	}

	public ServicoDeAluguel(Double precoPorDia, Double precoPorHora, ServicoDeImpostoDoBrasil servicoDeImposto) {
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.servicoDeImposto = servicoDeImposto;
	}

	public Double getPrecoPorDia() {
		return precoPorDia;
	}

	public void setPrecoPorDia(Double precoPorDia) {
		this.precoPorDia = precoPorDia;
	}

	public Double getPrecoPorHora() {
		return precoPorHora;
	}

	public void setPrecoPorHora(Double precoPorHora) {
		this.precoPorHora = precoPorHora;
	}

	public ServicoDeImpostoDoBrasil getServicoDeImposto() {
		return servicoDeImposto;
	}

	public void setServicoDeImposto(ServicoDeImpostoDoBrasil servicoDeImposto) {
		this.servicoDeImposto = servicoDeImposto;
	}

	public void processandoPagamento(Locadora locadora) {
		long instante1 = locadora.getIniciar().getTime();
		long instante2 = locadora.getFinalizar().getTime();
		double horas = (double) (instante2 - instante1) / 1000 / 60 / 60;

		double pagamentoBasico;
		if (horas <= 12.0) {
			pagamentoBasico = Math.ceil(horas) * precoPorHora;
		} else {
			pagamentoBasico = Math.ceil(horas / 24) * precoPorDia;
		}
		double imposto = servicoDeImposto.imposto(pagamentoBasico);
		
		locadora.setNota(new NotaDePagamento(pagamentoBasico, imposto));

	}

}
