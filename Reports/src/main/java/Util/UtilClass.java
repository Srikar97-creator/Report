package Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilClass {
	public String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}
}
