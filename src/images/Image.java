// Code modified from CPSC 210 lecture lab B01 - PhotoViewer

package images;

import javax.swing.*;
import java.awt.*;

public abstract class Image extends JFrame {

    // MODIFIES: this
    // EFFECTS: creates a pop up image
    public void createImage(int width, int height, String title, String image_file) {
        this.setSize(width, height);
        this.setTitle(title);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        ImageIcon icon = new ImageIcon(image_file);
        JLabel label = new JLabel();
        label.setIcon(icon);
        panel.add(label);
        this.add(panel);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screenSize.width / 2 - this.getWidth() / 2;
        int y = screenSize.height / 2 - this.getHeight() / 2;
        this.setLocation(x, y);

        this.setVisible(true);
    }

    // EFFECTS: prints out the name of the image file and a brief description of the image
    abstract public void imageCaption();
}
