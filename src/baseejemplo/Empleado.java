/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseejemplo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario 1 DAM
 */
public class Empleado {

    private int emp_no;
    private String apellido;
    private String oficio;
    private int dir;
    private Date fecha_Alt;
    private float salario;
    private float comision;
    private int dept_no;

    public Empleado() {
    }

    public Empleado(int emp_no, String apellido, String oficio, int dir, String fecha_Alt, float salario, float comision, int dept_no) {
        this.emp_no = emp_no;
        this.apellido = apellido;
        this.oficio = oficio;
        this.dir = dir;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.fecha_Alt = format.parse(fecha_Alt);
        } catch (ParseException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.salario = salario;
        this.comision = comision;
        this.dept_no = dept_no;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public java.util.Date getFecha_Alt() {
        return fecha_Alt;
    }
    
    public java.sql.Date getFechaSql(){
    
        return new java.sql.Date(fecha_Alt.getTime());
    
    
    }
    
    
    
    

    public void setFecha_Alt(Date fecha_Alt) {
        this.fecha_Alt = fecha_Alt;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }
  
    


}
