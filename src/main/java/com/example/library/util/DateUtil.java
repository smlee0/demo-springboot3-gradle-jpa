package com.example.library.util;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;

public class DateUtil {
	private static final Logger log = LoggerFactory.getLogger(DateUtil.class);
	public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
	public static final String DEFAULT_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String DEFAULT_TIME_PATTERN = "HH:mm:ss";
	private static ZoneId defaultZoneId = ZoneId.of("Asia/Seoul");

	private DateUtil() {
	}

	public static String now() {
		return now("yyyy-MM-dd");
	}

	public static String now(String outputPattern) {
		return LocalDateTime.now(defaultZoneId).format(DateTimeFormatter.ofPattern(outputPattern, LocaleContextHolder.getLocale()));
	}

	public static String yesterday() {
		return yesterday("yyyy-MM-dd");
	}

	public static String yesterday(String outputPattern) {
		return LocalDateTime.now(defaultZoneId).minusDays(1L).format(DateTimeFormatter.ofPattern(outputPattern, LocaleContextHolder.getLocale()));
	}

	public static String tommorow() {
		return tommorow("yyyy-MM-dd");
	}

	public static String tommorow(String outputPattern) {
		return LocalDateTime.now(defaultZoneId).plusDays(1L).format(DateTimeFormatter.ofPattern(outputPattern, LocaleContextHolder.getLocale()));
	}

	public static String future(long years) {
		return future(years, 0L, 0L, 0L, 0L, 0L, "yyyy-MM-dd");
	}

	public static String future(long years, String outputPattern) {
		return future(years, 0L, 0L, 0L, 0L, 0L, outputPattern);
	}

	public static String future(long years, long months) {
		return future(years, months, 0L, 0L, 0L, 0L, "yyyy-MM-dd");
	}

	public static String future(long years, long months, String outputPattern) {
		return future(years, months, 0L, 0L, 0L, 0L, outputPattern);
	}

	public static String future(long years, long months, long days) {
		return future(years, months, days, 0L, 0L, 0L, "yyyy-MM-dd");
	}

	public static String future(long years, long months, long days, String outputPattern) {
		return future(years, months, days, 0L, 0L, 0L, outputPattern);
	}

	public static String future(long years, long months, long days, long hours) {
		return future(years, months, days, hours, 0L, 0L, "yyyy-MM-dd");
	}

	public static String future(long years, long months, long days, long hours, String outputPattern) {
		return future(years, months, days, hours, 0L, 0L, outputPattern);
	}

	public static String future(long years, long months, long days, long hours, long minutes) {
		return future(years, months, days, hours, minutes, 0L, "yyyy-MM-dd");
	}

	public static String future(long years, long months, long days, long hours, long minutes, String outputPattern) {
		return future(years, months, days, hours, minutes, 0L, outputPattern);
	}

	public static String future(long years, long months, long days, long hours, long minutes, long seconds) {
		return future(years, months, days, hours, minutes, seconds, "yyyy-MM-dd");
	}

	public static String future(long years, long months, long days, long hours, long minutes, long seconds, String outputPattern) {
		years = Math.abs(years);
		months = Math.abs(months);
		days = Math.abs(days);
		hours = Math.abs(hours);
		minutes = Math.abs(minutes);
		seconds = Math.abs(seconds);
		return LocalDateTime.now(defaultZoneId)
			.plusYears(years)
			.plusMonths(months)
			.plusDays(days)
			.plusHours(hours)
			.plusMinutes(minutes)
			.plusSeconds(seconds)
			.format(DateTimeFormatter.ofPattern(outputPattern, LocaleContextHolder.getLocale()));
	}

	public static String futureYears(long years) {
		return future(years, 0L, 0L, 0L, 0L, 0L, "yyyy-MM-dd");
	}

	public static String futureYears(long years, String outputPattern) {
		return future(years, 0L, 0L, 0L, 0L, 0L, outputPattern);
	}

	public static String futureMonths(long months) {
		return future(0L, months, 0L, 0L, 0L, 0L, "yyyy-MM-dd");
	}

	public static String futureMonths(long months, String outputPattern) {
		return future(0L, months, 0L, 0L, 0L, 0L, outputPattern);
	}

	public static String futureDays(long days) {
		return future(0L, 0L, days, 0L, 0L, 0L, "yyyy-MM-dd");
	}

	public static String futureDays(long days, String outputPattern) {
		return future(0L, 0L, days, 0L, 0L, 0L, outputPattern);
	}

