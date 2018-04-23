package GraphDrawing;

import javax.swing.JFrame;

import core.Logic;
import core.ProbsDeterminer;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

// class Graph Drawer
public class GraphDrawer extends JFrame {
    // ctor Graph Drawer
    public GraphDrawer(String part) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);

        // Part A
        switch (part) {
            case "A":
                ProbsDeterminer probsDeterminer = new ProbsDeterminer(1, 0, 0, 0);
                DataTable data = spreadingResearch(probsDeterminer);
                XYPlot plot1 = new XYPlot(data);
                getContentPane().add(new InteractivePanel(plot1));
                LineRenderer lines = new DefaultLineRenderer2D();
                plot1.setLineRenderers(data, lines);
                break;


            //Part B case spreading
            case "B_case_G":
                probsDeterminer = new ProbsDeterminer(0.5, 0.5, 0.5, 0);
                data = spreadingResearch(probsDeterminer);
                XYPlot plot2 = new XYPlot(data);
                getContentPane().add(new InteractivePanel(plot2));
                lines = new DefaultLineRenderer2D();
                plot2.setLineRenderers(data, lines);
                break;


            //Part B case Fire
            case "B_case_F":
                probsDeterminer = new ProbsDeterminer(0.5, 0.5, 0, 0.5);
                data = fireResearch(probsDeterminer);
                XYPlot plot3 = new XYPlot(data);
                getContentPane().add(new InteractivePanel(plot3));
                lines = new DefaultLineRenderer2D();
                plot3.setLineRenderers(data, lines);
                break;

            //Part B case growing
            case "B_case_P":
                probsDeterminer = new ProbsDeterminer(0.5, 0, 0.5, 0.5);
                data = growingResearch(probsDeterminer);
                XYPlot plot4 = new XYPlot(data);
                getContentPane().add(new InteractivePanel(plot4));
                lines = new DefaultLineRenderer2D();
                plot4.setLineRenderers(data, lines);
                break;
        }
    }


    // func spreading Research
    private DataTable spreadingResearch(ProbsDeterminer probsDeterminer){
        DataTable data = new DataTable(Double.class, Double.class);
        for (double x = 0.0; x <= 1.05; x+=0.05) {
            probsDeterminer.setSpreadingProb(x);
            Logic logic = new Logic(probsDeterminer);
            logic.getAutomaton().InitialAutomaton();
            double y = logic.makeHugeMove();
            data.add(x, y);
        }
        return data;
    }

    // func fire Research
    private DataTable fireResearch(ProbsDeterminer probsDeterminer){
        DataTable data = new DataTable(Double.class, Double.class);
        for (double x = 0.0; x <= 1.05; x+=0.05) {
            probsDeterminer.setFireProb(x);
            Logic logic = new Logic(probsDeterminer);
            logic.getAutomaton().InitialAutomaton();
            double y = logic.makeHugeMove();
            data.add(x, y);
        }
        return data;
    }

    // func growing Research
    private DataTable growingResearch(ProbsDeterminer probsDeterminer){
        DataTable data = new DataTable(Double.class, Double.class);
        for (double x = 0.0; x <= 1.05; x+=0.05) {
            probsDeterminer.setTreeGrowingProb(x);
            Logic logic = new Logic(probsDeterminer);
            logic.getAutomaton().InitialAutomaton();
            double y = logic.makeHugeMove();
            data.add(x, y);
        }
        return data;
    }

    // func main
    public static void main(String[] args) {
        GraphDrawer frame = new GraphDrawer(args[0]);
        frame.setVisible(true);
    }
}
