package org.maxeagles;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class PairedStackPane extends StackPane {
    public PairedStackPane pair;

    public PairedStackPane(Node... nodes) {
        super(nodes);
    }

    public PairedStackPane() {
        super();
    }

    public void setPair(PairedStackPane pair) {
        this.pair = pair;
    }

    public PairedStackPane getPair() {
        return this.pair;
    }
}
