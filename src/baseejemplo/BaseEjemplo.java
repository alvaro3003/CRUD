/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseejemplo;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario 1 DAM
 */
public class BaseEjemplo {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {

        Departamentos deps=new Departamentos();
        Empleados emps=new Empleados();
        
    
        
       
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Elige una de los 8 casos");
            int opcion;
            opcion = sc.nextInt();
            
            switch(opcion){
                case 1:
                    //Listar departamentos
                  //  dep = deps.Read(10, dep);
                    System.out.println("Introduce el numero del departamento");
                   int dept_no= sc.nextInt();
                   Departamento dep= null;
                     dep = deps.Read(dept_no);
                     System.out.printf(
                        dep.getDept_no()+ " " +dep.getDnombre()+ " " +dep.getLoc()+ "\n");
                    break;
                case 2:
                    //Listar empleados
                    System.out.println("Introduce el numero del empleado");
                    Empleado emp=null;
                  int emp_no= sc.nextInt();
                     emp = emps.ReadNum(emp_no);
                     System.out.printf(" %d, %s %n %s %d %s %f %f %d %n ",
                        emp.getEmp_no(), emp.getApellido(), emp.getOficio(),emp.getDir(),emp.getFecha_Alt(),emp.getSalario(),emp.getComision(),emp.getDept_no());
                
                case 3:
                    //Buscar Empleado por nombre


                    
                 break;
                 
                case 4:
                    
                    //Buscar departamento por nombre
                    
                    
                    
                    
                    break;
                    
                case 5:
                    //Crear empleado
                    emp=null;
                    System.out.println("Introduce el apellido");      String apellido=sc.next();
              System.out.println("Introduce el numero de empresario");   int Emp_no=sc.nextInt();
               System.out.println("Introduce el oficio");  String oficio=sc.next();
                System.out.println("Introduce el dir"); int dir=sc.nextInt();
                System.out.println("Introduce la fecha"); String fecha=sc.next();
               System.out.println("Introduce el salario");  float salario=sc.nextFloat();
              System.out.println("Introduce la comision");   float comision=sc.nextFloat();
               System.out.println("Introduce el numero de departamento");  dept_no=sc.nextInt();
                 //   emp=new Empleado(Emp_no, apellido, oficio, dir, fecha_Alt, salario, comision, dept_no);
                    emps.Create(emp);
                    break;
                    
                case 6:
                    //Crear departamento
                  
                    System.out.println("Introduce el departamento numero"); dept_no=sc.nextInt();
                    System.out.println("Introduce el departamento numero"); String dnombre=sc.next();
                    System.out.println("Introduce el departamento numero"); String loc=sc.next();
                    
                    dep=new Departamento(dept_no, dnombre, loc);
                    deps.Create(dep);
                    break;
                    
                case 7:
                    //Borrar empleado
                    
                    break;
                    
                case 8:
                    //Borrar departamento
                  
                    break;
                       
                
            }
            
            
           
       //     emps.Create(emp);
         //   emp.setApellido("caarl");
           // emps.Update(69,emp);
            //emps.Read(69, emp);
            //emps.Delete(69,emp);
            
        } catch (SQLException ex) {
            Logger.getLogger(BaseEjemplo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
