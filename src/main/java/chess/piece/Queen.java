package chess.piece;

import chess.Color;
import chess.Position;

public class Queen extends Piece {

    public Queen(Position position, Color color, PieceType pieceType) {
        super(position, color, pieceType);
    }

    @Override
    public void move(Position targetPosition) {
        throw new IllegalArgumentException();
    }
}
