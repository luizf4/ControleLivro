package br.metodista.ads.telas;

import br.metodista.ads.modelos.Livro;
import java.awt.Component;
import java.awt.Container;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luiz Fernando de Souza ADS - EAD Sorocaba Matricula: 225272
 */
public class TelaLivro extends javax.swing.JInternalFrame {

    private List<Livro> livros = null;
    private int linhaSelecionada = -1;

    Object[] options = {"Sim", "Não"};

    /**
     * Creates new form TelaLivro
     *
     * @param livros
     */
    public TelaLivro(List<Livro> livros) {

        this.livros = livros;
        initComponents();
        carregarLivros();
        desabilitaBotoes();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCadastroLivro = new javax.swing.JPanel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jTextFieldAutor = new javax.swing.JTextField();
        jTextFieldISBN = new javax.swing.JTextField();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelAutor = new javax.swing.JLabel();
        jLabelISBN = new javax.swing.JLabel();
        jLabelPaginas = new javax.swing.JLabel();
        jLabelEdicao = new javax.swing.JLabel();
        jFormattedPaginas = new javax.swing.JFormattedTextField();
        jFormattedEdicao = new javax.swing.JFormattedTextField();
        jButtonNovo = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jPanelDadosLivro = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDadosLivro = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cadastro de Livro");
        setMinimumSize(new java.awt.Dimension(720, 720));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
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

        jPanelCadastroLivro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Livro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        jPanelCadastroLivro.setLayout(null);

        jTextFieldTitulo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldTitulo.setEnabled(false);
        jPanelCadastroLivro.add(jTextFieldTitulo);
        jTextFieldTitulo.setBounds(30, 60, 600, 30);

        jTextFieldAutor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldAutor.setEnabled(false);
        jPanelCadastroLivro.add(jTextFieldAutor);
        jTextFieldAutor.setBounds(30, 130, 600, 30);

        jTextFieldISBN.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldISBN.setEnabled(false);
        jPanelCadastroLivro.add(jTextFieldISBN);
        jTextFieldISBN.setBounds(30, 200, 230, 30);

        jLabelTitulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelTitulo.setText("Título:");
        jPanelCadastroLivro.add(jLabelTitulo);
        jLabelTitulo.setBounds(20, 30, 70, 30);

        jLabelAutor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelAutor.setText("Autor:");
        jPanelCadastroLivro.add(jLabelAutor);
        jLabelAutor.setBounds(20, 100, 70, 30);

        jLabelISBN.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelISBN.setText("ISBN:");
        jPanelCadastroLivro.add(jLabelISBN);
        jLabelISBN.setBounds(20, 170, 70, 30);

        jLabelPaginas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelPaginas.setText("Páginas:");
        jPanelCadastroLivro.add(jLabelPaginas);
        jLabelPaginas.setBounds(280, 170, 70, 30);

        jLabelEdicao.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelEdicao.setText("Edição:");
        jPanelCadastroLivro.add(jLabelEdicao);
        jLabelEdicao.setBounds(430, 170, 100, 30);

        jFormattedPaginas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedPaginas.setAutoscrolls(false);
        jFormattedPaginas.setEnabled(false);
        jFormattedPaginas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanelCadastroLivro.add(jFormattedPaginas);
        jFormattedPaginas.setBounds(290, 200, 119, 30);

        jFormattedEdicao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedEdicao.setEnabled(false);
        jFormattedEdicao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanelCadastroLivro.add(jFormattedEdicao);
        jFormattedEdicao.setBounds(450, 200, 180, 30);

        jButtonNovo.setMnemonic('N');
        jButtonNovo.setText("Novo");
        jButtonNovo.setToolTipText("Alt + N");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonSalvar.setMnemonic('S');
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setToolTipText("Alt + S");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonRemover.setMnemonic('R');
        jButtonRemover.setText("Remover");
        jButtonRemover.setToolTipText("Alt + R");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jButtonFechar.setMnemonic('F');
        jButtonFechar.setText("Fechar");
        jButtonFechar.setToolTipText("Alt + F");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jPanelDadosLivro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        jPanelDadosLivro.setLayout(null);

        jTableDadosLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Autor", "ISBN", "Páginas", "Edição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDadosLivro.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableDadosLivro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDadosLivroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDadosLivro);
        if (jTableDadosLivro.getColumnModel().getColumnCount() > 0) {
            jTableDadosLivro.getColumnModel().getColumn(0).setResizable(false);
            jTableDadosLivro.getColumnModel().getColumn(0).setPreferredWidth(300);
            jTableDadosLivro.getColumnModel().getColumn(1).setResizable(false);
            jTableDadosLivro.getColumnModel().getColumn(1).setPreferredWidth(300);
            jTableDadosLivro.getColumnModel().getColumn(2).setResizable(false);
            jTableDadosLivro.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTableDadosLivro.getColumnModel().getColumn(3).setResizable(false);
            jTableDadosLivro.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTableDadosLivro.getColumnModel().getColumn(4).setResizable(false);
            jTableDadosLivro.getColumnModel().getColumn(4).setPreferredWidth(80);
        }

