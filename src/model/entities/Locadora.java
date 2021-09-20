package model.entities;

import java.util.Date;

public class Locadora {
	private Date iniciar;
	private Date finalizar;
	
	private Veiculo veiculo;
	private NotaDePagamento nota;

	public Locadora() {
	}

	public Locadora(Date iniciar, Date finalizar, Veiculo veiculo) {
		this.iniciar = iniciar;
		this.finalizar = finalizar;
		this.veiculo = veiculo;
	}

	public Date getIniciar() {
		return iniciar;
	}

	public void setIniciar(Date iniciar) {
		this.iniciar = iniciar;
	}

	public Date getFinalizar() {
		return finalizar;
	}

	public void setFinalizar(Date finalizar) {
		this.finalizar = finalizar;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public NotaDePagamento getNota() {
		return nota;
	}

	public void setNota(NotaDePagamento nota) {
		this.nota = nota;
	}

}
