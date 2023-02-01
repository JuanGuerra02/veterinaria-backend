package com.Softcaribean.Veterinaria.database;

import java.sql.Connection;

public class Managerconexion {

    private static Managerconexion instance;
    private Conexion conexion;

    private Managerconexion(){
        conexion= new Conexion();
    }

    public static  Managerconexion getInstance(){
        if (instance==null){
            instance=new Managerconexion();
        }
        return instance;
    }

    public void open(){
        conexion.connetc();
    }//abre la conexion

    public void commit(){ //El método  commit()  de la interfaz Connection guarda todas las modificaciones realizadas desde la última confirmación.
        try {
            conexion.getCon().commit();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void rollback(){//si ocurre un problema revierte todos los cambios realizados hasta este punto
        try {
            conexion.getCon().rollback();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void close(){//cierra la conexion
        try {
            conexion.getCon().close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {return  conexion.getCon();}//obtiene la conexion
}
