import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] gabaritoProva = new char[10];
        char[] respostasAluno = new char[10];
        int totalAlunos = 0;
        int maiorAcerto = 0, menorAcerto = 10;
        int totalAcertosTurma = 0;

        // Entrada do gabarito da prova pelo professor
        System.out.println("Digite o gabarito da prova:");
        for (int i = 0; i < gabaritoProva.length; i++) {
            System.out.print("Questão " + (i + 1) + ": ");
            gabaritoProva[i] = scanner.next().charAt(0);
        }

        // Loop para processar respostas dos alunos
        boolean outroAluno;
        do {
            System.out.println("\nRespostas do Aluno:");
            for (int i = 0; i < respostasAluno.length; i++) {
                System.out.print("Questão " + (i + 1) + ": ");
                respostasAluno[i] = scanner.next().charAt(0);
            }

            int acertosAluno = verificarAcertos(gabaritoProva, respostasAluno);
            totalAcertosTurma += acertosAluno;

            if (acertosAluno > maiorAcerto) {
                maiorAcerto = acertosAluno;
            }
            if (acertosAluno < menorAcerto) {
                menorAcerto = acertosAluno;
            }

            totalAlunos++;

            System.out.print("\nOutro aluno vai utilizar o sistema? (S/N): ");
            outroAluno = scanner.next().equalsIgnoreCase("S");
        } while (outroAluno);

        double mediaNotas = (double) totalAcertosTurma / totalAlunos;

        System.out.println("\nResultados:");
        System.out.println("Maior Acerto: " + maiorAcerto);
        System.out.println("Menor Acerto: " + menorAcerto);
        System.out.println("Total de Alunos: " + totalAlunos);
        System.out.println("Média das Notas da Turma: " + mediaNotas);

        scanner.close();
    }

    public static int verificarAcertos(char[] gabarito, char[] respostas) {
        int acertos = 0;
        for (int i = 0; i < gabarito.length; i++) {
            if (gabarito[i] == respostas[i]) {
                acertos++;
            }
        }
        return acertos;
    }
}