	public static String futureHours(long hours) {
		return future(0L, 0L, 0L, hours, 0L, 0L, "yyyy-MM-dd HH:mm:ss");
	}

	public static String futureHours(long hours, String outputPattern) {
		return future(0L, 0L, 0L, hours, 0L, 0L, outputPattern);
	}

	public static String futureMinutes(long minutes) {
		return future(0L, 0L, 0L, 0L, minutes, 0L, "yyyy-MM-dd HH:mm:ss");
	}

	public static String futureMinutes(long minutes, String outputPattern) {
		return future(0L, 0L, 0L, 0L, minutes, 0L, outputPattern);
	}

	public static String futureSeconds(long seconds) {
		return future(0L, 0L, 0L, 0L, 0L, seconds, "yyyy-MM-dd HH:mm:ss");
	}

	public static String futureSeconds(long seconds, String outputPattern) {
		return future(0L, 0L, 0L, 0L, 0L, seconds, outputPattern);
	}

	public static String past(long years) {
		return past(years, 0L, 0L, 0L, 0L, 0L, "yyyy-MM-dd");
	}

	public static String past(long years, String outputPattern) {
		return past(years, 0L, 0L, 0L, 0L, 0L, outputPattern);
	}

	public static String past(long years, long months) {
		return past(years, months, 0L, 0L, 0L, 0L, "yyyy-MM-dd");
	}

	public static String past(long years, long months, String outputPattern) {
		return past(years, months, 0L, 0L, 0L, 0L, outputPattern);
	}

	public static String past(long years, long months, long days) {
		return past(years, months, days, 0L, 0L, 0L, "yyyy-MM-dd");
	}

	public static String past(long years, long months, long days, String outputPattern) {
		return past(years, months, days, 0L, 0L, 0L, outputPattern);
	}

	public static String past(long years, long months, long days, long hours) {
		return past(years, months, days, hours, 0L, 0L, "yyyy-MM-dd HH:mm:ss");
	}

	public static String past(long years, long months, long days, long hours, String outputPattern) {
		return past(years, months, days, hours, 0L, 0L, outputPattern);
	}

	public static String past(long years, long months, long days, long hours, long minutes) {
		return past(years, months, days, hours, minutes, 0L, "yyyy-MM-dd HH:mm:ss");
	}

	public static String past(long years, long months, long days, long hours, long minutes, String outputPattern) {
		return past(years, months, days, hours, minutes, 0L, outputPattern);
	}

	public static String past(long years, long months, long days, long hours, long minutes, long seconds) {
		return past(years, months, days, hours, minutes, seconds, "yyyy-MM-dd HH:mm:ss");
	}

	public static String past(long years, long months, long days, long hours, long minutes, long seconds, String outputPattern) {
		years = Math.abs(years);
		months = Math.abs(months);
		days = Math.abs(days);
		hours = Math.abs(hours);
		minutes = Math.abs(minutes);
		seconds = Math.abs(seconds);
		return LocalDateTime.now(defaultZoneId)
			.minusYears(years)
			.minusMonths(months)
			.minusDays(days)
			.minusHours(hours)
			.minusMinutes(minutes)
			.minusSeconds(seconds)
			.format(DateTimeFormatter.ofPattern(outputPattern, LocaleContextHolder.getLocale()));
	}

	public static String pastYears(long years) {
		return past(years, 0L, 0L, 0L, 0L, 0L, "yyyy-MM-dd");
	}

	public static String pastYears(long years, String outputPattern) {
		return past(years, 0L, 0L, 0L, 0L, 0L, outputPattern);
	}

	public static String pastMonths(long months) {
		return past(0L, months, 0L, 0L, 0L, 0L, "yyyy-MM-dd");
	}

	public static String pastMonths(long months, String outputPattern) {
		return past(0L, months, 0L, 0L, 0L, 0L, outputPattern);
	}

	public static String pastDays(long days) {
		return past(0L, 0L, days, 0L, 0L, 0L, "yyyy-MM-dd");
	}

	public static String pastDays(long days, String outputPattern) {
		return past(0L, 0L, days, 0L, 0L, 0L, outputPattern);
	}

	public static String pastHours(long hours) {
		return past(0L, 0L, 0L, hours, 0L, 0L, "yyyy-MM-dd HH:mm:ss");
	}

	public static String pastHours(long hours, String outputPattern) {
		return past(0L, 0L, 0L, hours, 0L, 0L, outputPattern);
	}

