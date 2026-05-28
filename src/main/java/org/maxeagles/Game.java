package org.maxeagles;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Game extends Application {

    public static CardCell chosen;
    public static BoardCell firstCell;
    public static BoardCell secondCell;

    public static Color redColor = Color.rgb(234, 0, 42);
    public static Color greenColor = Color.rgb(2, 177, 101);
    public static Color blackColor = Color.rgb(16, 15, 15);
    public static Color whiteColor = Color.rgb(251, 248, 238);
    public static Color highlightColor = Color.rgb(251, 210, 4);

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
        card.setSpacing(-1);
        CardCell cell1 = new CardCell(greenColor, 7, Pos.CENTER);
        CardCell cell2 = new CardCell(redColor, 2, Pos.CENTER);
        card.getChildren().add(cell1);
        card.getChildren().add(cell2);
        card.setBorder(new Border(new BorderStroke(
                Game.blackColor,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT
        )));
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