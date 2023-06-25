import javax.swing.*;

public class MSTVisualizer {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AlgorithmSelectionPage selectionPage = new AlgorithmSelectionPage();
                selectionPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                selectionPage.setSize(700, 350);
                selectionPage.setVisible(true);
            }
        });
    }
}

/*
 * 
9 13
0-1:4
0-7:8
1-2:8
1-7:11
2-3:7
2-8:2
7-6:1
8-6:6
6-5:2
3-4:9
3-5:14
5-4:10
2-5:4
 * 
 * 
 * 
 * 7 -- 6 : 1
 * 2 -- 8 : 2
 * 6 -- 5 : 2
 * 0 -- 1 : 4
 * 2 -- 5 : 4
 * 2 -- 3 : 7
 * 0 -- 7 : 8
 * 3 -- 4 : 9
 * Total Cost: 37
 */

// 7
// 9

// 6-1:10
// 6-5:25
// 1-2:28
// 5-7:24
// 5-4:22
// 7-4:18
// 7-2:14
// 4-3:12
// 2-3:16
/*
0-1:4
0-7:8
1-2:8
1-7:11
2-3:7
2-8:2
2-5:4
3-4:9
3-5:14
4-5:10
5-6:2
6-7:1
6-8:6
7-8:7
*/
// Node: 9
// Edge: 13