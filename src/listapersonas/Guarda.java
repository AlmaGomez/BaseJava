/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listapersonas;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author AlmaGomez
 */

public class Guarda{
            
        public void guardaBase(String nombree, String appp, String apmm, String escuelaa) 
            throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
            Connection con=null;
            Statement sta=null;
            int registros=0;
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con= DriverManager.getConnection("jdbc:mysql://localhost/guardarDatos","root", "n0m3l0");
                sta=con.createStatement();
            }
            catch(SQLException error){
                System.out.println(error.toString());
            }
            try {
                registros=sta.executeUpdate("select count(*) from datos);");
            }
            catch(SQLException error){
                System.out.println(error.toString());
            }
            try {
                sta.executeUpdate("Insert into datos values("+registros+",'"+nombree+"','"+appp+"','"+apmm+"','"+escuelaa+"');");
                con.close();
                System.out.println("Registro exitoso");
            }
            catch(SQLException error){
                System.out.println(error.toString());
                con.close();
            }
    }
}
