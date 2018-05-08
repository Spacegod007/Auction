package nl.fontys.util;

import java.sql.Time;
import java.util.TimeZone;

public class FontysTime {
	private long seconds;

	public FontysTime() {
		seconds = 0;
	}

	public static FontysTime now() {
		FontysTime someTime;
		someTime = FontysTime.fromSeconds(System.currentTimeMillis() / 1000);
		return someTime;
	}

	public static FontysTime fromSeconds(long iseconds) {
		FontysTime someTime;
		someTime = new FontysTime();
		someTime.seconds = iseconds;
		return someTime;
	}

	public FontysTime increment(long seconds) {
		this.seconds += seconds;
		return this;
	}

	public long asSeconds() {
		return (seconds);
	}

	public long subtractTime(FontysTime someTime) {
		return this.asSeconds() - someTime.asSeconds();
	}

	public String toString() {
		Time time;

		// de java Time class is in staat strings van tijd objecten
		// te maken echter vindt er ongewenste conversie plaats tov gmt
		// corrigeer hiervoor
		TimeZone current = TimeZone.getDefault();
		TimeZone tz = TimeZone.getTimeZone("GMT");
		TimeZone.setDefault(tz);

		time = new Time(this.asSeconds() * 1000);
		String timeString;
		timeString = time.toString();

		TimeZone.setDefault(current);
		return timeString;
	}
}
