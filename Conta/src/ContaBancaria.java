import java.util.Scanner;

public class ContaBancaria {
    // vai guardar o saldo da conta
    private double saldo;
    // Contador para o número de consultas
    private int contadorConsultas;

    // Vai estar iniciando o saldo e o contador de consultas
    public ContaBancaria() {
        this.saldo = 0.0;
        this.contadorConsultas = 0;
    }

    // Faz um deposito na conta
    public void depositar(double valor) {
        // taxa de 1% do depósito
        double taxa = valor * 0.01;
        // Faz a conta do valor com a taxa
        this.saldo += (valor - taxa);
    }

    // Saca um valor de dinheiro da conta
    public void sacar(double valor) {
        // taxa de 0,5% do saque
        double taxa = valor * 0.005;
        // vai veridicar se o saldo e suficiente para ser sacado
        if (this.saldo >= (valor + taxa)) {
            // Faz a conta do valor mais a taxa 
            this.saldo -= (valor + taxa);
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }

    // vai consultar o saldo da conta
    public double consultarSaldo() {
        this.contadorConsultas++;
        // a cada 5 consultas sera cobrado 0.10 centavos
        if (this.contadorConsultas % 5 == 0) {
            this.saldo -= 0.10;
        }
        return this.saldo;
    }

    public static void main(String[] args) {
        // faz um scanner que le as respostas do usuario 
        Scanner scanner = new Scanner(System.in);
        // vai criar uma nova conta bancaria
        ContaBancaria conta = new ContaBancaria();
        // vai ativar e desativar o loop
        boolean continuar = true;

        // Vai se repetir ate o a opçao sair seja escolhida
        while (continuar) {
            // mostra as perguntas como depositar, sacar, consultar saldo e sairr
            System.out.println("Escolha uma operação: 1-Depositar, 2-Sacar, 3-Consultar Saldo, 4-Sair");
            int opcao = scanner.nextInt();

            // quando o usuario escolher umas das opçoes a cima vai estar executando aqui
            switch (opcao) {
                case 1:
                    // pergunta o valor que o usuario deseja depositar
                    System.out.print("Digite o valor para depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    // faz o deposito
                    conta.depositar(valorDeposito);
                    // mostra o valor atualizado
                    System.out.println("Depósito realizado. Saldo atual: " + conta.consultarSaldo());
                    break;
                case 2:
                    // pergunta o valor do saque
                    System.out.print("Digite o valor para saque: ");
                    double valorSaque = scanner.nextDouble();
                    // faz o saque
                    conta.sacar(valorSaque);
                    // mostra o valor atualizado
                    System.out.println("Saque realizado. Saldo atual: " + conta.consultarSaldo());
                    break;
                case 3:
                    // mostra o saldo atual
                    System.out.println("Saldo atual: " + conta.consultarSaldo());
                    break;
                case 4:
                    // acaba o loop quando o usuario escolher a opçao sair
                    continuar = false;
                    System.out.println("Operação finalizada.");
                    break;
                default:
                    // mostra quando o usuario escolhe uma opçao que nao e valida
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
