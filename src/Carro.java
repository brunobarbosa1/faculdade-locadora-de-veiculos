public class Carro  extends Veiculo{

    private int numeroPortas;
    private boolean arCondicionado;

    public Carro(int id, String placa, String marca, String modelo, int ano,
                 double valorDiaria, int numeroPortas, boolean arCondicionado) {
        super(id, placa, marca, modelo, ano, valorDiaria);
        this.numeroPortas = numeroPortas;
        this.arCondicionado = arCondicionado;
    }

    @Override
    public double calcularValorDoAluguel(int dias) {
        double valor = getValorDiaria() * dias;
        if (arCondicionado){
            valor += 15.0 * dias;
        }
        return valor;
    }

    @Override
    public void exibirInfo() {
        System.out.print("CARRO ");
        super.exibirInfo();
        System.out.printf("      Portas: %d | Ar-condicionado: %s%n",
                numeroPortas,
                arCondicionado ? "Sim" : "Não");
    }

    public int getNumeroPortas() { return numeroPortas; }
    public boolean isArCondicionado() { return arCondicionado; }
}
