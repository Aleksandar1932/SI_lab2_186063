package angles;

import java.util.ArrayList;
import java.util.List;

class Angle {
	int degrees;
	int minutes;
	int seconds;

	public Angle(int degrees, int minutes, int seconds) {
		this.degrees = degrees;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public int getDegrees() {
		return degrees;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}
};

public class SILab2 {
	public static List<Integer> function(List<Angle> angleList) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < angleList.size(); i++) {
			int deg = angleList.get(i).getDegrees();
			int min = angleList.get(i).getMinutes();
			int sec = angleList.get(i).getSeconds();
			if (deg >= 0 && deg < 360) {
				if (min < 0 || min > 59)
					throw new RuntimeException("The minutes of the angle are not valid!");
				else {
					if (sec < 0 || sec > 59)
						throw new RuntimeException("The seconds of the angle are not valid");
					else
						result.add(deg * 3600 + min * 60 + sec);
				}
			} else if (deg == 360) {
				if (min == 0 && sec == 0)
					result.add(deg * 3600 + min * 60 + sec);
				else
					throw new RuntimeException("The angle is greater then the maximum");
			} else {
				throw new RuntimeException("The angle is smaller or greater then the minimum");
			}
		}
		return result;

	}
}