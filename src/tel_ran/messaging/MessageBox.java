package tel_ran.messaging;

import java.util.HashSet;
import java.util.LinkedList;

public class MessageBox {
	private LinkedList<String> messages = new LinkedList<>();
	private HashSet<String> threads = new HashSet<>();
	
	synchronized public void putMessage(String message){ 
		this.messages.add(message);
		this.notifyAll();
		try {
			this.wait(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		this.messages.remove();
		threads = new HashSet<>();
	}
	
	synchronized public String getMessage(String threadName){
		while(this.messages.isEmpty()){
			try {
				this.wait();
			} catch (InterruptedException e) {
				System.out.println("Thread was iterrupted");
			}
		}
		String message = null;
		if(this.threads.add(threadName))
			message = this.messages.getFirst();
		return message;
	}
}