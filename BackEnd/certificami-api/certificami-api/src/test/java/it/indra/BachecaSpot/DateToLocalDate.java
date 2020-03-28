package it.indra.BachecaSpot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DateToLocalDate {

	@Test
	public void contextLoads() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "31-08-1982 10:20:56";
		Date date = sdf.parse(dateInString);
		LocalDate localDate = new java.sql.Date(date.getTime()).toLocalDate();

		System.out.println(localDate);

	}

}
