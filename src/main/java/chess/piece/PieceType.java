package chess.piece;

public enum PieceType {
    ROOK("R"),
    KNIGHT("N"),
    BISHOP("B"),
    KING("K"),
    QUEEN("Q"),
    PAWN("P");

    private final String name;

    PieceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
