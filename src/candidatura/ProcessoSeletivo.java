package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String[] candidatos = { "FELIPE", "MARCIA", "PAULO", "AUGUSTO", "MONICA" };
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }

    }

    static void entrandoEmContato(String candidato){
            int tentivasRealizadas=1;
            boolean continuarTentando=true;
            boolean atendeu=false;
            do{
                atendeu=atender();
                continuarTentando=!atendeu;
                if(continuarTentando)
                    tentivasRealizadas++;
                else
                System.out.println("contato realizado com sucesso");

            }while(continuarTentando && tentivasRealizadas < 3);
                if(atendeu)
                System.out.println("conseguimos contato com "+ candidato+" na "+ tentivasRealizadas+" tentativa");
                else
                    System.out.println("não conseguimos contato com "+ candidato+" ,número maximo de tentativas "+ tentivasRealizadas+" tentativa");
                
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void imprimirCandidatos() {
        String[] candidatos = { "FELIPE", "MARCIA", "PAULO", "AUGUSTO", "MONICA" };
        System.out.println("Imprimir a lista de candidatos imformando o indice do elemento");
        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("o candidato de nº " + (indice + 1) + " é o" + candidatos[indice]);
        }
        System.out.println("forma abreviada de interação for each");
        for (String candidato : candidatos) {
            System.out.println("o candidato selecionado foi " + candidato);

        }

    }

    static void selecaoCandidatos() {
        String[] candidatos = { "FELIPE", "MARCIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA",
                "JULIA" };
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("o candidato " + candidato + " soliciotou este vallor de salario " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("o candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analizarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido)
            System.out.println("ligar para o candidato");
        else if (salarioBase == salarioPretendido)
            System.out.println("ligar para o candidato com contra proposta");
        else
            System.out.println("agardando o resultado dos demais candidatos");

    }
}