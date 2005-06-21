package squidtray.messages;


public class DialogBoxs {

	 public static int MsgBox(String Message) {
		int i = MsgBox(Message,"SquidTray");
		return i;
	}
	 
	 public static int MsgBox(String Message, String Title) {
		 int i = new ModalBox(Title, Message, 4).showDialog();
		 return i;
	 }

}
