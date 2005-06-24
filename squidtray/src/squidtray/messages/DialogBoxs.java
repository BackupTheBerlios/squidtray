package squidtray.messages;


public class DialogBoxs {

	 public static int MsgBox(String Message) {
		return MsgBox(Message,"SquidTray");
	}
	 
	 public static int MsgBox(String Message, String Title) {
		 return MsgBox(Message, Title, 1);
	 }

	 public static int MsgBox(String Message, String Title, int flagButtons) {
		 return new ModalBox(Message, Title, flagButtons).showDialog();
	 }

}
