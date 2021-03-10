package com.company;

import java.util.Scanner;

public class Main {

    private static int victoryH(int[][] matriceBoard, int jeton) {

        // Vérifier que la colonne 1 ligne 6 est égale au jeton observé
        // Si oui alors un compteur est alimenté à +1
        // Si non alors le compteur revient à 0
        // Si le compteur vaut 4
        // alors victoire du joueur
        // On passe à la colonne suivante
        // Vérifier...

        int pointVH = 0;

        // TEST HORIZONTAL
        // Boucle lignes (J)
        for (int j = 5; j > -1 && pointVH < 4; j--) {

            // Boucle colonnes (i)
            for (int i = 0; i < 7 && pointVH < 4; i++) {

                if (matriceBoard[j][i] == jeton) {
                    pointVH = pointVH + 1;
                    if (pointVH == 4) {
                        System.out.println("Joueur " + jeton + " a gagné!");
                        break;
                    }
                } else {
                    pointVH = 0;
                }
            }
        }
        return pointVH;
    }

    private static int victoryV(int[][] matriceBoard, int jeton) {

        int pointVV = 0;

        // TEST VERTICAL
        // Boucle colonnes (k)

        for (int k = 0; k < 7 && pointVV < 4; k++) {
            // Boucle lignes (l)
            for (int l = 5; l > -1 && pointVV < 4; l--) {
                if (matriceBoard[l][k] == jeton) {
                    pointVV = pointVV + 1;
                    if (pointVV == 4) {
                        System.out.println("Joueur " + jeton + " a gagné!");
                        break;
                    }
                } else {
                    pointVV = 0;
                }
            }
        }
        return pointVV;
    }

    private static int victoryD(int[][] matriceBoard, int jeton) {

        int pointVD = 0;

        // Observer la position du dernier jeton joué
        // Regarder la valeur de celui-ci
        // Se déplacer à +1/+1
        // observer la nouvelle valeur
        // si c'est la même alors on alimente un compteur
        // sinon on se déplace à +1/-1
        // ...
        // une fois que les diagonales sont vérifiées le test s'arrête

        return pointVD;
    }

    private static void limits(int chooseColumn) {
        // Délimite le plateau de jeu
        // A développer : faire en sorte de recommencer le tour du joueur qui s'est loupé

        if ((chooseColumn <= 6) && (chooseColumn >= 0)) {
        } else {
            System.err.println("Vous avez jeté votre jeton à côté !");
        }
    }

    private static void board(int[][] board) {

        // Afficher la grille de jeu
        for (int ncolumns = 0; ncolumns < 6; ncolumns++) {
            for (int nlines = 0; nlines < 7; nlines++) {
                System.out.print(board[ncolumns][nlines]);
            }
            System.out.println();
        }
    }

    private static int token(int[][] matriceBoard, int chooseColumn, int jeton) {
        // Placer des jetons

        for (int i = 5; i >= 0; i--) {

            if (matriceBoard[0][chooseColumn] != 0) {
                System.err.println("Colonne pleine, merci de choisir une autre colonne");
                break;
            } else {
                if (matriceBoard[i][chooseColumn] == 0) {
                    matriceBoard[i][chooseColumn] = jeton;
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Définir notre Scanner
        Scanner sc = new Scanner(System.in);

        //Définir le tableau
        int[][] matriceBoard = new int[6][7];

        //Déclarer les joueurs
        System.out.println("Entrez le nom du joueur 1 : ");
        String player1 = sc.nextLine();
        System.out.println("Entrez le nom du joueur 2 : ");
        String player2 = sc.nextLine();

        for (int compteur = 0; compteur < 100; compteur++) {

            // Si le compteur est pair joueur 1 doit jouer
            // Afficher "vas-y joueur 1", choisis ta colonne
            // Récupérer le numéro de colonne
            // Vérifier si le numéro de colonne est correct
            // Jouer pour joueur 1
            // Tant que le score n'est pas à 4 (vertical, horizontal ou diagonal) on continue de jouer

            // Sinon joueur 2 doit jouer
            // Afficher "vas-y joueur 2", choisis ta colonne
            // Récupérer le numéro de colonne
            // Vérifier si le numéro de colonne est correct
            // Jouer pour joueur 2
            // Tant que le score n'est pas à 4 (vertical, horizontal ou diagonal) on continue de jouer
            // Quand le score final pour un des 2 joueurs affiche 4 stopper le jeu

            if (compteur % 2 == 0) {
                System.out.println(player1 + " " + "Choisir votre numéro de colonne : ");
            } else {
                System.out.println(player2 + " " + "Choisir votre numéro de colonne : ");
            }

            int chooseColumn = sc.nextInt() - 1;
            sc.nextLine();

            // Appeler la fonction limits
            limits(chooseColumn);

            if (compteur % 2 == 0) {
                // appeler la fonction token pour déposer un jeton
                // afficher le tableau actualisé
                // tester les conditions de victoires
                // token(matriceBoard, chooseColumn, 1);
                int positionLines = token(matriceBoard, chooseColumn, 1);
                board(matriceBoard);
                if (victoryH(matriceBoard, 1) == 4) {
                    break;
                }
                if (victoryV(matriceBoard, 1) == 4) {
                    break;
                }
                if (victoryD(matriceBoard, 1) == 4) {
                    break;
                }
            } else {
                int positionLines = token(matriceBoard, chooseColumn, 2);
                board(matriceBoard);
                if (victoryH(matriceBoard, 2) == 4) {
                    break;
                }
                if (victoryV(matriceBoard, 2) == 4) {
                    break;
                }
                if (victoryD(matriceBoard, 2) == 4) {
                    break;
                }
            }
        }
    }
}