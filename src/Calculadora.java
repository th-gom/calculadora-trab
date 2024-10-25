import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Calculadora {

    private HashMap<String, Receita> receitas;

    public Calculadora() {
        receitas = new HashMap<>();
    }

    public void adicionarReceita(Receita receita) {
        receitas.put(receita.getNome(), receita);
    }
    public void removerReceita(String nomeReceita) {
        receitas.remove(nomeReceita);
    }
    public void mudarNomeReceita(String nomeAntigo, String novoNome) {


        Receita receita = receitas.get(nomeAntigo);


        if (receita != null) {

            receitas.remove(nomeAntigo);
            receita = new Receita(novoNome);
            receitas.put(novoNome, receita);

        }


    }


    public Receita obterReceitaPorNome(String nomeReceita) {
        return receitas.get(nomeReceita);
    }
    public String[] obterReceitaNomes() {
        return receitas.keySet().toArray(new String[0]);
    }
    public void adicionarIngrediente(Ingrediente ingrediente) {


    }

    public void exibirCustoReceita(String nomeReceita) {


        Receita receita = receitas.get(nomeReceita);


        if (receita != null) {


            StringBuilder detalhes = new StringBuilder();
            detalhes.append("ingredientes da receita ").append(nomeReceita).append(":\n");
            for (Ingrediente ingrediente : receita.getIngredientes()) {


                         detalhes.append("- ").append(ingrediente.getNome())
                        .append(" (").append(ingrediente.getTipo()).append("): ")
                        .append("R$ ").append(String.format("%.2f", ingrediente.calcularCusto()))
                        .append("\n");


            }


            detalhes.append("custo total: R$ ").append(String.format("%.2f", receita.calcularCustoTotal()));
            JOptionPane.showMessageDialog(null, detalhes.toString());

        } else {


            JOptionPane.showMessageDialog(null, "receita nao existe.");


        }

    }

}
