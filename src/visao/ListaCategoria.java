package visao;

import entidades.Categoria;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.CategoriaDAO;

/**
 *
 * @author JULIO PASCHOAL
 */
public class ListaCategoria extends javax.swing.JFrame {

    ArrayList<Categoria> categorias;

    public ListaCategoria() {
        initComponents();
        montarListaCategoria();
    }

    public void montarListaCategoria() {
        categorias = CategoriaDAO.listar();
        DefaultTableModel conteudo = (DefaultTableModel) tabCategoria.getModel();
        conteudo.setRowCount(0);// ELIMINAR AS LINHAS DA TABELA \\
        for (Categoria cat : categorias) {
            Object[] linha = {
                cat.getNome(),
                cat.getNomeTipo()
            };

            conteudo.addRow(linha);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabCategoria = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tabCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Categoria", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabCategoria);

        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
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
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // METODO PARA VERIFICA SE TEM UMA LINHA SELECIONADA \\
        int linha = tabCategoria.getSelectedRow();
        if (linha > -1) {
            Categoria categoria = categorias.get(linha);
            int opcao = JOptionPane.showConfirmDialog(this,
                    "Deseja realmente excluir a categoria " + categoria.getNome()
                    + "?", "Corfirmar a exclusão",
                    JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {

                // METODO DE EXLUIR UMA CATEGORIA \\
                if (CategoriaDAO.excluir(categoria.getId())) {
                    JOptionPane.showMessageDialog(this, "Categoria exluida com sucesso!");
                    // ATUALIZAR A LISTA \\
                    montarListaCategoria();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir a " + categoria.getNome() + ".");
                }
            }
        } else {
                JOptionPane.showMessageDialog(this, "Selecione uma Categoria para excluir!");
            }
    }//GEN-LAST:event_btnExcluirActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabCategoria;
    // End of variables declaration//GEN-END:variables
}
