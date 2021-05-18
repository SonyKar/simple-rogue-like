package components;

import frames.Content;

import javax.swing.border.EmptyBorder;

public class Padding extends Content {
    public Padding(int top, int left, int bottom, int right) {
        super();

        // JPanel Properties
        setBorder(new EmptyBorder(top, left, bottom, right));
    }
}
