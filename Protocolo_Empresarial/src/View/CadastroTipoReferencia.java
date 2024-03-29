/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.TipoReferencia;
//import Model.Usuario;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.JTableBinding.ColumnBinding;
import org.jdesktop.swingbinding.SwingBindings;
/**
 *
 * @author reinaldo.nti
 */
public class CadastroTipoReferencia extends javax.swing.JFrame {

    /**
     * Creates new form CadastroReferencia
     */
    private List<TipoReferencia> lstTipoReferencia;
    public CadastroTipoReferencia() {
        lstTipoReferencia = new ArrayList<>();
        lstTipoReferencia = ObservableCollections.observableList(lstTipoReferencia);
        
        initComponents();
        
        BindingGroup bg = new BindingGroup();
        
        JTableBinding tb = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE,
                lstTipoReferencia, tbTipoReferencia);
        ColumnBinding cb = tb.addColumnBinding(BeanProperty.create("descricao"));
        cb.setColumnName("Descricao");
        
        bg.addBinding(tb);
        
        Binding b = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE,
                tbTipoReferencia, BeanProperty.create("selectedElement.descricao"),
                txtDescricao, BeanProperty.create("text"));
        bg.addBinding(b);
        
        
        bg.bind();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        srcTbTipoDocumento = new javax.swing.JScrollPane();
        tbTipoReferencia = new javax.swing.JTable();
        btMostrarLista = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        lblDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        btAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbTipoReferencia.setAutoCreateRowSorter(true);
        tbTipoReferencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        srcTbTipoDocumento.setViewportView(tbTipoReferencia);

        btMostrarLista.setText("Mostrar lista");
        btMostrarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMostrarListaActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        lblDescricao.setText("Nome: ");

        btAdicionar.setText("Adicionar");
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btMostrarLista))
                    .addComponent(srcTbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(srcTbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btMostrarLista)
                    .addComponent(btExcluir)
                    .addComponent(btAdicionar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btMostrarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMostrarListaActionPerformed

        for(TipoReferencia c:lstTipoReferencia){
            System.out.printf("Descricao: %s\n",c.getDescricao());
        }

    }//GEN-LAST:event_btMostrarListaActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        int v[] = tbTipoReferencia.getSelectedRows();
        List<TipoReferencia> c = new LinkedList<>();

        for(int i=0;i<v.length;i++)
        {
            int idxTabela = v[i];
            int idxList = tbTipoReferencia.convertRowIndexToModel(idxTabela);
            c.add(lstTipoReferencia.get(idxList));
        }
        
        lstTipoReferencia.removeAll(c);
        txtDescricao.setText("");
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed

        TipoReferencia r = new TipoReferencia();
        if(tbTipoReferencia.getSelectedRows().length==0){
            r.setDescricao(txtDescricao.getText());            
            lstTipoReferencia.add(r);
            txtDescricao.setText("");
        }else{
            lstTipoReferencia.add(r);
            tbTipoReferencia.getSelectionModel().setSelectionInterval(
            lstTipoReferencia.size()-1,
            lstTipoReferencia.size()-1);
        }

    }//GEN-LAST:event_btAdicionarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroReferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroReferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroReferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroReferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroTipoReferencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btMostrarLista;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JScrollPane srcTbTipoDocumento;
    private javax.swing.JTable tbTipoReferencia;
    private javax.swing.JTextField txtDescricao;
    // End of variables declaration//GEN-END:variables
}
