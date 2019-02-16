package challenge;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class LocalDateConverter extends AbstractBeanField {
	@Override
	protected Object convert(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate parse = LocalDate.parse(s, formatter);
		return parse;
	}
}
