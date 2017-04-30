package time;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Time {

	public void time(){
		Instant dateOne = Instant.parse("1970-11-10T10:42:55.034Z");
		Instant dateTwo = Instant.parse("2016-11-10T10:42:55.034Z");

		System.out.println(dateOne.compareTo(dateTwo));
		// -1 oznacza, że dateOne jest starsza niż dateTwo,
		// 0 oznacza, że dateOne jest taka sama dateTwo,
		// oznacza, że 1 dateOne jest młodsza dateTwo
		
		ZonedDateTime zoneWarsaw = 
				ZonedDateTime.now(ZoneId.of("Europe/Warsaw"));
		System.out.println(zoneWarsaw);
		
		Instant  i = Instant.now();
		ZonedDateTime terazPolska = 
				i.atZone(ZoneId.of("Europe/Warsaw"));
		
		//zwraca pierwszy dzien nastepnego miesiaca
		ZonedDateTime pierwszyNas = terazPolska.
				with(TemporalAdjusters.firstDayOfNextMonth());
		//zwraca nastepny poniedzialek chyba ze dzis jest poniedzialek
		ZonedDateTime najblizszyPon = terazPolska.with(TemporalAdjusters.
				nextOrSame(DayOfWeek.MONDAY)).
		truncatedTo(ChronoUnit.DAYS);

		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		ZonedDateTime plus4 = zonedDateTime.minus(Period.ofDays(4));
		ZonedDateTime minu4 = zonedDateTime.plus(Period.ofDays(4));
		if (plus4.isAfter(minu4)) {
		    //pierwsza data jest po drugiej
		}
		
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
		String data = "2017 03 25";
		LocalDate local = LocalDate.parse(data, formatter);
		LocalDate nastepnyPon = local.with(TemporalAdjusters.
				nextOrSame(DayOfWeek.MONDAY));
		System.out.println(nastepnyPon.format(formatter));

		long dni = ChronoUnit.DAYS.between(terazPolska, nastepnyPon );

	
		
	}
	}
