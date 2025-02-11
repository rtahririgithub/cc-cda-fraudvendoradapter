package com.telus.subsfraudmgmt.springboot.model.transaction;

public enum TransactionType {

	FraudCheckTransaction,
	CreateFraudFileTransaction,
	UpdateFraudFileTransaction,
	DeleteFraudFileTransaction,
	UpdateAppDispositionTransaction,
	UpdateCaseDispositionTransaction;

	public static boolean isFraudCheckTransaction(String transactionType) {
		return FraudCheckTransaction.toString().equalsIgnoreCase(transactionType);
	}

	public static boolean isCreateFraudFileTransaction(String transactionType) {
		return CreateFraudFileTransaction.toString().equalsIgnoreCase(transactionType);
	}

	public static boolean isUpdateFraudFileTransaction(String transactionType) {
		return UpdateFraudFileTransaction.toString().equalsIgnoreCase(transactionType);
	}

	public static boolean isDeleteFraudFileTransaction(String transactionType) {
		return DeleteFraudFileTransaction.toString().equalsIgnoreCase(transactionType);
	}

	public static boolean isUpdateAppDispositionTransaction(String transactionType) {
		return UpdateAppDispositionTransaction.toString().equalsIgnoreCase(transactionType);
	}

	public static boolean isUpdateCaseDispositionTransaction(String transactionType) {
		return UpdateCaseDispositionTransaction.toString().equalsIgnoreCase(transactionType);
	}
}
