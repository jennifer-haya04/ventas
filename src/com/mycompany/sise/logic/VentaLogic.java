/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.logic;

import com.mycompany.sise.dao.IDetalleVentaDAO;
import com.mycompany.sise.dao.IVentaDAO;
import com.mycompany.sise.dao.mysql.MySqlDAOManager;
import com.mycompany.sise.entity.DetalleVenta;
import com.mycompany.sise.entity.Venta;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
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
public class VentaLogic {
    
    MySqlDAOManager factory = MySqlDAOManager.getInstancia();
    IVentaDAO dao = factory.getVentaDAO();
    IDetalleVentaDAO daoDetalle = factory.getDetalleVentaDAO();
    //Tabla Unica 
    DefaultTableModel modeloProducto = null;
    //Para asignar el Id al detalle Venta
    int currentIdVenta;

    public DefaultTableModel getModeloProducto() {
        return modeloProducto;
    }

    public void setModeloProducto(DefaultTableModel modeloProducto) {
        this.modeloProducto = modeloProducto;
    }

    public int getCurrentIdVenta() {
        return currentIdVenta;
    }

    public void setCurrentIdVenta(int currentIdVenta) {
        this.currentIdVenta = currentIdVenta;
    }
    
//------------------------VENTA---------------------------------------------------
    
    public DefaultTableModel obtenerTodos() throws Exception{
        DefaultTableModel modelo = getModelo();
        List<Venta> lista = dao.obtenerTodos();
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
    
    private void llenarModelo(List<Venta> lista, DefaultTableModel modelo){
        
        for(Venta obj : lista){
            Object data[] = {
                obj.getId_venta(),
                obj.getId_persona(),
                obj.getId_tipo_doc(),
                obj.getId_tipo_pago(),
                obj.getId_sucursal(),
                obj.getFecha(),
                obj.getTotal_Desc(),
                obj.getTotal_Venta(),
                obj.getNombre(),
                obj.getApellidos(),
                obj.getDoc_venta(),
                obj.getTipo_pago(),
                obj.getSucursal()
            };
            modelo.addRow(data);
        }
    }
    
    
    public Integer insertarReturnId(Venta o) throws Exception{
        return dao.insertarReturnId(o);
    }
    
    public void eliminar(Venta o) throws Exception{
        dao.eliminar(o);
    }
    
    public DefaultTableModel busqueda(String valor) throws Exception{
        DefaultTableModel modelo = getModelo();
        List<Venta> lista = dao.busqueda(valor);
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
        List<Venta> lista = dao.paginacion(inicio, fin);
        llenarModelo(lista, modelo);
        
        return modelo;
    }
    
    public Integer cantidadRegistros() throws Exception {
        return dao.cantidadRegistros();
    }
    
    public void imprimirCB(JComboBox jComboBox) throws Exception{
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        List<Venta> lista = dao.obtenerTodos();
        for(Venta o :lista){
            modelo.addElement(o);
        }
        jComboBox.setModel(modelo);
    }
    
    
    public void imprimirReporte(HashMap parametros) throws Exception{
        JasperReport reporte;
        String ruta = "D:\\Reportes Proyecto\\ReporteVentas.jasper";
        
        reporte= (JasperReport)JRLoader.loadObjectFromFile(ruta);
        
        parametros.put("dsVentas", new JRBeanCollectionDataSource(dao.obtenerTodos()));
        
        JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, 
                new JRBeanCollectionDataSource(dao.obtenerTodos()));
        
        JasperViewer viewer = new JasperViewer(jprint,false);
        viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        viewer.setVisible(true);
    }
    
//Imprimir Reportes de Ventas con Filtro
    public void imprimirReporte(List<Venta> lista, HashMap parametros, int tipo) throws Exception{
        JasperReport reporte = null;
        String ruta;
        
        switch(tipo){
            case 1:
                ruta = "D:\\Reportes Proyecto\\ReporteSucursal2.jasper";
                reporte = (JasperReport)JRLoader.loadObjectFromFile(ruta);
                parametros.put("dsSucursal2", new JRBeanCollectionDataSource(lista)); 
                break;
            case 2:
                ruta = "D:\\Reportes Proyecto\\ReporteCliente2.jasper";
                reporte = (JasperReport)JRLoader.loadObjectFromFile(ruta);
                parametros.put("dsClientes2", new JRBeanCollectionDataSource(lista));
                break;
        }
           
        JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, 
                new JRBeanCollectionDataSource(lista));
        
