/*
 * package com.telus.subsfraudmgmt.springboot.mybatis;
 * 
 * import java.sql.Date; import java.sql.Timestamp;
 * 
 * import org.apache.ibatis.annotations.Insert; import
 * org.apache.ibatis.annotations.Mapper; import
 * org.apache.ibatis.annotations.Select; import
 * org.apache.ibatis.annotations.SelectKey;
 * 
 * @Mapper public interface FraudTransactionMapper {
 * 
 * @Insert( "Insert into FRAUD_TRN(" + "PARTITION_KEY," + "FRAUD_TRN_ID," +
 * "CREDIT_ASSESSMENT_REQUEST_ID," + "ACCOUNT_ID," + "FRAUD_TRN_TYPE," +
 * "FRAUD_TRN_DOC," + "CREATE_USER_ID," + "DATA_SOURCE_ID)" + "values(" +
 * "trunc(sysdate, 'mm'),"+ "#{id}," + "#{creditAssementRequestId}," +
 * "#{accountId}," + "#{fraudTransactionType}," + "#{fraudTransactionDoc:BLOB},"
 * + "#{createUser}," + "#{dataSourceId}" + ")" )
 * 
 * @SelectKey(statement = "SELECT FRAUD_TRN_ID_SEQ.NEXTVAL FROM dual", before =
 * true, keyProperty = "id", resultType = long.class) void
 * insertFraudTran(FraudTranEntity fraudTranEntity);
 * 
 * 
 * @Select( "SELECT " + "FRAUD_TRN_ID as id," + "ACCOUNT_ID as accountId," +
 * "FRAUD_TRN_TYPE as fraudTransactionType," +
 * "FRAUD_TRN_DOC as fraudTransactionDoc," + "CREATE_TS as createTs " +
 * " from FRAUD_TRN " + "where FRAUD_TRN_ID=#{fraudTranId}" ) FraudTranEntity
 * getFraudTranById(long fraudTranId);
 * 
 * 
 * @Insert( "Insert into LAST_FRAUD_TRN(" + "FRAUD_PARTITION_KEY," +
 * "LAST_FRAUD_TRN_ID," + "ACCOUNT_ID," + "FRAUD_TRN_ID," + "FRAUD_TRN_TYPE," +
 * "FRAUD_TRN_TS," + "CREATE_USER_ID," + "DATA_SOURCE_ID)" + "values(" +
 * "trunc(sysdate, 'mm'),"+ "#{id}," + "#{accountId}," + "#{fraundTranId}," +
 * "#{fraudTransactionType}," + "#{fraudTranTs}," + "#{createUser}," +
 * "#{dataSourceId}" + ")" )
 * 
 * @SelectKey(statement = "SELECT LAST_FRAUD_TRN_ID_SEQ.NEXTVAL FROM dual",
 * before = true, keyProperty = "id", resultType = long.class) void
 * insertLastFraudTran(LastFraudTranEntity lastFraudTranEntity);
 * 
 * @Select( "SELECT 1 from dual" ) long ping();
 * 
 * public static class FraudTranEntity { private Date partitionKey; private long
 * id; private long creditAssementRequestId; private long accountId; private
 * String fraudTransactionType; private byte[] fraudTransactionDoc; private
 * Timestamp createTs; private String createUser; private long dataSourceId;
 * public Date getPartitionKey() { return partitionKey; } public void
 * setPartitionKey(Date partitionKey) { this.partitionKey = partitionKey; }
 * public long getId() { return id; } public void setId(long id) { this.id = id;
 * } public long getCreditAssementRequestId() { return creditAssementRequestId;
 * } public void setCreditAssementRequestId(long creditAssementRequestId) {
 * this.creditAssementRequestId = creditAssementRequestId; } public long
 * getAccountId() { return accountId; } public void setAccountId(long accountId)
 * { this.accountId = accountId; } public String getFraudTransactionType() {
 * return fraudTransactionType; } public void setFraudTransactionType(String
 * fraudTransactionType) { this.fraudTransactionType = fraudTransactionType; }
 * public byte[] getFraudTransactionDoc() { return fraudTransactionDoc; } public
 * void setFraudTransactionDoc(byte[] fraudTransactionDoc) {
 * this.fraudTransactionDoc = fraudTransactionDoc; } public Timestamp
 * getCreateTs() { return createTs; } public void setCreateTs(Timestamp
 * createTs) { this.createTs = createTs; } public String getCreateUser() {
 * return createUser; } public void setCreateUser(String createUser) {
 * this.createUser = createUser; } public long getDataSourceId() { return
 * dataSourceId; } public void setDataSourceId(long dataSourceId) {
 * this.dataSourceId = dataSourceId; }
 * 
 * 
 * }
 * 
 * public static class LastFraudTranEntity {
 * 
 * private Date partitionKey; private long id; private long accountId; private
 * long fraundTranId; private String fraudTransactionType; private Timestamp
 * fraudTranTs; private String createUser; private long dataSourceId; public
 * Date getPartitionKey() { return partitionKey; } public void
 * setPartitionKey(Date partitionKey) { this.partitionKey = partitionKey; }
 * public long getId() { return id; } public void setId(long id) { this.id = id;
 * } public long getAccountId() { return accountId; } public void
 * setAccountId(long accountId) { this.accountId = accountId; } public long
 * getFraundTranId() { return fraundTranId; } public void setFraundTranId(long
 * fraundTranId) { this.fraundTranId = fraundTranId; } public String
 * getFraudTransactionType() { return fraudTransactionType; } public void
 * setFraudTransactionType(String fraudTransactionType) {
 * this.fraudTransactionType = fraudTransactionType; } public Timestamp
 * getFraudTranTs() { return fraudTranTs; } public void setFraudTranTs(Timestamp
 * fraudTranTs) { this.fraudTranTs = fraudTranTs; } public String
 * getCreateUser() { return createUser; } public void setCreateUser(String
 * createUser) { this.createUser = createUser; } public long getDataSourceId() {
 * return dataSourceId; } public void setDataSourceId(long dataSourceId) {
 * this.dataSourceId = dataSourceId; }
 * 
 * 
 * 
 * }
 * 
 * 
 * }
 */