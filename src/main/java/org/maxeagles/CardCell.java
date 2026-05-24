package org.maxeagles;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class CardCell extends StackPane {
    private CardCell pair;
    private Rectangle border;
    private Rectangle background;
    private Text text;
    private int value;
    private Color color;

    public CardCell(Color color, int value) {
        super();
        this.border = new Rectangle(110, 110, Game.blackColor);
        this.background = new Rectangle(100, 100, color);
        this.color = color;
        this.value = value;
        this.text = new Text(String.valueOf(value));
        this.text.setFont(new Font(50));
        this.getChildren().add(border);
        this.getChildren().add(background);
        this.getChildren().add(text);
        this.setOnMouseClicked(event -> processClicked(event));
    }

    public void setPair(CardCell pair) {
        this.pair = pair;
    }

    public CardCell getPair() {
        return this.pair;
    }

    private void processClicked(MouseEvent event) {
        Game.chosen = (CardCell) event.getSource();
        Game.highlightCard(Game.chosen, Game.highlightColor);
    }

    public Color getColor() {
        return this.color;
    }

    public int getValue() {
        return this.value;
    }
}
