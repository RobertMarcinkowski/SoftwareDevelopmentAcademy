package Time;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class main {

	public static void main(String[] args) {
		Time time = new Time();
		time.time();
		Instant I = Instant.now();
		ZonedDateTime terazPolska = I.atZone(ZoneId.of("Europe/Warsaw"));

		System.out.println(terazPolska);

		ZonedDateTime pierwszyNas = terazPolska.with(TemporalAdjusters.firstDayOfNextMonth());
		System.out.println(pierwszyNas);
		ZonedDateTime najblizszyWt = terazPolska.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
		System.out.println(najblizszyWt);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formatter.withZone(ZoneId.of("Europe/Warsaw"));
		String text = terazPolska.format(formatter);
		LocalDate dateLocal = LocalDate.parse(text, formatter);
		ZonedDateTime zdt = dateLocal.atStartOfDay(ZoneId.systemDefault());
		System.out.println(zdt);

		String koniecKursuString = "2017-03-25";
		LocalDate dateLocal2 = LocalDate.parse(koniecKursuString, formatter);
		LocalDate koniecKursu = dateLocal2.with(TemporalAdjusters.next(DayOfWeek.MONDAY));

		System.out.println("Nastêpny poniedzia³ek po ukoñczeniu kursu to: " + koniecKursu.getDayOfWeek());
		System.out.println("Koniec kursu plus 7 dni: " + koniecKursu.plus(Period.ofDays(7)));
		System.out.println("Koniec kursu plus 102 lata: " + koniecKursu.plus(Period.ofYears(102)));
		Period duration = Period.between(dateLocal, koniecKursu);
		System.out.println("Duration get days: " + duration.getDays());
		long dni = ChronoUnit.DAYS.between(dateLocal, dateLocal2);
		System.out.println(dni);
		String poczatekKursuString = "2016-10-26";
		LocalDate dateLocalpoczatek = LocalDate.parse(poczatekKursuString, formatter);
		long odRozpoczecia = ChronoUnit.DAYS.between(dateLocalpoczatek, dateLocal);
		System.out.println("Od rozpoczecia kursu mine³o: " + odRozpoczecia);

	}

}
