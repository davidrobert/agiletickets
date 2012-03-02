package br.com.caelum.agiletickets.models;

import java.util.List;
import java.util.Locale;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

public class EspetaculoTest {

	@Test
	public void deveCriarNovaSessaoUnicaComPeriodicidadeDiaria() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		espetaculo.setNome("um nome");
		espetaculo.setDescricao("uma descricao");

		LocalDate inicio = new LocalDate(2012, 03, 01);
		LocalDate fim = new LocalDate(2012, 03, 01);
		LocalTime horario = new LocalTime(20, 10, 5);
		Periodicidade periodicidade = Periodicidade.DIARIA;

		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, periodicidade);

		Assert.assertEquals(1, sessoes.size());
		Sessao sessao = sessoes.get(0);

		DateTime dateTime = inicio.toDateTime(horario);
		String hora = dateTime.toString(DateTimeFormat.shortTime().withLocale(new Locale("pt", "BR")));

		Assert.assertEquals(2, sessao.getInicio().getDayOfMonth());
		Assert.assertEquals(hora, sessao.getHora());
	}

	@Test
	public void deveCriarNovaSessaoComPeriodicidadeDiaria() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		espetaculo.setNome("um nome");
		espetaculo.setDescricao("uma descricao");

		LocalDate inicio = new LocalDate(2012, 03, 01);
		LocalDate fim = new LocalDate(2012, 03, 02);
		LocalTime horario = new LocalTime(20, 10, 5);
		Periodicidade periodicidade = Periodicidade.DIARIA;

		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, periodicidade);

		Assert.assertEquals(2, sessoes.size());
		DateTime dateTime = inicio.toDateTime(horario);
		String hora = dateTime.toString(DateTimeFormat.shortTime().withLocale(new Locale("pt", "BR")));

		Assert.assertEquals(01, sessoes.get(0).getInicio().getDayOfMonth());
		Assert.assertEquals(hora, sessoes.get(0).getHora());

		Assert.assertEquals(02, sessoes.get(1).getInicio().getDayOfMonth());
		Assert.assertEquals(hora, sessoes.get(1).getHora());
	}
	
	@Test
	public void deveCriarNovaSessaoUnicaComPeriodicidadeSemanal() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		espetaculo.setNome("um nome");
		espetaculo.setDescricao("uma descricao");

		LocalDate inicio = new LocalDate(2012, 03, 1);
		LocalDate fim = new LocalDate(2012, 03, 7);
		LocalTime horario = new LocalTime(20, 10, 5);
		Periodicidade periodicidade = Periodicidade.SEMANAL;

		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, periodicidade);

		Assert.assertEquals(1, sessoes.size());
		Sessao sessao = sessoes.get(0);

		DateTime dateTime = inicio.toDateTime(horario);
		String hora = dateTime.toString(DateTimeFormat.shortTime().withLocale(new Locale("pt", "BR")));

		Assert.assertEquals(01, sessao.getInicio().getDayOfMonth());
		Assert.assertEquals(hora, sessao.getHora());
	}

	@Test
	public void deveCriarNovaSessaoComPeriodicidadeSemanal() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		espetaculo.setNome("um nome");
		espetaculo.setDescricao("uma descricao");

		LocalDate inicio = new LocalDate(2012, 03, 01);
		LocalDate fim = new LocalDate(2012, 03, 8);
		LocalTime horario = new LocalTime(20, 10, 5);
		Periodicidade periodicidade = Periodicidade.SEMANAL;

		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, periodicidade);

		Assert.assertEquals(2, sessoes.size());
		DateTime dateTime = inicio.toDateTime(horario);
		String hora = dateTime.toString(DateTimeFormat.shortTime().withLocale(new Locale("pt", "BR")));

		Assert.assertEquals(01, sessoes.get(0).getInicio().getDayOfMonth());
		Assert.assertEquals(hora, sessoes.get(0).getHora());

		Assert.assertEquals(8, sessoes.get(1).getInicio().getDayOfMonth());
		Assert.assertEquals(hora, sessoes.get(1).getHora());
	}
	
	@Test
	public void deveCriarMultiplasSessaoComPeriodicidadeSemanal() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		espetaculo.setNome("um nome");
		espetaculo.setDescricao("uma descricao");

		LocalDate inicio = new LocalDate(2012, 03, 01);
		LocalDate fim = new LocalDate(2012, 03, 29);
		LocalTime horario = new LocalTime(20, 10, 5);
		Periodicidade periodicidade = Periodicidade.SEMANAL;

		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, periodicidade);

		Assert.assertEquals(5, sessoes.size());
		DateTime dateTime = inicio.toDateTime(horario);
		String hora = dateTime.toString(DateTimeFormat.shortTime().withLocale(new Locale("pt", "BR")));

		int day, pos;
		for (day = 1, pos = 0; day <= 29; day += 7, pos++) {
			Assert.assertEquals(day, sessoes.get(pos).getInicio().getDayOfMonth());
			Assert.assertEquals(hora, sessoes.get(pos).getHora());
		}		
	}
	
}
