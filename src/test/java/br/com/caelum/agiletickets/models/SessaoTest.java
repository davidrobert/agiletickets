package br.com.caelum.agiletickets.models;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class SessaoTest {


	@Test
	public void deveVender1ingressoSeHa2vagas() throws Exception {
		Sessao sessao = new Sessao();
        sessao.setTotalIngressos(2);

        Assert.assertTrue(sessao.podeReservar(1));
	}

	@Test
	public void naoDeveVender3ingressoSeHa2vagas() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(2);

		Assert.assertFalse(sessao.podeReservar(3));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(5);
		
		sessao.reserva(5);
		
		int totalReservados = sessao.getIngressosReservados();
		
		assertEquals(0, sessao.getIngressosDisponiveis().intValue());
	}
	
	@Test
	public void testeIngressosDisponiveis() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(1);
		
		boolean reserva = sessao.podeReservar(1);
		
		Assert.assertTrue(reserva);
	}
}