        JasperViewer viewer = new JasperViewer(jprint,false);
        viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        viewer.setVisible(true);
    }
    
    
    // Metodos para Reporte por Filtro
    
    public List<Venta> obtenerReportexSuc(Integer id_suc) throws Exception{
        return dao.obtenerReportexSuc(id_suc);
    }
    
    public List<Venta> obtenerReportexCliente(Integer id_cliente) throws Exception{
        return dao.obtenerReportexCliente(id_cliente);
    }
    
    //Metodo para validar la Cantidad en Inventario antes de la Venta
    
    public int obtenerCantidadInventario(Integer id_producto, Integer id_sucursal) throws Exception{
        return dao.obtenerCantidadInventario(id_producto, id_sucursal);
    }
    
//------------------------------DETALLE VENTA-----------------------------------------------------------
    
    private void setModelDetalle(){
        if(getModeloProducto()==null){
            setModeloProducto(new DefaultTableModel());
             getModeloProducto().addColumn("ID PRODUCTO");
             getModeloProducto().addColumn("CANTIDAD");
             getModeloProducto().addColumn("TOTAL");
             getModeloProducto().addColumn("MODELO");
             getModeloProducto().addColumn("PRECIO");
             getModeloProducto().addColumn("DESCUENTO");
        }
    }
    
    public DefaultTableModel obtenerDetalle(Integer id_Venta) throws Exception{
        setModelDetalle();
                     
        List<DetalleVenta> lista = dao.obtenerDetalle(id_Venta);
        DetalleVenta objDetalle=null;
        
        for(int i = 0; i < lista.size();i++){
             objDetalle = lista.get(i);
             Object data[] ={
                 objDetalle.getId_producto(),
                 objDetalle.getCantidad(),
                 objDetalle.getTotal(),
                 objDetalle.getModelo(),
                 objDetalle.getPrecio(),
                 objDetalle.getDescuento()
             };
            getModeloProducto().addRow(data);
        }
        
        return getModeloProducto();
    }
     
    public DefaultTableModel agregarProducto(DetalleVenta objeto) throws Exception{
        setModelDetalle();       
        DetalleVenta objDetalle = objeto;
        
        Object data[] ={
            objDetalle.getId_producto(),
            objDetalle.getCantidad(),
            objDetalle.getTotal(),
            objDetalle.getModelo(),
            objDetalle.getPrecio(),
            objDetalle.getDescuento()
        };
        
        getModeloProducto().addRow(data);
        return getModeloProducto();
    }
    
    public Double obtenerDescuentoxProducto(Integer id_producto, LocalDate fecha_venta) throws Exception{
        return dao.obtenerDescuentoxProducto(id_producto, fecha_venta);
    }
    
    public void llenarTotales(JTextField txtDesc, JTextField txtTotal, DefaultTableModel modelo){
        
        double precio, desc, totalPrecio=0, totalDesc=0, total=0;
        
        for(int i=0; i<modelo.getRowCount();i++){
            precio = Double.parseDouble(modelo.getValueAt(i, 2)+"");
            if(precio>0) totalPrecio = totalPrecio + precio;
            desc = Double.parseDouble(modelo.getValueAt(i, 5)+"");
            if(desc>0) totalDesc = totalDesc + desc;
        }
        
        total = totalPrecio - totalDesc;
        
        txtDesc.setText(totalDesc+"");
        txtTotal.setText(total+"");
        
    }
     
    public Boolean productosBd(DefaultTableModel modelo) throws Exception{
       
        Boolean conforme = false;
        List<DetalleVenta> lista = new ArrayList<>();
        
        if(modelo != null){
           for(int i = 0; i < modelo.getRowCount(); i++){
               lista.add(new DetalleVenta(
                    getCurrentIdVenta(), 
                    Integer.parseInt(modelo.getValueAt(i, 0).toString()), 
                    Integer.parseInt(modelo.getValueAt(i, 1).toString()), 
                    Double.parseDouble(modelo.getValueAt(i, 2).toString())
               ));
           } 
        }
        
        int[] resultados = daoDetalle.cargarProductosBD(lista);
        
        if(resultados.equals(null)){
            conforme = false;
        }else {
            conforme = true;
        }
        
        return conforme; 
    }
    
    
    public void imprimirProducto(JTable jTable, DetalleVenta objeto) throws Exception{
        jTable.setModel(agregarProducto(objeto));
    }
    
    public void imprimirProductos(JTable jTable, Integer id_venta) throws Exception{
        jTable.setModel(obtenerDetalle(id_venta));
    }
    
}
