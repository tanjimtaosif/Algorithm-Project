import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlgorithmSelectionPage extends JFrame {

    public AlgorithmSelectionPage() {
        setTitle("Minimum Spanning Tree Visualization");
        setLayout(new FlowLayout());

        JButton primButton = new JButton("Prim's Algorithm");
        primButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PrimInputPage primInputPage = new PrimInputPage();
                primInputPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                primInputPage.setSize(700, 350);
                primInputPage.setVisible(true);
            }
        });
        add(primButton);

        JButton kruskalButton = new JButton("Kruskal's Algorithm");
        kruskalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                KruskalInputPage kruskalInputPage = new KruskalInputPage();
                kruskalInputPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                kruskalInputPage.setSize(700, 350);
                kruskalInputPage.setVisible(true);
            }
        });
        add(kruskalButton);

        JButton exitButton = new JButton("Dijkstra's Algorithm");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DijkstraInputPage dijkstraInputPage = new DijkstraInputPage();
                dijkstraInputPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dijkstraInputPage.setSize(700, 350);
                dijkstraInputPage.setVisible(true);
            }
        });
        add(exitButton);

        pack();
    }
}
