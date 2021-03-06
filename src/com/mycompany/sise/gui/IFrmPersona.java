/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.gui;


import com.mycompany.sise.entity.Persona;
import com.mycompany.sise.logic.PersonaLogic;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 *
 * @author jennifer
 */
public class IFrmPersona extends javax.swing.JInternalFrame {

    PersonaLogic logic = null;
    final ResourceBundle rb = ResourceBundle.getBundle("com.mycompany.sise.gui.mensajes");
    
    int pagina = 0;
    int contador = 0;
    int total = 0;
    
    public IFrmPersona() {
        initComponents();
        this.setTitle(rb.getString("titulo_persona"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDocId = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        btnNew2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLista = new javax.swing.JTable();
        btnIzquierda = new javax.swing.JButton();
        btnDerecha = new javax.swing.JButton();
        cboPaginacion = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnQr = new javax.swing.JButton();
        lblQr = new javax.swing.JLabel();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)), "DATOS"));

        jLabel1.setText("ID:");

        jLabel2.setText("NOMBRE:");

        jLabel3.setText("APELLIDOS:");

        jLabel5.setText("DOC IDENTIDAD:");

        jLabel6.setText("DIRECCION:");

        jLabel7.setText("EDAD:");

        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });

        btnNew2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/sise/gui/resources/new.png"))); // NOI18N
        btnNew2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNew2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(94, 94, 94)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDocId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNew2))
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnNew2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDocId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)), "BUSQUEDA"));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/sise/gui/resources/buscar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnBuscar)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        btnListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/sise/gui/resources/listar.png"))); // NOI18N
        btnListar.setText("LISTAR");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/sise/gui/resources/agregar.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/sise/gui/resources/modificar.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/sise/gui/resources/eliminar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/sise/gui/resources/imprimir (1).png"))); // NOI18N
        btnImprimir.setText("IMPRIMIR");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/sise/gui/resources/salir.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        tbLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbListaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbLista);

        btnIzquierda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/sise/gui/resources/izquierda (2).png"))); // NOI18N
        btnIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzquierdaActionPerformed(evt);
            }
        });

        btnDerecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/sise/gui/resources/derecha (2).png"))); // NOI18N
        btnDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDerechaActionPerformed(evt);
            }
        });

        cboPaginacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "2", "5", "10", "15" }));
        cboPaginacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPaginacionItemStateChanged(evt);
            }
        });

        jLabel4.setText("Reg. Pagina");

        btnQr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/sise/gui/resources/qr.png"))); // NOI18N
        btnQr.setText("QR");
        btnQr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQrActionPerformed(evt);
            }
        });

        lblQr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 204)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnIzquierda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDerecha)
                                .addGap(136, 136, 136)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cboPaginacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnImprimir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnQr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(11, 11, 11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDerecha)
                            .addComponent(btnIzquierda)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(cboPaginacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQr, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblQr, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        
        logic = new PersonaLogic();
        try {
            logic.imprimirTable(tbLista);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        logic = new PersonaLogic();
        Persona objPersona = getPersona();
        objPersona.setId_persona(0);
        
        try {
            if(logic.validador(txtDocId.getText())==1){
                JOptionPane.showMessageDialog(null, "El DNI ya existe en nuestra BD!");
            }else{
                logic.insertar(objPersona);
                JOptionPane.showMessageDialog(null, rb.getString("mensaje_agregar"));
                logic.imprimirTable(tbLista);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Sistema", JOptionPane.ERROR_MESSAGE);
        }
        
        limpiar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        logic = new PersonaLogic();
        
        try {
            logic.modificar(getPersona());
            JOptionPane.showMessageDialog(null, rb.getString("mensaje_modificar"));
            logic.imprimirTable(tbLista);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Sistema", JOptionPane.ERROR_MESSAGE);
        }
        
        limpiar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        logic = new PersonaLogic();
        
        try {
            logic.eliminar(getPersona());
            JOptionPane.showMessageDialog(null, rb.getString("mensaje_eliminar"));
            logic.imprimirTable(tbLista);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Sistema", JOptionPane.ERROR_MESSAGE);
        }
        
        limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
        logic = new PersonaLogic();
        try {
            logic.imprimirTable(tbLista, logic.busqueda(txtBusqueda.getText()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tbListaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListaMouseReleased
        
        int fila ;
        fila = tbLista.getSelectedRow();
        int id, edad;
        String nombre, apellidos, doc_identidad, direccion;
        
        if(fila>=0){
            int i = 0;
            id = Integer.parseInt(tbLista.getValueAt(fila, i++)+"");
            nombre = tbLista.getValueAt(fila, i++)+"";
            apellidos = tbLista.getValueAt(fila, i++)+"";
            doc_identidad = tbLista.getValueAt(fila, i++)+"";
            direccion = tbLista.getValueAt(fila, i++)+"";
            edad = Integer.parseInt(tbLista.getValueAt(fila, i++)+"");
            
            btnAgregar.setEnabled(false);
            txtId.setText(id+"");
            txtNombre.setText(nombre);
            txtApellidos.setText(apellidos);
            txtDocId.setText(doc_identidad);
            txtDireccion.setText(direccion);
            txtEdad.setText(edad+"");
        }
    }//GEN-LAST:event_tbListaMouseReleased

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        
        int valor = JOptionPane.showConfirmDialog(null, "Desea realmente Salir? ", "Sistema", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        
        this.cboPaginacion.setSelectedIndex(1);
    }//GEN-LAST:event_formInternalFrameOpened

    private void cboPaginacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPaginacionItemStateChanged
        
    logic = new PersonaLogic();

        try {
            if(cboPaginacion.getSelectedIndex() >= 0){
                logic.imprimirTable(tbLista, logic.paginacion(0, Integer.parseInt(cboPaginacion.getSelectedItem()+"")));
            }else{
                logic.imprimirTable(tbLista);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cboPaginacionItemStateChanged

    private void btnIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzquierdaActionPerformed
        
        logic = new PersonaLogic();
        
        try {
            total = logic.cantidadRegistros();
            if(cboPaginacion.getSelectedIndex()> 0){
                int max = total/(Integer.parseInt(cboPaginacion.getSelectedItem() + ""));
                contador--;
                if(contador < 0) contador = 0;
                if(max >= contador){
                    pagina = (Integer.parseInt(cboPaginacion.getSelectedItem() + "")) * contador;
                    logic.imprimirTable(tbLista, logic.paginacion(pagina, Integer.parseInt(cboPaginacion.getSelectedItem() + "")));
                }else{
                    contador = 0;
                }
            }else{
                logic.imprimirTable(tbLista);
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIzquierdaActionPerformed

    private void btnDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDerechaActionPerformed
        
        logic = new PersonaLogic();
        try {
            total = logic.cantidadRegistros();
            if(cboPaginacion.getSelectedIndex()> 0){
                int max = total/(Integer.parseInt(cboPaginacion.getSelectedItem() + ""));
                contador++;
                if(max >= contador){
                    pagina = (Integer.parseInt(cboPaginacion.getSelectedItem() + "")) * contador;
                    logic.imprimirTable(tbLista, logic.paginacion(pagina, Integer.parseInt(cboPaginacion.getSelectedItem() + "")));
                }else{
                    contador = max;
                }
            }else{
                logic.imprimirTable(tbLista);
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDerechaActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    private void btnQrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQrActionPerformed
        
        String valor = "";
        valor = txtId.getText() + " | "  + txtNombre.getText() + " | " 
              + txtApellidos.getText() + " | " + txtDocId.getText() + " | " 
              + txtDireccion.getText() + " | " + txtEdad.getText();
        
        ByteArrayOutputStream qr = QRCode.from(valor).to(ImageType.PNG).stream();
        ImageIcon icono = new ImageIcon(qr.toByteArray());
        lblQr.setIcon(icono);
    }//GEN-LAST:event_btnQrActionPerformed

    private void btnNew2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNew2ActionPerformed
        limpiar();
        btnAgregar.setEnabled(true);
        txtId.setText("0");
        txtId.setEditable(false);
    }//GEN-LAST:event_btnNew2ActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        
        logic = new PersonaLogic();
        try{
            HashMap<String, String> parametros = new HashMap<>();
            logic.imprimirReporte(parametros);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed
    
    Persona getPersona(){
        
        return new Persona(
                Integer.parseInt(txtId.getText()),
                txtNombre.getText(),
                txtApellidos.getText(),
                txtDocId.getText(),
                txtDireccion.getText(),
                Integer.parseInt(txtEdad.getText())
        );
    }
    
    private void limpiar(){
        txtId.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtDocId.setText("");
        txtDireccion.setText("");
        txtEdad.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDerecha;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnIzquierda;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNew2;
    private javax.swing.JButton btnQr;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboPaginacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblQr;
    private javax.swing.JTable tbLista;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDocId;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
