package br.com.caelum.jdbc.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {
	Connection conn;
	
	public ContatoDao(){
		this.conn = new ConnectionFactory().getconnection();
	}
	public ContatoDao(Connection connection) {
		this.conn = connection;
	}
	
	public boolean adiciona(Contato contato) {
		try {
			
			String sql = "insert into Contatos " + 
						"(nome, email, endereco, dataNascimento)" +
						" values (?,?,?,?)";
						
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
			
			return true;
			
		} catch (SQLException e) {
			return false;
		}		
	}
	
	public boolean remove(Contato contato) {
		
		try {
			String sql = "delete from Contatos " + 
					"where id = ? ";
			
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			
			stmt.execute();
			stmt.close();
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
		
	}
	
	public List<Contato> getLista() {
		
		try {
			PreparedStatement stmt = this.conn.prepareStatement("select * from contatos");
			
			ResultSet rs = stmt.executeQuery();
			
			List<Contato> contatos = new ArrayList<>();
			
			while(rs.next()){
				
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();			
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				contatos.add(contato);			
			}
			
			rs.close();
			stmt.close();
			
			return contatos;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}
	
}
