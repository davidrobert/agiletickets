package br.com.caelum.agiletickets.models;

public enum Periodicidade {
	DIARIA(1), SEMANAL(7);
	
	private int days;
	
	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	private Periodicidade(int days) {
		this.days = days;
	}
}
