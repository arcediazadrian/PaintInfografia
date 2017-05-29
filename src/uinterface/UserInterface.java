package uinterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import logic.Logic;

public class UserInterface {
	public static final int NUM_ROWS_AND_COLS = 50;
	private int frameWidth = 500;
	private int frameHeigth = (frameWidth * 11) / 12;
	private JButton[][] grid;
	private JFrame frame;
	private JPanel rigthPanel;
	private JPanel leftPanel;
	private JButton drawLine;
	private int firstX = -1;
	private int firstY;
	private int secondX;
	private int secondY;
	private static Logic logic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		logic = new Logic();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, frameWidth, frameHeigth);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, frameWidth - 18, frameHeigth - 47);
		splitPane.setDividerLocation(70);

		frame.getContentPane().add(splitPane);

		rigthPanel = new JPanel();
		splitPane.setRightComponent(rigthPanel);
		rigthPanel.setLayout(new GridLayout(NUM_ROWS_AND_COLS,
				NUM_ROWS_AND_COLS, 0, 0));

		leftPanel = new JPanel();
		splitPane.setLeftComponent(leftPanel);
		initializeGrid();

		drawLine = new JButton("Line");
		drawLine.setBackground(Color.WHITE);
		drawLine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				firstX = drawLine.getBackground() == Color.CYAN ? -1 : firstX;
				drawLine.setBackground(drawLine.getBackground() == Color.WHITE ? Color.CYAN
						: Color.WHITE);
			}
		});
		leftPanel.add(drawLine);

	}

	private void initializeGrid() {
		grid = new JButton[NUM_ROWS_AND_COLS][NUM_ROWS_AND_COLS];
		for (int i = 0; i < NUM_ROWS_AND_COLS; i++) {
			for (int j = 0; j < NUM_ROWS_AND_COLS; j++) {
				JButton button = new JButton();
				button.setBackground(Color.WHITE);
				button.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseClicked(MouseEvent arg0) {
						if (drawLine.getBackground() == Color.CYAN) {
							int x = arg0.getXOnScreen()
									- (89 + frame.getLocationOnScreen().x);
							int y = arg0.getYOnScreen()
									- (39 + frame.getLocationOnScreen().y);
							x = x
									/ ((frameWidth * 5) / (6 * NUM_ROWS_AND_COLS));
							y = y
									/ ((frameWidth * 5) / (6 * NUM_ROWS_AND_COLS));
							if (firstX == -1) {
								firstX = x;
								firstY = y;
							} else {
								secondX = x;
								secondY = y;
								logic.drawLine(firstX, firstY, secondX,
										secondY, grid);
								firstX = -1;
								drawLine.setBackground(Color.WHITE);
							}
						} else {
							button.setBackground(button.getBackground() == Color.BLACK ? Color.WHITE
									: Color.BLACK);
						}
					}
				});
				grid[i][j] = button;
				rigthPanel.add(button);
			}
		}
	}
}
