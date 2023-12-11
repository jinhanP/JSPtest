package eltag;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateUtil {
	//정적 멤버 함수
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	public static String format(Date date) {
		return formatter.format(date);
	}
}
