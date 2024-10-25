import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MenuPrincipal {

    public static void main(String[] args) {

    new MenuPrincipal();

    }



    private Calculadora calculadora;
    private JFrame frame;



    public MenuPrincipal() {


        calculadora = new Calculadora();
        frame = new JFrame("Calculadora Francisco"); //QUE
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(6, 1));


        JLabel titulo = new JLabel("calculadora de preços GLAUBER", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 15));
        frame.add(titulo);


        JButton adicionarReceitaBtn = new JButton("Adicionar Receita");
        JButton adicionarIngredienteBtn = new JButton("Adicionar Ingrediente");
        JButton mudarReceitaBtn = new JButton("Mudar RECEITA");
        JButton visualizarReceitaBtn = new JButton("Ver Receita");
        JButton sairBtn = new JButton("Sair");


        adicionarReceitaBtn.setPreferredSize(new Dimension(200, 50));
        adicionarIngredienteBtn.setPreferredSize(new Dimension(200, 50));
        mudarReceitaBtn.setPreferredSize(new Dimension(200, 50));
        visualizarReceitaBtn.setPreferredSize(new Dimension(200, 50));
        sairBtn.setPreferredSize(new Dimension(200, 50));


        adicionarReceitaBtn.setBackground(Color.green);
        adicionarIngredienteBtn.setBackground(Color.yellow);
        mudarReceitaBtn.setBackground(Color.orange);
        visualizarReceitaBtn.setBackground(Color.black);
        sairBtn.setBackground(Color.red);


        adicionarReceitaBtn.setFocusPainted(false);
        adicionarIngredienteBtn.setFocusPainted(false);
        mudarReceitaBtn.setFocusPainted(false);
        visualizarReceitaBtn.setFocusPainted(false);
        sairBtn.setFocusPainted(false);


        frame.add(adicionarReceitaBtn);
        frame.add(adicionarIngredienteBtn);
        frame.add(mudarReceitaBtn);
        frame.add(visualizarReceitaBtn);
        frame.add(sairBtn);


        adicionarReceitaBtn.addActionListener(new ActionListener() {


            @Override

            public void actionPerformed(ActionEvent e) {

                adicionarReceita();

            }


        });


        adicionarIngredienteBtn.addActionListener(new ActionListener() {


            @Override

            public void actionPerformed(ActionEvent e) {

                adicionarIngrediente();

            }


        });


        mudarReceitaBtn.addActionListener(new ActionListener() {


            @Override

            public void actionPerformed(ActionEvent e) {

                mudarReceita();

            }


        });


        visualizarReceitaBtn.addActionListener(new ActionListener() {


            @Override

            public void actionPerformed(ActionEvent e) {

                visualizarReceita();

            }


        });



        sairBtn.addActionListener(new ActionListener() {



            @Override


            public void actionPerformed(ActionEvent e) {


                System.exit(0);

            }


        });



        frame.setVisible(true);



    }


    private void adicionarReceita() {


        String nomeReceita = JOptionPane.showInputDialog("digite o nome da sua receita");


        if (nomeReceita != null && !nomeReceita.isEmpty()) {


            Receita receita = new Receita(nomeReceita);
            calculadora.adicionarReceita(receita);
            JOptionPane.showMessageDialog(null, "nome adicionado " + nomeReceita);
            adicionarIngrediente(receita);


        }


    }


    private void adicionarIngrediente() {


        String[] tipos = {"unidade", "peso", "liquido"};
        String tipo = (String) JOptionPane.showInputDialog(null, "escolha o tipo de ingrediente", "tipo de ingrediente", JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);


        String unidadeMedida = "";


        if (tipo.equals("peso")) {


            String[] opcoesPeso = {"Kg", "Mg"};
            unidadeMedida = (String) JOptionPane.showInputDialog(null, "especifíque o tipo de peso", "unidade de peso", JOptionPane.QUESTION_MESSAGE, null, opcoesPeso, opcoesPeso[0]);


        } else if (tipo.equals("liquido")) {


            String[] opcoesLiquido = {"L", "ML"};
            unidadeMedida = (String) JOptionPane.showInputDialog(null, "escolha a unidade de medida", "unidade de liquido", JOptionPane.QUESTION_MESSAGE, null, opcoesLiquido, opcoesLiquido[0]);


        } else {


            unidadeMedida = "unidade";


        }

        String nomeIngrediente = JOptionPane.showInputDialog("digite o nome do ingrediente");

        double quantidadeEmbalagem = Double.parseDouble(JOptionPane.showInputDialog("qual a quantidade que vem na embalagem " + unidadeMedida + "?"));

        double precoEmbalagem = Double.parseDouble(JOptionPane.showInputDialog("qual o preço da embalagem?"));

        double precoPorUnidade = calcularPrecoPorUnidade(precoEmbalagem, quantidadeEmbalagem, unidadeMedida);

        Ingrediente ingrediente = new Ingrediente(nomeIngrediente, quantidadeEmbalagem, precoEmbalagem, 0, tipo + " (" + unidadeMedida + ")");

        calculadora.adicionarIngrediente(ingrediente);

        JOptionPane.showMessageDialog(null, "ingrediente adicionado" + nomeIngrediente + "\n preco por " + unidadeMedida + ": RS " + precoPorUnidade);

    }

    private void adicionarIngrediente(Receita receita) {


        int resposta = JOptionPane.showConfirmDialog(null, "quer adicionar um ingrediente agora?", "adicionar ingrediente", JOptionPane.YES_NO_OPTION);


        while (resposta == JOptionPane.YES_OPTION) {


            String[] tipos = {"unidade", "peso", "líquido"};

            String tipo = (String) JOptionPane.showInputDialog(null, "selecione o tipo de ingrediente:", "tipo de ingrediente", JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);


            String unidadeMedida = "";


            if (tipo.equals("peso")) {


                String[] opcoesPeso = {"Kg", "Mg"};
                unidadeMedida = (String) JOptionPane.showInputDialog(null, "Selecione a unidade de peso:", "Unidade de Peso", JOptionPane.QUESTION_MESSAGE, null, opcoesPeso, opcoesPeso[0]);


            } else if (tipo.equals("líquido")) {


                String[] opcoesLiquido = {"L", "ML"};
                unidadeMedida = (String) JOptionPane.showInputDialog(null, "Selecione a unidade de volume:", "Unidade de Volume", JOptionPane.QUESTION_MESSAGE, null, opcoesLiquido, opcoesLiquido[0]);


            } else {


                unidadeMedida = "unidade";


            }

            String nomeIngrediente = JOptionPane.showInputDialog("qual o nome do ingrediente?");
            double quantidadeEmbalagem = Double.parseDouble(JOptionPane.showInputDialog("quanto vem na embalagem em " + unidadeMedida + "?"));
            double precoEmbalagem = Double.parseDouble(JOptionPane.showInputDialog("qual o preço pago na embalagem?"));
            double quantidadeUsada = Double.parseDouble(JOptionPane.showInputDialog("qual a quantidade usada na receita em " + unidadeMedida + "?"));

            double precoPorUnidade = calcularPrecoPorUnidade(precoEmbalagem, quantidadeEmbalagem, unidadeMedida);

            Ingrediente ingrediente = new Ingrediente(nomeIngrediente, quantidadeEmbalagem, precoEmbalagem, quantidadeUsada, tipo + " (" + unidadeMedida + ")");
            receita.adicionarIngrediente(ingrediente);
            JOptionPane.showMessageDialog(null, "ingrediente adicionado: " + nomeIngrediente + "\n preco por " + unidadeMedida + ": RS " + precoPorUnidade);

            resposta = JOptionPane.showConfirmDialog(null, "deseja adicionar mais um ingrediente?", "adicionar ingrediente", JOptionPane.YES_NO_OPTION);


        }
    }


    private double calcularPrecoPorUnidade(double precoEmbalagem, double quantidadeEmbalagem, String unidadeMedida) {

        if (unidadeMedida.equals("ML")) {

            quantidadeEmbalagem = quantidadeEmbalagem / 1000;

        } else if (unidadeMedida.equals("Mg")) {

            quantidadeEmbalagem = quantidadeEmbalagem / 1000000;

        }

        return precoEmbalagem / quantidadeEmbalagem;
    }

    private void mudarReceita() {


        String[] opcoesReceitas = calculadora.obterReceitaNomes();
        String receitaSelecionada = (String) JOptionPane.showInputDialog(null, "Escolha sua receita:", "Mudar Receita", JOptionPane.QUESTION_MESSAGE, null, opcoesReceitas, opcoesReceitas[0]);



        if (receitaSelecionada != null) {


            Receita receita = calculadora.obterReceitaPorNome(receitaSelecionada);
            String[] opcoesAcoes = {"adicionar ingrediente", "remover ingrediente", "mudar nome", "excluir receita"};
            String acaoSelecionada = (String) JOptionPane.showInputDialog(null, "escolha:", "mudar receita", JOptionPane.QUESTION_MESSAGE, null, opcoesAcoes, opcoesAcoes[0]);


            if (acaoSelecionada.equals("adicionar ingrediente")) {


                adicionarIngrediente(receita);


            } else if (acaoSelecionada.equals("remover ingrediente")) {                 /////////////// ERRO LEMBRAR


                String nomeIngrediente = JOptionPane.showInputDialog("digite o nome do ingrediente a ser removido:");
                receita.removerIngrediente(nomeIngrediente);
                JOptionPane.showMessageDialog(null, "ingrediente removido: " + nomeIngrediente);


            } else if (acaoSelecionada.equals("Mudar Nome")) {


                String novoNome = JOptionPane.showInputDialog("digite o novo nome da receita:");
                calculadora.mudarNomeReceita(receita.getNome(), novoNome);
                JOptionPane.showMessageDialog(null, "nome da receita alterado para: " + novoNome);


            } else if (acaoSelecionada.equals("excluir receita")) {


                calculadora.removerReceita(receita.getNome());
                JOptionPane.showMessageDialog(null, "receita excluída.");


            }
        }
    }

    private void visualizarReceita() {


        String[] opcoesReceitas = calculadora.obterReceitaNomes();
        String receitaSelecionada = (String) JOptionPane.showInputDialog(null, "escolha uma receita receita:", "ver receita", JOptionPane.QUESTION_MESSAGE, null, opcoesReceitas, opcoesReceitas[0]);


        if (receitaSelecionada != null) {


            calculadora.exibirCustoReceita(receitaSelecionada);


        }
    }


}
