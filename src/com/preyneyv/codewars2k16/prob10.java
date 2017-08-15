package com.preyneyv.codewars2k16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class prob10 {
    public static void main(String[] args){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));

            List<String[][]> boards = new ArrayList<>();

            String line;
            while (!(line = reader.readLine()).equals("=========")) {
                // fetch and store all input
                String[] row1 = line.substring(0, 3).split("");
                String[] row2 = line.substring(3, 6).split("");
                String[] row3 = line.substring(6).split("");
                String[][] board = {row1,row2,row3};
                boards.add(board);
            }

            for (String[][] board : boards) {
                // look for winner
                String winner = null;
                
                // check verticals
                for (int c = 0; c < board.length; c++) {
                    String tok = board[0][c];
                    if(tok.equals("="))
                        continue;

                    if(board[1][c].equals(board[2][c]) && tok.equals(board[1][c])) {
                        winner = tok;
                        board[0][c] = "$";
                        board[1][c] = "$";
                        board[2][c] = "$";
                        break;
                    }
                }
                if (winner == null) {
                    // check horizontals
                    for (int r = 0; r < board.length; r++) {
                        String tok = board[r][0];
                        if(tok.equals("="))
                            continue;

                        if(board[r][1].equals(board[r][2]) && tok.equals(board[r][1])) {
                            winner = tok;
                            board[r][0] = "$";
                            board[r][1] = "$";
                            board[r][2] = "$";
                            break;
                        }
                    }

                    if (winner == null) {
                        // check diagonals
                        if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].equals("=")) {
                            winner = board[0][0];
                            board[0][0] = board[1][1] = board[2][2] = "$";
                        }
                        if(board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[0][2].equals("=")) {
                            winner = board[0][2];
                            board[0][2] = board[1][1] = board[2][0] = "$";
                        }
                    }
                }
                if(winner == null) {
                    System.out.println("There was a tie.");
                }else {
                    System.out.printf("Player %s won.\n", winner);
                }
                for (String[] row : board) {
                    for (String piece : row) {
                        System.out.print(piece);
                    }
                    System.out.println();
                }

                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
