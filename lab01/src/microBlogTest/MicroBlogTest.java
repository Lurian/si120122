package microBlogTest;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import microBlog.LinhaDoTempo;
import microBlog.MicroBlog;
import microBlogException.FormatoDeLinkIncorretoException;
import microBlogException.NaoHouvePostagemAindaException;
import microBlogUtil.Tempo;

import org.junit.Before;
import org.junit.Test;

public class MicroBlogTest {

	private MicroBlog microBlog;
	
	@Before
	public void setUp(){
		microBlog = new MicroBlog();
	}

	@Test
	public void postaLinkTest() throws FormatoDeLinkIncorretoException, NaoHouvePostagemAindaException {
		microBlog.postaLink("http://www.youtube.com.br/meuvideo");
		assertEquals("http://www.youtube.com.br/meuvideo", microBlog.getLinkUltimaPostagem());

		microBlog.postaLink("https://docs.google.com/document/d/1d9n15za");
		assertEquals("https://docs.google.com/document/d/1d9n15za", microBlog.getLinkUltimaPostagem());

		microBlog.postaLink("https://google.com.br");
		assertEquals("https://google.com.br", microBlog.getLinkUltimaPostagem());	
	}
	
	@Test
	public void postaLinkFailureTest(){
		try {
			microBlog.postaLink("O link ta aki galera: https://www.youtube.com.br/meuvideo");
			fail("An exception should have been thrown");
		} catch (FormatoDeLinkIncorretoException e){ /* An exception should be caught */ }

		try {
			microBlog.postaLink("http://www.youtube.com.br/meuvideo se liguem no video!");
			fail("An exception should have been thrown");
		} catch (FormatoDeLinkIncorretoException e){ /* An exception should be caught */ }

		try {
			microBlog.postaLink("Doc: https://docs.google.com/document/d/1ag35a");
			fail("An exception should have been thrown");
		} catch (FormatoDeLinkIncorretoException e){ /* An exception should be caught */ }

		try {
			microBlog.postaLink("https://docs.google.com/document/d/1ag35a Muito massa xD");
			fail("An exception should have been thrown");
		} catch (FormatoDeLinkIncorretoException e){ /* An exception should be caught */ }
	}

	@Test
	public void horaDaPostagemTest() throws FormatoDeLinkIncorretoException, NaoHouvePostagemAindaException{
		microBlog.postaLink("http://www.youtube.com.br/meuvideo");
		int hora = GregorianCalendar.getInstance().get(GregorianCalendar.HOUR_OF_DAY);
		int minuto = GregorianCalendar.getInstance().get(GregorianCalendar.MINUTE);
		int dia = GregorianCalendar.getInstance().get(GregorianCalendar.DAY_OF_MONTH);
		int mes = GregorianCalendar.getInstance().get(GregorianCalendar.MONTH);
		int ano = GregorianCalendar.getInstance().get(GregorianCalendar.YEAR);

		assertEquals(hora, microBlog.getHoraUltimaPostagem());
		assertEquals(minuto, microBlog.getMinutoUltimaPostagem());
		assertEquals(dia, microBlog.getDiaUltimaPostagem());
		assertEquals(mes, microBlog.getMesUltimaPostagem());
		assertEquals(ano, microBlog.getAnoUltimaPostagem());
	}
	@Test
	public void siteMaisVisitadoeTest() throws FormatoDeLinkIncorretoException, NaoHouvePostagemAindaException{

		microBlog.postaLink("http://pt.wikipedia.org/wiki/Eficacia");
		microBlog.postaLink("http://pt.wikipedia.org/wiki/BPM");

		assertEquals("pt.wikipedia.org", microBlog.getSiteMaisPostado());

		microBlog.postaLink("https://www.google.com.br/#gukdle4ffsr+lasfratoriosadhrnsoRHem+tempos+de+prova.1355534169,d.eWU&fp=8fdb");		
		microBlog.postaLink("https://www.google.com.br/#joag+apr235er+JSF43a5ijsnho+esrtjaher+dk,dgova.1355534169,d.eWU&fp=8fdb");			
		microBlog.postaLink("https://www.google.com.br/#3oag+sab32+o+q43jg+jsg+hd+sjfposdfhaprjvaSDG555dhtsa,d.eWU&fp=8fdb");		
		microBlog.postaLink("https://www.google.com.br/#Csjo+apro23dfar+S+n34al+em+temfjs+de+prk7a.sj55534169,d.eWUYFDRYfdb");					
		microBlog.postaLink("https://www.google.com.br/#34yo+esc23ver+mens3gens+sublijsgjres34sdUnit.1355534169,d.eWU&fp=8fdb");		

		assertEquals("www.google.com.br", microBlog.getSiteMaisPostado());

		microBlog.postaLink("http://www.youtube.com.br/gqagg33ga");
		microBlog.postaLink("http://www.youtube.com.br/u89318h0f0h");
		microBlog.postaLink("http://www.youtube.com.br/i9d3/a822");

		assertEquals("www.google.com.br", microBlog.getSiteMaisPostado());

		microBlog.postaLink("http://www.youtube.com.br/45sg4g");
		microBlog.postaLink("http://www.youtube.com.br/aas/18h0f0h");
		microBlog.postaLink("http://www.youtube.com.br/4g3/a822");

		assertEquals("www.youtube.com.br", microBlog.getSiteMaisPostado());
	}
	
