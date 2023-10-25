
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Form1 {
    private JFrame frame;
    private JTable table;

    public Form1(Flight[] flights) {
        frame = new JFrame("Flight Information System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 2)); // 1 Row, 2 columns

        // Create an empty JTable initially
        String[] columnNames = {"Flight Number", "Airline", "Origin", "Destination", "Airfare", "Departure Time", "Arrival Time", "Duration"};
        Object[][] rowData = {};
        DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames);
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Enable row selection

        // Set font and background color for table headers
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));
        header.setBackground(Color.LIGHT_GRAY);

        // Set column widths based on content
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setRowHeight(30);

        // Center-align cell contents
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Create JScrollPane for the table
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        JButton displayButton = new JButton("Display Results");
        displayButton.setFont(new Font("Arial", Font.BOLD, 16));
        displayButton.setBackground(Color.GRAY);
        displayButton.setForeground(Color.WHITE);
        displayButton.setToolTipText("Click to display sorted flight information");
        displayButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {

                // Update the JTable with sorted data
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0); // Clear existing data
                for (Flight flight : flights) {
                    model.addRow(new Object[]{flight.getFlightNumber(), flight.getAirlineName(), flight.getFlightOrigin(),
                            flight.getDestinationCities(), flight.getAirfare(), flight.getDepartureTime(),
                            flight.getArrivalTime(), flight.calculateTotalTravelTime() + " " + "Hours"});
                }
            }
        });
        frame.add(displayButton);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        
    }
}
