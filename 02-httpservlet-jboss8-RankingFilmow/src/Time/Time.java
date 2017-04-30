package Time;

import java.time.Instant;

public class Time {

	public void time() {
		Instant I = Instant.now();
		Instant I2 = Instant.now();
		I2 = I2.parse("1989-11-10T10:42:55.034Z");
		// System.out.println(I.isAfter(I2));
		// System.out.println(I.isBefore(I2));
		// System.out.println(I.compareTo(I2));

	}

}
