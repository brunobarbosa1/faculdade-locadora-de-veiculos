public class Locacao {

    private int id;
    private Cliente cliente;
    private Veiculo veiculo;
    private int diasPrevistos;
    private int diasEfetivos;
    private double valorTotal;
    private StatusLocacao status;

    public Locacao(int id, Cliente cliente, Veiculo veiculo, int diasPrevistos) {
        this.id = id;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.diasPrevistos = diasPrevistos;
        this.diasEfetivos = 0;
        this.valorTotal = veiculo.calcularValorDoAluguel(diasPrevistos);
        this.status = StatusLocacao.ATIVA;
        veiculo.setStatus(StatusVeiculo.ALUGADO);
    }

    public double calcularMulta() {
        int diasExtras = Math.max(0, diasEfetivos - diasPrevistos);
        return diasExtras * veiculo.getValorDiaria() * 1.5;
    }

    public double finalizar(int diasEfetivos) {
        this.diasEfetivos = diasEfetivos;
        this.valorTotal = veiculo.calcularValorDoAluguel(diasEfetivos) + calcularMulta();
        this.status = StatusLocacao.FINALIZADA;
        veiculo.setStatus(StatusVeiculo.DISPONIVEL);
        return valorTotal;
    }

    public void exibirInfo() {
        System.out.printf("Locação #%d - %s | %s %s (%s) | %d dia(s) previsto(s) | R$ %.2f | %s%n",
                id, cliente.getNome(), veiculo.getMarca(), veiculo.getModelo(),
                veiculo.getPlaca(), diasPrevistos, valorTotal, status);
    }

    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Veiculo getVeiculo() { return veiculo; }
    public int getDiasPrevistos() { return diasPrevistos; }
    public int getDiasEfetivos() { return diasEfetivos; }
    public double getValorTotal() { return valorTotal; }
    public StatusLocacao getStatus() { return status; }
}

