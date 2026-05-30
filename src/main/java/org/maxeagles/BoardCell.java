package org.maxeagles;

import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class BoardCell extends StackPane {
    private Rectangle background;
    private Rectangle colorArea;
    private CardCell chosenCopy;
    private boolean isActive;

    public BoardCell() {
        super();
        this.background = new Rectangle(110, 110, Game.whiteColor);
        this.colorArea = new Rectangle(100, 100, Game.highlightColor);
        setInactive();
        this.getChildren().add(background);
        this.getChildren().add(colorArea);
        this.setOnMouseClicked(event -> processClicked(event));
        this.setOnMouseEntered(event -> processEntered(event));
        this.setOnMouseExited(event -> processExited(event));
    }

    public void setInactive() {
        this.setVisible(false);
        isActive = false;
    }

    public void setActive() {
        this.setVisible(true);
        isActive = true;
    }

    public Rectangle getBack() {
        return this.background;
    }

    private void processClicked(MouseEvent event) {
        if (Game.chosen != null) {
            if (Game.firstCell == null) {
                Game.firstCell = (BoardCell) event.getSource();
            } else {
                Game.secondCell = (BoardCell) event.getSource();
                Game.moveCard();
            }
        }
    }

    private void processEntered(MouseEvent event) {
        if (Game.chosen != null) {
            chosenCopy = createCopy(Game.chosen);
            this.getChildren().add(chosenCopy);
        }
    }

    private void processExited(MouseEvent event) {
        if (chosenCopy != null) {
            this.getChildren().remove(chosenCopy);
        }
    }

    private CardCell createCopy(CardCell original) {
        return new CardCell(original.getColor(), original.getValue());
    }
}
