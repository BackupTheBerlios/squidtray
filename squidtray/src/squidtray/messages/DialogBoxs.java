package squidtray.messages;


public class DialogBoxs {

	 public int MsgBox(String Message) {
		return MsgBox(Message,"SquidTray");
	}
	 
	 public int MsgBox(String Message, String Title) {
		 return MsgBox(Message, Title, 1);
	 }

	 public int MsgBox(String Message, String Title, int flagButtons) {
		 return new ModalBox(Message, Title, flagButtons).showDialog();
	 }

}
