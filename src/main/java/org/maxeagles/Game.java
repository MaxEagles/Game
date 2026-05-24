package org.maxeagles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Game extends Application {

    public static CardCell chosen;
    public static BoardCell firstCell;
    public static BoardCell secondCell;

    public static Color redColor = Color.INDIANRED;
    public static Color greenColor = Color.LIGHTGREEN;
    public static Color blackColor = Color.BLACK;
    public static Color whiteColor = Color.WHITE;
    public static Color highlightColor = Color.LIGHTGRAY;

    @Override
    public void start(Stage stage) {
        Board board = new Board();
        board.showStartBoard();
        HBox hand = createHand();
        BorderPane borderPane = new BorderPane(board);
        borderPane.setBottom(hand);
        var scene = new Scene(borderPane);
        scene.setFill(whiteColor);
        scene.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                highlightCard(chosen, blackColor);
                chosen = null;
                firstCell = null;
                secondCell = null;
            }
        });
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private HBox createHand() {
        HBox hand = new HBox();
        VBox card = new VBox();
        card.setSpacing(-5);
        CardCell cell1 = new CardCell(greenColor, 7);
        CardCell cell2 = new CardCell(redColor, 2);
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

    public static void highlightCard(CardCell cardCell, Color color) {
        Rectangle border1 = (Rectangle) cardCell.getChildren().get(0);
        Rectangle border2 = (Rectangle) cardCell.getPair().getChildren().get(0);
        border1.setFill(color);
        border2.setFill(color);
    }
}