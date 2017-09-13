/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command.tools;

import java.util.List;

import multichain.command.MultichainException;

/**
 * @author Ub - H. MARTEAU
 * @version 1.1
 */
public class MultichainTestParameter {

	public static void isNotNullOrEmpty(String name, String string) throws MultichainException {
		if (string != null) {
			if (string.isEmpty()) {
				throw new MultichainException(name, "is null or empty.");
			}
		} else {
			throw new MultichainException(name, "is null or empty.");
		}
	}

	public static void isNotNull(String name, Object object) throws MultichainException {
		if (object == null) {
			throw new MultichainException(name, "is null or empty.");
		}
	}

	public static void isNotNullOrEmpty(String name, Object[] array) throws MultichainException {
		if (array != null) {
			if (array.length <= 0) {
				throw new MultichainException(name, "size is 0.");
			}
		} else {
			throw new MultichainException(name, "is null.");
		}
	}

	public static void isNotNullOrEmpty(String name, List<Object> list) throws MultichainException {
		if (list != null) {
			if (list.size() <= 0) {
				throw new MultichainException(name, "size is 0.");
			}
		} else {
			throw new MultichainException(name, "is null.");
		}
	}

	public static boolean isArrayNotNullOrEmpty(Object[] array) {
		if (array == null || array.length <= 0) {
			return false;
		}
		return true;
	}

	public static void arrayNotContainNullOrEmptyValues(String name, Object[] array) throws MultichainException {
		for (Object object : array) {
			if (object == null) {
				throw new MultichainException(name, "array contain null value.");
			} else if (object.getClass() == String.class) {
				if (((String) object).isEmpty()) {
					throw new MultichainException(name, "array contain empty string.");
				}
			}
		}
	}

	public static void floatArrayContainNullOrNegativeValue(String name, float[] array) throws MultichainException {
		for (float f : array) {
			if (f < 0) {
				throw new MultichainException(name, "array contain negative value.");
			} else if (f == 0) {
				throw new MultichainException(name, "array contain null values.");
			}
		}
	}

	public static void intArrayContainNullOrNegativeValue(String name, int[] array) throws MultichainException {
		for (int i : array) {
			if (i < 0) {
				throw new MultichainException(name, "array contain negative value.");
			} else if (i == 0) {
				throw new MultichainException(name, "array contain null values.");
			}
		}
	}

	public static void valueIsNotNegative(String name, int value) throws MultichainException {
		if (value < 0) {
			throw new MultichainException(name, "is negative.");
		}
	}

	public static void valueIsNotNegative(String name, float value) throws MultichainException {
		if (value < 0) {
			throw new MultichainException(name, "is negative.");
		}
	}

	public static void valueIsNotNegative(String name, double value) throws MultichainException {
		if (value < 0) {
			throw new MultichainException(name, "is negative.");
		}
	}

	public static void valueIsPositive(String name, int value) throws MultichainException {
		if (value < 0) {
			throw new MultichainException(name, "is negative.");
		} else if (value == 0) {
			throw new MultichainException(name, "is null.");
		}
	}

	public static void valueIsPositive(String name, float value) throws MultichainException {
		if (value < 0) {
			throw new MultichainException(name, "is negative.");
		} else if (value == 0) {
			throw new MultichainException(name, "is null.");
		}
	}

	public static void valueIsPositive(String name, double value) throws MultichainException {
		if (value < 0) {
			throw new MultichainException(name, "is negative.");
		} else if (value == 0) {
			throw new MultichainException(name, "is null.");
		}
	}

}
