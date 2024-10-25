



public class Ingrediente {

    private String nome;
    private double quantidadeEmbalagem;
    private double precoEmbalagem;
    private double quantidadeUsada;
    private String tipo;

    public Ingrediente(String nome, double quantidadeEmbalagem, double precoEmbalagem, double quantidadeUsada, String tipo) {

        this.nome = nome;
        this.quantidadeEmbalagem = quantidadeEmbalagem;
        this.precoEmbalagem = precoEmbalagem;
        this.quantidadeUsada = quantidadeUsada;
        this.tipo = tipo;

    }

    public String getNome() {
        return nome;
    }

    public double getQuantidadeEmbalagem() {
        return quantidadeEmbalagem;
    }
    public double getPrecoEmbalagem() {
        return precoEmbalagem;
    }
    public double getQuantidadeUsada() {
        return quantidadeUsada;
    }

    public String getTipo() {
        return tipo;
    }

    public double calcularCusto() {
        return (precoEmbalagem / quantidadeEmbalagem) * quantidadeUsada;
    }
}
