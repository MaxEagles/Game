package org.maxeagles;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardCell extends StackPane {
    private Rectangle border;
    private Rectangle background;
    private boolean isActive;

    public BoardCell() {
        super();
        this.border = new Rectangle(110, 110, Game.blackColor);
        this.background = new Rectangle(100, 100, Game.whiteColor);
        this.isActive = true;
        this.getChildren().add(border);
        this.getChildren().add(background);
        this.setOnMouseClicked(event -> processClicked(event));
    }

    public void setInactive() {
        background.setFill(Color.GREY);
        isActive = false;
    }

    public void setActive() {
        background.setFill(Game.whiteColor);
        isActive = true;
    }

    private void processClicked(MouseEvent event) {
        if (Game.chosen != null) {
            if (Game.firstCell == null) {
                Game.firstCell = (StackPane) event.getSource();
            } else {
                Game.secondCell = (StackPane) event.getSource();
                Game.moveCard();
            }
        }
    }
}
