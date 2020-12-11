package com.example.tictactoe.business;

import com.example.tictactoe.entity.User;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class Game {

    char rowA[] = {'.','.','.'};
    char rowB[] = {'.','.','.'};
    char rowC[] = {'.','.','.'};

    public void play(){
        boolean end = false;
        Scanner in = new Scanner(System.in);
        int turn = 1;

        displayGrid();
        while (turn <= 9) {
            System.out.print("Player " + turn%2);
            System.out.println(", where do you want to play : (exemple : A1, B2 ...)");
            String value = in.next();
            if(!checkValue(value.toUpperCase()))
                continue;
            if(!putValueInGrid(value.toUpperCase(), turn))
                continue;

            displayGrid();
            if(turn >= 5 && hasWon()){
                System.out.print("Player " + turn%2 + " has won");
                break;
            }
            turn++;
        }
        if(turn == 10){
            System.out.println("It is a draw");
        }
    }

    private boolean hasWon() {
        if( //Row
            (rowA[0]==rowA[1] && rowA[2]==rowA[0] && rowA[0]!='.')||
            (rowB[0]==rowB[1] && rowB[2]==rowB[0] && rowB[0]!='.')||
            (rowC[0]==rowC[1] && rowC[2]==rowC[0] && rowC[0]!='.')||
            //Column
            (rowA[0]==rowB[0] && rowB[0]==rowC[0] && rowA[0]!='.')||
            (rowA[1]==rowB[1] && rowB[1]==rowC[1] && rowA[1]!='.')||
            (rowA[2]==rowB[2] && rowB[2]==rowC[2] && rowA[2]!='.')||
            //Diagonal
            (rowA[0]==rowB[1] && rowB[1]==rowC[2] && rowA[0]!='.')||
            (rowA[2]==rowB[1] && rowB[1]==rowC[0] && rowC[0]!='.')){

            return true;
        }
        return false;
    }

    /**
     *
     * @param value input from player
     * @return true if value in [A1,A2,A3,B1,B2,B3,C1,C2,C3]
     */
    private boolean checkValue(String value) {
        if(value.equals("A1") ||
                value.equals("A2") ||
                value.equals("A3") ||
                value.equals("B1") ||
                value.equals("B2") ||
                value.equals("B3") ||
                value.equals("C1") ||
                value.equals("C2") ||
                value.equals("C3"))
            return true;
        System.out.println("Wrong value");
        return false;
    }

    /**
     *
     * @param played
     * @param turn
     * @throws RuntimeException
     */
    private boolean putValueInGrid(String played, int turn) throws RuntimeException {
        char row[];
        char value;
        switch (played.charAt(0)){
            case 'A':
                row = rowA;
                break;
            case 'B':
                row = rowB;
                break;
            default:
                row = rowC;
                break;
        }
        int i = Character.getNumericValue(played.charAt(1)) - 1;
        if(row[i] == '.'){
            row[i] = (turn%2==0) ? 'O' : 'X';
            return true;
        }
        System.out.println("Already played");
        return false;
    }

    public void displayGrid(){
        int i = 0;
        System.out.println("   1 2 3 ");
        System.out.print("A |");
        displayRow(rowA);
        System.out.print("B |");
        displayRow(rowB);
        System.out.print("C |");
        displayRow(rowC);
    }

    public void displayRow(char[] row){
        for (char box: row) {
            System.out.print(box + "|");
        }
        System.out.println();
    }
}
