package project1;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;


class jUnitTests {

	@Test
	void testXorIt()
	{
		assertEquals(Conversions.xorIt("00000", "11111"), "11111");
		assertEquals(Conversions.xorIt("01010101", "10101010"), "11111111");
	}
	
	@Test
	void testShiftIt()
	{
		assertEquals(Conversions.shiftIt("1111"), "1110");
		assertEquals(Conversions.shiftIt("01010101"), "10101010");
	}
	
	@Test
	void testPermuteIt()
	{
		assertEquals(Conversions.permuteIt("00000000000000000000000000000000"), "00000000000000000000000000000000");
		
	}

}
