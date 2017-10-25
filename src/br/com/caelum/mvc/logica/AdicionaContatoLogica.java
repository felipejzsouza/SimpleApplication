package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class AdicionaContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
					
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataEmTexto = req.getParameter("dataNascimento");
		
		if (nome == null || endereco == null || dataEmTexto == null)
			return "/WEB-INF/jsp/adiciona-contato.jsp";			
		
		Calendar dataNascimento = null;
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			throw e;
		}
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		Connection conn = (Connection)req.getAttribute("conexao");
		
		ContatoDao dao = new ContatoDao(conn);
		boolean cadastrado = dao.adiciona(contato);
		
		return "mvc?logica=ListaContatosLogica";		
	}

}
