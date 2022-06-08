
public class MyDate {
	
	private int day;
	private int month;
	private int year;
	private int objectNumber=0;
	public static int objectCounter=0;
	public static String[] strMonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
			"Aug", "Sep", "Oct", "Nov", "Dec"};
	
	public static int[] strdays = {
			31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
	};
	
	public MyDate() {
		day = 1;
		month = 1;
		year = 1900;
		objectCounter++;
		objectNumber = objectCounter;
	}
	
	public MyDate(int aYear, int aMonth, int aDay) {
		day = aDay;
		month = aMonth;
		year = aYear;
		objectCounter++;
		objectNumber = objectCounter;
	}
	public void setDate(int aYear, int aMonth, int aDay) {
		year = aYear;
		month = aMonth;
		day = aDay;
	}
	public int getObjectNumber() {
		return objectNumber;
	}
	
	public int getDay() {
		return day;
	}public void setDay(int aDay) {
		this.day = aDay;
	}
	public int getMonth() {
		return month;
	}public void setMonth(int aMonth) {
		this.month = aMonth;
	}

	public int getYear() {
		return year;
	}public void setYear(int aYear) {
		this.year = aYear;
	}

	@Override
	public String toString() {
		if(day < 10) {
			return "0"+day + " " + strMonths[month-1] + " " + year;
		}else {
			return day + " " + strMonths[month-1] + " " + year;
		}
	}
	
	public static boolean isLeapYear(int year) {
		if(year%4 !=0) {
			return false;
		}else {
			if(year%100 !=0) {
				return true;
			}else {
				if(year%400 !=0) {
					return false;
				}else {
					return true;
				}
			}
		}
	}
	
	public MyDate nextDay() {
		if(month == 12 && day == 31) {
			this.year +=1;
			this.month =1;
			this.day =1;
		}else {
			if(month == 4|| month ==6|| month ==9||month == 11) {
				if(day == 30) {
					this.month += 1;
					this.day =1;
				}else {
					this.day+=1;
				}
			}else {
				if(month!= 2) {
					if(day == 31) {
						this.month+=1;
						this.day =1;
					}else {
						this.day += 1;
					}
				}else {
					if(isLeapYear(year) && day == 29) {
						this.month +=1;
						this.day = 1;
					}else {
						if(!(isLeapYear(year))&&day == 28) {
							this.month+=1;
							this.day=1;
						}else {
							this.day+=1;
						}
					}
				}
			}
		}
		return this;
	}
	
	public MyDate nextMonth() {
		if(month == 12) {
			this.month = 1;
			this.year += 1;
		}else {
			if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10) {
				if(day == 31 &&  month != 1) {
					this.month += 1;
					this.day = 30;
				}else {
					if(day >=30 && month ==1) {
						this.month +=1;
						if(isLeapYear(year)) {
							this.day = 29;
						}else {
							this.day = 28;
						}
					}else {
						this.month += 1;
					}
				}
			}else {
				this.month++;
			}
		}
		return this;
	}
	
	public MyDate nextYear() {
		if(month == 2 && day == 29) {
			this.year++;
			this.day =28;
		}else {
			this.year++;
		}
		return this;
	}
	
	public MyDate previousDay() {
		if(month == 1 && day == 1) {
			this.year -=1;
			this.month = 12;
			this.day = 31;
		}else {
			if( month == 5 || month == 7 || month ==10 || month == 12) {
				if(day == 1) {
					this.month -=1;
					this.day = 30;
				}else {
					this.day -=1;
				}
			}else {
				if(month != 3) {
					if(day == 1) {
						this.month-=1;
						this.day = 31;
					}else {
						this.day -= 1;
					}
				}else {
					if(isLeapYear(year) && day == 1) {
						this.month -=1;
						this.day = 29;
					}else {
						if(day == 1) {
							this.month -= 1;
							this.day = 28;
						}else {
							this.day -= 1;
						}
					}
				}
			}
		}
		return this;
	}
	public MyDate previousMonth() {
		if(month == 1) {
			this.year -= 1;
			this.month = 12;
		}else {
			if(month == 5 || month == 7 || month ==10 || month == 12) {
				if(day == 31) {
					this.month -= 1;
					this.day = 30;
				}else {
					this.month -= 1;
				}
			}else {
				if(month == 3) {
					if(isLeapYear(year)&& day >29) {
						this.month -= 1;
						this.day = 29;
					}else {
						if(!(isLeapYear(year)) && day >28) {
							this.month -= 1;
							this.day = 28;
						}
					}
				}else {
					this.month -= 1;
				}
			}
		}
		return this;
	}
	
	public MyDate previousYear() {
		if(month == 2 && day == 29) {
			this.day = 28;
			this.year -= 1;
		}else {
			this.year -= 1;
		}
		return this;
	}
	
	public static int dateDiff(MyDate a, MyDate b) {
		int i=0, diff=0,am=0, bm=0;
		am+=a.day;
		for(i=1; i<a.month; i++) {
			if(i==1||i==3||i==5||i==7||i==8||i==10||i==12) {
				am+=31;
			}
			if(i==4||i==6||i==9||i==11) {
				am+=30;
			}
			if(i==2&&isLeapYear(a.year)) {
				am+=29;
			}
			if(i==2 && isLeapYear(a.year)==false) {
				am+=28;
			}
		}
		for(i=1; i<a.year; i++) {
			if(isLeapYear(i)) {
				am+=366;
			}else {
				am+=365;
			}
		}
		
		
		bm+=b.day;
		for(i=1; i<b.month; i++) {
			if(i==1||i==3||i==5||i==7||i==8||i==10||i==12) {
				bm+=31;
			}
			if(i==4||i==6||i==9||i==11) {
				bm+=30;
			}
			if(i==2&&isLeapYear(b.year)) {
				bm+=29;
			}
			if(i==2 && isLeapYear(b.year)==false) {
				bm+=28;
			}
		}
		for(i=1; i<b.year; i++) {
			if(isLeapYear(i)) {
				bm+=366;
			}else {
				bm+=365;
			}
		}
		
		diff = bm-am;
		
		return diff;
	}
}

