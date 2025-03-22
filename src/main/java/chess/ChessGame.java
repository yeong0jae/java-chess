package chess;

import chess.piece.Piece;
import java.util.function.Supplier;
import view.View;

public class ChessGame {

    private final View view = new View();

    public void play() {

        Board board = new Board();

        while (true) {
            view.printChessBoard(board);

            Position start = retryUntilValid(view::readStartPosition);

            Piece piece = retryUntilValid(() -> board.findPieceByPosition(start));

            Position target = view.readTargetPosition();
            piece.move(target);
        }
    }

    private <T> T retryUntilValid(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
