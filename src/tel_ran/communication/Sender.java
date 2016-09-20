package tel_ran.communication;

import tel_ran.messaging.MessageBox;

public class Sender extends Thread {
	private MessageBox messageBox;
	private int nMessages = 10;
	
	public int getnMessages() {
		return nMessages;
	}

	public void setnMessages(int nMessages) {
		this.nMessages = nMessages;
	}

	public Sender(MessageBox messageBox) {
		super();
		this.messageBox = messageBox;
	}

	@Override
	public void run(){
		for(int i = 1; i <= nMessages; i++){
			messageBox.putMessage(" message" + i);
		}
	}

}
