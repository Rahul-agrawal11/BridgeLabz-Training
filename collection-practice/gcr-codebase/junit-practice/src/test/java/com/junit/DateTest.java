package com.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTest {
	DateFormatter df = new DateFormatter();
	
	@Test
	void testFormatter() {
//		LocalDateTime ldt = LocalDateTime.now();
		assertEquals("30-01-2026", df.formatDate("2026-01-30"));
	}
}
