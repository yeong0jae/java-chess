package chess.piece;

import chess.Color;
import chess.Movement;
import chess.Position;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    private final List<Movement> movements = new ArrayList<>();

    public Pawn(Position position, Color color, PieceType pieceType) {
        super(position, color, pieceType);

        if (color.isBlack()) {
            movements.addAll(List.of(Movement.DOWN, Movement.RIGHT_DOWN, Movement.LEFT_DOWN));
        }
        if (color.isWhite()) {
            movements.addAll(List.of(Movement.UP, Movement.RIGHT_UP, Movement.LEFT_UP));
        }
    }

    @Override
    public void move(Position targetPosition) {
        for (Movement movement : movements) {
            try {
                if (this.position.move(movement).equals(targetPosition)) {
                    this.position = this.position.move(movement);
                    return;
                }
            } catch (Exception e) {
            }
        }
        throw new IllegalArgumentException("기물의 이동 경로 아님");
    }
}
