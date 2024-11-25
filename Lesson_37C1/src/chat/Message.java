package chat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Message implements Serializable
{
	@Serial
	private static final long   serialVersionUID = 1L;
	private              LocalTime time;
	private              String name;
	private              String text;

	public Message(String name, String text)
	{
		this.time = LocalTime.now();
		this.name    = name;
		this.text = text;
	}

	@Override
	public String toString()
	{
		return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + " " + name + " :   " + text;
	}

	public LocalTime getTime()
	{
		return time;
	}

	public void setTime(LocalTime time)
	{
		this.time = time;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}
}
