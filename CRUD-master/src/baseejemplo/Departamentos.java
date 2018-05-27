/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseejemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio
 */
public class Departamentos {

    private Connection conexion;
    private ArrayList<Departamento> departamentos;

    public Departamentos(Connection c) { 
    this.conexion = c;
      }

    public int Create(Departamento dep) throws SQLException {
        int filas;
        String sql = "INSERT INTO departamentos VALUES ( ?, ?, ? )";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, dep.getDept_no());
        sentencia.setString(2, dep.getDnombre());
        sentencia.setString(3, dep.getLoc());
        filas = sentencia.executeUpdate();
        
        return filas;
    }

    public int Update(int dep_no, Departamento dep) throws SQLException {

        int flias;

        String sql = "Update departamentos set loc = ? where dept_no=?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(2, dep.getDept_no());
        sentencia.setString(1, dep.getLoc());
        flias = sentencia.executeUpdate();
        return flias;

    }

    public Departamento Read(int dept_no) throws SQLException {

        String sql = "select * from departamentos where dept_no=?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, dept_no);

        sentencia.execute();
        ResultSet rs = sentencia.getResultSet();
        Departamento dep = null;
        while (rs.next()) {
            dep = new Departamento(rs.getInt("dept_no"), rs.getString("dnombre"), rs.getNString("loc"));
        }
        return dep;
    }

    public void Delete(Departamento dep,int dept_no) throws SQLException {

        String sql = "Delete from Departamentos WHERE dept_no= ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1 , dept_no);
        sentencia.executeUpdate();

    }
 public Departamento ReadNombre(String dnombre) throws SQLException {

        String sql = "select * from departamentos where dnombre = ?";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, dnombre);

        sentencia.execute();
        ResultSet rs = sentencia.getResultSet();
       Departamento dep=new Departamento();
        while (rs.next()) {
            dep = new Departamento(rs.getInt("dept_no"), rs.getString("dnombre"), rs.getNString("loc"));
        }
        return dep;
    }
       public List<Departamento> ReadTodos() throws SQLException {

        String sql = "select * from departamentos";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
     

        sentencia.execute();
        ResultSet rs = sentencia.getResultSet();
        List<Departamento> dep = new ArrayList();
        while (rs.next()) {
            dep.add(new Departamento(rs.getInt("dept_no"), rs.getString("dnombre"), rs.getNString("loc")));
        }
        return dep;
    }
    
}
