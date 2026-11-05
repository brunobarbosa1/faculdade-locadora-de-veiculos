//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Veiculo[] frota = {
                new Carro(1, "ABC1D23", "Fiat", "Argo", 2023, 120.0, 4, true),
                new Moto(2, "XYZ9K87", "Honda", "CB 650R", 2022, 90.0, 650)
        };

        for (Veiculo v : frota) {
            v.exibirInfo();
            System.out.printf("      3 dias = R$ %.2f%n%n", v.calcularValorDoAluguel(3));
        }

    }
}