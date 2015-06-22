
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utfpr.ct.dainf.if62c.pratica.Jogador;
import utfpr.ct.dainf.if62c.pratica.JogadorComparator;
import utfpr.ct.dainf.if62c.pratica.Time;
import static java.lang.System.*;
import static java.util.Collections.*;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DANIEL
 */
public class Pratica71 {

    public static void main(String[] args) {

        boolean laco = true;
        int numeroInicialDeJogadores = 0;
        ArrayList<Jogador> jogadores = new ArrayList<>();
        Jogador atual;

        Scanner scanner = new Scanner(in);
        out.print("Digite o número de jogadores: ");

        while (laco) {
            if (scanner.hasNextInt() && (numeroInicialDeJogadores = scanner.nextInt()) >= 0) {
 //               numeroInicialDeJogadores = scanner.nextInt();
                out.println();
                laco = false;
            } else {
                out.println("Digite novamente o número de jogadores (um número válido desta vez)");
                scanner.nextLine();
            }
        }

        String nome;
        Integer numJogador/* = 0*/;
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < numeroInicialDeJogadores; i++) {
            laco = true;
            while (laco) {
                out.print("Digite o número do jogador " + (i + 1) + ": ");
                if (scanner.hasNextInt()) {
                    numJogador = scanner.nextInt();
                    out.println();
                    if (frequency(numeros, numJogador) == 0) {
                        numeros.add(numJogador);
                        out.print("Digite o nome do jogador " + (i + 1) + ": ");
                        nome = scanner.next();
                        out.println();
                        atual = new Jogador(numJogador, nome);
                        jogadores.add(atual);
                        laco = false;
                    } else {
                        out.println("Digite um número ainda não utilizado!");
                    }
                } else {
                    out.println("%nReveja seus conceitos!");
                    scanner.nextLine();
                }
            }
        }

        jogadores.sort(new Comparator<Jogador>() {
            @Override
            public int compare(Jogador j1, Jogador j2) {
                return j1.compareTo(j2);
            }
        });

        out.println();

        for (Jogador j : jogadores) {
            out.println(j);
        }
        out.println();

        numJogador = 1;
        while (numJogador != 0) {
            out.print("Digite o número do próximo jogador (número 0 encerra a lista): ");
            if (scanner.hasNextInt()) {
                numJogador = scanner.nextInt();
                out.println();
                if (numJogador == 0) {
                    break;
                }
                out.print("Digite o nome do jogador: ");
                nome = scanner.next();
                out.println();
                atual = new Jogador(numJogador, nome);
                if (!(jogadores.contains(atual))) {
                    if (numeros.contains(numJogador)) {
                        jogadores.set(binarySearch(jogadores, atual), atual);
                    } else {
                        numeros.add(numJogador);
                        jogadores.add(-(binarySearch(jogadores, atual) + 1), atual);
                    }
                }
                for (Jogador j : jogadores) {
                    out.println(j);
                }
                out.println();
            } else {
                out.println("Reveja seus conceitos!");
                scanner.nextLine();
            }
        }
        
        scanner.close();

        out.println("Lista de Jogadores Final:");
        for (Jogador j : jogadores) {
            out.println(j);
        }

        
        /*
         JogadorComparator inspetor = new JogadorComparator(false, true, false);
        
         Time time1 = new Time();
         time1.addJogador("Zagueiro1", new Jogador(4, "David Luiz"));
         time1.addJogador("Zagueiro2", new Jogador(1, "David Luiz"));
         time1.addJogador("Goleiro1", new Jogador(12, "Júlio César"));
         time1.addJogador("Lateral1", new Jogador(20, "Daniel Alves"));
         time1.addJogador("Atacante1", new Jogador(10, "Neymar"));
         time1.addJogador("Técnico1", new Jogador(0, "Filipon"));
         time1.addJogador("Zagueiro3", new Jogador(12, "Júlio Velasquez"));
         time1.addJogador("Zagueiro4", new Jogador(12, "Zuleico"));
         time1.addJogador("Goleiro2", new Jogador(1, "Bagual"));
         time1.addJogador("Zagueiro5", new Jogador(2, "Pereba"));
         time1.addJogador("Lateral2", new Jogador(7, "Drácula"));
         time1.addJogador("Atacante2", new Jogador(11, "Droga"));
         time1.addJogador("Técnico2", new Jogador(0, "Cauquete"));
        
         List<Jogador> timeOrdenado = time1.ordena(inspetor);
         for (Jogador j : timeOrdenado) {
         System.out.println(j);
         }
        
         timeOrdenado.sort(new JogadorComparator());
        
         Jogador teste = timeOrdenado.get(2);
        
         int encontrado = Collections.binarySearch(timeOrdenado, teste, new JogadorComparator());
         System.out.println("Jogador Encontrado: " + timeOrdenado.get(encontrado));
         */
    }
}