	public static String pastMinutes(long minutes) {
		return past(0L, 0L, 0L, 0L, minutes, 0L, "yyyy-MM-dd HH:mm:ss");
	}

	public static String pastMinutes(long minutes, String outputPattern) {
		return past(0L, 0L, 0L, 0L, minutes, 0L, outputPattern);
	}

	public static String pastSeconds(long seconds) {
		return past(0L, 0L, 0L, 0L, 0L, seconds, "yyyy-MM-dd HH:mm:ss");
	}

	public static String pastSeconds(long seconds, String outputPattern) {
		return past(0L, 0L, 0L, 0L, 0L, seconds, outputPattern);
	}

	public static boolean isBefore(String targetDate, String compareDate) {
		return isBefore(targetDate, compareDate, "yyyy-MM-dd");
	}

	public static boolean isBefore(String targetDateTime, String compareDateTime, String inputPattern) {
		if (!inputPattern.contains("uu") && !inputPattern.contains("yy") && !inputPattern.contains("M") && !inputPattern.contains("d")) {
			LocalTime target = LocalTime.parse(targetDateTime, DateTimeFormatter.ofPattern(inputPattern));
			LocalTime compare = LocalTime.parse(compareDateTime, DateTimeFormatter.ofPattern(inputPattern));
			return target.isBefore(compare);
		} else if (!inputPattern.contains("H") && !inputPattern.contains("h") && !inputPattern.contains("m") && !inputPattern.contains("s")) {
			LocalDate target = LocalDate.parse(targetDateTime, DateTimeFormatter.ofPattern(inputPattern));
			LocalDate compare = LocalDate.parse(compareDateTime, DateTimeFormatter.ofPattern(inputPattern));
			return target.isBefore(compare);
		} else {
			LocalDateTime target = LocalDateTime.parse(targetDateTime, DateTimeFormatter.ofPattern(inputPattern));
			LocalDateTime compare = LocalDateTime.parse(compareDateTime, DateTimeFormatter.ofPattern(inputPattern));
			return target.isBefore(compare);
		}
	}

	public static boolean isBeforeNow(String targetDate) {
		return isBeforeNow(targetDate, "yyyy-MM-dd");
	}

	public static boolean isBeforeNow(String targetDateTime, String inputPattern) {
		if (!inputPattern.contains("uu") && !inputPattern.contains("yy") && !inputPattern.contains("M") && !inputPattern.contains("d")) {
			LocalTime target = LocalTime.parse(targetDateTime, DateTimeFormatter.ofPattern(inputPattern));
			LocalTime compare = LocalTime.now(defaultZoneId);
			return target.isBefore(compare);
		} else if (!inputPattern.contains("H") && !inputPattern.contains("h") && !inputPattern.contains("m") && !inputPattern.contains("s")) {
			LocalDate target = LocalDate.parse(targetDateTime, DateTimeFormatter.ofPattern(inputPattern));
			LocalDate compare = LocalDate.now(defaultZoneId);
			return target.isBefore(compare);
		} else {
			LocalDateTime target = LocalDateTime.parse(targetDateTime, DateTimeFormatter.ofPattern(inputPattern));
			LocalDateTime compare = LocalDateTime.now(defaultZoneId);
			return target.isBefore(compare);
		}
	}

	public static boolean isAfter(String targetDate, String compareDate) {
		return isAfter(targetDate, compareDate, "yyyy-MM-dd");
	}

	public static boolean isAfter(String targetDateTime, String compareDateTime, String inputPattern) {
		if (!inputPattern.contains("uu") && !inputPattern.contains("yy") && !inputPattern.contains("M") && !inputPattern.contains("d")) {
			LocalTime target = LocalTime.parse(targetDateTime, DateTimeFormatter.ofPattern(inputPattern));
			LocalTime compare = LocalTime.parse(compareDateTime, DateTimeFormatter.ofPattern(inputPattern));
			return target.isAfter(compare);
		} else if (!inputPattern.contains("H") && !inputPattern.contains("h") && !inputPattern.contains("m") && !inputPattern.contains("s")) {
			LocalDate target = LocalDate.parse(targetDateTime, DateTimeFormatter.ofPattern(inputPattern));
			LocalDate compare = LocalDate.parse(compareDateTime, DateTimeFormatter.ofPattern(inputPattern));
			return target.isAfter(compare);
		} else {
			LocalDateTime target = LocalDateTime.parse(targetDateTime, DateTimeFormatter.ofPattern(inputPattern));
			LocalDateTime compare = LocalDateTime.parse(compareDateTime, DateTimeFormatter.ofPattern(inputPattern));
			return target.isAfter(compare);
		}
	}

