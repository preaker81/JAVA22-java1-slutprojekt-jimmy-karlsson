package javaSlutproject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

class GUI {

	static void createAndDisplay() {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.white);
		frame.setSize(1200, 500);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout());

		addPanels(frame);

		frame.setVisible(true);
	}

	private static void addPanels(JFrame frame) {
		for (int i = 1; i <= 7; i++) {
			Border blackline = BorderFactory.createLineBorder(Color.black);
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.setBounds(0, 0, 100, 400);
			panel.setBorder(blackline);

			if (Date.getDate(i).equals(LocalDate.now().toString())) {
				panel.setBackground(new Color(180, 206, 179));
			} else {
				panel.setBackground(Color.lightGray);
			}

			addComponents(i, panel, frame);
			frame.add(panel);
		}
	}

	private static void addComponents(int x, JPanel container, JFrame frame) {
		JLabel labelWeekday = new JLabel(Date.getWeekDay(x));
		labelWeekday.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel labelDate = new JLabel(Date.getDate(x));
		labelDate.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel notePanel = new JPanel();
		notePanel.setBackground(Color.white);

		JTextField textfield = new JTextField("Add an event", 20);
		textfield.setPreferredSize(new Dimension(0, 30));
		textfield.setMaximumSize(textfield.getPreferredSize());
		textfield.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton addButton = new JButton("Add a note");
		addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel note = new JLabel("Event");
				notePanel.add(note);
				note.setText("<html><p style=\"width:100px\">" + textfield.getText() + "</p><br></html>");
				textfield.setText("");
			}
		});

		JButton clearButton = new JButton("Clear Notes");
		clearButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notePanel.removeAll();
				frame.repaint();
			}
		});

		addPlaceholderText(textfield, "Add an event");

		container.add(labelWeekday);
		container.add(labelDate);
		container.add(notePanel);
		container.add(textfield);
		container.add(addButton);
		container.add(clearButton);
	}

	public static void addPlaceholderText(JTextField textfield, String placeholder) {
		textfield.setForeground(Color.GRAY);
		textfield.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textfield.getText().equals(placeholder)) {
					textfield.setText("");
					textfield.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textfield.getText().isEmpty()) {
					textfield.setForeground(Color.GRAY);
					textfield.setText(placeholder);
				}
			}
		});
	}

}