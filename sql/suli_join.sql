SELECT * FROM naplo, diak
WHERE naplo.id = diak.naplo_id;

SELECT *FROM naplo
JOIN diak ON naplo.id = diak.naplo_id;

SELECT * FROM naplo
LEFT JOIN diak ON naplo.id = diak.naplo_id
UNION
SELECT * FROM naplo
RIGHT JOIN diak ON naplo.id = diak.naplo_id;

SELECT * FROM naplo
JOIN diak ON naplo.id = diak.naplo_id
JOIN jegy ON diak.id = jegy.diak_id;

SELECT * FROM jegy
JOIN diak ON diak.id = jegy.diak_id
JOIN naplo ON diak.naplo_id = naplo.id
WHERE jegy.datum BETWEEN '2022-01-05' AND '2022-01-11';

CREATE VIEW IF NOT EXISTS suli.temp AS
SELECT * FROM diak;

SELECT * FROM temp;

SELECT nev
FROM temp
WHERE id = 1;

SELECT MAX(ID) FROM diak;

SELECT @diak_id := MAX(ID) FROM diak;

INSERT INTO diak
VALUES ((@diak_id + 1), 'Nagy József', '2010-04-09', 1);