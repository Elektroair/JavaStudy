import java.io.File;

public class JavaFile
{
	public static void main(String[] args)
	{
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		String path = "D:" + File.separator + "Elektroair" + File.separator + "Programs" + File.separator + "Java" +
		              File.separator + "Study" + File.separator + "Lesson_28C1";
		System.out.println(path);
		File file = new File(path);
		System.out.println(file.exists());
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		System.out.println(file.getName());
		File[] files = file.listFiles();
		for(File fileExact : files) {
			System.out.println(fileExact);
		}
		String newPath = path + File.separator +  "File";
		File newDir = new File(newPath);
		System.out.println(newDir.exists());
		newDir.mkdir();
		System.out.println(newDir.exists());
		newDir.delete();
	}
}
