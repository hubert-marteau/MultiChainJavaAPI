/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.formatters;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Ub - H. MARTEAU
 * @version 1.1
 */
public class GsonFormatters {

	protected static String formatJson(String value) {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		return gson.toJson(value);
	}

	protected static String formatString(String jsonValue) {
		final Gson gson = new GsonBuilder().create();
		final String value = gson.fromJson(jsonValue, String.class);

		return value;
	}

	protected static String formatJson(boolean value) {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		return gson.toJson(value);
	}

	protected static String formatJson(int value) {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		return gson.toJson(value);
	}

	protected static String formatJson(long value) {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		return gson.toJson(value);
	}

	protected static String formatJson(float value) {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		return gson.toJson(value);
	}

	protected static String formatJson(double value) {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		return gson.toJson(value);
	}

	protected static String formatJson(String[] values) {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		return gson.toJson(values);
	}

	protected static String formatJson(List<Object> values) {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		return gson.toJson(values);
	}

	protected static String formatJson(Object value) {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		return gson.toJson(value);
	}
}
