package VIEW;

import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class IndexVIEW extends javax.swing.JFrame {

    /**
     * Creates new form IndexVIEW
     */
    public IndexVIEW() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void abreClienteVIEW() {
        ClienteVIEW clienteVIEW = new ClienteVIEW();
        this.desktopPane.add(clienteVIEW);
        clienteVIEW.setVisible(true);
        clienteVIEW.setPosition();
    }

    private void abreFuncionarioVIEW() {
        FuncionarioVIEW funcionarioVIEW = new FuncionarioVIEW();
        this.desktopPane.add(funcionarioVIEW);
        funcionarioVIEW.setVisible(true);
        funcionarioVIEW.setPosition();
    }

    private void abreRelatorioVIEW() {
        RelatorioVIEW relatorioVIEW = new RelatorioVIEW();
        this.desktopPane.add(relatorioVIEW);
        relatorioVIEW.setVisible(true);
        relatorioVIEW.setPosition();
    }

    private void sair() {
        Object[] options = {"Sair", "Cancelar"};
        if (JOptionPane.showOptionDialog(null, "Deseja mesmo sair do sistema?", "Informação",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]) == 0) {
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        gerenciarFuncionario = new javax.swing.JMenuItem();
        gerenciarCliente = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenu();
        menuBackup = new javax.swing.JMenu();
        restaurar = new javax.swing.JMenuItem();
        gerar = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 837, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );

        jMenuBar1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jMenu1.setText("Gerenciar");
        jMenu1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        gerenciarFuncionario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        gerenciarFuncionario.setText("Funcionário");
        gerenciarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerenciarFuncionarioActionPerformed(evt);
            }
        });
        jMenu1.add(gerenciarFuncionario);

        gerenciarCliente.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        gerenciarCliente.setText("Cliente");
        gerenciarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerenciarClienteActionPerformed(evt);
            }
        });
        jMenu1.add(gerenciarCliente);

        jMenuBar1.add(jMenu1);

        menuRelatorio.setText("Relatório");
        menuRelatorio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        menuRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuRelatorioMouseClicked(evt);
            }
        });
        menuRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuRelatorio);

        menuBackup.setText("Backup");
        menuBackup.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        menuBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBackupActionPerformed(evt);
            }
        });

        restaurar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        restaurar.setText("Restaurar");
        restaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurarActionPerformed(evt);
            }
        });
        menuBackup.add(restaurar);

        gerar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        gerar.setText("Gerar");
        gerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarActionPerformed(evt);
            }
        });
        menuBackup.add(gerar);

        jMenuBar1.add(menuBackup);

        menuSair.setText("Sair");
        menuSair.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gerenciarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenciarFuncionarioActionPerformed
        abreFuncionarioVIEW();
    }//GEN-LAST:event_gerenciarFuncionarioActionPerformed

    private void gerenciarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenciarClienteActionPerformed
        abreClienteVIEW();
    }//GEN-LAST:event_gerenciarClienteActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed

    }//GEN-LAST:event_menuSairActionPerformed

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
        sair();
    }//GEN-LAST:event_menuSairMouseClicked

    private void restaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_restaurarActionPerformed

    private void gerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gerarActionPerformed

    private void menuBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBackupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuBackupActionPerformed

    private void menuRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuRelatorioMouseClicked
        abreRelatorioVIEW();
    }//GEN-LAST:event_menuRelatorioMouseClicked

    private void menuRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioActionPerformed
        abreRelatorioVIEW();
    }//GEN-LAST:event_menuRelatorioActionPerformed

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
            java.util.logging.Logger.getLogger(IndexVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IndexVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IndexVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IndexVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IndexVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem gerar;
    private javax.swing.JMenuItem gerenciarCliente;
    private javax.swing.JMenuItem gerenciarFuncionario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuBackup;
    private javax.swing.JMenu menuRelatorio;
    private javax.swing.JMenu menuSair;
    private javax.swing.JMenuItem restaurar;
    // End of variables declaration//GEN-END:variables
}
