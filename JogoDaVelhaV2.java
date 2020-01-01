/**
 * Autor: Matheus Rocha
 * Data de inicio: 10/12/2019
 * Data de conclusão: 12/12/2019
 * Classe: Jogo da Velha
 */

package Projetos.JogoDaVelha;

import java.util.Scanner;

public class JogoDaVelhaV2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] tabuleiro = new String[3][3];
        boolean jogadorBolaWin = false;
        boolean jogadorXWin = false;
        int empate = 0;
        int jogadorWin = 0;
        int jogador = 1;
        int linha = 0 , coluna = 0, jogadas = 0;


        // Preenche o tabuleiro com " - "
        for (int i = 0; i<tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = "-";
            }
        }

        do {
            // Mostra o tabuleiro na tela
            System.out.println("================================ Tabuleiro ================================");
            for (int i = 0; i<tabuleiro.length; i++) {
                for (int j = 0; j < tabuleiro[i].length; j++) {
                    // Esse IF faz com que no final de cada linha pule uma linha
                    if (j == 2) {
                        System.out.println(tabuleiro[i][j]);
                    } else {
                        System.out.print(tabuleiro[i][j] + " "); // O espaço no final é para separar os " - "
                    }
                }
            }
            System.out.println();
            // Essa condição faz a troca de jogadores.
            if (jogador == 1) {
                do {
                    System.out.println("Vez do jogador 1");
                    System.out.print("Informe a linha: ");
                    linha = scan.nextInt();
                    System.out.print("Informe a coluna: ");
                    coluna = scan.nextInt();

                    if ((linha < 0 || linha > 2) || (coluna < 0 || coluna > 2)) {
                        System.out.println();
                        System.out.println("Informe um número entre 0 e 2 para linha e coluna.");
                        System.out.println();
                    }
                } while ((linha < 0 || linha > 2) || (coluna < 0 || coluna > 2));

                if (tabuleiro[linha][coluna].equals("x") || tabuleiro[linha][coluna].equals("o")) {
                    // Verifica se a posição já foi jogada e faz que o mesmo jogador jogue de novo !!
                    jogador = 1; // A jogada continua com o jogador 1
                    System.out.println("A posição já está preenchida, jogue novamente.");
                } else {
                    tabuleiro[linha][coluna] = "x";
                    jogador = 2; // Caso a posição esteja vazia, muda para o jogador 2
                    jogadas ++;
                }

            } else if (jogador == 2) {
                do {
                    System.out.println("Vez do jogador 1");
                    System.out.print("Informe a linha: ");
                    linha = scan.nextInt();
                    System.out.print("Informe a coluna: ");
                    coluna = scan.nextInt();

                    if ((linha < 0 || linha > 2) || (coluna < 0 || coluna > 2)) {
                        System.out.println();
                        System.out.println("Informe um número entre 0 e 2 para linha e coluna.");
                        System.out.println();
                    }
                } while ((linha < 0 || linha > 2) || (coluna < 0 || coluna > 2));

                if (tabuleiro[linha][coluna].equals("x") || tabuleiro[linha][coluna].equals("o")) {
                    // Verifica se a posição já foi jogada e faz que o mesmo jogador jogue de novo !!
                    jogador = 2;
                    System.out.println("A posição já está preenchida, jogue novamente.");
                } else {
                    tabuleiro[linha][coluna] = "o";
                    jogador = 1;
                    jogadas ++;
                }

            }

            // Essa condição verifica se há vencedores ou se deu empate.
            if (jogadas > 0 && jogadas < 9) {
                // Essas condições verificam se jogador X venceu.
                if (tabuleiro[0][0].equals("x") && tabuleiro[0][1].equals("x") && tabuleiro[0][2].equals("x") ||
                        tabuleiro[0][0].equals("x") && tabuleiro[1][0].equals("x") && tabuleiro[2][0].equals("x") ||
                        tabuleiro[0][1].equals("x") && tabuleiro[1][1].equals("x") && tabuleiro[2][1].equals("x") ||
                        tabuleiro[0][2].equals("x") && tabuleiro[1][2].equals("x") && tabuleiro[2][2].equals("x")) {
                    jogadorXWin = true;
                } else if (tabuleiro[1][0].equals("x") && tabuleiro[1][1].equals("x") && tabuleiro[1][2].equals("x") ||
                        tabuleiro[0][0].equals("x") && tabuleiro[1][1].equals("x") && tabuleiro[2][2].equals("x")) {
                    jogadorXWin = true;
                } else if (tabuleiro[2][0].equals("x") && tabuleiro[2][1].equals("x") && tabuleiro[2][2].equals("x") ||
                        tabuleiro[0][2].equals("x") && tabuleiro[1][1].equals("x") && tabuleiro[2][0].equals("x")) {
                    jogadorXWin = true;
                }

                // Essas condições verificam se jogador bola venceu.
                if (tabuleiro[0][0].equals("o") && tabuleiro[0][1].equals("o") && tabuleiro[0][2].equals("o") ||
                        tabuleiro[0][0].equals("o") && tabuleiro[1][0].equals("o") && tabuleiro[2][0].equals("o") ||
                        tabuleiro[0][1].equals("o") && tabuleiro[1][1].equals("o") && tabuleiro[2][1].equals("o") ||
                        tabuleiro[0][2].equals("o") && tabuleiro[1][2].equals("o") && tabuleiro[2][2].equals("o")) {
                    jogadorBolaWin = true;
                } else if (tabuleiro[1][0].equals("o") && tabuleiro[1][1].equals("o") && tabuleiro[1][2].equals("o") ||
                        tabuleiro[0][0].equals("o") && tabuleiro[1][1].equals("o") && tabuleiro[2][2].equals("o")) {
                    jogadorBolaWin = true;
                } else if (tabuleiro[2][0].equals("o") && tabuleiro[2][1].equals("o") && tabuleiro[2][2].equals("o") ||
                        tabuleiro[0][2].equals("o") && tabuleiro[1][1].equals("o") && tabuleiro[2][0].equals("o")) {
                    jogadorBolaWin = true;
                }
            } else {
                System.out.println("===================== Deu empate!! ===================== ");
                empate = 1;
            }

            if (jogadorBolaWin == true || jogadorXWin == true) {
                // Esse if é pra printar novamente o tabuleiro pois sem ele não printa a última jogada
                // Devido a condição vencedor ser verdadeira e ele sair do do - while.
                System.out.println("================================ Tabuleiro ================================");
                for (int i = 0; i<tabuleiro.length; i++) {
                    for (int j = 0; j < tabuleiro[i].length; j++) {
                        // Esse IF faz com que no final de cada linha pule uma linha
                        if (j == 2) {
                            System.out.println(tabuleiro[i][j]);
                        } else {
                            System.out.print(tabuleiro[i][j] + " "); // O espaço no final é para separar os " - "
                        }
                    }
                }
            }
        } while (jogadorBolaWin == false && jogadorXWin == false && empate == 0);

        if (jogadorXWin == true) {
            System.out.println("===================== Jogador 1 venceu!! Parabéns. =====================");
        } else if (jogadorBolaWin == true) {
            System.out.println("===================== Jogador 2 venceu!! Parabéns. =====================");
        }
    }
}