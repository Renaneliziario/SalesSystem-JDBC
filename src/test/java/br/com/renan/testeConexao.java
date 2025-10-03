package br.com.renan;

import java.sql.Connection;

import br.com.renan.dao.generic.jdbc.ConnectionFactory;

public class testeConexao {
	public static void main(String [] args) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			System.out.println("Conexão estabelecida: " + !conn.isClosed());
		} catch (Exception e) {
			System.err.println("Erro ao conectar: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
