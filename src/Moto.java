public class Moto extends Veiculo{

    private int cilindradas;

    public Moto(int id, String placa, String marca, String modelo,
                int ano, double valorDiaria, int cilindradas) {

        super(id, placa, marca, modelo, ano, valorDiaria);
        this.cilindradas = cilindradas;
    }

    @Override
    public double calcularValorDoAluguel(int dias) {
       double valor = getValorDiaria() * dias;

       if (cilindradas > 500){
           valor *= 1.10; // 10%
       }
       return valor;
    }

    @Override
    public void exibirInfo() {
        System.out.print("MOTO  ");
        super.exibirInfo();
        System.out.printf("      Cilindradas: %d cc%n", cilindradas);
    }

    public int getCilindradas() { return cilindradas; }
}
