import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Sofrimento {



    private Calculadora francisco;


    private JFrame glaube;


    private JPanel painelzao;



    public Sofrimento() {


        francisco = new Calculadora();
        glaube = new JFrame("Calculadora de Custo");
        glaube.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        glaube.setSize(980, 600);
        glaube.setLayout(null);


        JLabel titulo = new JLabel("calculadora de custo ", JLabel.CENTER);

        titulo.setFont(new Font("Arial", Font.BOLD, 15));

        titulo.setBounds(0, 10, 800, 30);

        glaube.add(titulo);





        JButton botaoAdicionar = new JButton("adicionar receita");
        JButton botaoAdicionaringred = new JButton("adicionar ingrediente");
        JButton botaoMudar = new JButton("mudar RECEITA");
        JButton botaoVer = new JButton("ver receita");
        JButton botaoSaiu = new JButton("sair");







        botaoAdicionar.setBounds(50, 100, 200, 50);
        botaoAdicionaringred.setBounds(50, 160, 200, 50);
        botaoMudar.setBounds(50, 220, 200, 50);
        botaoVer.setBounds(50, 280, 200, 50);
        botaoSaiu.setBounds(50, 340, 200, 50);




        botaoAdicionar.setBackground(Color.orange);
        botaoAdicionaringred.setBackground(Color.orange);
        botaoMudar.setBackground(Color.orange);
        botaoVer.setBackground(Color.orange);
        botaoSaiu.setBackground(Color.orange);





        botaoAdicionar.setFocusPainted(false);
        botaoAdicionaringred.setFocusPainted(false);
        botaoMudar.setFocusPainted(false);
        botaoVer.setFocusPainted(false);
        botaoSaiu.setFocusPainted(false);




        glaube.add(botaoAdicionar);
        glaube.add(botaoAdicionaringred);
        glaube.add(botaoMudar);
        glaube.add(botaoVer);
        glaube.add(botaoSaiu);





        painelzao = new JPanel();
        painelzao.setBounds(300, 50, 500, 400);
        painelzao.setLayout(new BorderLayout());
        painelzao.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        glaube.add(painelzao);






        botaoAdicionar.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                exibirAdicionarReceita();

            }
        });





        botaoAdicionaringred.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                exibirAdicionarIngrediente();

            }
        });





        botaoMudar.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                exibirMudarReceita();
            }
        });




        botaoVer.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                exibirVisualizarReceita();
            }
        });






        botaoSaiu.addActionListener(new ActionListener() {


            @Override

            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });







        glaube.setVisible(true);








    }

    private void exibirAdicionarReceita() {


        painelzao.removeAll();


        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("digite o nome da receita:", JLabel.CENTER);


        JTextField textField = new JTextField(20);
        textField.setBounds(20, 60, 300, 30);



        JButton botaoConfirma = new JButton("adicionar");





        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(botaoConfirma);





        botaoConfirma.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                String nomeReceita = textField.getText();


                if (!nomeReceita.isEmpty()) {


                    Receita receita = new Receita(nomeReceita);
                    francisco.adicionarReceita(receita);



                    JOptionPane.showMessageDialog(glaube, "receita '" + nomeReceita + "' adicionada com sucesso!");




                    int resposta = JOptionPane.showConfirmDialog(glaube, "deseja adicionar um ingrediente agora?", "adicionar", JOptionPane.YES_NO_OPTION);



                   if (resposta == JOptionPane.YES_OPTION) {



                        exibirAdicionarIngrediente();


                    } else {



                        SwingUtilities.invokeLater(new Runnable() {

                            @Override

                            public void run() {



                                painelzao.removeAll();
                                painelzao.revalidate();
                                painelzao.repaint();



                            }
                        });
                    }




                } else {


                    JOptionPane.showMessageDialog(glaube, "fez errado.");


                }


            }
        });

        panel.add(label, BorderLayout.NORTH);
        panel.add(textField, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        painelzao.setLayout(new BorderLayout());
        painelzao.add(panel, BorderLayout.CENTER);

        painelzao.revalidate();
        painelzao.repaint();
    }

    private void exibirAdicionarIngrediente() {


        painelzao.removeAll();


        //PERGUNTA1
        JLabel receitaCampo = new JLabel("escolha a receita para adicionar o ingrediente:");
        String[] receitas = francisco.obterReceitaNomes();
        JComboBox<String> receitaCaixote = new JComboBox<>(receitas);






        //PERGUNTA2
        JLabel nomeCampo = new JLabel("Digite o nome do ingrediente:");
        JTextField nomeIngredienteTexto = new JTextField(15);







        //PERGUNTA3
        JLabel tipoCampo = new JLabel("Escolha o tipo do ingrediente:");
        String[] tipos = {"unidade", "peso", "líquido"};
        JComboBox<String> tipoIngredienteCaixote = new JComboBox<>(tipos);







        //PERGUNTA4
        JLabel quantidadeCampo = new JLabel("Qual a quantidade da embalagem?");
        JTextField quantidadeEmbalagemTexto = new JTextField(10);









        //PERGUNTA 5
        JLabel precoCampo = new JLabel("Qual o preço da embalagem?");
        JTextField precoEmbalagemTexto = new JTextField(10);






        //PERGUNTA 6
        JLabel quantidadeUsadaCampo = new JLabel("Qual a quantidade usada na receita?");
        JTextField quantidadeUsadaTexto = new JTextField(10);





        //77777777
        JLabel unidadeCampo = new JLabel("Escolha a unidade de medida:");
        String[] unidades = {"Litro", "Unidade", "Gramas", "Ml", "Kg"};
        JComboBox<String> unidadeComboCaixote = new JComboBox<>(unidades);






        JButton botaoConfirmar = new JButton("Adicionar Ingrediente");










        botaoConfirmar.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {








                String receitaSelecionada = (String) receitaCaixote.getSelectedItem();
                String nomeIngrediente = nomeIngredienteTexto.getText();
                String tipoIngrediente = (String) tipoIngredienteCaixote.getSelectedItem();
                double quantidadeEmbalagem = Double.parseDouble(quantidadeEmbalagemTexto.getText());
                double precoEmbalagem = Double.parseDouble(precoEmbalagemTexto.getText());
                double quantidadeUsada = Double.parseDouble(quantidadeUsadaTexto.getText());
                String unidade = (String) unidadeComboCaixote.getSelectedItem();








                if (!nomeIngrediente.isEmpty() && quantidadeEmbalagem > 0 && precoEmbalagem > 0 && quantidadeUsada > 0) {




                    Receita receita = francisco.obterReceitaPorNome(receitaSelecionada);
                    if (receita != null) {



                        Ingrediente ingrediente = new Ingrediente(nomeIngrediente, quantidadeEmbalagem, precoEmbalagem, quantidadeUsada, tipoIngrediente, unidade);



                        receita.adicionarIngrediente(ingrediente);



                        JOptionPane.showMessageDialog(glaube, "ingrediente '" + nomeIngrediente + "' adicionado à receita!");






                        SwingUtilities.invokeLater(new Runnable() {


                            @Override


                            public void run() {

                                painelzao.removeAll();
                                painelzao.revalidate();
                                painelzao.repaint();


                            }
                        });
                    }


                } else {



                    JOptionPane.showMessageDialog(glaube, "caracter errado.");


                }
            }
        });








        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));
        panel.add(receitaCampo);
        panel.add(receitaCaixote);
        panel.add(nomeCampo);
        panel.add(nomeIngredienteTexto);
        panel.add(tipoCampo);
        panel.add(tipoIngredienteCaixote);
        panel.add(quantidadeCampo);
        panel.add(quantidadeEmbalagemTexto);
        panel.add(precoCampo);
        panel.add(precoEmbalagemTexto);
        panel.add(quantidadeUsadaCampo);
        panel.add(quantidadeUsadaTexto);
        panel.add(unidadeCampo);
        panel.add(unidadeComboCaixote);
        panel.add(new JLabel());
        panel.add(botaoConfirmar);






        painelzao.setLayout(new BorderLayout());
        painelzao.add(panel, BorderLayout.CENTER);
        painelzao.revalidate();
        painelzao.repaint();





    }


    private void exibirMudarReceita() {


        painelzao.removeAll();


        JLabel receitaLabel = new JLabel("escolha a receita para mudar:");
        String[] receitas = francisco.obterReceitaNomes(); // Lista de receitas existentes
        JComboBox<String> receitaCaixote = new JComboBox<>(receitas);





        JButton mudarNomeButton = new JButton("Mudar Nome");
        JButton excluirButton = new JButton("Excluir Receita");





        //botao do MUDAR
        mudarNomeButton.setBounds(0, 0, 150, 50);
        excluirButton.setBounds(160, 0, 150, 50);




        mudarNomeButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {


                String receitaSelecionada = (String) receitaCaixote.getSelectedItem();
                Receita receita = francisco.obterReceitaPorNome(receitaSelecionada);


                if (receita != null) {



                    String novoNome = JOptionPane.showInputDialog(glaube, "escreva o novo nome da receita:");
                    francisco.mudarNomeReceita(receita.getNome(), novoNome);
                    JOptionPane.showMessageDialog(glaube, "nome da receita alterado para: " + novoNome);
                    exibirMudarReceita();



                }
            }
        });



        excluirButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {


                String receitaSelecionada = (String) receitaCaixote.getSelectedItem();
                Receita receita = francisco.obterReceitaPorNome(receitaSelecionada);


                if (receita != null) {


                    francisco.removerReceita(receita.getNome());
                    JOptionPane.showMessageDialog(glaube, "receita excluída.");
                    exibirMudarReceita();


                }
            }
        });



        //CNTROL C CNTRL V

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(receitaLabel);
        panel.add(receitaCaixote);
        panel.add(mudarNomeButton);
        panel.add(excluirButton);





        painelzao.setLayout(new BorderLayout());
        painelzao.add(panel, BorderLayout.CENTER);
        painelzao.revalidate();
        painelzao.repaint();



    }

    private void exibirVisualizarReceita() {


        painelzao.removeAll();




        JLabel receitaLabel = new JLabel("escolha a receita para ver:");
        String[] receitas = francisco.obterReceitaNomes();
        JComboBox<String> receitaCaixote = new JComboBox<>(receitas);



        JButton verBotao = new JButton("ver Receita");



        verBotao.addActionListener(new ActionListener() {


            @Override

            public void actionPerformed(ActionEvent e) {


                String receitaSelecionada = (String) receitaCaixote.getSelectedItem();


                if (receitaSelecionada != null) {


                    Receita receita = francisco.obterReceitaPorNome(receitaSelecionada);


                    if (receita != null) {






                        StringBuilder detalhes = new StringBuilder();
                        detalhes.append("receita: ").append(receitaSelecionada).append("\n");
                        detalhes.append("ingredientes:\n");





                        for (Ingrediente ingrediente : receita.getIngredientes()) {
                            detalhes.append("- ").append(ingrediente.getNome())
                                    .append(" (").append(ingrediente.getTipo()).append("): ")
                                    .append("R$ ").append(String.format("%.2f", ingrediente.calcularCusto()))
                                    .append("\n");





                        }



                        detalhes.append("\nCusto total da receita: R$ ")
                                .append(String.format("%.2f", receita.calcularCustoTotal()));


                          ////// CAIXA DA RECEITA

                        JOptionPane.showMessageDialog(glaube, detalhes.toString(), "Visualização da Receita", JOptionPane.INFORMATION_MESSAGE);



                    } else {


                        JOptionPane.showMessageDialog(glaube, "Receita não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);


                    }

                } else {

                    JOptionPane.showMessageDialog(glaube, "Por favor, selecione uma receita.", "Erro", JOptionPane.ERROR_MESSAGE);

                }

            }

        });



        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.add(receitaLabel);
        panel.add(receitaCaixote);
        panel.add(verBotao);




        painelzao.setLayout(new BorderLayout());
        painelzao.add(panel, BorderLayout.CENTER);
        painelzao.revalidate();
        painelzao.repaint();





    }
}
