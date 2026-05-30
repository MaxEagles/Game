package org.maxeagles;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class Board extends VBox {
    private BoardCell[][] boardCells = new BoardCell[5][5];
    private Rectangle[][] hLines = new Rectangle[6][5];
    private Rectangle[][] vLines = new Rectangle[5][6];

    private final int LINE_SIZE = 104;

    public Board() {
        super();
        this.setAlignment(Pos.CENTER);
        for (int i = 0; i < 5; i++) {
            HBox linesRow = new HBox();
            linesRow.setAlignment(Pos.CENTER);
            linesRow.setSpacing(8);
            for (int j = 0; j < 5; j++) {
                Rectangle hLine = new Rectangle(LINE_SIZE, 1, Game.blackColor);
                hLines[i][j] = hLine;
                linesRow.getChildren().add(hLine);
            }
            this.getChildren().add(linesRow);

            HBox cellsRow = new HBox();
            cellsRow.setAlignment(Pos.CENTER);
            for (int j = 0; j < 5; j++) {
                Rectangle vLine = new Rectangle(1, LINE_SIZE, Game.blackColor);
                vLines[i][j] = vLine;
                cellsRow.getChildren().add(vLine);
                BoardCell boardCell = new BoardCell();
                boardCells[i][j] = boardCell;
                cellsRow.getChildren().add(boardCell);
            }
            Rectangle vLine = new Rectangle(1, LINE_SIZE, Game.blackColor);
            vLines[i][5] = vLine;
            cellsRow.getChildren().add(vLine);
            this.getChildren().add(cellsRow);
        }
        HBox linesRow = new HBox();
        linesRow.setAlignment(Pos.CENTER);
        linesRow.setSpacing(8);
        for (int j = 0; j < 5; j++) {
            Rectangle hLine = new Rectangle(LINE_SIZE, 1, Game.blackColor);
            hLines[5][j] = hLine;
            linesRow.getChildren().add(hLine);
        }
        this.getChildren().add(linesRow);
    }

    public void showStartBoard() {
        boardCells[1][2].setActive();
        boardCells[2][1].setActive();
        boardCells[2][2].setActive();
        boardCells[2][3].setActive();
        boardCells[3][2].setActive();
    }
}
