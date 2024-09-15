package interfaces;

import java.awt.*;

public interface LayoutManagers {
    LayoutManager TWO_COLUMN = new GridLayout(1, 2, 32, 0);
    LayoutManager TWO_ROWS = new GridLayout(2, 1, 0, 20);
    LayoutManager FOUR_ROWS = new GridLayout(4, 1, 0, 20);

    LayoutManager THREE_COLUMN = new GridLayout(1, 3, 32, 0);

}
