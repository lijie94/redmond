package com.redmond.coding;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneralUtils {

	public static final SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);

	public static String dateToString(Date date) {
		return date == null ? "null" : sdf.format(date);
	}

	public static Date dateFromString(String string) {
		try {
			return string == null || string.isEmpty()
					|| string.equalsIgnoreCase("null") ? null : sdf
					.parse(string);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String toSimpleBSSID(String bssidWithColon) {
		if (bssidWithColon == null) {
			return "";
		}
		String bssid = bssidWithColon.trim();
		if (bssid.length() != 17) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int j = 0;
		for (int i = 0; i < 17; i++) {
			if (j == 2) {
				j = 0;
				continue;
			}
			sb.append(bssid.charAt(i));
			j++;
		}
		return sb.toString();
	}

	public static String toString(Iterable<String> set, String separator) {
		if (set == null) {
			return "null";
		}
		StringBuilder sbuf = new StringBuilder();
		boolean isFirst = true;
		for (String value : set) {
			if (!isFirst) {
				sbuf.append(separator);
			}
			isFirst = false;
			sbuf.append(value);
		}
		return sbuf.toString();
	}

	public static String[] fromString(String str, String separator) {
		if (str.equals("null")) {
			return null;
		}
		if (str.isEmpty()) {
			return new String[0];
		}
		String[] res = str.split(separator);
		return res;
	}

	public static boolean[] booleanArrayFromString(String str, String separator) {
		String[] res = GeneralUtils.fromString(str, ",");
		if (res == null) {
			return null;
		} else {
			boolean[] res0 = new boolean[res.length];
			for (int i = 0, n = res.length; i < n; i++) {
				res0[i] = Boolean.parseBoolean(res[i]);
			}

			return res0;
		}
	}

	public static int[] intArrayFromString(String str, String separator) {
		String[] res = GeneralUtils.fromString(str, ",");
		if (res == null) {
			return null;
		} else {
			int[] res0 = new int[res.length];
			for (int i = 0, n = res.length; i < n; i++) {
				res0[i] = Integer.parseInt(res[i]);
			}

			return res0;
		}
	}

	public static double[] doubleArrayFromString(String str, String separator) {
		String[] res = GeneralUtils.fromString(str, ",");
		if (res == null) {
			return null;
		} else {
			double[] res0 = new double[res.length];
			for (int i = 0, n = res.length; i < n; i++) {
				res0[i] = Double.parseDouble(res[i]);
			}

			return res0;
		}
	}

	public static long[] longArrayFromString(String str, String separator) {
		String[] res = GeneralUtils.fromString(str, ",");
		if (res == null) {
			return null;
		} else {
			long[] res0 = new long[res.length];
			for (int i = 0, n = res.length; i < n; i++) {
				res0[i] = Long.parseLong(res[i]);
			}

			return res0;
		}
	}

	public static String toString(boolean[] l) {
		return "[" + toString(l, ", ") + "]";
	}

	public static String toString(boolean[] l, String seperator) {
		if (l == null) {
			return "NULL_ARRAY";
		}
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for (boolean k : l) {
			if (!isFirst) {
				sb.append(seperator);
			}
			sb.append(k);
			isFirst = false;
		}
		return sb.toString();
	}

	public static String toString(double[] l) {
		return "[" + toString(l, ", ") + "]";
	}

	public static String toString(double[] l, String seperator) {
		if (l == null) {
			return "NULL_ARRAY";
		}
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for (double k : l) {
			if (!isFirst) {
				sb.append(seperator);
			}
			sb.append(k);
			isFirst = false;
		}
		return sb.toString();
	}

	public static String toString(float[] l) {
		return "[" + toString(l, ", ") + "]";
	}

	public static String toString(float[] l, String seperator) {
		if (l == null) {
			return "NULL_ARRAY";
		}
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for (float k : l) {
			if (!isFirst) {
				sb.append(seperator);
			}
			sb.append(k);
			isFirst = false;
		}
		return sb.toString();
	}

	public static String toString(int[] l) {
		return "[" + toString(l, ", ") + "]";
	}

	public static String toString(int[] l, String seperator) {
		if (l == null) {
			return "NULL_ARRAY";
		}
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for (int k : l) {
			if (!isFirst) {
				sb.append(seperator);
			}
			sb.append(k);
			isFirst = false;
		}
		return sb.toString();
	}

	public static <T> String toString(List<T> l) {
		return "[" + toString(l, ", ") + "]";
	}

	public static <T> String toString(List<T> l, String seperator) {
		if (l == null) {
			return "NULL_LIST";
		}
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for (T k : l) {
			if (!isFirst) {
				sb.append(seperator);
			}
			sb.append("" + k);
			isFirst = false;
		}
		return sb.toString();
	}

	public static String toString(long[] l, String seperator) {
		if (l == null) {
			return "NULL_ARRAY";
		}
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for (long k : l) {
			if (!isFirst) {
				sb.append(seperator);
			}
			sb.append(k);
			isFirst = false;
		}
		return sb.toString();
	}

	public static <K, V> String toString(Map<K, V> m) {
		return toString(m, ", ", ": ");
	}

	public static <K, V> String toString(Map<K, V> m, String s, String d) {
		if (m == null) {
			return "NULL_MAP";
		}
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for (K key : m.keySet()) {
			if (!isFirst) {
				sb.append(s);
			}
			sb.append(key.toString() + d + m.get(key).toString());
			isFirst = false;
		}
		return sb.toString();
	}

	public static <T> String toString(Set<T> l) {
		return "[" + toString(l, ", ") + "]";
	}

	public static <T> String toString(Set<T> s, String seperator) {
		if (s == null) {
			return "NULL_SET";
		}
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for (T k : s) {
			if (!isFirst) {
				sb.append(seperator);
			}
			sb.append(k.toString());
			isFirst = false;
		}
		return sb.toString();
	}

	public static <T> String toString(T[] l) {
		return "[" + toString(l, ", ") + "]";
	}

	public static <T> String toString(T[] l, String seperator) {
		if (l == null) {
			return "NULL_ARRAY";
		}
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for (T k : l) {
			if (!isFirst) {
				sb.append(seperator);
			}
			sb.append("" + k);
			isFirst = false;
		}
		return sb.toString();
	}

	public static long[] toLongArray(Collection<Long> data) {
		long[] arr = new long[data.size()];
		int i = 0;
		for (long f : data) {
			arr[i] = f;
			i++;
		}
		return arr;
	}

	public static long[] toLongArray(String[] array) {
		long[] vals = new long[array.length];
		for (int i = 0; i < array.length; i++) {
			vals[i] = Long.parseLong(array[i]);
		}
		return vals;
	}

	public static String md5(String string) {
		byte[] hash;

		try {
			hash = MessageDigest.getInstance("MD5").digest(
					string.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Huh, MD5 should be supported?", e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Huh, UTF-8 should be supported?", e);
		}

		StringBuilder hex = new StringBuilder(hash.length * 2);

		for (byte b : hash) {
			int i = (b & 0xFF);
			if (i < 0x10)
				hex.append('0');
			hex.append(Integer.toHexString(i));
		}

		return hex.toString();
	}

	public static boolean isRemoteUrl(String filename) {
		return filename != null && filename.startsWith("http");
	}

	public static int parseInt(String txt, int defaultValue) {
		try {
			int res = Integer.parseInt(txt);
			return res;
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static String randomString(int len) {
		StringBuilder sb = new StringBuilder();
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < len; i++) {
			int r0 = r.nextInt(62);
			char ch = 'A';
			if (r0 < 26) {
				ch = (char) ('A' + r0);
			} else if (r0 < 52) {
				ch = (char) ('a' + r0 - 26);
			} else {
				ch = (char) ('0' + r0 - 52);
			}
			sb.append(ch);
		}

		return sb.toString();
	}

	public static boolean isEqual(String stringA, String stringB) {
		if (stringA == null) {
			return stringB == null;
		}

		if (stringB == null) {
			return false;
		}

		return stringA.equals(stringB);
	}

	public static <T> boolean isEqualObject(T a, T b) {
		if (a == null) {
			return b == null;
		}

		if (b == null) {
			return false;
		}

		return a.equals(b);
	}

	public static String getReadableTimeDifference(Date date) {
		long now = System.currentTimeMillis();
		long difference = now - date.getTime();
		int minutes = (int) (Math.floor(difference / (60.0 * 1000)));
		if (minutes == 0) {
			return "now";
		}

		if (minutes < 60) {
			return "" + minutes + "m ago";
		}

		int daysDifference = getDaysDifference(new Date(), date);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",
				Locale.US);

		switch (daysDifference) {
		case 0:
			formatter.applyPattern("h:mm a");
			break;
		case 1: {
			formatter.applyPattern("'Yesterday'");
			break;
		}
		default:
			break;
		}
		String formattedDateString = formatter.format(date);
		return formattedDateString;
	}

	public static Date getStartTimeOfTheDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);
		calendar.set(year, month, day, 0, 0, 0);
		return calendar.getTime();
	}

	public static int getDaysDifference(Date date0, Date date1) {
		long t0 = date0.getTime();
		long t1 = date1.getTime();

		long diff = t0 - t1;
		return (int) (Math.floor(diff / (1000 * 3600 * 24.0)));
	}

	private static Pattern pattern;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static boolean isValidEmail(String email) {
		if (email == null || email.isEmpty()) {
			return false;
		}

		if (pattern == null) {
			pattern = Pattern.compile(EMAIL_PATTERN);
		}

		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static String parseLastName(String name) {
		if (name == null || name.isEmpty()) {
			return "";
		}

		int indexOfLastSpace = name.lastIndexOf(' ');
		if (indexOfLastSpace >= 0) {
			return name.substring(indexOfLastSpace + 1);
		} else {
			return "";
		}
	}

	public static String parseFirstName(String name) {
		if (name == null || name.isEmpty()) {
			return "";
		}

		int indexOfLastSpace = name.lastIndexOf(' ');
		if (indexOfLastSpace >= 0) {
			return name.substring(0, indexOfLastSpace);
		} else {
			return name;
		}
	}

	public static String generateFullName(String firstName, String lastName) {
		lastName = lastName == null ? "" : lastName.trim();
		firstName = firstName == null ? "" : firstName.trim();
		return firstName + " " + lastName;
	}

	/**
	 * Unique day-id based on UTC.
	 */
	public static int getDayId(Date date) {
		return getDayId(date.getTime());
	}

	public static final long ONE_DAY = 24L * 60L * 60L * 1000L;

	/**
	 * Unique day-id based on UTC.
	 */
	public static int getDayId(long time) {
		return (int) (time / ONE_DAY);
	}

	/**
	 * Returns midnight in UTC for start of the specified dayId.
	 */
	public static Date getDate(int dayId) {
		return new Date(dayId * ONE_DAY);
	}

	public static boolean isUrl(String resource) {
		return resource != null && resource.startsWith("http");
	}

	public static boolean contains(String[] list, String s) {
		if (list != null && list.length != 0 && s != null) {
			for (String str : list) {
				if (str.equals(s)) {
					return true;
				}
			}
		}
		return false;
	}

	@Deprecated
	// for waterpark
	// hash employee id before sending
	public static String hashEmployeeId(String id) {
		String padding = "00000000000";
		String paddedId = id + padding;

		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			return "";
		}
		digest.reset();
		digest.update(paddedId.getBytes());
		byte[] data = digest.digest();
		return String.format("%0" + (data.length * 2) + "X", new BigInteger(1,
				data));
	}

	@Deprecated
	public static boolean isValidEmployeeId(String id) {
		if (id == null || id.length() != 9) {
			return false;
		}

		for (int i = 0; i < 9; i++) {
			int ch = id.charAt(i);
			if (ch < '0' || ch > '9') {
				return false;
			}
		}

		return true;
	}

}
