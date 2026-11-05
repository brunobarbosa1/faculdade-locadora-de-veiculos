import java.util.ArrayList;
import java.util.List;

public class Locadora {

    private List<Veiculo> veiculos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Locacao> locacoes = new ArrayList<>();

    private int proximoIdVeiculo = 1;
    private int proximoIdCliente = 1;
    private int proximoIdLocacao = 1;

    // Veículos

    public Veiculo buscarVeiculoPorPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) return veiculo;
        }
        return null;
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        if (buscarVeiculoPorPlaca(veiculo.getPlaca()) != null) {
            System.out.println("Erro: já existe um veículo com essa placa.");
        }
        veiculos.add(veiculo);
        proximoIdVeiculo++;
        System.out.println("Veículo cadastrado com sucesso!");
    }

    public void listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        for (Veiculo veiculo : veiculos) {
            veiculo.exibirInfo();
        }
    }

    public void listarVeiculosDisponiveis() {
        boolean achou = false;
        for (Veiculo veiculo : veiculos) {
            if (veiculo.estaDisponivel()){
                veiculo.exibirInfo();
                achou = true;
            }
        }
        if (!achou) System.out.println("Nenhum veículo disponível.");
    }


    // Clientes

    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) return cliente;
        }
        return null;
    }

    public void cadastrarCliente(Cliente cliente) {
        if (buscarClientePorCpf(cliente.getCpf()) != null) {
            System.out.println("Erro: já existe um cliente com esse CPF.");
            return;
        }
        clientes.add(cliente);
        proximoIdCliente++;
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (Cliente c : clientes) {
            c.exibirInfo();
        }
    }

    // Locação

    public Locacao realizarLocacao(String cpf, String placa, int dias) {

        Cliente cliente = buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Erro: Cliente não encontrado.");
            return null;
        }

        Veiculo veiculo = buscarVeiculoPorPlaca(placa);
        if (veiculo == null) {
            System.out.println("Erro: veículo não encontrado.");
            return null;
        }

        if (!veiculo.estaDisponivel()) {
            System.out.println("Erro: veículo não está disponível.");
            return null;
        }

        if (dias < 1) {
            System.out.println("Erro: a quantidade de dias deve ser pelo menos 1.");
            return null;
        }

        Locacao loc = new Locacao(proximoIdLocacao++, cliente, veiculo, dias);
        locacoes.add(loc);
        System.out.printf("Locação #%d realizada! Valor previsto: R$ %.2f%n",
                loc.getId(), loc.getValorTotal());
        return loc;
    }

    public void listarLocacoesAtivas() {
        boolean achou = false;
        for (Locacao l : locacoes) {
            if (l.getStatus() == StatusLocacao.ATIVA) {
                l.exibirInfo();
                achou = true;
            }
        }
        if (!achou) System.out.println("Nenhuma locação ativa.");
    }

    public double devolverVeiculo(int idLocacao, int diasEfetivos) {
        Locacao locacao = null;
        for (Locacao loc : locacoes) {
            if (loc.getId() == idLocacao) { locacao = loc; break; }
        }
        if (locacao == null) {
            System.out.println("Erro: locação não encontrada.");
            return -1;
        }
        if (locacao.getStatus() != StatusLocacao.ATIVA) {
            System.out.println("Erro: essa locação já foi finalizada.");
            return -1;
        }
        if (diasEfetivos < 1) {
            System.out.println("Erro: a quantidade de dias deve ser pelo menos 1.");
            return -1;
        }
        double total = locacao.finalizar(diasEfetivos);
        System.out.printf("Devolução registrada! Multa: R$ %.2f | Total: R$ %.2f%n",
                locacao.calcularMulta(), total);
        return total;
    }

    public int getProximoIdVeiculo() { return proximoIdVeiculo; }
    public int getProximoIdCliente() { return proximoIdCliente; }
}
