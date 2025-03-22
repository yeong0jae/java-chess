package chess;

import chess.piece.Bishop;
import chess.piece.King;
import chess.piece.Knight;
import chess.piece.Pawn;
import chess.piece.Piece;
import chess.piece.PieceType;
import chess.piece.Queen;
import chess.piece.Rook;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    public static final int MIN_SIZE = 0;
    public static final int MAX_SIZE = 8;

    List<Piece> pieces;

    public Board() {
        List<Piece> initPieces = new ArrayList<>();
        initBoard(initPieces);

        pieces = initPieces;
    }

    public boolean hasPiece(Row row, Column column) {
        return pieces.stream()
                .anyMatch(pieces -> pieces.isSamePosition(column, row));
    }

    public Piece findPieceByPosition(Row row, Column column) {
        return pieces.stream()
                .filter(pieces -> pieces.isSamePosition(column, row))
                .findFirst()
                .get();
    }

    public Piece findPieceByPosition(Position position) {
        return pieces.stream()
                .filter(piece -> piece.isSamePosition(position))
                .findFirst()
                .get();
    }

    private void initBoard(List<Piece> initPieces) {
        initPieces.add(new Rook(new Position(Column.A, Row.ONE), Color.WHITE, PieceType.ROOK));
        initPieces.add(new Knight(new Position(Column.B, Row.ONE), Color.WHITE, PieceType.KNIGHT));
        initPieces.add(new Bishop(new Position(Column.C, Row.ONE), Color.WHITE, PieceType.BISHOP));
        initPieces.add(new Queen(new Position(Column.D, Row.ONE), Color.WHITE, PieceType.QUEEN));
        initPieces.add(new King(new Position(Column.E, Row.ONE), Color.WHITE, PieceType.KING));
        initPieces.add(new Bishop(new Position(Column.F, Row.ONE), Color.WHITE, PieceType.BISHOP));
        initPieces.add(new Knight(new Position(Column.G, Row.ONE), Color.WHITE, PieceType.KNIGHT));
        initPieces.add(new Knight(new Position(Column.H, Row.ONE), Color.WHITE, PieceType.ROOK));

        Arrays.stream(Column.values()).forEach(column -> {
            initPieces.add(new Pawn(new Position(column, Row.TWO), Color.WHITE, PieceType.PAWN));
        });

        initPieces.add(new Rook(new Position(Column.A, Row.EIGHT), Color.BLACK, PieceType.ROOK));
        initPieces.add(new Knight(new Position(Column.B, Row.EIGHT), Color.BLACK, PieceType.KNIGHT));
        initPieces.add(new Bishop(new Position(Column.C, Row.EIGHT), Color.BLACK, PieceType.BISHOP));
        initPieces.add(new Queen(new Position(Column.D, Row.EIGHT), Color.BLACK, PieceType.QUEEN));
        initPieces.add(new King(new Position(Column.E, Row.EIGHT), Color.BLACK, PieceType.KING));
        initPieces.add(new Bishop(new Position(Column.F, Row.EIGHT), Color.BLACK, PieceType.BISHOP));
        initPieces.add(new Knight(new Position(Column.G, Row.EIGHT), Color.BLACK, PieceType.KNIGHT));
        initPieces.add(new Knight(new Position(Column.H, Row.EIGHT), Color.BLACK, PieceType.ROOK));

        Arrays.stream(Column.values()).forEach(column -> {
            initPieces.add(new Pawn(new Position(column, Row.SEVEN), Color.BLACK, PieceType.PAWN));
        });
    }

    public List<Piece> getPieces() {
        return pieces;
    }

}
