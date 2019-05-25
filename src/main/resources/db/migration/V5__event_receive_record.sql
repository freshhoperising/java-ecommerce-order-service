CREATE TABLE EVENT_RECEIVE_RECORD
(
  ENDPOINT_TAG VARCHAR(128) NOT NULL,
  EVENT_ID     CHAR(32)    NOT NULL,
  RECORDED_AT  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (ENDPOINT_TAG, EVENT_ID)
) CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;
