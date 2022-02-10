SELECT * 
FROM orszagok
WHERE orszag LIKE 'M%';

SELECT COUNT(*) AS count
FROM orszagok
WHERE orszag LIKE 'M%';

SELECT *
FROM orszagok
WHERE foldrajzi_hely LIKE '%szigetország_'
ORDER BY orszag DESC;

SELECT foldrajzi_hely, COUNT(orszag) AS number_of_countries
FROM orszagok
GROUP BY foldrajzi_hely
ORDER BY number_of_countries DESC, foldrajzi_hely ASC;

SELECT allamforma, foldrajzi_hely, COUNT('orszag') AS number_of_countries
FROM orszagok
GROUP BY allamforma, foldrajzi_hely
ORDER BY number_of_countries DESC, foldrajzi_hely ASC;

SELECT *
FROM orszagok
ORDER BY ABS(terulet-(SELECT terulet FROM orszagok WHERE orszag = 'MAGYARORSZÁG')) LIMIT 3;

SELECT orszag, gdp
FROM orszagok
ORDER BY gdp
LIMIT 5;

SELECT COUNT(orszag)
FROM orszagok
WHERE orszagok.gdp > (SELECT orszagok.gdp FROM orszagok WHERE orszag = 'Magyarország');

SELECT orszag, nepesseg
FROM orszagok
WHERE nepesseg = (SELECT MAX(nepesseg) FROM orszagok);

SELECT orszag, terulet
FROM orszagok
WHERE terulet > (SELECT AVG(terulet) FROM orszagok)
ORDER BY terulet DESC;
