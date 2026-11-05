public class Cliente {

    private int id;
    private String nome;
    private String cpf;
    private String cnh;
    private String telefone;

    public Cliente(int id, String nome, String cpf, String cnh, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
        this.telefone = telefone;
    }

    public void exibirInfo() {
        System.out.printf("[%d] %s - CPF: %s - CNH: %s - Tel: %s%n",
                id, nome, cpf, cnh, telefone);
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getCnh() { return cnh; }
    public String getTelefone() { return telefone; }

    public void setNome(String nome) { this.nome = nome; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}
