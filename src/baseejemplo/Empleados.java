/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseejemplo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Usuario 1 DAM
 */
public class Empleados {
   
    private Connection conexion;
    private ArrayList<Empleado> empleados;  
    PreparedStatement sentencia = null;    
    public Empleados() {
      try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }      
   public int Create(Empleado emp) throws SQLException {
        int filas;
        String sql = "INSERT INTO empleados VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, emp.getEmp_no());
        sentencia.setString(2, emp.getApellido());
        sentencia.setString(3, emp.getOficio());
        sentencia.setInt(4, emp.getDir());
        sentencia.setDate(5, emp.getFechaSql());
        sentencia.setFloat(6, emp.getSalario());
        sentencia.setFloat(7, emp.getComision());
        sentencia.setInt(8, emp.getDept_no());
        filas = sentencia.executeUpdate();
        return filas;
    }         
       public int Update(int emp_no, Empleado emp) throws SQLException {
        int flias;

        String sql = "Update empleados set apellidos = '" + emp.getApellido()+ "', oficio= '"+ emp.getOficio()+ "', dir= '" +emp.getDir()+"'fecha'"+emp.getFecha_Alt()+"'salario'"+emp.getSalario()+"'comision'"+ emp.getComision()+"' Empleado '"+ emp.getEmp_no()+ "' where emp_no = '" + emp.getEmp_no() +"';";
        Statement sentencia = conexion.createStatement();
        flias = sentencia.executeUpdate(sql);
        return flias;

    }

     
       
      public void Delete(int emp_no, Empleado emp) throws SQLException {
        
      
        String sql = "Delete from Empleados WHERE emp_no= 9";
        Statement sentencia = conexion.createStatement();
       
      sentencia.execute(sql);
      
    }
      
      
      
    public Empleado ReadNum(int emp_no) throws SQLException {

       Empleado emp = null;

       String sql = "select * from empleados where emp_no = " + emp_no;
       sentencia = conexion.prepareStatement(sql);
       sentencia.execute(sql);

        ResultSet rs = sentencia.getResultSet();
       while (rs.next()) {
           emp = new Empleado(rs.getInt("emp_no"), rs.getString("Apellido"), rs.getString("oficio"), rs.getInt("dir"), rs.getDate("fecha_alt").toString(), rs.getFloat("salario"), rs.getFloat("comision"), rs.getInt("dept_no"));
       }
       rs.close();

       sentencia.close();
       return emp;


   }
     public Empleado ReadNombre(String apellido) throws SQLException {

       String sql = "select * from empleados where apellido = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, apellido);

        sentencia.execute();
        ResultSet rs = sentencia.getResultSet();
       Empleado emp=new Empleado();
        while (rs.next()) {
            emp = new Empleado(rs.getInt("emp_no"), rs.getString("Apellido"), rs.getString("oficio"), rs.getInt("dir"), rs.getDate("fecha_alt").toString(), rs.getFloat("salario"), rs.getFloat("comision"), rs.getInt("dept_no"));
        }
        return emp;

   }
}
