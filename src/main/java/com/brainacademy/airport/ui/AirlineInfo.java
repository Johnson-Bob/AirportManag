package com.brainacademy.airport.ui;

import com.brainacademy.airport.entity.Flight;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.sql.Date;
import java.time.Instant;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

/**
 /* Created by gladi on 12.12.2016.*/


public class AirlineInfo extends JPanel {
    private Vector<Flight> data;

    public AirlineInfo(Vector<Flight> data) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.data = data;

        //Create the table
        JTable table = new JTable(new AirlineTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(600, 70));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it. Add the scroll pane to this panel.
        JScrollPane scrollPane = new JScrollPane(table);

        //Create the radio buttons.
        JRadioButton arrivalButton = new JRadioButton("Arrival");
        arrivalButton.setSelected(true);

        JRadioButton departureButton = new JRadioButton("Departure");

        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(arrivalButton);
        group.add(departureButton);

        //Put the radio buttons in a column in a panel.
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(arrivalButton);
        radioPanel.add(departureButton);
        radioPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,50));

        //Create date spiners
        Calendar calendar = Calendar.getInstance();
        java.util.Date initDate = calendar.getTime();
        calendar.add(Calendar.YEAR, -100);
        java.util.Date earliestDate = calendar.getTime();
        calendar.add(Calendar.YEAR, +200);
        java.util.Date latestDate = calendar.getTime();

        JSpinner fromDate = new JSpinner(new SpinnerDateModel(initDate, earliestDate, latestDate, Calendar.DAY_OF_MONTH));
        JSpinner toDate = new JSpinner(new SpinnerDateModel(initDate, earliestDate, latestDate, Calendar.DAY_OF_MONTH));


        //Put the radio buttons in a column in a panel.
        JPanel datePanel = new JPanel(new GridLayout(0, 1));
        datePanel.add(fromDate);
        fromDate.setEditor(new JSpinner.DateEditor(fromDate,"dd.MM.yyy"));
        datePanel.add(toDate);
        toDate.setEditor(new JSpinner.DateEditor(toDate,"dd.MM.yyy"));

        //Create top panel and add elements
        JPanel topPanel = new JPanel(){
            @Override
            public Dimension getMaximumSize() {
                return getPreferredSize();
            }

            @Override
            public Dimension getMinimumSize() {
                return getPreferredSize();
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(super.getPreferredSize().width, 50);
            }
        };
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.setAlignmentX(0f);
        topPanel.add(radioPanel);
        topPanel.add(datePanel);

        // Add elements to panel
        add(topPanel);
        add(scrollPane);
    }

    private class AirlineTableModel extends AbstractTableModel{
        private String[] columnNames = {"Flight type", "Date and time", "Flight number", "City/Port",
                "Terminal", "Flight status", "Gate"};

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex){
                case 0: return data.elementAt(rowIndex).getType();
                case 1: return data.elementAt(rowIndex).getDate();
                case 2: return data.elementAt(rowIndex).getNumber();
                case 3: return data.elementAt(rowIndex).getCity();
                case 4: return data.elementAt(rowIndex).getTerminal();
                case 5: return data.elementAt(rowIndex).getStatus();
                case 6: return data.elementAt(rowIndex).getGate();
                default: return null;
            }
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return getValueAt(0, columnIndex).getClass();
        }
    }

    private Object[][] convertData(List<Flight> data) {
        Object[][] result = new Object[data.size()][7];
        int i = 0;
        for (Flight el: data){
            result[i] = new Object[]{el.getType(), el.getDate(), el.getNumber(), el.getCity(), el.getTerminal(),
                            el.getStatus(), el.getGate()};
            i++;
        }
        return result;
    }

    public static void createAndShowGUI(Vector<Flight> data) {
        //Create and set up the window.
        JFrame frame = new JFrame("Airline info");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        AirlineInfo newContentPane = new AirlineInfo(data);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
