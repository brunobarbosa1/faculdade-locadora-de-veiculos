import java.util.Scanner;

public class Menu {

    private Locadora locadora;
    private Scanner scanner =  new Scanner(System.in);

    public Menu(Locadora locadora) {
        this.locadora = locadora;
    }

    public void executar() {
        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = lerOpcao();
            System.out.println();

            switch (opcao) {
                case 1 -> cadastrarCarro();
                case 2 -> cadastrarMoto();
                case 3 -> locadora.listarVeiculos();
                case 4 -> locadora.listarVeiculosDisponiveis();
                case 5 -> cadastrarCliente();
                case 6 -> locadora.listarClientes();
                case 7 -> realizarLocacao();
                case 8 -> devolverVeiculo();
                case 9 -> locadora.listarLocacoesAtivas();
                case 0 -> System.out.println("Saindo... Até logo!");
                default -> System.out.println("Opção inválida.");
            }
            System.out.println();
        } while (opcao != 0);
    }

    private void exibirMenuPrincipal() {
        System.out.println("===== LOCADORA DE VEÍCULOS =====");
        System.out.println("1 - Cadastrar carro");
        System.out.println("2 - Cadastrar moto");
        System.out.println("3 - Listar veículos");
        System.out.println("4 - Listar veículos disponíveis");
        System.out.println("5 - Cadastrar cliente");
        System.out.println("6 - Listar clientes");
        System.out.println("7 - Realizar locação");
        System.out.println("8 - Devolver veículo");
        System.out.println("9 - Listar locações ativas");
        System.out.println("0 - Sair");
    }

    // Ações do menu

    private void cadastrarCarro() {
        System.out.println("--- Cadastro de Carro ---");
        String placa = lerTexto("Placa: ");
        String marca = lerTexto("Marca: ");
        String modelo = lerTexto("Modelo: ");
        int ano = lerInt("Ano: ");
        double diaria = lerDouble("Valor da diária: ");
        int portas = lerInt("Número de portas: ");
        boolean ar = lerSimNao("Tem ar-condicionado? (s/n): ");

        locadora.cadastrarVeiculo(new Carro(locadora.getProximoIdVeiculo(),
                placa, marca, modelo, ano, diaria, portas, ar));
    }

    private void cadastrarMoto() {
        System.out.println("--- Cadastro de Moto ---");
        String placa = lerTexto("Placa: ");
        String marca = lerTexto("Marca: ");
        String modelo = lerTexto("Modelo: ");
        int ano = lerInt("Ano: ");
        double diaria = lerDouble("Valor da diária: ");
        int cilindradas = lerInt("Cilindradas: ");

        locadora.cadastrarVeiculo(new Moto(locadora.getProximoIdVeiculo(),
                placa, marca, modelo, ano, diaria, cilindradas));
    }

    private void cadastrarCliente() {
        System.out.println("--- Cadastro de Cliente ---");
        String nome = lerTexto("Nome: ");
        String cpf = lerTexto("CPF: ");
        String cnh = lerTexto("CNH: ");
        String telefone = lerTexto("Telefone: ");

        locadora.cadastrarCliente(new Cliente(locadora.getProximoIdCliente(),
                nome, cpf, cnh, telefone));
    }

    private void realizarLocacao() {
        System.out.println("--- Nova Locação ---");
        String cpf = lerTexto("CPF do cliente: ");
        String placa = lerTexto("Placa do veículo: ");
        int dias = lerInt("Quantidade de dias: ");
        locadora.realizarLocacao(cpf, placa, dias);
    }

    private void devolverVeiculo() {
        System.out.println("--- Devolução ---");
        locadora.listarLocacoesAtivas();
        int id = lerInt("ID da locação: ");
        int dias = lerInt("Dias efetivamente utilizados: ");
        locadora.devolverVeiculo(id, dias);
    }

    // Uso do scanner. Validações necessárias

    private int lerOpcao() {
        return lerInt("Escolha uma opção: ");
    }

    private String lerTexto(String msg) {
        String texto;
        do {
            System.out.print(msg);
            texto = scanner.nextLine().trim();
        } while (texto.isEmpty());
        return texto;
    }

    private int lerInt(String msg) {
        while (true) {
            try {
                return Integer.parseInt(lerTexto(msg));
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private double lerDouble(String msg) {
        while (true) {
            try {
                return Double.parseDouble(lerTexto(msg).replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor válido (ex.: 120,50).");
            }
        }
    }

    private boolean lerSimNao(String msg) {
        while (true) {
            String r = lerTexto(msg).toLowerCase();
            if (r.equals("s")) return true;
            if (r.equals("n")) return false;
            System.out.println("Responda com s ou n.");
        }
    }
}
