import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


/**
 * Scratch Tests class is for temporary tests.
 */
public class ScratchTests {

	// Initialize Log4j logs
	private static final Logger Log = LogManager.getLogger();


	@Test
	public void dateTest() {
		String itemDate = "2018-05-23";
		LocalDate lDate = LocalDate.parse(itemDate, DateTimeFormatter.ISO_LOCAL_DATE);

		Locale locales[] = SimpleDateFormat.getAvailableLocales();

		for (int i = 0; i < locales.length; i++) {

			String formatPattern = DateTimeFormatterBuilder.getLocalizedDateTimePattern(FormatStyle.SHORT, null,
					IsoChronology.INSTANCE, locales[i]);
			formatPattern = formatPattern.replaceAll("\\byy\\b", "yyyy");

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern, locales[i]);

			itemDate = lDate.format(formatter);

			Log.info("The date for locale " + locales[i].toString() + " is: " + itemDate);
		}

	}


	@Test
	public void testLoggingException() {

		Exception ce = new IllegalArgumentException("This is the exception message.");


		Log.info("The first style of logging logs just the exception message and not the call stack. " + ce.getMessage());
		Log.info("The second style logs the whole exception which includes the call stack.", ce);

	}


	@Test
	private void splitString() {
		String test = "July18 Release FR Test";

		String locale = null;

		String parsed[] = test.split(" ");

		Log.info("The parsed string is: " + parsed.toString());

		locale = parsed[2];

		Log.info("The locale is :" + locale);


	}
}
