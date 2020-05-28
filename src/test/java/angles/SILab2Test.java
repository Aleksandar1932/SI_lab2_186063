package angles;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
	static SILab2 converter;

	@BeforeAll
	static void init(){
		System.out.println("Instancing converter");
		converter = new SILab2();
	}

	@Test
	void testConvertibleAngles() {
		assertEquals(
				List.of(
						360 * 3600,
						300*3600+20*60+20
				),
				converter.function(
				List.of(
						new Angle(360, 0, 0),
						new Angle(300, 20, 20)
				)
		));
		assertEquals(List.of(0), converter.function(List.of(new Angle(0, 0, 0))));
		assertEquals(List.of(),converter.function(List.of()));

	}

	@Test
	void testExceptions() {
		String INVALID_MINUTES = "The minutes of the angle are not valid!";
		String INVALID_SECONDS = "The seconds of the angle are not valid";
		String INVALID_ANGLE = "The angle is smaller or greater then the minimum";
		String ANGLE_GREATER_THAN_MAX = "The angle is greater then the maximum";

		RuntimeException ex;
		ex = assertThrows(RuntimeException.class, () -> converter.function(List.of(new Angle(500, 20, 20))));
		assertTrue(ex.getMessage().contains(INVALID_ANGLE));

		ex = assertThrows(RuntimeException.class, () -> converter.function(List.of(
				new Angle(300, -10, -10))));
		assertTrue(ex.getMessage().contains(INVALID_MINUTES));

		ex = assertThrows(RuntimeException.class, () -> converter.function(List.of(
				new Angle(300, 20, -20))));
		assertTrue(ex.getMessage().contains(INVALID_SECONDS));

		ex = assertThrows(RuntimeException.class, () -> converter.function(List.of(
				new Angle(360, 1, 2))));
		assertTrue(ex.getMessage().contains(ANGLE_GREATER_THAN_MAX));

	}


}