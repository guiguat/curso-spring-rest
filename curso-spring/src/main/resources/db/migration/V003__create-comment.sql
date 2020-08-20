CREATE TABLE _comment (
	id BIGINT NOT NULL AUTO_INCREMENT,
  order_id BIGINT NOT NULL,
  description TEXT NOT NULL,
  sent_date DATETIME NOT NULL,
  
  PRIMARY KEY(id)
);

ALTER TABLE _comment ADD CONSTRAINT fk_comment_order
FOREIGN KEY (order_id) REFERENCES order_service (id);