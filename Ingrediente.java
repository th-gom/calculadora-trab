public class Ingrediente {



    private String nome;
    private double quantidadeEmbalagem;
    private double precoEmbalagem;
    private double quantidadeUsada;
    private String tipo;
    private String unidade;




    public Ingrediente(String nome, double quantidadeEmbalagem, double precoEmbalagem, double quantidadeUsada, String tipo, String unidade) {





        this.nome = nome;
        this.quantidadeEmbalagem = quantidadeEmbalagem;
        this.precoEmbalagem = precoEmbalagem;
        this.quantidadeUsada = quantidadeUsada;
        this.tipo = tipo;
        this.unidade = unidade;





    }


    public String getNome() {
           return nome;



    }



    public String getTipo() {
           return tipo;



    }


    public double calcularCusto() {


        if ("Unidade".equals(unidade)) {
            return precoEmbalagem / quantidadeEmbalagem * quantidadeUsada;


        }


        if ("peso".equals(tipo)) {


            if ("Kg".equalsIgnoreCase(unidade)) {

                return (precoEmbalagem / quantidadeEmbalagem) * quantidadeUsada;


            } else if ("Gramas".equalsIgnoreCase(unidade)) {


                return (precoEmbalagem / quantidadeEmbalagem) * quantidadeUsada;


            }


        }

        if ("líquido".equals(tipo)) {


            if ("Litro".equalsIgnoreCase(unidade)) {



                return (precoEmbalagem / quantidadeEmbalagem) * quantidadeUsada;



            } else if ("Ml".equalsIgnoreCase(unidade)) {



                return (precoEmbalagem / quantidadeEmbalagem) * (quantidadeUsada / 1000);



            }
        }


        return (precoEmbalagem / quantidadeEmbalagem) * quantidadeUsada;


    }
}
