CREATE TABLE IF NOT EXISTS kotlin_demo.sale(
  id SERIAL PRIMARY KEY,
  price float8,
  price_modifier float8,
  payment_method VARCHAR(30),
  datetime timestamp without time zone,
  final_price float8,
  points int4
)