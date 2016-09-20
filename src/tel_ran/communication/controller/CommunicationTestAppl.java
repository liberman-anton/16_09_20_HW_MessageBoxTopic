package tel_ran.communication.controller;

import tel_ran.communication.Receiver;
import tel_ran.communication.Sender;
import tel_ran.messaging.MessageBox;

public class CommunicationTestAppl {

	private static final int N_RECEIVERS = 10;

	public static void main(String[] args) throws InterruptedException {
		MessageBox messageBox = new MessageBox();
		Sender sender = new Sender(messageBox);
		launchReceivers(messageBox);
		sender.start();
		sender.join();
		Thread.sleep(100);
	}

	private static void launchReceivers(MessageBox messageBox) {
		for(int i = 0; i < N_RECEIVERS; i++){
			new Receiver(messageBox).start();
		}
	}

}
