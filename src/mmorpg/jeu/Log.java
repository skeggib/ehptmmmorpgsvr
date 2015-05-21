package mmorpg.jeu;

import java.util.ArrayList;

public class Log {
	
	public static final int MAX_MESSAGES = 100;

	ArrayList<String> messages;
	
	public Log() {
		this.messages = new ArrayList<String>();
	}
	
	public void add(String message) {
		this.messages.add(message);
		if (this.messages.size() > 100)
			this.messages.remove(0);
	}
	
	public String[] getDerniersMessages(int nbMessages) {
		if (nbMessages > this.messages.size())
			nbMessages = this.messages.size();
		
		String[] rtrn = new String[nbMessages];
		int depart = this.messages.size() - nbMessages;
		
		for (int i = 0; i < nbMessages; i++) {
			rtrn[i] = this.messages.get(depart + i);
		}
		
		return rtrn;
	}
}
