import javax.swing.*;

public class DisplayUI {

    QueueManager qm = new QueueManager();
    ReportManager rm = new ReportManager();

    JLabel display;
    JLabel reportLabel;

    public DisplayUI() {

        JFrame frame = new JFrame("Smart Queue Management System");
        frame.setSize(500, 400);
        frame.setLayout(null);

        JButton normalBtn = new JButton("Generate Normal Token");
        normalBtn.setBounds(130, 50, 220, 30);

        JButton priorityBtn = new JButton("Generate Priority Token");
        priorityBtn.setBounds(130, 100, 220, 30);

        JButton serveBtn = new JButton("Serve Next");
        serveBtn.setBounds(130, 150, 220, 30);

        JButton resetBtn = new JButton("Reset Queue");
        resetBtn.setBounds(130, 200, 220, 30);

        display = new JLabel("Now Serving: ");
        display.setBounds(130, 250, 300, 30);

        reportLabel = new JLabel("Report: ");
        reportLabel.setBounds(130, 300, 300, 30);

        // Button Actions

        normalBtn.addActionListener(e -> {
            Token t = qm.generateToken("NORMAL");
            rm.tokenGenerated();
            JOptionPane.showMessageDialog(frame, "Token: " + t.number);
            updateReport();
        });

        priorityBtn.addActionListener(e -> {
            Token t = qm.generateToken("PRIORITY");
            rm.tokenGenerated();
            JOptionPane.showMessageDialog(frame, "Priority Token: " + t.number);
            updateReport();
        });

        serveBtn.addActionListener(e -> {
            Token t = qm.serveNext();
            if (t != null) {
                display.setText("Now Serving: " + t.number + " (" + t.type + ")");
                rm.tokenServed();
            } else {
                display.setText("No tokens!");
            }
            updateReport();
        });

        resetBtn.addActionListener(e -> {
            qm.resetQueue();
            display.setText("Queue Reset!");
            reportLabel.setText("Report: ");
        });

        frame.add(normalBtn);
        frame.add(priorityBtn);
        frame.add(serveBtn);
        frame.add(resetBtn);
        frame.add(display);
        frame.add(reportLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void updateReport() {
        reportLabel.setText("Report: " + rm.getReport());
    }
}