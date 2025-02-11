package com.telus.subsfraudmgmt.springboot.model.transaction;

public enum TransactionSubType {

	AIFraudPredictionTransaction;

	public static boolean isAIFraudPredictionTransaction(String transactionType) {
		return AIFraudPredictionTransaction.toString().equalsIgnoreCase(transactionType);
	}

}
