/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.logic;

import com.mycompany.sise.dao.IInventarioDAO;
import com.mycompany.sise.dao.mysql.MySqlDAOManager;
import com.mycompany.sise.entity.Inventario;
import com.mycompany.sise.util.Helper;
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
public class InventarioLogic {
    
    MySqlDAOManager factory = MySqlDAOManager.getInstancia();
    IInventarioDAO dao = factory.getInventarioDAO();
    
     public DefaultTableModel obtenerTodos() throws Exception{
        DefaultTableModel modelo = getModelo();
        List<Inventario> lista = dao.obtenerTodos();
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
    
    private void llenarModelo(List<Inventario> lista, DefaultTableModel modelo){
        
        for(Inventario obj : lista){
            Object data[] = {
                obj.getId_sucursal(),
                obj.getId_producto(),
                obj.getStock(),
                obj.getNombre_sucursal(),
                obj.getModelo_Producto(),
                obj.getColor(),
                obj.getTalla()
            };
            modelo.addRow(data);
        }
    }
    
    public Helper insertarValidado(Inventario o){
        
        Helper oHelperDao = dao.insertarValidado(o);
        
        Helper oHelperLogic = new Helper(oHelperDao.getError(), oHelperDao.getMensajeUsuario());
       
        return oHelperLogic;
        
    }
    
    public void modificar(Inventario o) throws Exception{
        dao.modificar(o);
    }
    
    public void eliminar(Inventario o) throws Exception{
        dao.eliminar(o);
    }
    
    public DefaultTableModel busqueda(String valor) throws Exception{
        DefaultTableModel modelo = getModelo();
        List<Inventario> lista = dao.busqueda(valor);
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
        List<Inventario> lista = dao.paginacion(inicio, fin);
        llenarModelo(lista, modelo);
        
        return modelo;
    }
    
    public Integer cantidadRegistros() throws Exception {
        return dao.cantidadRegistros();
    }
    
    public void imprimirCB(JComboBox jComboBox) throws Exception{
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        List<Inventario> lista = dao.obtenerTodos();
        for(Inventario o :lista){
            modelo.addElement(o);
        }
        jComboBox.setModel(modelo);
    }
    
    
    public void imprimirReporte(HashMap parametros) throws Exception{
        JasperReport reporte;
        String ruta = "D:\\Reportes Proyecto\\ReporteInventario.jasper";
        
        reporte= (JasperReport)JRLoader.loadObjectFromFile(ruta);
        
        parametros.put("dsInventario", new JRBeanCollectionDataSource(dao.obtenerTodos()));
        
        JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, 
                new JRBeanCollectionDataSource(dao.obtenerTodos()));
        
        JasperViewer viewer = new JasperViewer(jprint,false);
        viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        viewer.setVisible(true);
    }
    
    
}
