import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

public class AnimatedBackground extends JFrame {

    public AnimatedBackground() {
        setTitle("Animated Background - Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        AnimatedPanel panel = new AnimatedPanel();
        setContentPane(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AnimatedBackground::new);
    }
}

/* ===================== PANEL ===================== */

class AnimatedPanel extends JPanel {

    private final List<FloatingShape> shapes = new ArrayList<>();
    private final Timer timer;

    public AnimatedPanel() {
        setDoubleBuffered(true);
        setLayout(null);

        // Configuration équivalente au JS
        int[][] config = {
                {25, 80, 25},
                {10, 20, 12},
                {70, 20, 25},
                {40, 60, 18},
                {65, 20, 25},
                {75, 110, 25},
                {35, 150, 25},
                {50, 25, 45},
                {20, 15, 35},
                {85, 150, 11}
        };

        for (int[] c : config) {
            shapes.add(new FloatingShape(c[0], c[1], c[2]));
        }

        timer = new Timer(16, (ActionEvent e) -> {
            for (FloatingShape s : shapes) {
                s.update();
            }
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Fond dégradé
        GradientPaint gradient = new GradientPaint(
                0, 0, new Color(0x8f94fb),
                getWidth(), 0, new Color(0x4e54c8)
        );
        g2.setPaint(gradient);
        g2.fillRect(0, 0, getWidth(), getHeight());

        // Dessin des formes
        for (FloatingShape s : shapes) {
            s.draw(g2, getWidth(), getHeight());
        }
    }
}

/* ===================== SHAPE ===================== */

class FloatingShape {

    private final int size;
    private final float speed;
    private float y;
    private float rotation;
    private float opacity;
    private final int xPercent;
    private float borderRadius;

    public FloatingShape(int xPercent, int size, int duration) {
        this.xPercent = xPercent;
        this.size = size;
        this.speed = 1000f / (duration * 60f);
        reset();
        y = 800 + new Random().nextInt(300);
    }

    private void reset() {
        y = 800;
        rotation = 0;
        opacity = 1f;
        borderRadius = 0f;
    }

    public void update() {
        y -= speed;
        rotation += 2;
        opacity -= 0.002f;
        borderRadius += 0.01f;

        if (opacity <= 0) {
            reset();
        }
    }

    public void draw(Graphics2D g2, int width, int height) {
        int x = (int) (width * (xPercent / 100.0));

        g2.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER,
                Math.max(opacity, 0))
        );

        g2.translate(x, y);
        g2.rotate(Math.toRadians(rotation));

        g2.setColor(new Color(255, 255, 255, 50));

        int arc = (int) (size * borderRadius);
        g2.fillRoundRect(
                -size / 2,
                -size / 2,
                size,
                size,
                arc,
                arc
        );

        g2.rotate(-Math.toRadians(rotation));
        g2.translate(-x, -y);
        g2.setComposite(AlphaComposite.SrcOver);
    }
}
