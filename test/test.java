import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

class AnimatedBackground extends JPanel {

    static class Circle {
        int x, y, size, speed;
        float alpha;
    }

    private final ArrayList<Circle> circles = new ArrayList<>();
    private final Random random = new Random();

    public AnimatedBackground() {
        // Création des cercles
        for (int i = 0; i < 50; i++) {
            Circle c = new Circle();
            c.x = random.nextInt(1920); // Largeur écran
            c.y = random.nextInt(1440) - 300; // Hauteur écran
            c.size = 20 + random.nextInt(100);
            c.speed = 1 + random.nextInt(3);
            c.alpha = 0.2f;
            circles.add(c);
        }

        // Timer pour l'animation (~60 FPS)
        Timer timer = new Timer(16, e -> {
            for (Circle c : circles) {
                c.y -= c.speed;
                if (c.y + c.size < 0) {
                    c.y = 1440 + 100; // Hauteur écran
                }
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
        GradientPaint gp = new GradientPaint(
                0, 0, new Color(0x8f94fb),
                0, getHeight(), new Color(0x4e54c8)
        );
        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());

        // Cercles
        for (Circle c : circles) {
            g2.setComposite(AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, c.alpha));
            g2.setColor(Color.WHITE);
            g2.fillOval(c.x, c.y, c.size, c.size);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Background Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new AnimatedBackground());
        
        // Plein écran
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(false);
        frame.setVisible(true);
    }
}