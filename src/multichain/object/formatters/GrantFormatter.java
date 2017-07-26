/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.formatters;

import java.util.ArrayList;
import java.util.List;

import multichain.object.Permission;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

/**
 * @author Ub - H. MARTEAU
 * @version 3.0
 */
public class GrantFormatter {
	public final static Permission formatPermission(Object objectPermission) {
		Permission permission = new Permission();

		if (objectPermission != null && LinkedTreeMap.class.isInstance(objectPermission)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectPermission);
			permission = gson.fromJson(jsonValue, Permission.class);
		}

		return permission;
	}

	public final static List<Permission> formatPermissions(List<Object> objectPermissions) {
		List<Permission> permissions = new ArrayList<Permission>();

		if (objectPermissions != null) {
			for (Object objectPermission : objectPermissions) {
				permissions.add(formatPermission(objectPermission));
			}
		}

		return permissions;
	}

}