	public static boolean isAfterNow(String targetDateTime) {
		return isAfterNow(targetDateTime, "yyyy-MM-dd");
	}

	public static boolean isAfterNow(String targetDateTime, String inputPattern) {
		if (!inputPattern.contains("uu") && !inputPattern.contains("yy") && !inputPattern.contains("M") && !inputPattern.contains("d")) {
			LocalTime target = LocalTime.parse(targetDateTime, DateTimeFormatter.ofPattern(inputPattern));
			LocalTime compare = LocalTime.now(defaultZoneId);
			return target.isAfter(compare);
		} else if (!inputPattern.contains("H") && !inputPattern.contains("h") && !inputPattern.contains("m") && !inputPattern.contains("s")) {
			LocalDate target = LocalDate.parse(targetDateTime, DateTimeFormatter.ofPattern(inputPattern));
			LocalDate compare = LocalDate.now(defaultZoneId);
			return target.isAfter(compare);
		} else {
			LocalDateTime target = LocalDateTime.parse(targetDateTime, DateTimeFormatter.ofPattern(inputPattern));
			LocalDateTime compare = LocalDateTime.now(defaultZoneId);
			return target.isAfter(compare);
		}
	}

	private static long between(String startDateTime, String endDateTime, String inputPattern, ChronoUnit chronoUnit) {
		if (!inputPattern.contains("uu") && !inputPattern.contains("yy") && !inputPattern.contains("M") && !inputPattern.contains("d")) {
			LocalTime start = LocalTime.parse(startDateTime, DateTimeFormatter.ofPattern(inputPattern));
			LocalTime end = LocalTime.parse(endDateTime, DateTimeFormatter.ofPattern(inputPattern));
			return chronoUnit.between(start, end);
		} else if (!inputPattern.contains("H") && !inputPattern.contains("h") && !inputPattern.contains("m") && !inputPattern.contains("s")) {
			LocalDate start = LocalDate.parse(startDateTime, DateTimeFormatter.ofPattern(inputPattern));
			LocalDate end = LocalDate.parse(endDateTime, DateTimeFormatter.ofPattern(inputPattern));
			return chronoUnit.between(start, end);
		} else {
			LocalDateTime start = LocalDateTime.parse(startDateTime, DateTimeFormatter.ofPattern(inputPattern));
			LocalDateTime end = LocalDateTime.parse(endDateTime, DateTimeFormatter.ofPattern(inputPattern));
			return chronoUnit.between(start, end);
		}
	}

	public static long betweenYears(String startDateTime, String endDateTime) {
		return between(startDateTime, endDateTime, "yyyy-MM-dd", ChronoUnit.YEARS);
	}

	public static long betweenYears(String startDateTime, String endDateTime, String inputPattern) {
		return between(startDateTime, endDateTime, inputPattern, ChronoUnit.YEARS);
	}

	public static long betweenMonths(String startDateTime, String endDateTime) {
		return between(startDateTime, endDateTime, "yyyy-MM-dd", ChronoUnit.MONTHS);
	}

	public static long betweenMonths(String startDateTime, String endDateTime, String inputPattern) {
		return between(startDateTime, endDateTime, inputPattern, ChronoUnit.MONTHS);
	}

	public static long betweenDays(String startDateTime, String endDateTime) {
		return between(startDateTime, endDateTime, "yyyy-MM-dd", ChronoUnit.DAYS);
	}

	public static long betweenDays(String startDateTime, String endDateTime, String inputPattern) {
		return between(startDateTime, endDateTime, inputPattern, ChronoUnit.DAYS);
	}

	public static long betweenHours(String startDateTime, String endDateTime) {
		return between(startDateTime, endDateTime, "yyyy-MM-dd HH:mm:ss", ChronoUnit.HOURS);
	}

	public static long betweenHours(String startDateTime, String endDateTime, String inputPattern) {
		return between(startDateTime, endDateTime, inputPattern, ChronoUnit.HOURS);
	}

	public static long betweenMinutes(String startDateTime, String endDateTime) {
		return between(startDateTime, endDateTime, "yyyy-MM-dd HH:mm:ss", ChronoUnit.MINUTES);
	}

	public static long betweenMinutes(String startDateTime, String endDateTime, String inputPattern) {
		return between(startDateTime, endDateTime, inputPattern, ChronoUnit.MINUTES);
	}

