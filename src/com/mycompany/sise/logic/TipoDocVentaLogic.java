/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.logic;

import com.mycompany.sise.dao.ITipoDocVentaDAO;
import com.mycompany.sise.dao.ITipoDocVentaDAO;
import com.mycompany.sise.dao.mysql.MySqlDAOManager;
import com.mycompany.sise.entity.TipoDocVenta;
import com.mycompany.sise.entity.TipoDocVenta;
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
public class TipoDocVentaLogic {
    
    MySqlDAOManager factory = MySqlDAOManager.getInstancia();
    ITipoDocVentaDAO dao = factory.getTipoDocVentaDAO();
    
    public DefaultTableModel obtenerTodos() throws Exception{
        DefaultTableModel modelo = getModelo();
        List<TipoDocVenta> lista = dao.obtenerTodos();
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
    
    private void llenarModelo(List<TipoDocVenta> lista, DefaultTableModel modelo){
        
        for(TipoDocVenta obj : lista){
            Object data[] = {
                obj.getId_tipo_doc(),
                obj.getNombre()
            };
            modelo.addRow(data);
        }
    }
    
    public void insertar(TipoDocVenta o) throws Exception{
        dao.insertar(o);
    }
    
    public void modificar(TipoDocVenta o) throws Exception{
        dao.modificar(o);
    }
    
    public void eliminar(TipoDocVenta o) throws Exception{
        dao.eliminar(o);
    }
    
    public DefaultTableModel busqueda(String valor) throws Exception{
        DefaultTableModel modelo = getModelo();
        List<TipoDocVenta> lista = dao.busqueda(valor);
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
        List<TipoDocVenta> lista = dao.paginacion(inicio, fin);
        llenarModelo(lista, modelo);
        
        return modelo;
    }
    
    public Integer cantidadRegistros() throws Exception {
        return dao.cantidadRegistros();
    }
    
    public void imprimirCB(JComboBox jComboBox) throws Exception{
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        List<TipoDocVenta> lista = dao.obtenerTodos();
        for(TipoDocVenta o :lista){
            modelo.addElement(o);
        }
        jComboBox.setModel(modelo);
    }
    
    public void selectItemByIDCombo(JComboBox jComboBox, int id_doc) throws Exception {
        
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)jComboBox.getModel();
        TipoDocVenta obj;
        for(int i=0; i<modelo.getSize();i++){
            obj = (TipoDocVenta)modelo.getElementAt(i);
            if(obj.getId_tipo_doc()==id_doc){
                modelo.setSelectedItem(obj);
                break;
            }    
        }
    }
    
    public DefaultComboBoxModel getListaDoc(String filtro) throws Exception{
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        List<TipoDocVenta> lista = dao.obtenerTodos();
        
        for(TipoDocVenta dv:lista){
            if(dv.getNombre().contains(filtro)){
                modelo.addElement(dv);
            }
        }
        return modelo;
    }
    
}
