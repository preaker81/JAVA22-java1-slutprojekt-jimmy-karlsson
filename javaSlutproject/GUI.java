package javaSlutproject;

/**
 * class for making the main frame, panels and components.
 * Also includes a method for adding placeholder text to textboxes.
 */

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

	// creates main frame and calls method for creating panels.
	protected static void createAndDisplay() {

		JFrame frame = new JFrame();
		frame.setTitle("Week Calendar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.white);
		frame.setSize(1200, 500);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout());

		addPanels(frame);

		frame.setVisible(true);
	}

	// generating panels (condition in loop set to 1 and 7 to be reused to get correct day).
	// expected arguments: target frame
	private static void addPanels(JFrame frame) {
		for (int i = 1; i <= 7; i++) {
			Border blackline = BorderFactory.createLineBorder(Color.black);
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.setBounds(0, 0, 100, 400);
			panel.setBorder(blackline);

			// sets the background to a specific color.
			if (Date.getDate(i).equals(LocalDate.now().toString())) {// uses loop index to get day
				panel.setBackground(new Color(180, 206, 179)); // color for current day
			} else {
				panel.setBackground(Color.lightGray); // color for day not current
			}

			addGroupOfComponents(i, panel, frame); // uses loop index to get day
			frame.add(panel);
		}
	}

	// adds components
	//  expected arguments: day(day of week 1-7), target panel, target frame.
	private static void addGroupOfComponents(int day, JPanel container, JFrame frame) {
		JLabel labelWeekday = new JLabel(Date.getWeekDay(day));
		labelWeekday.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel labelDate = new JLabel(Date.getDate(day));
		labelDate.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel notePanel = new JPanel();
		notePanel.setBackground(Color.white);

		JTextField textfield = new JTextField("Add a note", 20);
		textfield.setPreferredSize(new Dimension(0, 30));
		textfield.setMaximumSize(textfield.getPreferredSize());
		textfield.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton addButton = new JButton("Add a note");
		addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel note = new JLabel("");
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

		addPlaceholderText(textfield, "Add a note");

		container.add(labelWeekday);
		container.add(labelDate);
		container.add(notePanel);
		container.add(textfield);
		container.add(addButton);
		container.add(clearButton);
	}

	// adding a placeholder text.
	//  Expected arguments: target textfield, String "placeholder text"
	private static void addPlaceholderText(JTextField textfield, String placeholder) {
		textfield.setForeground(Color.GRAY); // initial placeholder text color
		textfield.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textfield.getText().equals(placeholder)) {
					textfield.setText("");
					textfield.setForeground(Color.BLACK); // Main text color
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textfield.getText().isEmpty()) {
					textfield.setForeground(Color.GRAY); // placeholder text color
					textfield.setText(placeholder);
				}
			}
		});
	}

}