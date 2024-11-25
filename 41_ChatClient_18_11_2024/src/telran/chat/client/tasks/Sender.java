package telran.chat.client.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalTime;

public class Sender implements Runnable {
	Socket socket;

	public Sender(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try (Socket socket = this.socket;
				OutputStream outputStream = socket.getOutputStream();
				PrintWriter socketWriter = new PrintWriter(outputStream);
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {

			System.out.println("Enter your name:");
			String name = br.readLine();
			System.out.println("Enter your message or exit for quit");
			String message = br.readLine();
			while (!"exit".equalsIgnoreCase(message)) {
				socketWriter.println("[" + LocalTime.now() + "]" + name + ":" + message);
				socketWriter.flush();
				System.out.println("Enter your message or exit for quit");
				message = br.readLine();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
