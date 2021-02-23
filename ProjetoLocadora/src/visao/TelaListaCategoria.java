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
public class TelaListaCategoria extends javax.swing.JFrame {

    ArrayList<Categoria> categorias;

    public TelaListaCategoria() {
        initComponents();
        // MONTAR A TABELA COM OS DADOS DO BANCO \\
        montarListaCategoria();
    }

    public void montarListaCategoria() {
        categorias = CategoriaDAO.listar();
        DefaultTableModel conteudo = (DefaultTableModel) TabCategoria.getModel();
        conteudo.setRowCount(0); // ELIMINAR AS LINHAS DA TABELA
        for (Categoria cat : categorias) {
            // CRIANDO UMA LINHA PRA TABELA \\
            Object[] linha = {
                cat.getNome(),
                cat.getNomeTipo()
            };
            // ADICIONANDO A LINHA \\
            conteudo.addRow(linha);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabCategoria = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        TabCategoria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TabCategoria);

        btnExcluir.setText("Excluir");
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExcluir)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // METODO PARA VERIFICAR SER TEM ALGUMA LINHA SELECIONADA \\
        int linha = TabCategoria.getSelectedRow();
        if (linha > -1) {
            Categoria categoria = categorias.get(linha);
            int opcao = JOptionPane.showConfirmDialog(this,
                    "Deseja realmente excluir a categoria " + categoria.getNome() + "?",
                    "Confirme a exclusão", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                // CODIGO DE EXCLUIR A CATEGORIA \\
                if (CategoriaDAO.exluir(categoria.getId())) {
                    JOptionPane.showConfirmDialog(this, "Categoria excluida com sucesso!");
                    // ATUALIZAR A LISTA \\
                    montarListaCategoria();
                } else {
                    JOptionPane.showConfirmDialog(this, "Erroa ao excluir a categoria " + categoria.getNome() + ".");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma categoria para excluir");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaListaCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabCategoria;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
