package squidtray.messages;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ModalBox extends JDialog implements ActionListener {
	private int returnValue = 0;

	public ModalBox( String stringMessage, String stringTitre, int flagButtons) {
		super();
		
		JPanel globalBox = new JPanel(new BorderLayout());
		
		JLabel labelMessage = new JLabel(stringMessage, JLabel.CENTER);
		globalBox.add(labelMessage,BorderLayout.CENTER);
		JPanel buttonBox = new JPanel(new FlowLayout(FlowLayout.CENTER));
		globalBox.add(buttonBox,BorderLayout.SOUTH);
		
		switch (flagButtons) {
		case 1:
			JButton but1Ok = new JButton("Ok");
			but1Ok.addActionListener(this);
			buttonBox.add(but1Ok);
			break;
		case 2:
			JButton but2Ok = new JButton("Ok");
			but2Ok.addActionListener(this);
			buttonBox.add(but2Ok);
			JButton but2Cancel = new JButton("Cancel");
			but2Cancel.addActionListener(this);
			buttonBox.add(but2Cancel);
			break;
			
		case 3:
			JButton but3Yes = new JButton("Yes");
			but3Yes.addActionListener(this);
			buttonBox.add(but3Yes);
			JButton but3No = new JButton("No");
			but3No.addActionListener(this);
			buttonBox.add(but3No);
			break; 
			
		case 4:
			JButton but4Yes = new JButton("Yes");
			but4Yes.addActionListener(this);
			buttonBox.add(but4Yes);
			JButton but4No = new JButton("No");
			but4No.addActionListener(this);
			buttonBox.add(but4No);
			JButton but4Cancel = new JButton("Cancel");
			but4Cancel.addActionListener(this);
			buttonBox.add(but4Cancel);
			break;
		}
		
		setContentPane(globalBox);
		setSize(350,150);
		setTitle(stringTitre);
		setModal(true);
	}
	
	public int showDialog() {
		setVisible(true);
		return returnValue;
	}

	public void actionPerformed(ActionEvent evt) {
		dispose();
		/*
		 * TODO Mettre un switch pour chacun des types de MsgBox.
		 */
		returnValue = Boxs.YES;
	}
}
