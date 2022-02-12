-- Mely termékek drágábbak 1000 Ft-nál? (2 pont)

SELECT *
FROM termek
WHERE ar > 1000;

-- Hányszor rendelt termékeket Morgó? (3 pont)

SELECT *
FROM rendeles
WHERE vasarlo_id = (SELECT id FROM vasarlo WHERE vasarlo.nev = 'Morgó');
 
-- Ki vásárolta meg az egyes rendeléseket? A nevét is jelenítsd meg! Az eredményoszlopot nevezd el „ugyfel” néven!  (4 pont)

SELECT rendeles.id, vasarlo.nev AS ugyfel
FROM rendeles
JOIN vasarlo ON vasarlo_id = vasarlo.id;
 
-- Hány darabot rendeltek összesen az egyes termékekből? A termékek árát is jelenítsd meg! (4 pont)

SELECT termek.id, termek.ar, db AS eladott_mennyiseg, (db * termek.ar) AS teljes_ar
FROM tetel
JOIN termek ON termek_id = termek.id
GROUP BY termek.id;
 
-- Mely rendelések történtek délután? A megrendelt termékek nevét is jelenítsd meg! (4 pont)

SELECT rendeles.id, ido, termek.nev
FROM rendeles
JOIN tetel ON rendeles.id = tetel.rendeles_id
JOIN termek ON tetel.termek_id = termek.id
WHERE ido > 12.0;
 
-- Melyik a legolcsóbb termék? Az árát, az azonosítóját és a nevét is listázd ki! (3 pont)

SELECT *
FROM termek
WHERE ar = (SELECT MIN(ar) FROM termek);
 
-- Mely termékek olcsóbbak 1000 Ft-nál? (2 pont)

SELECT *
FROM termek
WHERE ar < 1000;
 
-- Hányszor rendelt termékeket Szende? (3 pont)

SELECT COUNT(vasarlo_id)
FROM rendeles
WHERE vasarlo_id = (SELECT id FROM vasarlo WHERE vasarlo.nev = 'Szende');
 
-- Ki adta el az egyes rendeléseket? A nevét is jelenítsd meg! Az eredményoszlopot nevezd el „elado” néven!  (4 pont)

SELECT rendeles.id, elado.nev
FROM rendeles
JOIN elado ON rendeles.elado_id = elado.id;
 
-- Hány darabot rendeltek összesen az egyes termékekből? A termékek nevét is jelenítsd meg! (4 pont)

SELECT termek.id, db AS eladott_mennyiseg, termek.nev
FROM tetel
JOIN termek ON termek_id = termek.id
GROUP BY termek.nev;

-- Mely rendelések történtek délelőtt? A megrendelt termék nevét is jelenítsd meg! (4 pont)

SELECT rendeles.id, ido, termek.nev
FROM rendeles
JOIN tetel ON rendeles.id = tetel.rendeles_id
JOIN termek ON tetel.termek_id = termek.id
WHERE ido < 12.0;

-- Melyik a legdrágább termék? Az árát, az azonosítóját és a nevét is listázd ki! (4 pont)

SELECT *
FROM termek
WHERE ar = (SELECT MAX(ar) FROM termek);
 
-- Melyek azok a termékek, amelyekből még nem történt eladás, azaz csak porosodnak a raktárban? (4 pont)

SELECT termek.nev
FROM termek
WHERE termek.id NOT IN (SELECT tetel.termek_id FROM tetel);
