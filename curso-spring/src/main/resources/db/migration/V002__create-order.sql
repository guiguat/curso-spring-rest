CREATE TABLE order_service (
	id BIGINT NOT NULL AUTO_INCREMENT,
    costumer_id BIGINT NOT NULL,
    description TEXT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) NOT NULL,
    open_date DATETIME NOT NULL,
    finish_date DATETIME,
    PRIMARY KEY(id)
);

ALTER TABLE order_service ADD CONSTRAINT fk_costumer_order
FOREIGN KEY (costumer_id) REFERENCES costumer (id);