package telran.chat.server.tasks;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

import telran.mediation.BlkQueue;

public class ChatServerSender implements Runnable {
	BlkQueue<String> messageBox;
	Set<PrintWriter> clients;

	public ChatServerSender(BlkQueue<String> messageBox) {
		super();
		this.messageBox = messageBox;
		this.clients = new HashSet<>();
	}

	public synchronized boolean addClient(Socket socket) throws IOException {
		OutputStream outputStream = socket.getOutputStream();
		PrintWriter socketWriter = new PrintWriter(outputStream);
		return clients.add(socketWriter);
	}

	@Override
	public void run() {
		while (true) {
			String message = messageBox.pop();
			clients.parallelStream().forEach(c -> {
				c.println(message);
				c.flush();
			});

		}

	}

}
