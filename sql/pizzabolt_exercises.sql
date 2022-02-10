-- Listázd ki az összes pizzát név szerint csökkenő sorrendben! (2 pont)

SELECT nev
FROM pizza
ORDER BY nev;

-- Számold meg, hány futár van, akinek a neve nem ’G’ betűvel kezdődik!

SELECT COUNT(nev)
FROM futar
WHERE nev NOT LIKE 'G%';

-- Számold össze, hogy melyik dátumon hány darab megrendelés történt! (2 pont)



-- Mely rendelések történtek délelőtt? (2 pont)



-- Átlagosan mennyibe kerül egy pizza? 1 tizedes pontossággal add meg a választ! Az eredményoszlopot nevezd el ’Atlag’ néven! (3 pont)

SELECT ROUND(AVG(ar), 1) AS Atlag
FROM pizza;

-- Listázd ki az összes megrendelés idejét, a megrendelő azonosítóját és a megrendelő nevét is! (3 pont)
-- Szúrj be egy új oszlopot a vevo táblába! Az új mező típusa szöveges legyen, 9 karakter hosszú, a mező neve ’telefon’! (3 pont)
-- Szúrj be egy új rekordot a módosított vevo táblába! Minden mezőbe kerüljön adat! (3 pont)
-- Listázd ki az összes pizzafutárt név szerint csökkenő sorrendben! (2 pont)

SELECT nev
FROM futar
ORDER BY nev DESC;

-- Számold meg, mennyi vásárló van, akinek a neve nem ’S’ betűvel kezdődik! (2 pont)

SELECT COUNT(nev)
FROM vevo
WHERE nev NOT LIKE 'S%';

-- Számold össze, hogy melyik dátumon mennyi darab megrendelés történt! (2 pont)
-- Mely rendelések történtek délután? (2 pont)
-- Átlagosan hány órakor rendelnek pizzát? 1 tizedes pontossággal add meg a választ! Az eredményoszlopot nevezd el ’Atlag’ néven! (3 pont)
-- Listázd ki az összes megrendeléshez tartozó azonosítót, a megrendelés idejét és a megrendelő nevét is! (3 pont)
-- Szúrj be egy új oszlopot a futar táblába! Az új mező típusa szám legyen, 4 karakter hosszú, a mező neve ’szuletesi_ev’! (3 pont)
-- Szúrj be egy új rekordot a futar táblába! Minden mezőbe kerüljön adat! (3 pont)
-- Listázd ki az összes vásárlót név szerint csökkenő sorrendben! (2 pont)

SELECT nev
FROM vevo
ORDER BY nev DESC;

-- Átlagosan mennyi pizzát rendelnek egy alkalommal? 1 tizedes pontossággal add meg a választ! Az eredményoszlopot nevezd el ’Atlag’ néven! (3 pont)
-- Listázd ki az összes megrendeléshez tartozó azonosítót, a megrendelő azonosítóját és a megrendelő nevét is! (3 pont)
-- Szúrj be egy új oszlopot a pizza táblába! Az új mező típusa szám legyen, 4 karakter hosszú, a mező neve ’atmero’! (3 pont)
-- Szúrj be egy új rekordot a pizza táblába! Minden mezőbe kerüljön adat! (3 pont)
