/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.logic;

import com.mycompany.sise.dao.ITipoPagoDAO;
import com.mycompany.sise.dao.mysql.MySqlDAOManager;
import com.mycompany.sise.entity.TipoPago;
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
public class TipoPagoLogic {
    
    MySqlDAOManager factory = MySqlDAOManager.getInstancia();
    ITipoPagoDAO dao = factory.getTipoPagoDAO();
    
    public DefaultTableModel obtenerTodos() throws Exception{
        DefaultTableModel modelo = getModelo();
        List<TipoPago> lista = dao.obtenerTodos();
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
    
    private void llenarModelo(List<TipoPago> lista, DefaultTableModel modelo){
        
        for(TipoPago obj : lista){
            Object data[] = {
                obj.getId_tipo_pago(),
                obj.getNombre()
            };
            modelo.addRow(data);
        }
    }
    
    public void insertar(TipoPago o) throws Exception{
        dao.insertar(o);
    }
    
    public void modificar(TipoPago o) throws Exception{
        dao.modificar(o);
    }
    
    public void eliminar(TipoPago o) throws Exception{
        dao.eliminar(o);
    }
    
    public DefaultTableModel busqueda(String valor) throws Exception{
        DefaultTableModel modelo = getModelo();
        List<TipoPago> lista = dao.busqueda(valor);
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
        List<TipoPago> lista = dao.paginacion(inicio, fin);
        llenarModelo(lista, modelo);
        
        return modelo;
    }
    
    public Integer cantidadRegistros() throws Exception {
        return dao.cantidadRegistros();
    }
    
    public void imprimirCB(JComboBox jComboBox) throws Exception{
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        List<TipoPago> lista = dao.obtenerTodos();
        for(TipoPago o :lista){
            modelo.addElement(o);
        }
        jComboBox.setModel(modelo);
    }
    
    public void selectItemByIDCombo(JComboBox jComboBox, int id_pago) throws Exception {
        
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)jComboBox.getModel();
        TipoPago obj;
        for(int i=0; i<modelo.getSize();i++){
            obj = (TipoPago)modelo.getElementAt(i);
            if(obj.getId_tipo_pago()==id_pago){
                modelo.setSelectedItem(obj);
                break;
            }    
        }
    }
    
    
    public DefaultComboBoxModel getListaPago(String filtro) throws Exception{
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        List<TipoPago> lista = dao.obtenerTodos();
        
        for(TipoPago p:lista){
            if(p.getNombre().contains(filtro)){
                modelo.addElement(p);
            }
        }
        return modelo;
    }
    
}
