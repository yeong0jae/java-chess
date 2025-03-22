package chess.piece;

import chess.Color;
import chess.Movement;
import chess.Position;
import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    private final List<Movement> movements = new ArrayList<>(List.of(
            Movement.UP, Movement.DOWN, Movement.RIGHT, Movement.LEFT
    ));

    public King(Position position, Color color, PieceType pieceType) {
        super(position, color, pieceType);
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
