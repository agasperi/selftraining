package com.mitocode.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mitocode.beans.Marca;
import com.mitocode.dao.DAOMarca;

@Repository
public class DAOMarcaImpl implements DAOMarca {
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void registrar(Marca marca) throws Exception {
		String sql = "INSERT INTO marca(id,nombre) VALUES(?,?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, marca.getId());
			ps.setString(2, marca.getNombre());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			throw e;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}

}