	public static long betweenSeconds(String startDateTime, String endDateTime) {
		return between(startDateTime, endDateTime, "yyyy-MM-dd HH:mm:ss", ChronoUnit.SECONDS);
	}

	public static long betweenSeconds(String startDateTime, String endDateTime, String inputPattern) {
		return between(startDateTime, endDateTime, inputPattern, ChronoUnit.SECONDS);
	}

	public static long betweenMillis(String startDateTime, String endDateTime) {
		return between(startDateTime, endDateTime, "yyyy-MM-dd HH:mm:ss", ChronoUnit.MILLIS);
	}

	public static long betweenMillis(String startDateTime, String endDateTime, String inputPattern) {
		return between(startDateTime, endDateTime, inputPattern, ChronoUnit.MILLIS);
	}

	private static long betweenNow(String targetDateTime, String inputPattern, ChronoUnit chronoUnit) {
		if (!inputPattern.contains("uu") && !inputPattern.contains("yy") && !inputPattern.contains("M") && !inputPattern.contains("d")) {
			LocalTime target = LocalTime.parse(targetDateTime, DateTimeFormatter.ofPattern(inputPattern));
			LocalTime now = LocalTime.now(defaultZoneId);
			return chronoUnit.between(target, now);
		} else if (!inputPattern.contains("H") && !inputPattern.contains("h") && !inputPattern.contains("m") && !inputPattern.contains("s")) {
			LocalDate target = LocalDate.parse(targetDateTime, DateTimeFormatter.ofPattern(inputPattern));
			LocalDate now = LocalDate.now(defaultZoneId);
			return chronoUnit.between(target, now);
		} else {
			LocalDateTime target = LocalDateTime.parse(targetDateTime, DateTimeFormatter.ofPattern(inputPattern));
			LocalDateTime now = LocalDateTime.now(defaultZoneId);
			return chronoUnit.between(target, now);
		}
	}

	public static long betweenYearsNow(String targetDateTime) {
		return betweenNow(targetDateTime, "yyyy-MM-dd", ChronoUnit.YEARS);
	}

	public static long betweenYearsNow(String targetDateTime, String inputPattern) {
		return betweenNow(targetDateTime, inputPattern, ChronoUnit.YEARS);
	}

	public static long betweenYearsNow(Long epochMilli) {
		return betweenNow(convert(epochMilli, "yyyy-MM-dd"), "yyyy-MM-dd", ChronoUnit.YEARS);
	}

	public static long betweenMonthsNow(String targetDateTime) {
		return betweenNow(targetDateTime, "yyyy-MM-dd", ChronoUnit.MONTHS);
	}

	public static long betweenMonthsNow(String targetDateTime, String inputPattern) {
		return betweenNow(targetDateTime, inputPattern, ChronoUnit.MONTHS);
	}

	public static long betweenMonthsNow(Long epochMilli) {
		return betweenNow(convert(epochMilli, "yyyy-MM-dd"), "yyyy-MM-dd", ChronoUnit.MONTHS);
	}

	public static long betweenDaysNow(String targetDateTime) {
		return betweenNow(targetDateTime, "yyyy-MM-dd", ChronoUnit.DAYS);
	}

	public static long betweenDaysNow(String targetDateTime, String inputPattern) {
		return betweenNow(targetDateTime, inputPattern, ChronoUnit.DAYS);
	}

	public static long betweenDaysNow(Long epochMilli) {
		return betweenNow(convert(epochMilli, "yyyy-MM-dd"), "yyyy-MM-dd", ChronoUnit.DAYS);
	}

	public static long betweenHoursNow(String targetDateTime) {
		return betweenNow(targetDateTime, "yyyy-MM-dd HH:mm:ss", ChronoUnit.HOURS);
	}

	public static long betweenHoursNow(String targetDateTime, String inputPattern) {
		return betweenNow(targetDateTime, inputPattern, ChronoUnit.HOURS);
	}