        jPanelDadosLivro.add(jScrollPane1);
        jScrollPane1.setBounds(10, 20, 630, 280);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanelCadastroLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanelDadosLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanelCadastroLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonNovo)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonRemover)
                    .addComponent(jButtonFechar))
                .addGap(4, 4, 4)
                .addComponent(jPanelDadosLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed

        try {

            if ("".equals(jTextFieldTitulo.getText())) {

                JOptionPane.showMessageDialog(this, "Titulo é Obrigatório!", 
                        "Erro", JOptionPane.OK_OPTION);
                jTextFieldTitulo.requestFocus();

            } else if ("".equals(jTextFieldAutor.getText())) {

                JOptionPane.showMessageDialog(this, "Autor é Obrigatório!", 
                        "Erro", JOptionPane.OK_OPTION);
                jTextFieldAutor.requestFocus();

            } else if ("".equals(jTextFieldISBN.getText())) {

                JOptionPane.showMessageDialog(this, "ISBN de 13 digitos é Obrigatório!", 
                        "Erro", JOptionPane.OK_OPTION);
                jTextFieldISBN.requestFocus();

            } else if ("0".equals(jFormattedPaginas.getText())) {

                JOptionPane.showMessageDialog(this, "Um livro não pode ter 0 Páginas!",
                        "Erro", JOptionPane.OK_OPTION);
                jFormattedPaginas.requestFocus();

            } else if ("0".equals(jFormattedEdicao.getText())) {

                JOptionPane.showMessageDialog(this, "Edição não pode começar em 0!",
                        "Erro", JOptionPane.OK_OPTION);
                jFormattedEdicao.requestFocus();

            } else {

                Livro i = obterLivro(livros, jTextFieldTitulo.getText());

                if (i == null) {

                    i = new Livro();
                    i.setTitulo(jTextFieldTitulo.getText());
                    i.setAutor(jTextFieldAutor.getText());
                    i.setIsbn(jTextFieldISBN.getText());
                    i.setEdicao(Integer.parseInt(jFormattedEdicao.getText()));
                    i.setPaginas(Integer.parseInt(jFormattedPaginas.getText()));

                    livros.add(i);

                } else {

                    i.setAutor(jTextFieldAutor.getText());
                    i.setIsbn(jTextFieldISBN.getText());
                    i.setEdicao(Integer.parseInt(jFormattedEdicao.getText()));
                    i.setPaginas(Integer.parseInt(jFormattedPaginas.getText()));

                }

                carregarLivros();
                desabilitaBotoes();
                limpaDados();
                jButtonSalvar.setEnabled(true);
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(this, "Excedeu o Limite de '9' dígitos!",
                    "Erro", JOptionPane.OK_OPTION);
        }


    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

        dispose();

    }//GEN-LAST:event_formInternalFrameClosing

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

        Principal.setVerificaTelalivro(true);

    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed

        Principal.setVerificaTelalivro(false);

    }//GEN-LAST:event_formInternalFrameClosed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed

        habilitaCaixaTexto();
        limpaCaixaTexto(jPanelCadastroLivro);
        jTextFieldTitulo.requestFocus();
        habilitaBotoes();
        jButtonNovo.setEnabled(false);


    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed

        livros.remove(linhaSelecionada);

        ((DefaultTableModel) jTableDadosLivro.getModel()).removeRow(linhaSelecionada);

        desabilitaCaixaTexto();
        desabilitaBotoes();
        limpaCaixaTexto(jPanelCadastroLivro);
        jTextFieldAutor.setText("");
        jTextFieldAutor.setEnabled(false);
        jButtonNovo.setEnabled(true);

    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed

        dispose();

    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jTableDadosLivroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDadosLivroMouseClicked

        habilitaCaixaTexto();
        linhaSelecionada = jTableDadosLivro.getSelectedRow();
        Livro u = livros.get(linhaSelecionada);
        preencharDadosLivro(u);
        this.jTextFieldTitulo.setEnabled(false);
        this.jButtonNovo.setEnabled(false);
        habilitaBotoes();


    }//GEN-LAST:event_jTableDadosLivroMouseClicked

    private void carregarLivros() {

        for (int cont = jTableDadosLivro.getRowCount() - 1; cont >= 0; cont--) {

            ((DefaultTableModel) jTableDadosLivro.getModel()).removeRow(cont);

        }

        for (Livro i : livros) {

            ((DefaultTableModel) jTableDadosLivro.getModel()).addRow(i.carregarGrid());

        }

    }

    private void preencharDadosLivro(Livro i) {

        this.jTextFieldTitulo.setText(i.getTitulo());
        this.jTextFieldAutor.setText(i.getAutor());
        this.jTextFieldISBN.setText(i.getIsbn());
        this.jFormattedPaginas.setText(String.valueOf(i.getPaginas()));
        this.jFormattedEdicao.setText(String.valueOf(i.getEdicao()));

    }

    private Livro obterLivro(List<Livro> livros, String titulo) {

        Livro livro = null;

        for (Livro u : livros) {

            if (u.getTitulo().equals(titulo)) {

                livro = u;

                break;
            }

        }

        return livro;
    }

    public static void limpaCaixaTexto(Container container) {

        Component components[] = container.getComponents();

        for (Component component : components) {

            if (component instanceof JTextField) {

                JTextField field = (JTextField) component;
                field.setText("");

            } else if (component instanceof JFormattedTextField) {

                JFormattedTextField fieldFormatted = (JFormattedTextField) component;
                fieldFormatted.setText("");

            }

        }

    }

    private void desabilitaBotoes() {

        jButtonRemover.setEnabled(false);
        jButtonSalvar.setEnabled(false);

    }

    private void habilitaBotoes() {

        jButtonRemover.setEnabled(true);
        jButtonSalvar.setEnabled(true);

    }

    private void habilitaCaixaTexto() {

        jTextFieldTitulo.setEnabled(true);
        jTextFieldAutor.setEnabled(true);
        jTextFieldISBN.setEnabled(true);
        jFormattedPaginas.setEnabled(true);
        jFormattedEdicao.setEnabled(true);

    }

    private void desabilitaCaixaTexto() {

        jTextFieldTitulo.setEnabled(false);
        jTextFieldAutor.setEnabled(false);
        jTextFieldISBN.setEnabled(false);
        jFormattedPaginas.setEnabled(false);
        jFormattedEdicao.setEnabled(false);

    }

    private void limpaDados() {

        limpaCaixaTexto(jPanelCadastroLivro);
        this.linhaSelecionada = -1;
        habilitaCaixaTexto();
        jTextFieldTitulo.requestFocus();

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JFormattedTextField jFormattedEdicao;
    private javax.swing.JFormattedTextField jFormattedPaginas;
    private javax.swing.JLabel jLabelAutor;
    private javax.swing.JLabel jLabelEdicao;
    private javax.swing.JLabel jLabelISBN;
    private javax.swing.JLabel jLabelPaginas;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelCadastroLivro;
    private javax.swing.JPanel jPanelDadosLivro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDadosLivro;
    private javax.swing.JTextField jTextFieldAutor;
    private javax.swing.JTextField jTextFieldISBN;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables

}
