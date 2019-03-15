CREATE TABLE media (
  id               integer      constraint m_id primary key,
  list             varchar(50),
  title            varchar(50),
  episodes_watched integer,
  episodes_total   integer,
  notes            varchar(200)
);