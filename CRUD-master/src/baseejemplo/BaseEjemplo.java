/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseejemplo;

import com.mysql.jdbc.CommunicationsException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario 1 DAM
 */
public class BaseEjemplo {

    static Connection conexionBBDD;

    /**
     * @param args the command line arguments
     */
    public static Connection getConnection() {
        try {
            String connectionURL = "jdbc:mysql://localhost:3306/ejemplo";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            if (conexionBBDD == null) {
                conexionBBDD = DriverManager.getConnection(connectionURL, "ejemplo", "ejemplo");
            }
        } catch (Exception e) {

            System.err.println("FALLO AL ABRIR LA CONEXION A LA BASE DE DATOS ");
        }
        return conexionBBDD;
    }

    public static void main(String[] args) {
//Creamos 2 obejtos para usar los metodos CRUDS

        while (true) {

            menu();

        }

    }

    public static void menu() {
        Departamentos deps = new Departamentos(BaseEjemplo.getConnection());
        Empleados emps = new Empleados(BaseEjemplo.getConnection());
        //Creamos un swtich para los 8 casos
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("----------------------------------");

            System.out.println("1º Listar todos los departamentos");
            System.out.println("2º Listar 1 departamento");
            System.out.println("3º Listar todos los empleados");
            System.out.println("4º Listar 1 empleado");
            System.out.println("5º Buscar empleado por apellido");

            System.out.println("6º Buscar departamento por nombre");

            System.out.println("7º Crear Empleado");

            System.out.println("8º Crear Departamento");

            System.out.println("9º Borrar Empleado");

            System.out.println("10º Borrar departamento");
            System.out.println("11º Cerrar Conexión");
            System.out.println("----------------------------------");

            int opcion;
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:

                    //Listar todos los departamentos
                    List<Departamento> dep = null;
                    dep = deps.ReadTodos();
                    if (dep == null) {

                        System.out.println("No se ha encontrado departamento");

                        break;
                    }
                    for (Departamento d : dep) {

                        System.out.printf(
                                d.getDept_no() + " " + d.getDnombre() + " " + d.getLoc() + "\n");
                    }
                    break;

                case 2:
                    //Listar 1 departamento
                    System.out.println("Listar 1 departamento");

                    System.out.println("Introduce el numero del departamento");
                    int dept_no = sc.nextInt();

                    Departamento depar = deps.Read(dept_no);
                    System.out.printf(
                            depar.getDept_no() + " " + depar.getDnombre() + " " + depar.getLoc() + "\n");

                    break;
                case 3:
                    //Listar todos los empleados
                    List<Empleado> emp = null;
                    emp = emps.ReadNumTodos();
                    if (emp == null) {

                        System.out.println("No se ha encontrado empleado");

                    }
                    for (Empleado e : emp) {

                        System.out.printf (
                               e.getEmp_no()+ " "+ e.getApellido()+ " " + e.getOficio()+ " " + e.getDir()+ " " + e.getFecha_Alt()+ " " + e.getSalario()+ " " + e.getComision()+ " " + e.getDept_no()+ "\n");
                    }
                    break;

                case 4:
                    //Listar 1 empleado
                    System.out.println("Introduce el numero del empleado");
                    int emp_no = sc.nextInt();
                  Empleado  emple = emps.ReadNum(emp_no);
                  if (emple == null){
                      System.out.println("No se ha encontrado empleado");
                  }
                  
                    System.out.printf(" %d, %s %n %s %d %s %f %f %d %n ",
                            emple.getEmp_no(), emple.getApellido(), emple.getOficio(), emple.getDir(), emple.getFecha_Alt(), emple.getSalario(), emple.getComision(), emple.getDept_no());

                    break;
                case 5:
                    //Buscar Empleado por nombre

                    System.out.println("Introduce el apellido del empleado");
                    String apellido = sc.next();
                    emple = emps.ReadNombre(apellido);
                    if (emple == null){
                        System.out.println("No se ha encontrado empleado");
                    }
                    
                    System.out.printf(" %d, %s %n %s %d %s %f %f %d %n ",
                            emple.getEmp_no(), emple.getApellido(), emple.getOficio(), emple.getDir(), emple.getFecha_Alt(), emple.getSalario(), emple.getComision(), emple.getDept_no());


                    break;
                case 6:

                    //Buscar departamento por nombre
                    System.out.println("Introduce el nombre del departamento");
                    String dnombre = sc.next();
                    depar = deps.ReadNombre(dnombre);
                      if (depar == null){
                        System.out.println("No se ha encontrado departamento");
                    }
                    
                    System.out.printf(
                            depar.getDept_no() + " " + depar.getDnombre() + " " + depar.getLoc() + "\n");


                    break;
                case 7:
                    //Crear empleado
                    System.out.println("Introduce el apellido");
                    apellido = sc.next();

                    System.out.println("Introduce el numero de empleado");
                    int Emp_no = sc.nextInt();
                    System.out.println("Introduce el oficio");
                    String oficio = sc.next();
                    System.out.println("Introduce el dir");
                    int dir = sc.nextInt();
                    System.out.println("Introduce la fecha, debe seguirn el siguiente Formato: ej. '1990-02-20' ");
                    String fecha = sc.next();
                    System.out.println("Introduce el salario");
                    float salario = sc.nextFloat();
                    System.out.println("Introduce la comision");
                    float comision = sc.nextFloat();
                    System.out.println("Introduce el numero de departamento");
                    dept_no = sc.nextInt();
                    emple = new Empleado(Emp_no, apellido, oficio, dir, fecha, salario, comision, dept_no);
                    emps.Create(emple);
                    System.out.println("Has creado con exito un empleado");
                    break;

                case 8:
                    //Crear departamento

                    System.out.println("Introduce el departamento numero");
                    dept_no = sc.nextInt();
                    System.out.println("Introduceel nombre departamento");
                    dnombre = sc.next();
                    System.out.println("Introduce la localizacion del departamento");
                    String loc = sc.next();

                    depar = new Departamento(dept_no, dnombre, loc);
                    deps.Create(depar);
                    System.out.println("Has creado con exito un departamento");

                    break;

                case 9:
                    //Borrar empleado
                    System.out.println("Introduce el apellido");
                    apellido = sc.next();
                    System.out.println("Introduce el numero de empleado");
                    Emp_no = sc.nextInt();
                    System.out.println("Introduce el oficio");
                    oficio = sc.next();
                    System.out.println("Introduce el dir");
                    dir = sc.nextInt();
                    System.out.println("Introduce la fecha, debe seguirn el siguiente Formato: ej. '1990-02-20' ");
                    fecha = sc.next();
                    System.out.println("Introduce el salario");
                    salario = sc.nextFloat();
                    System.out.println("Introduce la comision");
                    comision = sc.nextFloat();
                    System.out.println("Introduce el numero de departamento");
                    dept_no = sc.nextInt();
                    emple = new Empleado(Emp_no, apellido, oficio, dir, fecha, salario, comision, dept_no);
                    emps.Delete(Emp_no, emple);
                                        System.out.println("Has borrado con exito un empleado");


                    break;

                case 10:
                    //Borrar departamento
                    System.out.println("Introduce el departamento numero");
                    dept_no = sc.nextInt();
                    System.out.println("Introduce el nombre departamento");
                    dnombre = sc.next();
                    System.out.println("Introduce el departamento numero");
                    loc = sc.next();

                    depar = new Departamento(dept_no, dnombre, loc);
                    deps.Delete(depar, dept_no);
                                        System.out.println("Has borrado con exito un departamento");

                    break;

                case 11:
                    closeConnection();

            }

        } catch (CommunicationsException exp) {

            System.err.println("LA CONEXION HA FALLADO");
            Logger.getLogger(BaseEjemplo.class.getName()).log(Level.SEVERE, null, exp);

        } catch (SQLException ex) {
            System.err.println("Probablemente sea un error de sql o de resultado");
            Logger.getLogger(BaseEjemplo.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception ex) {
            System.err.println("Error desconocido");
            Logger.getLogger(BaseEjemplo.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    private static void closeConnection() {
        try {
            conexionBBDD.close();
            System.exit(0);
        } catch (SQLException ex) {
            System.err.println("Has cerrado la conexion");
            Logger.getLogger(BaseEjemplo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
