/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.logic;

import com.mycompany.sise.dao.IPersonaDAO;
import com.mycompany.sise.dao.mysql.MySqlDAOManager;
import com.mycompany.sise.entity.Persona;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jennifer
 */
public class PersonaLogic {
    
    MySqlDAOManager factory = MySqlDAOManager.getInstancia();
    IPersonaDAO dao = factory.getPersonaDAO();
    
    public DefaultTableModel obtenerTodos() throws Exception{
        DefaultTableModel modelo = getModelo();
        List<Persona> lista = dao.obtenerTodos();
        llenarModelo(lista, modelo);
        return modelo;
    }
    
    private DefaultTableModel getModelo() throws Exception{
        DefaultTableModel modelo = new DefaultTableModel();
        List<String> listaColumnas = dao.obtenerNombresColumnas();
        
            for(String columna:listaColumnas){
            modelo.addColumn(columna.replace('_', ' ').toUpperCase());
            }
        return modelo;
    }
    
    private void llenarModelo(List<Persona> lista, DefaultTableModel modelo){
        
        for(Persona obj : lista){
            Object data[] = {
                obj.getId_persona(),
                obj.getNombre(),
                obj.getApellidos(),
                obj.getDoc_identidad(),
                obj.getDireccion(),
                obj.getEdad()
            };
            modelo.addRow(data);
        }
    }
    
    public void insertar(Persona o) throws Exception{
        dao.insertar(o);
    }
    
    public void modificar(Persona o) throws Exception{
        dao.modificar(o);
    }
    
    public void eliminar(Persona o) throws Exception{
        dao.eliminar(o);
    }
    
    public DefaultTableModel busqueda(String valor) throws Exception{
        DefaultTableModel modelo = getModelo();
        List<Persona> lista = dao.busqueda(valor);
        llenarModelo(lista, modelo);
         
        return modelo;
    }
    
    
    public void imprimirTable(JTable jTable) throws Exception{
        jTable.setModel(obtenerTodos());
    }
    
    public void imprimirTable(JTable jTable, DefaultTableModel modelo) throws Exception{
        jTable.setModel(modelo);
    }
    
    public DefaultTableModel paginacion(Integer inicio, Integer fin) throws Exception {
        DefaultTableModel modelo = getModelo();
        List<Persona> lista = dao.paginacion(inicio, fin);
        llenarModelo(lista, modelo);
        
        return modelo;
    }
    
    public Integer cantidadRegistros() throws Exception {
        return dao.cantidadRegistros();
    }
    
    public void imprimirCB(JComboBox jComboBox) throws Exception{
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        List<Persona> lista = dao.obtenerTodos();
        for(Persona o :lista){
            modelo.addElement(o);
        }
        jComboBox.setModel(modelo);
    }
    
    public void selectItemByIDCombo(JComboBox jComboBox, int id_persona) throws Exception {
        
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)jComboBox.getModel();
        Persona obj;
        for(int i=0; i<modelo.getSize();i++){
            obj = (Persona)modelo.getElementAt(i);
            if(obj.getId_persona()==id_persona){
                modelo.setSelectedItem(obj);
                break;
            }    
        }
    }
    
    public void imprimirReporte(HashMap parametros) throws Exception{
        JasperReport reporte;
        String ruta = "D:\\Reportes Proyecto\\ReportePersona.jasper";
        
        reporte= (JasperReport)JRLoader.loadObjectFromFile(ruta);
        
        parametros.put("dsPersona", new JRBeanCollectionDataSource(dao.obtenerTodos()));
        
        JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, 
                new JRBeanCollectionDataSource(dao.obtenerTodos()));
        
        JasperViewer viewer = new JasperViewer(jprint,false);
        viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        viewer.setVisible(true);
    }
    
    public Integer validador(String dni) throws Exception{
       return dao.validador(dni);
    }
    
    public DefaultComboBoxModel getListaPersona(String filtro) throws Exception{
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        List<Persona> lista = dao.obtenerTodos();
        
        for(Persona p:lista){
            if(p.getNombre().contains(filtro) || p.getApellidos().contains(filtro)){
                modelo.addElement(p);
            }
        }
        return modelo;
    }
    
}
