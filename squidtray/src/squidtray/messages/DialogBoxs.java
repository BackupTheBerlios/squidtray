package squidtray.messages;


public class DialogBoxs {

	 public static int MsgBox(String Message) {
		int i = MsgBox(Message,"SquidTray");
		return i;
	}
	 
	 public static int MsgBox(String Message, String Title) {
		 int i = MsgBox(Message, Title, 1);
		 return i;
	 }

	 public static int MsgBox(String Message, String Title, int flagButtons) {
		 int i = new ModalBox(Message, Title, flagButtons).showDialog();
		 return i;
	 }

}
