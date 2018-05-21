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
//Creamos 2 obejtos para usar los metodos CRUDS
        Departamentos deps=new Departamentos();
        Empleados emps=new Empleados();
        
    
        
       //Creamos un swtich para los 8 casos
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Elige una de los 8 casos");
            
            System.out.println("1º Listar el numero del departamento");
             System.out.println("2º Listar el numero del empleado");

             System.out.println("3º Buscar empleado por apellido");

            System.out.println("4º Buscar departamento por nombre");

                System.out.println("5º Crear Empleado");

                System.out.println("6º Crear Departamento");

              System.out.println("7º Borrar Empleado");

            System.out.println("8º Borrar departamento");

            int opcion;
            opcion = sc.nextInt();
            
            switch(opcion){
                case 1:
                    //Listar departamentos
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
                break;
                case 3:
                    //Buscar Empleado por nombre
                    
                    System.out.println("Introduce el apellido del empleado");
                  String apellido= sc.next();
                     emp = emps.ReadNombre(apellido);
                     System.out.printf(" %d, %s %n %s %d %s %f %f %d %n ",
                        emp.getEmp_no(), emp.getApellido(), emp.getOficio(),emp.getDir(),emp.getFecha_Alt(),emp.getSalario(),emp.getComision(),emp.getDept_no());
                    

                    
                 break;
                 
                case 4:
                    
                    //Buscar departamento por nombre
                      System.out.println("Introduce el nombre del departamento");
                   String dnombre= sc.next();
                     dep = deps.ReadNombre(dnombre);
                     System.out.printf(
                        dep.getDept_no()+ " " +dep.getDnombre()+ " " +dep.getLoc()+ "\n");
                    
                    
                    
                    break;
                    
                case 5:
                    //Crear empleado
                    System.out.println("Introduce el apellido");     apellido=sc.next();
                   
              System.out.println("Introduce el numero de empleado");   int Emp_no=sc.nextInt();
               System.out.println("Introduce el oficio");  String oficio=sc.next();
                System.out.println("Introduce el dir"); int dir=sc.nextInt();
                System.out.println("Introduce la fecha, debe seguirn el siguiente Formato: ej. '1990-02-20' "); String fecha=sc.next();
               System.out.println("Introduce el salario");  float salario=sc.nextFloat();
              System.out.println("Introduce la comision");   float comision=sc.nextFloat();
               System.out.println("Introduce el numero de departamento");  dept_no=sc.nextInt();
               emp=new Empleado(Emp_no, apellido, oficio, dir, fecha, salario, comision, dept_no);
               emps.Create(emp);
                    break;
                    
                case 6:
                    //Crear departamento
                  
                    System.out.println("Introduce el departamento numero");
                    dept_no=sc.nextInt();
                    System.out.println("Introduceel nombre departamento");
                     dnombre=sc.next();
                    System.out.println("Introduce la localizacion del departamento"); 
                    String loc=sc.next();
                    
                    dep=new Departamento(dept_no, dnombre, loc);
                    deps.Create(dep);
                    break;
                    
                case 7:
                    //Borrar empleado
                      System.out.println("Introduce el apellido");     apellido=sc.next();
              System.out.println("Introduce el numero de empleado");    Emp_no=sc.nextInt();
               System.out.println("Introduce el oficio");   oficio=sc.next();
                System.out.println("Introduce el dir");  dir=sc.nextInt();
                System.out.println("Introduce la fecha, debe seguirn el siguiente Formato: ej. '1990-02-20' ");  fecha=sc.next();
               System.out.println("Introduce el salario");   salario=sc.nextFloat();
              System.out.println("Introduce la comision");    comision=sc.nextFloat();
               System.out.println("Introduce el numero de departamento");  dept_no=sc.nextInt();
               emp=new Empleado(Emp_no, apellido, oficio, dir, fecha, salario, comision, dept_no);
                    emps.Delete(Emp_no, emp); 
                    break;
                    
                    
                    
                    
                case 8:
                    //Borrar departamento
                   System.out.println("Introduce el departamento numero");
                    dept_no=sc.nextInt();
                    System.out.println("Introduce el nombre departamento");
                     dnombre=sc.next();
                    System.out.println("Introduce el departamento numero"); 
                     loc=sc.next();
                    
                    dep=new Departamento(dept_no, dnombre, loc);
                    deps.Delete(dep, dept_no);
                    break;
                       
                
            }
            
            
           
      
        } catch (SQLException ex) {
            Logger.getLogger(BaseEjemplo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
