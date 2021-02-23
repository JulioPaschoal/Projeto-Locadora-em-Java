package visao;

import entidades.Categoria;
import javax.swing.JOptionPane;
import persistencia.CategoriaDAO;

/**
 *
 * @author JULIO PASCHOAL
 */
public class TelaCadastroCategoria extends javax.swing.JFrame {

    private Categoria categoria = new Categoria();
    private TelaListaCategoria telaListagem;

    public TelaCadastroCategoria(TelaListaCategoria telaListagem) {
        initComponents();
        this.telaListagem = telaListagem;
    }

    // METODO PARA ALTERA A CATEGORIA
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
        txtCategoria.setText(categoria.getNome());
        if (categoria.getTipo() == 'F') {
            rdbFilme.setSelected(true);
        } else if (categoria.getTipo() == 'J') {
            rdbJogo.setSelected(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpTipo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        rdbFilme = new javax.swing.JRadioButton();
        rdbJogo = new javax.swing.JRadioButton();
        txtCategoria = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Cadastro de Categoria");

        grpTipo.add(rdbFilme);
        rdbFilme.setText("Filme");
        rdbFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbFilmeActionPerformed(evt);
            }
        });

        grpTipo.add(rdbJogo);
        rdbJogo.setText("Jogo");
        rdbJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbJogoActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo de Categoria");

        btnCadastrar.setText("Cadastrar categoria");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCategoria)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdbFilme)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdbJogo))
                            .addComponent(btnCadastrar))
                        .addGap(0, 251, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbFilme)
                    .addComponent(rdbJogo))
                .addGap(18, 18, 18)
                .addComponent(btnCadastrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rdbFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbFilmeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbFilmeActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        categoria.setNome(txtCategoria.getText());
        if (rdbFilme.isSelected()) {
            categoria.setTipo('F');
        } else if (rdbJogo.isSelected()) {
            categoria.setTipo('J');
        }
        // INSERIR NO BANCO DE DADOS \\
        if (categoria.getTipo() != ' ') {
            if (categoria.getId() == 0) {
                inserir();
            } else {
                alterar();
            }
        } else {
            JOptionPane.showConfirmDialog(this, "Selecione o tipo de categoria!");
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void inserir() {
        if (CategoriaDAO.inserir(categoria)) {
            JOptionPane.showConfirmDialog(this, "Categoria Inserida com Sucesso");
            telaListagem.montarListaCategoria();
            dispose();// FECHAR A TELA DE CADASTRO \\
        } else {
            JOptionPane.showConfirmDialog(this, "Erro ao inserir categoria!");
        }
    }

    private void alterar() {
        if (CategoriaDAO.alterar(categoria)) {
            JOptionPane.showConfirmDialog(this, "Categoria alterada com Sucesso");
            telaListagem.montarListaCategoria();
            dispose();// FECHAR A TELA DE CADASTRO \\
        } else {
            JOptionPane.showConfirmDialog(this, "Erro ao alterar categoria!");
        }
    }

    private void rdbJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbJogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbJogoActionPerformed

//
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.ButtonGroup grpTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton rdbFilme;
    private javax.swing.JRadioButton rdbJogo;
    private javax.swing.JTextField txtCategoria;
    // End of variables declaration//GEN-END:variables
}
