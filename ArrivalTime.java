package people;

public class ArrivalTime implements Comparable<ArrivalTime> {
	
	private int hour;
	private int minutes;
	private String meridiem;
	
	public ArrivalTime(int hour, int minutes, String meridiem) {
		this.hour = hour;
		this.minutes = minutes;
		this.meridiem = meridiem;
	}
	public int compareTo(ArrivalTime other) {
		if(!meridiem.equals(other.meridiem)) {
			return meridiem.compareTo(other.meridiem);
		}else if (hour != other.hour) {
			return hour - other.hour;
		}else if (minutes != other.minutes) {
			return minutes - other.minutes;
		}
		return 0;
	}

	public boolean equals(Object object) {
		if(object instanceof ArrivalTime) {
			ArrivalTime other = (ArrivalTime) object;
			return meridiem.equals(other.meridiem) &&
				minutes == other.minutes		&&
				hour == other.hour;
	}
	return false;
	}
	
	public String toFile() {
		String minute = (minutes >= 0 && minutes <= 9) ? "0" + minutes :"" + minutes;
		return hour + ":" + minute + " " + meridiem;
	}
	
	public String toString() {
		String minute = (minutes >= 0 && minutes <= 9) ? "0" + minutes :"" + minutes;
		return hour + ":" + minute + " " + meridiem;
	}
	
}
