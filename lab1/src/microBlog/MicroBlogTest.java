package microBlog;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class MicroBlogTest {

	private MicroBlog microBlog;
	
	@Before
	public void setUp(){
		microBlog = new MicroBlog();
	}

	@Test
	public void postaLinkTest() throws FormatodeLinkIncorretoException {
		microBlog.postaLink("http://www.youtube.com.br/meuvideo");
		assertEquals("http://www.youtube.com.br/meuvideo", microBlog.ultimaPostagem());

		microBlog.postaLink("https://docs.google.com/document/d/1d9n15za");
		assertEquals("https://docs.google.com/document/d/1d9n15za", microBlog.ultimaPostagem());

		microBlog.postaLink("https://google.com.br");
		assertEquals("https://google.com.br", microBlog.ultimaPostagem());	
	}
	
	@Test
	public void postaLinkFailureTest(){
		try {
			microBlog.postaLink("O link ta aki galera: https://www.youtube.com.br/meuvideo");
			fail("An exception should have been thrown");
		} catch (FormatodeLinkIncorretoException e){ /* An exception should be caught */ }

		try {
			microBlog.postaLink("http://www.youtube.com.br/meuvideo se liguem no video!");
			fail("An exception should have been thrown");
		} catch (FormatodeLinkIncorretoException e){ /* An exception should be caught */ }

		try {
			microBlog.postaLink("Doc: https://docs.google.com/document/d/1ag35a");
			fail("An exception should have been thrown");
		} catch (FormatodeLinkIncorretoException e){ /* An exception should be caught */ }

		try {
			microBlog.postaLink("https://docs.google.com/document/d/1ag35a Muito massa xD");
			fail("An exception should have been thrown");
		} catch (FormatodeLinkIncorretoException e){ /* An exception should be caught */ }
	}
	
//	@Test
//	public void informacoesDaPostagemTest() throws FormatodeLinkIncorretoException{
//		microBlog.postaLink("http://www.youtube.com.br/meuvideo");
//		int hora = GregorianCalendar.HOUR;
//		int minuto = GregorianCalendar.MINUTE;
//		int dia = GregorianCalendar.DAY_OF_MONTH;
//		int mes = GregorianCalendar.MONTH;
//		int ano = GregorianCalendar.YEAR;
//		
//		assertEquals(hora, microBlog.getHoraUltimaPostagem());
//		assertEquals(minuto, microBlog.getMinutoUltimaPostagem());
//		assertEquals(dia, microBlog.getDiaUltimaPostagem());
//		assertEquals(mes, microBlog.getMesUltimaPostagem());
//		assertEquals(ano, microBlog.getAnoUltimaPostagem());
//
//
//		microBlog.postaLink("https://docs.google.com/document/d/1d9n15za");
//		
//
//		microBlog.postaLink("https://google.com.br");
//
//	}

}
