package view;

import chess.Board;
import chess.Column;
import chess.Position;
import chess.Row;
import chess.piece.Piece;
import java.util.Scanner;

public class View {

    private static final Scanner scanner = new Scanner(System.in);

    public void printChessBoard(Board board) {

        System.out.println("체스판 현황");
        for (Row row : Row.values()) {
            for (Column col : Column.values()) {
                if (board.hasPiece(row, col)) {
                    Piece piece = board.findPieceByPosition(row, col);
                    System.out.print(piece.getPieceName() + " ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }

    }

    public Position readStartPosition() {
        System.out.println("움직일 말 좌표 입력 ㄱ");
        String input = scanner.nextLine();
        return new Position(
                Column.from(input.split(",")[0]),
                Row.from(Integer.parseInt(input.split(",")[1])));
    }

    public Position readTargetPosition() {
        System.out.println("이동할 좌표 입력 ㄱ");
        String input = scanner.nextLine();
        return new Position(
                Column.from(input.split(",")[0]),
                Row.from(Integer.parseInt(input.split(",")[1])));
    }
}
