package cs;

import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class Main {

	public static final void main(String[] args) throws IOException {
		Print x = new Print();
		setPrint(x);
		x.show();
	}
	//改动
	public static void setPrint(Print x) {
		Calendar c = Calendar.getInstance();
		int dyear = c.get(Calendar.YEAR);
		int dmonth = c.get(Calendar.MONTH) + 1;
		int dday = c.get(Calendar.DATE);
		// 输入出生日期
		Scanner in = new Scanner(System.in);
		System.out.println("请输入年份:");
		int year = in.nextInt();
		if (year < 1900 || year > dyear)
			throw new TimeException("出现非法值");
		x.setYear(year);
		System.out.println("请输入月份:");
		int month = in.nextInt();
		if (month < 1 || month > 12)
			throw new TimeException("出现非法值");
		x.setMonth(month);
		if(dyear==x.getYear()&&x.getMonth()>dmonth)
			throw new TimeException("出现非法值");
		System.out.println("请输入日期:");
		int day = in.nextInt();
		if (day < 1 || day > 31)
			throw new TimeException("出现非法值");
		x.setDay(day);
		if(dyear==x.getYear()&&x.getMonth()==dmonth&&x.getDay()>dday)
			throw new TimeException("出现非法值");
	}
}

class TimeException extends RuntimeException {
	TimeException(String message) {
		super(message);
	}
}