	@Test
	public void tempoMedioEntrePostangesTest() throws FormatoDeLinkIncorretoException{
		
		microBlog.postaLink("http://pt.wikipedia.org/wiki/Eficacia");
		microBlog.postaLink("http://pt.wikipedia.org/wiki/BPM");
		microBlog.postaLink("https://www.google.com.br/#gukdle4ffsr+lasfratoriosadhrnsoRHem+tempos+de+prova.1355534169,d.eWU&fp=8fdb");		
		microBlog.postaLink("https://www.google.com.br/#joag+apr235er+JSF43a5ijsnho+esrtjaher+dk,dgova.1355534169,d.eWU&fp=8fdb");			
		microBlog.postaLink("https://www.google.com.br/#3oag+sab32+o+q43jg+jsg+hd+sjfposdfhaprjvaSDG555dhtsa,d.eWU&fp=8fdb");		
		microBlog.postaLink("https://www.google.com.br/#Csjo+apro23dfar+S+n34al+em+temfjs+de+prk7a.sj55534169,d.eWUYFDRYfdb");					
		microBlog.postaLink("https://www.google.com.br/#34yo+esc23ver+mens3gens+sublijsgjres34sdUnit.1355534169,d.eWU&fp=8fdb");		
		microBlog.postaLink("http://www.youtube.com.br/gqagg33ga");
		microBlog.postaLink("http://www.youtube.com.br/u89318h0f0h");
		microBlog.postaLink("http://www.youtube.com.br/i9d3/a822");
		microBlog.postaLink("http://www.youtube.com.br/45sg4g");
		microBlog.postaLink("http://www.youtube.com.br/aas/18h0f0h");
		microBlog.postaLink("http://www.youtube.com.br/4g3/a822");
		
		microBlog.getPostagensRecentes();
		
	}

	@Test
	public void tempoMedioEntrePostagensTest() throws NaoHouvePostagemAindaException, FormatoDeLinkIncorretoException{
		LinhaDoTempo linhaDoTempo = new LinhaDoTempo();
		
		linhaDoTempo.addPostagem("http://www.youtube.com.br", new Tempo(new GregorianCalendar(2012, 12, 19, 14, 42)));
		
		linhaDoTempo.addPostagem("http://www.youtube.com.br", new Tempo(new GregorianCalendar(2012, 12, 19, 14, 59)));
			
		assertEquals("17 Minutos", linhaDoTempo.getTempoMedioEntrePostagens());
		
		linhaDoTempo.addPostagem("http://www.youtube.com.br", new Tempo(new GregorianCalendar(2012, 12, 19, 17, 34)));
	
		assertEquals("1 Hora", linhaDoTempo.getTempoMedioEntrePostagens());
		
		linhaDoTempo.addPostagem("http://www.youtube.com.br", new Tempo(new GregorianCalendar(2012, 12, 20, 12, 9)));
		
		assertEquals("7 Horas", linhaDoTempo.getTempoMedioEntrePostagens());
			
		linhaDoTempo.addPostagem("http://www.youtube.com.br", new Tempo(new GregorianCalendar(2012, 12, 21, 0, 0)));
		
		assertEquals("8 Horas", linhaDoTempo.getTempoMedioEntrePostagens());
	}
}
