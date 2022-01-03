/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.logic;

import com.mycompany.sise.dao.IProductoDAO;
import com.mycompany.sise.dao.mysql.MySqlDAOManager;
import com.mycompany.sise.entity.Producto;
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
public class ProductoLogic {
    
    MySqlDAOManager factory = MySqlDAOManager.getInstancia();
    IProductoDAO dao = factory.getProductoDAO();
    
    public DefaultTableModel obtenerTodos() throws Exception{
        DefaultTableModel modelo = getModelo();
        List<Producto> lista = dao.obtenerTodos();
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
    
    private void llenarModelo(List<Producto> lista, DefaultTableModel modelo){
        
        for(Producto obj : lista){
            Object data[] = {
                obj.getId_producto(),
                obj.getId_Cat(),
                obj.getModelo(),
                obj.getTalla(),
                obj.getColor(),
                obj.getPrecio(),
                obj.getImagen(),
                obj.getDes_categoria()
            };
            modelo.addRow(data);
        }
    }
    
    public void insertar(Producto o) throws Exception{
        dao.insertar(o);
    }
    
    public void modificar(Producto o) throws Exception{
        dao.modificar(o);
    }
    
    public void eliminar(Producto o) throws Exception{
        dao.eliminar(o);
    }
    
    public DefaultTableModel busqueda(String valor) throws Exception{
        DefaultTableModel modelo = getModelo();
        List<Producto> lista = dao.busqueda(valor);
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
        List<Producto> lista = dao.paginacion(inicio, fin);
        llenarModelo(lista, modelo);
        
        return modelo;
    }
    
    public Integer cantidadRegistros() throws Exception {
        return dao.cantidadRegistros();
    }
    
    public void imprimirCB(JComboBox jComboBox) throws Exception{
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        List<Producto> lista = dao.obtenerTodos();
        for(Producto o :lista){
            modelo.addElement(o);
        }
        jComboBox.setModel(modelo);
    }
    
    public void selectItemByIDCombo(JComboBox jComboBox, int id_prod) throws Exception {
        
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)jComboBox.getModel();
        Producto obj;
        for(int i=0; i<modelo.getSize();i++){
            obj = (Producto)modelo.getElementAt(i);
            if(obj.getId_producto()==id_prod){
                modelo.setSelectedItem(obj);
                break;
            }    
        }
    }
    
    public void imprimirReporte(HashMap parametros) throws Exception{
        JasperReport reporte;
        String ruta = "D:\\Reportes Proyecto\\ReporteProductoF.jasper";
        
        reporte= (JasperReport)JRLoader.loadObjectFromFile(ruta);
        
        parametros.put("dsProducto", new JRBeanCollectionDataSource(dao.obtenerTodos()));
        
        JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, 
                new JRBeanCollectionDataSource(dao.obtenerTodos()));
        
        JasperViewer viewer = new JasperViewer(jprint,false);
        viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        viewer.setVisible(true);
    }
    
    
    public DefaultComboBoxModel getListaProducto(String filtro) throws Exception{
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        List<Producto> lista = dao.obtenerTodos();
        
        for(Producto s:lista){
            if(s.getModelo().contains(filtro)){
                modelo.addElement(s);
            }
        }
        return modelo;
    }
    
}
