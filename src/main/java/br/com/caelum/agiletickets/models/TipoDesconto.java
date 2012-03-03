package br.com.caelum.agiletickets.models;

public enum TipoDesconto {
	NORMAL(0),
	ESTUDANTE(30),
	IDOSO(50);
	
	private int percentualDesconto;
	
	private TipoDesconto(int percentual) {
		this.percentualDesconto = percentual;
	}
	
	public int getPercentualDesconto() {
		return this.percentualDesconto;
	}
}
