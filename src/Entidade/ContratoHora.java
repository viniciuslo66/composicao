package Entidade;

import java.util.Date;

public class ContratoHora {
	private Date data;
	private double valorPorHora;
	private Integer hora;

	public ContratoHora() {
	}

	public ContratoHora(Date data, double valorPorHora, int hora) {
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.hora = hora;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public Double valorTotal() {
		return valorPorHora * hora;
	}

}
