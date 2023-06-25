import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

import algorithms.Edge;
import algorithms.Dijkstra;

public class DijkstraInputPage extends JFrame {
    private JTextField nodeField;
    private JTextField edgeField;
    private JTextArea edgesArea;

    public DijkstraInputPage() {
        setTitle("Dijkstra's Algorithm Input");
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        JLabel nodeLabel = new JLabel("Enter the number of nodes:");
        nodeField = new JTextField(10);
        JLabel edgeLabel = new JLabel("Enter the number of edges:");
        edgeField = new JTextField(10);
        JLabel edgesLabel = new JLabel("Enter edges (format: node1-node2:weight):");
        edgesArea = new JTextArea(5, 20);

        inputPanel.add(nodeLabel);
        inputPanel.add(nodeField);
        inputPanel.add(edgeLabel);
        inputPanel.add(edgeField);
        inputPanel.add(edgesLabel);
        inputPanel.add(new JScrollPane(edgesArea));

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // int numNodes = Integer.parseInt(nodeField.getText());
                int numEdges = Integer.parseInt(edgeField.getText());

                // Parse the edges and weights input
                String[] edgesInput = edgesArea.getText().split("\n");
                int[][] edges = new int[numEdges][3];
                for (int i = 0; i < numEdges; i++) {
                    String[] edgeInfo = edgesInput[i].split(":");
                    String[] nodes = edgeInfo[0].split("-");
                    int node1 = Integer.parseInt(nodes[0]);
                    int node2 = Integer.parseInt(nodes[1]);
                    int weight = Integer.parseInt(edgeInfo[1]);
                    edges[i][0] = node1;
                    edges[i][1] = node2;
                    edges[i][2] = weight;
                }

                List<List<Edge>> graph = new ArrayList<>();

                for (int i = 0; i < 10; i++) {
                    graph.add(new ArrayList<>());
                }

                for (int i = 0; i < edges.length; i++) {
                    int node1 = edges[i][0];
                    int node2 = edges[i][1];
                    int weight = edges[i][2];
                    graph.get(node1).add(new Edge(node1, node2, weight));
                    graph.get(node2).add(new Edge(node2, node1, weight));
                }
                // graph.get(0).add(new Edge(0, 1, 10));

                Dijkstra prims = new Dijkstra();

                // Perform Dijkstra's algorithm with the input values
                List<Edge> mst = prims.applyDijkstra(graph, edges[0][0]);

                // Display the result in a new window
                ResultWindow resultWindow = new ResultWindow(mst);
                resultWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                resultWindow.setSize(700, 350);
                resultWindow.setVisible(true);
            }
        });

        add(inputPanel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);

        pack();
    }
}
