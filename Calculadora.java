import javax.swing.*;
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






    }


