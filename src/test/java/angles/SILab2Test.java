package angles;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SILab2Test {

	@Test
	public void function() {
		assertEquals(
				SILab2.function(List.of(
						new Angle(360, 0, 0),
						new Angle(0, 0, 0)
				)),
				List.of(
						1296000,
						0
				)
		);
		assertEquals(
				SILab2.function(List.of(
						// empty list : input
				)),
				List.of(
					// empty list : output
				)
		);
		assertEquals(
				SILab2.function(List.of(
						new Angle(100, 10, 10)
				)),
				List.of(
						100*3600+10*60+10
				)
		);

	}

	@Test
	public void testExceptions(){
		// Valid degrees, invalid minutes, seconds don't matter
		try {
			SILab2.function(List.of(new Angle(300,-10,0)));
			fail();
		}
		catch (Exception e){
			final String expected = "The minutes of the angle are not valid!";
			assertEquals(expected, e.getMessage());
		}

		// Valid degrees, valid minutes, invalid seconds
		try {
			SILab2.function(List.of(new Angle(300,10,-10)));
			fail();
		}
		catch (Exception e){
			final String expected = "The seconds of the angle are not valid";
			assertEquals(expected, e.getMessage());
		}

		// Degrees are 360, invalid minutes
		try {
			SILab2.function(List.of(new Angle(360,10,0)));
			fail();
		}
		catch (Exception e){
			final String expected = "The angle is greater then the maximum";
			assertEquals(expected, e.getMessage());
		}

		// Degrees are 360, invalid seconds
		try {
			SILab2.function(List.of(new Angle(360,0,10)));
			fail();
		}
		catch (Exception e){
			final String expected = "The angle is greater then the maximum";
			assertEquals(expected, e.getMessage());
		}

		// Invalid degrees, minutes and seconds don't matter
		try {
			SILab2.function(List.of(new Angle(500,0,0)));
			fail();
		}
		catch (Exception e){
			final String expected = "The angle is smaller or greater then the minimum";
			assertEquals(expected, e.getMessage());
		}
	}
}