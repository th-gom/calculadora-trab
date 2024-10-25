import java.util.ArrayList;

public class Receita {

    private String nome;
    private ArrayList<Ingrediente> ingredientes;

    public Receita(String nome) {

        this.nome = nome;
        this.ingredientes = new ArrayList<>();

    }

    public String getNome() {

        return nome;

    }

    public void adicionarIngrediente(Ingrediente ingrediente) {

        ingredientes.add(ingrediente);

    }

    public void removerIngrediente(String nomeIngrediente) {

        ingredientes.removeIf(ingrediente -> ingrediente.getNome().equalsIgnoreCase(nomeIngrediente));

    }

    public double calcularCustoTotal() {

        double custoTotal = 0;

        for (Ingrediente ingrediente : ingredientes) {

            custoTotal += ingrediente.calcularCusto();

        }


        return custoTotal;


    }

    public ArrayList<Ingrediente> getIngredientes() {


        return ingredientes;


    }
}
