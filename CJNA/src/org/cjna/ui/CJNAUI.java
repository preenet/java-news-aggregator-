package org.cjna.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.cjna.Global;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

/**
 * @author Pree
 *
 */
public class CJNAUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList list;
	private CJNAHandler worker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CJNAUI frame = new CJNAUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CJNAUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 470);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSystem = new JMenu("System");
		menuBar.add(mnSystem);
		
		JMenuItem mntmAddRss = new JMenuItem("Add RSS");
		mnSystem.add(mntmAddRss);
		
		JMenuItem mntmConnectionSetting = new JMenuItem("Connection Setting");
		mntmConnectionSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectionUI frame = new ConnectionUI();
				frame.setVisible(true);
			}
		});
		mnSystem.add(mntmConnectionSetting);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnSystem.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAboutCjna = new JMenuItem("About CJNA");
		mntmAboutCjna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutCNJADialog about = new AboutCNJADialog();
				about.setVisible(true);
			}
		});
		mnHelp.add(mntmAboutCjna);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		list = new JList();
		list.setCellRenderer(new CJNAListCellRenderer());
		JScrollPane scroll = new JScrollPane(list);
		contentPane.add(scroll, BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.SOUTH);
		
		JLabel lblSystemMessage = new JLabel("System Message");
		toolBar.add(lblSystemMessage);
		
		worker = new CJNAHandler(this);
		worker.start();
	}
	
	public void setConsoleDone(boolean d) {
		worker.setConsoleDone(d);
	}

	public void refresh() {
		if (worker.getConsoleDone()) {
			list.setListData(Global.myFeed.getMessages());
			setConsoleDone(false);
		}
	}
}// end class CJNAUI
