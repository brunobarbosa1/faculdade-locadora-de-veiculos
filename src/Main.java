//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Cliente c = new Cliente(1, "Bruno", "123.456.789-00", "12345678900", "(11) 99999-0000");
        Carro carro = new Carro(1, "ABC1D23", "Fiat", "Argo", 2023, 120.0, 4, true);

        Locacao loc = new Locacao(1, c, carro, 3);
        loc.exibirInfo();
        System.out.println("Status do carro: " + carro.getStatus());

        double total = loc.finalizar(5);
        System.out.printf("Multa: R$ %.2f%n", loc.calcularMulta());
        System.out.printf("Total: R$ %.2f%n", total);
        System.out.println("Status do carro: " + carro.getStatus());

    }
}