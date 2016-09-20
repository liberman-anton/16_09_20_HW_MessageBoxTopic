package tel_ran.communication;

import tel_ran.messaging.MessageBox;

public class Receiver extends Thread {
	private MessageBox messageBox;
	private String name;
	
	public Receiver(MessageBox messageBox) {
		this.messageBox = messageBox;
		this.name = getName();
		setDaemon(true);
	}

	@Override
	public void run(){
		while(true){
			String message = messageBox.getMessage(name);
			if(message != null)
				System.out.println(name + message);
		}
	}
}
