package org.maxeagles;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class Card extends StackPane {
    private VBox vertical;
    private HBox horizontal;
    private CardCell first;
    private CardCell second;

    public Card() {
        super();
        this.vertical = new VBox();
        this.horizontal = new HBox();
        this.vertical.setSpacing(-1);
        this.first = new CardCell(Game.greenColor, 7);
        this.second = new CardCell(Game.redColor, 2);
        Rectangle spoiler = new Rectangle(100, 10, Game.whiteColor);
        this.vertical.getChildren().add(first);
        this.vertical.getChildren().add(spoiler);
        this.vertical.getChildren().add(second);
        this.vertical.setBorder(new Border(new BorderStroke(
                Game.blackColor,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT
        )));
        first.setPair(second);
        this.vertical.setPadding(new Insets(10));

        this.getChildren().add(vertical);
    }
}
