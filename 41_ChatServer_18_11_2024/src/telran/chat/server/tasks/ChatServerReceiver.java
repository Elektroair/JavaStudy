package telran.chat.server.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import telran.mediation.BlkQueue;

public class ChatServerReceiver implements Runnable {
	Socket socket;
	BlkQueue<String> messageBox;

	public ChatServerReceiver(Socket socket, BlkQueue<String> messageBox) {
		super();
		this.socket = socket;
		this.messageBox = messageBox;
	}

	@Override
	public void run() {
		try (Socket socket = this.socket;
				InputStream inputStream = socket.getInputStream();
				BufferedReader socketReader = new BufferedReader(new InputStreamReader(inputStream));) {

			while (true) {
				String message = socketReader.readLine();
				messageBox.push(message);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
