package org.cjna.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.cjna.Global;

public class CJNAUI extends JFrame {

	private JPanel contentPane;
	private final JList list = new JList();
	private boolean consoleDone;
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
		
		setResizable(false);
		consoleDone = false;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSystem = new JMenu("System");
		menuBar.add(mnSystem);
		
		JMenuItem mntmConnectionSetting = new JMenuItem("Connection Setting");
		mnSystem.add(mntmConnectionSetting);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnSystem.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 406);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout());
		list.setBounds(0, 0, 450, 406);
		JScrollPane sPane = new JScrollPane(list);
		panel.add(sPane);
		
		worker = new CJNAHandler(this);
		worker.start();
	}
	
	public void setConsoleDone(boolean done) {
		this.consoleDone = done;
	}
	
	public void refresh() {
		list.setListData(Global.myFeed.getMessages());
	}

}
