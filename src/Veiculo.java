public abstract class Veiculo {

    private int id;
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private double valorDiaria;
    private StatusVeiculo status;

    public Veiculo(int id,
                   String placa,
                   String marca,
                   String modelo,
                   int ano,
                   double valorDiaria) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
        this.status = StatusVeiculo.DISPONIVEL;
    }

    public abstract double calcularValorDoAluguel(int dias);

    public boolean estaDisponivel(){
        return status == StatusVeiculo.DISPONIVEL;
    }

    public void exibirInfo() {
        System.out.printf("[%d] %s %s (%d) - Placa: %s - Diária: R$ %.2f - %s%n",
                id, marca, modelo, ano, placa, valorDiaria, status);
    }

    public int getId() { return id; }
    public String getPlaca() { return placa; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAno() { return ano; }
    public double getValorDiaria() { return valorDiaria; }
    public StatusVeiculo getStatus() { return status; }

    public void setValorDiaria(double valorDiaria) { this.valorDiaria = valorDiaria; }
    public void setStatus(StatusVeiculo status) { this.status = status; }

}
