package org.maxeagles;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Game extends Application {

    public static PairedStackPane chosen;
    public static StackPane firstCell;
    public static StackPane secondCell;

    public static Color redColor = Color.PALEVIOLETRED;
    public static Color greenColor = Color.LIGHTGREEN;
    public static Color yellowColor = Color.rgb(249, 162, 4);
    public static Color blackColor = Color.BLACK;
    public static Color whiteColor = Color.WHITE;

    @Override
    public void start(Stage stage) {
        Board board = new Board();
        board.showStartBoard();
        //VBox board = createBoard();
        HBox hand = createHand();
        BorderPane borderPane = new BorderPane(board);
        borderPane.setBottom(hand);
        var scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private VBox createBoard() {
        StackPane [][] cells = new StackPane[5][5];
        VBox board = new VBox();
        board.setAlignment(Pos.CENTER);
        board.setSpacing(-5);
        for (int i = 0; i < 5; i++) {
            HBox row = new HBox();
            row.setAlignment(Pos.CENTER);
            row.setSpacing(-5);
            for (int j = 0; j < 5; j++) {
                Rectangle border = new Rectangle(110, 110, blackColor);
                Rectangle background = new Rectangle(100, 100, whiteColor);
                StackPane cell = new StackPane(border, background);
                cell.setOnMouseClicked(event -> {
                    if (chosen != null) {
                        if (firstCell == null) {
                            firstCell = (StackPane) event.getSource();
                        } else {
                            secondCell = (StackPane) event.getSource();
                            moveCard();
                        }
                    }
                });
                cells[i][j] = cell;
                row.getChildren().add(cell);
            }
            board.getChildren().add(row);
        }
        return board;
    }

    private HBox createHand() {
        HBox hand = new HBox();
        VBox card = new VBox();
        card.setSpacing(-5);
        PairedStackPane cell1 = createCardCell(greenColor, 7);
        PairedStackPane cell2 = createCardCell(redColor, 2);
        card.getChildren().add(cell1);
        card.getChildren().add(cell2);
        cell1.setPair(cell2);
        cell2.setPair(cell1);
        hand.getChildren().add(card);
        return hand;
    }

    public static void moveCard() {
        firstCell.getChildren().add(chosen);
        secondCell.getChildren().add(chosen.getPair());
        highlightCard(chosen, blackColor);
        chosen = null;
        firstCell = null;
        secondCell = null;
    }

    private PairedStackPane createCardCell(Color color, int value) {
        Rectangle border = new Rectangle(110, 110, blackColor);
        Rectangle background = new Rectangle(100, 100, color);
        background.setStroke(blackColor);
        Text text = new Text(String.valueOf(value));
        text.setFont(new Font(50));
        PairedStackPane cell = new PairedStackPane(border, background, text);
        cell.setOnMouseClicked(event -> {
            chosen = (PairedStackPane) event.getSource();
            highlightCard(chosen, Color.MAGENTA);
        });
        return cell;
    }

    private static void highlightCard(PairedStackPane card, Color color) {
        Rectangle border1 = (Rectangle) card.getChildren().get(0);
        Rectangle border2 = (Rectangle) card.getPair().getChildren().get(0);
        border1.setFill(color);
        border2.setFill(color);
    }
}