package javaSlutproject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
				panel.setBackground(Color.gray);
			} else {
				panel.setBackground(Color.lightGray);
			}

			addComponents(i, panel, frame);
			frame.add(panel);
		}
	}

	private static void addComponents(int x, JPanel container, JFrame frame) {
		// Creates components
		JLabel labelWeekday = new JLabel(Date.getWeekDay(x));
		labelWeekday.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel labelDate = new JLabel(Date.getDate(x));
		labelDate.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel notePanel = new JPanel();
		notePanel.setBackground(Color.white);

		JTextField textfield = new JTextField("Add an event", 20);
		textfield.setPreferredSize(new Dimension(0, 40));
		textfield.setMaximumSize(textfield.getPreferredSize());
		textfield.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton button = new JButton("Add");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);

		container.add(labelWeekday);
		container.add(labelDate);
		container.add(notePanel);
		container.add(textfield);
		container.add(button);

		ActionListener buttonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JLabel note = new JLabel("Event");
				notePanel.add(note);
				note.setText("<html><p style=\"width:80px\">" + textfield.getText() + "</p><br></html>");

				frame.revalidate();
			}
		};
		button.addActionListener(buttonListener);
	}

}
