package chess.piece;

import chess.Color;
import chess.Column;
import chess.Position;
import chess.Row;

abstract public class Piece {
    Position position;
    Color color;
    PieceType pieceType;

    public Piece(Position position, Color color, PieceType pieceType) {
        this.position = position;
        this.color = color;
        this.pieceType = pieceType;
    }

    public boolean isSamePosition(Column column, Row row) {
        return position.isSame(column, row);
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    public String getPieceName() {
        return this.pieceType.getName();
    }

    public abstract void move(Position targetPosition);

}