	public static long betweenHoursNow(Long epochMilli) {
		return betweenNow(convert(epochMilli, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss", ChronoUnit.HOURS);
	}

	public static long betweenMinutesNow(String targetDateTime) {
		return betweenNow(targetDateTime, "yyyy-MM-dd HH:mm:ss", ChronoUnit.MINUTES);
	}

	public static long betweenMinutesNow(String targetDateTime, String inputPattern) {
		return betweenNow(targetDateTime, inputPattern, ChronoUnit.MINUTES);
	}

	public static long betweenMinutesNow(Long epochMilli) {
		return betweenNow(convert(epochMilli, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss", ChronoUnit.MINUTES);
	}

	public static long betweenSecondsNow(String targetDateTime) {
		return betweenNow(targetDateTime, "yyyy-MM-dd HH:mm:ss", ChronoUnit.SECONDS);
	}

	public static long betweenSecondsNow(String targetDateTime, String inputPattern) {
		return betweenNow(targetDateTime, inputPattern, ChronoUnit.SECONDS);
	}

	public static long betweenSecondsNow(Long epochMilli) {
		return betweenNow(convert(epochMilli, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss", ChronoUnit.SECONDS);
	}

	public static long betweenMillisNow(String targetDateTime) {
		return betweenNow(targetDateTime, "yyyy-MM-dd HH:mm:ss.SSS", ChronoUnit.MILLIS);
	}

	public static long betweenMillisNow(String targetDateTime, String inputPattern) {
		return betweenNow(targetDateTime, inputPattern, ChronoUnit.MILLIS);
	}

	public static long betweenMillisNow(Long epochMilli) {
		return betweenNow(convert(epochMilli, "yyyy-MM-dd HH:mm:ss.SSS"), "yyyy-MM-dd HH:mm:ss.SSS", ChronoUnit.MILLIS);
	}

	public static String convert(String targetDateTime, String outputPattern) {
		return convert(targetDateTime, "yyyy-MM-dd", outputPattern);
	}

	public static String convert(String targetDateTime, String inputPattern, String outputPattern) {
		if (!inputPattern.contains("uu") && !inputPattern.contains("yy") && !inputPattern.contains("M") && !inputPattern.contains("d")) {
			return LocalTime.parse(targetDateTime, DateTimeFormatter.ofPattern(inputPattern))
				.format(DateTimeFormatter.ofPattern(outputPattern, LocaleContextHolder.getLocale()));
		} else {
			return !inputPattern.contains("H") && !inputPattern.contains("h") && !inputPattern.contains("m") && !inputPattern.contains("s") ?
				LocalDate.parse(targetDateTime, DateTimeFormatter.ofPattern(inputPattern))
					.format(DateTimeFormatter.ofPattern(outputPattern, LocaleContextHolder.getLocale())) :
				LocalDateTime.parse(targetDateTime, DateTimeFormatter.ofPattern(inputPattern))
					.format(DateTimeFormatter.ofPattern(outputPattern, LocaleContextHolder.getLocale()));
		}
	}

	public static String convertISOPattern(String targetDateTime, String outputPattern) {
		if (!StringUtils.isEmpty(targetDateTime) && !StringUtils.isEmpty(outputPattern)) {
			try {
				TemporalAccessor temporalAccessor = null;
				if (targetDateTime.contains("T")) {
					temporalAccessor = DateTimeFormatter.ISO_DATE_TIME.parse(targetDateTime);
					LocalDateTime localDateTime = LocalDateTime.from(temporalAccessor);
					return localDateTime.format(DateTimeFormatter.ofPattern(outputPattern, LocaleContextHolder.getLocale()));
				} else {
					temporalAccessor = DateTimeFormatter.ISO_DATE.parse(targetDateTime);
					LocalDate localDate = LocalDate.from(temporalAccessor);
					return localDate.format(DateTimeFormatter.ofPattern(outputPattern, LocaleContextHolder.getLocale()));
				}
			} catch (DateTimeParseException var4) {
				log.error("ISO 8601 날짜 패턴이 아닙니다. " + var4.getLocalizedMessage());
				return targetDateTime;
			} catch (DateTimeException var5) {
				log.error("포맷 변경시 에러 발생 " + var5.getLocalizedMessage());
				return targetDateTime;
			} catch (Exception var6) {
				log.error("{}: 오류 발생  " + var6.getLocalizedMessage());
				return targetDateTime;
			}
		} else {
			log.error("{}: 입력 데이터 없음");
			return "";
		}
	}

	public static String convertISOPattern(String targetDateTime, String outputPattern, String zoneId) {
		if (!StringUtils.isEmpty(targetDateTime) && !StringUtils.isEmpty(outputPattern)) {
			if (StringUtils.isEmpty(zoneId)) {
				zoneId = defaultZoneId.getId();
			} else if (!isAvailableZoneId(zoneId)) {
				log.error("올바른 ZoneId 문자열이 아닙니다.");
				log.info("아래의 사용 가능한 ZoneId 문자열 목록에서 확인하세요.");
				String[] zoneIdArray = getAvailableZoneIdArray();
				String[] var14 = zoneIdArray;
				int var16 = zoneIdArray.length;

				for (int var17 = 0; var17 < var16; ++var17) {
					String zone = var14[var17];
					log.info("{}", zone);
				}

				return targetDateTime;
			}

			try {
				TemporalAccessor temporalAccessor = null;
				if (targetDateTime.contains("T")) {
					temporalAccessor = DateTimeFormatter.ISO_DATE_TIME.parse(targetDateTime);

					ZonedDateTime zonedDateTime;
					try {
						OffsetDateTime dateTime = OffsetDateTime.from(temporalAccessor);
						zonedDateTime = dateTime.atZoneSameInstant(ZoneId.of(zoneId));
					} catch (DateTimeException var8) {
						LocalDateTime dateTime = LocalDateTime.from(temporalAccessor);
						zonedDateTime = ZonedDateTime.of(dateTime, defaultZoneId).withZoneSameInstant(ZoneId.of(zoneId));
					} catch (Exception var9) {
						log.error("{}: 오류 발생");
						return targetDateTime;
					}

					return zonedDateTime.format(DateTimeFormatter.ofPattern(outputPattern, LocaleContextHolder.getLocale()));
				} else {
					temporalAccessor = DateTimeFormatter.ISO_DATE.parse(targetDateTime);
					LocalDate localDate = LocalDate.from(temporalAccessor);
					return localDate.format(DateTimeFormatter.ofPattern(outputPattern, LocaleContextHolder.getLocale()));
				}
			} catch (DateTimeParseException var10) {
				log.error("ISO 8601 날짜 패턴이 아닙니다. " + var10.getLocalizedMessage());
				return targetDateTime;
			} catch (DateTimeException var11) {
				log.error("포맷 변경시 에러 발생 " + var11.getLocalizedMessage());
				return targetDateTime;
			} catch (Exception var12) {
				log.error("{}: 오류 발생  " + var12.getLocalizedMessage());
				return targetDateTime;
			}
		} else {
			log.error("{}: 입력 데이터 없음");
			return "";
		}
	}

	public static String convert(Long epochMilli) {
		return convert(epochMilli, "yyyy-MM-dd");
	}

	public static String convert(Long epochMilli, String outputPattern) {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), defaultZoneId)
			.format(DateTimeFormatter.ofPattern(outputPattern, LocaleContextHolder.getLocale()));
	}

	public static String print(String dateTime, int offset) {
		if (dateTime == null) {
			return "";
		} else {
			offset = Math.abs(offset);
			return dateTime.length() >= offset ? dateTime.substring(0, offset) : dateTime;
		}
	}

	public static String printDate(String dateTime) {
		if (dateTime == null) {
			return "";
		} else if (dateTime.contains("T")) {
			return dateTime.substring(0, dateTime.indexOf("T")).trim();
		} else {
			if (dateTime.contains(" ")) {
				String[] strArray = dateTime.split(" ");
				if (strArray.length <= 1) {
					return dateTime;
				}

				if (strArray.length == 2) {
					return strArray[0];
				}
			}

			return dateTime;
		}
	}

	public static String printTime(String dateTime) {
		if (dateTime == null) {
			return "";
		} else if (dateTime.contains("T")) {
			return dateTime.substring(dateTime.indexOf("T") + 1).trim();
		} else {
			if (dateTime.contains(" ")) {
				String[] strArray = dateTime.split(" ");
				if (strArray.length <= 1) {
					return dateTime;
				}

				if (strArray.length == 2) {
					return strArray[1];
				}
			}

			return dateTime;
		}
	}

	public static String period(String dateTime1, String dateTime2) {
		return period(dateTime1, dateTime2, "yyyy-MM-dd");
	}

	public static String period(String dateTime1, String dateTime2, String inputPattern) {
		return period(dateTime1, dateTime2, inputPattern, "${years}년  ${months}개월 ${days}일 ${hours}시간 ${minutes}분 ${seconds}초");
	}

	public static String period(String dateTime1, String dateTime2, String inputPattern, String outputPattern) {
		Period period = null;
		Duration duration = null;
		if (!inputPattern.contains("uu") && !inputPattern.contains("yy") && !inputPattern.contains("M") && !inputPattern.contains("d")) {
			LocalTime date1 = LocalTime.parse(dateTime1, DateTimeFormatter.ofPattern(inputPattern));
			LocalTime date2 = LocalTime.parse(dateTime2, DateTimeFormatter.ofPattern(inputPattern));
			if (date1.isBefore(date2)) {
				duration = Duration.between(date1, date2);
			} else {
				duration = Duration.between(date2, date1);
			}
		} else if (!inputPattern.contains("H") && !inputPattern.contains("h") && !inputPattern.contains("m") && !inputPattern.contains("s")) {
			LocalDate date1 = LocalDate.parse(dateTime1, DateTimeFormatter.ofPattern(inputPattern));
			LocalDate date2 = LocalDate.parse(dateTime2, DateTimeFormatter.ofPattern(inputPattern));
			if (date1.isBefore(date2)) {
				period = Period.between(date1, date2);
			} else {
				period = Period.between(date2, date1);
			}
		} else {
			LocalDateTime date1 = LocalDateTime.parse(dateTime1, DateTimeFormatter.ofPattern(inputPattern));
			LocalDateTime date2 = LocalDateTime.parse(dateTime2, DateTimeFormatter.ofPattern(inputPattern));
			if (date1.isBefore(date2)) {
				period = Period.between(date1.toLocalDate(), date2.toLocalDate());
				duration = Duration.between(date1.toLocalTime(), date2.toLocalTime());
			} else {
				period = Period.between(date2.toLocalDate(), date1.toLocalDate());
				duration = Duration.between(date2.toLocalTime(), date1.toLocalTime());
			}
		}

		String result = outputPattern;
		int hours;
		int minutes;
		if (duration != null) {
			long seconds = duration.getSeconds();
			if (seconds < 0L && period != null) {
				seconds += 86400L;
				period = period.minusDays(1L);
			}
			hours = (int)seconds / 3600;
			seconds -= (long)(hours * 3600);
			minutes = (int)seconds / 60;
			seconds -= (long)(minutes * 60);
			if (hours > 0) {
				result = outputPattern.replace("${hours}", String.valueOf(hours));
			}

			if (minutes > 0) {
				result = result.replace("${minutes}", String.valueOf(minutes));
			}

			if (seconds > 0L) {
				result = result.replace("${seconds}", String.valueOf(seconds));
			}
		}

		if (period != null) {
			if (period.getYears() > 0) {
				result = result.replace("${years}", String.valueOf(period.getYears()));
			}

			if (period.getMonths() > 0) {
				result = result.replace("${months}", String.valueOf(period.getMonths()));
			}

			if (period.getDays() > 0) {
				result = result.replace("${days}", String.valueOf(period.getDays()));
			}
		}

		String[] patterns = outputPattern.split("[$]");
		String[] var8 = patterns;
		hours = patterns.length;

		for (minutes = 0; minutes < hours; ++minutes) {
			String pattern = var8[minutes];
			if (!"".equals(pattern)) {
				result = result.replace("$" + pattern, "");
			}
		}

		return result;
	}

	public static String[] getAvailableZoneIdArray() {
		String[] zoneIdArray = (String[])ZoneId.getAvailableZoneIds().toArray(new String[0]);
		Arrays.sort(zoneIdArray);
		return zoneIdArray;
	}

	public static List<ZoneId> getAvailableZoneIdList() {
		String[] zoneIdArray = (String[])ZoneId.getAvailableZoneIds().toArray(new String[0]);
		Arrays.sort(zoneIdArray);
		List<ZoneId> zoneIdList = new ArrayList();
		String[] var2 = zoneIdArray;
		int var3 = zoneIdArray.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			String zoneId = var2[var4];
			zoneIdList.add(ZoneId.of(zoneId));
		}

		return zoneIdList;
	}

	public static boolean isAvailableZoneId(ZoneId zoneId) {
		return isAvailableZoneId(zoneId.getId());
	}

	public static boolean isAvailableZoneId(String zoneId) {
		return getAvailableZoneIdList().contains(ZoneId.of(zoneId));
	}

	public static boolean setTimeZone(ZoneId zoneId) {
		return setTimeZone(zoneId.getId());
	}

	public static boolean setTimeZone(String zoneId) {
		if (isAvailableZoneId(zoneId)) {
			defaultZoneId = ZoneId.of(zoneId);
			return true;
		} else {
			log.error("올바른 ZoneId 문자열이 아닙니다.");
			log.info("아래의 사용 가능한 ZoneId 문자열 목록에서 확인하세요.");
			String[] zoneIdArray = getAvailableZoneIdArray();
			String[] var2 = zoneIdArray;
			int var3 = zoneIdArray.length;

			for (int var4 = 0; var4 < var3; ++var4) {
				String zone = var2[var4];
				log.info("{}", zone);
			}

			return false;
		}
	}
}

