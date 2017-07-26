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

import multichain.object.TransactionWallet;
import multichain.object.TransactionWalletDetailed;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

/**
 * @author Ub - H. MARTEAU
 * @version 3.0
 */
public class WalletTransactionFormatter {
	public final static List<TransactionWallet> formatListTransactionWallet(List<Object> objectWalletTransactions) {
		List<TransactionWallet> transactionWalletList = new ArrayList<TransactionWallet>();

		if (objectWalletTransactions != null) {
			for (Object objectWalletTransaction : objectWalletTransactions) {
				transactionWalletList.add(formatTransactionWallet(objectWalletTransaction));
			}
		}

		return transactionWalletList;
	}

	public final static TransactionWallet formatTransactionWallet(Object objectWalletTransaction) {
		TransactionWallet transactionWallet = new TransactionWallet();

		if (objectWalletTransaction != null && LinkedTreeMap.class.isInstance(objectWalletTransaction)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectWalletTransaction);
			transactionWallet = gson.fromJson(jsonValue, TransactionWallet.class);
		}

		return transactionWallet;
	}

	public final static TransactionWalletDetailed formatTransactionWalletDetailed(Object objectWalletTransactionDetailed) {
		TransactionWalletDetailed transactionWalletDetailed = new TransactionWalletDetailed();

		if (objectWalletTransactionDetailed != null && LinkedTreeMap.class.isInstance(objectWalletTransactionDetailed)) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();

			String jsonValue = gson.toJson(objectWalletTransactionDetailed);
			transactionWalletDetailed = gson.fromJson(jsonValue, TransactionWalletDetailed.class);
		}

		return transactionWalletDetailed;
	}

}
