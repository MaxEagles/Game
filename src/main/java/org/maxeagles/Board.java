package org.maxeagles;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Board extends VBox {
    private BoardCell[][] boardCells = new BoardCell[5][5];

    public Board() {
        super();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(5);
        for (int i = 0; i < 5; i++) {
            HBox row = new HBox();
            row.setAlignment(Pos.CENTER);
            row.setSpacing(5);
            for (int j = 0; j < 5; j++) {
                BoardCell boardCell = new BoardCell();
                boardCells[i][j] = boardCell;
                row.getChildren().add(boardCell);
            }
            this.getChildren().add(row);
        }
    }

    public void showStartBoard() {
        boardCells[1][2].setActive();
        boardCells[2][1].setActive();
        boardCells[2][2].setActive();
        boardCells[2][3].setActive();
        boardCells[3][2].setActive();
//        boardCells[2][1].setPadding(new Insets(10, 5, 10, 15));
//        boardCells[2][2].setPadding(new Insets(10, 15, 10, 5));
        boardCells[2][1].getBack().setFill(Game.greenColor);
        boardCells[2][2].getBack().setFill(Game.greenColor);
    }
}
