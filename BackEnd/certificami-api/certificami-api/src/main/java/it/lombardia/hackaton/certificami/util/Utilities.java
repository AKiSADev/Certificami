package it.lombardia.hackaton.certificami.util;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component("utility")
@Scope("singleton")
@Slf4j
public class Utilities {
	// Espressione regolare per la validazione di stringhe numeriche.
	public static final String NUM_REGEX = "-?\\d+(\\.\\d+)?";
	// Motivazione per richiesta di cancellazione pervenuta da SPOT.
	public static final String SPOT_MOTIVATION = "Richiesta di cancellazione movimentazione pervenuta da SPOT.";

	/**
	 * Metodo per l'indicazione dei doppi apici all'inizio ed al termine di una
	 * stringa.
	 * 
	 * @param string Stringa di riferimento.
	 * @return Stringa risultato della formattazione.
	 */
	public static String addDoubleQuotes(String string) {
		return "\"" + (string != null ? string : "") + "\"";
	}

	/**
	 * Metodo per l'indicazione dei singoli apici all'inizio ed al termine di una
	 * stringa.
	 * 
	 * @param string Stringa di riferimento.
	 * @return Stringa risultato della formattazione.
	 */
	public static String addSingleQuotes(String string) {
		return "'" + (string != null ? string : "") + "'";
	}

	/**
	 * Metodo per la conversione di una lista Java in un array Javascript.
	 * 
	 * @param javaList Array da convertire.
	 * @return Array risultato della conversione.
	 */
	public static String toJavascriptArray(List<String> javaList) {
		StringBuffer jsArray = new StringBuffer();
		jsArray.append("[");

		for (int i = 0; i < javaList.size(); i++) {
			jsArray.append("\"").append(javaList.get(i)).append("\"");
			if (i + 1 < javaList.size())
				jsArray.append(",");
		}

		jsArray.append("]");
		return jsArray.toString();
	}

	/**
	 * Metodo per la conversione di una stringa in timestamp per database Oracle.
	 * 
	 * @param date    Stringa rappresentativa della data di riferimento.
	 * @param pattern Pattern per la formattazione desiderata.
	 * @return Timestamp da salvare su database Oracle.
	 */
	public static Timestamp getTimestamp(String date, String pattern) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			LocalDate localDate = LocalDate.parse(date, formatter);
			return Timestamp.valueOf(localDate.atStartOfDay());
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}

		return null;
	}

	/**
	 * Metodo per la conversione in timestamp formato stringa.
	 * 
	 * @param date    Stringa rappresentativa della data di riferimento.
	 * @param pattern Pattern per la formattazione desiderata.
	 * @return Risultato della conversione richiesta.
	 */
	public static String getStringTimestamp(String date, String pattern) {
		try {
			return notEmpty(date) ? getTimestamp(date, pattern).toString() : "";
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}

		return "";
	}

	/**
	 * Metodo per la conversione della stringa rappresentativa di una data.
	 * 
	 * @param dateString Stringa rappresentativa della data di riferimento.
	 * @return Stringa risultato della conversione desiderata.
	 */
	public static String convertDate(String dateString) {
		if (dateString == null || dateString.equals("") || dateString.length() < 10)
			return "";

		try {
			dateString = dateString.substring(0, 10);

			String year = dateString.substring(0, 4);
			String month = dateString.substring(5, 7);
			String day = dateString.substring(8, 10);

			return day + "/" + month + "/" + year;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * Metodo personalizzato per la conversione di un oggetto in stringa.
	 * 
	 * @param object Oggetto da convertire.
	 * @return Risultato della conversione.
	 */
	public static String valueOf(Object object) {
		if (object != null) {
			try {
				return String.valueOf(object);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return "";
	}

	/**
	 * Metodo per la validazione di stringhe di tipo numerico.
	 * 
	 * @param string Stringa da validare.
	 * @return Risultato della validazione richiesta.
	 */
	public static boolean isNumeric(String string) {
		return string != null && string.matches(NUM_REGEX);
	}

	/**
	 * Metodo per la verifica di anno bisestile.
	 * 
	 * @param year Anno di riferimento.
	 * @return Esito della verifica richiesta.
	 */
	public static boolean leapYear(Integer year) {
		return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
	}

	/**
	 * Metodo per la generazione di una data da una specifica stringa.
	 * 
	 * @param dateString Stringa rappresentativa della data di riferimento.
	 * @param pattern    Pattern per la formattazione desiderata.
	 * @return Data estratta dalla stringa indicata.
	 */
	public static LocalDate getLocalDate(String dateString, String pattern) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			return LocalDate.parse(dateString, formatter);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			return null;
		}
	}

	public static String convertProvincia(String provincia) {
		String prov = "";

		switch (provincia) {
		case "BA":
			prov = "Bari";
			break;

		case "BR":
			prov = "Brindisi";
			break;

		case "LE":
			prov = "Lecce";
			break;

		case "FG":
			prov = "Foggia";
			break;

		case "BT":
			prov = "Barletta - Andria - Trani";
			break;

		default:
			prov = provincia;
		}

		return prov;
	}

	/**
	 * Metodo per la conversione di una data in corrispondente stringa con formato
	 * di riferimento.
	 * 
	 * @param localDate Oggetto rappresentativo della data da convertire.
	 * @param pattern   Pattern per la formattazione desiderata.
	 * @return Stringa risultato della formattazione.
	 */
	public static String formatLocalDate(LocalDate localDate, String pattern) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			return localDate.format(formatter);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			return "";
		}
	}

	/**
	 * Metodo per verifica di non nullità di una stringa di riferimento.
	 * 
	 * @param string Stringa da analizzare.
	 * @return Risultato della verifica richiesta.
	 */
	public static boolean notEmpty(String string) {
		return string != null && !string.equals("");
	}

}
