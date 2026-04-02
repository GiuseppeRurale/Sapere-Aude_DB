/*Operazione 1: Creare un nuovo account*/
INSERT INTO accountuser(username, nome, cognome, email, passw, dataNascita, nazionalita) VALUES (?, ?, ?, ?, ?, ?, ?);

/*Operazione 2: Inserire una nuova opera*/
INSERT INTO opera(ISBN, nome, casaEditrice, autore, categoria) VALUES(?, ?, ?, ?, ?);

/*Si inserisce l'opera in formato digitale, con la seguente query:*/
INSERT INTO operadigitale(nomeFile, opera, bookFile, numeroPagine, linguaTesto, costoAcquisto, costoNoleggio) VALUES(?, ?, ?, ?, ?, ?, ?);

/*Se si vuole inserire l'opera anche in formato audiolibro, si procede con la seguente query:*/
INSERT INTO audiolibro(nomeFile, opera, audioFile, durata, linguaAudio, costoAcquisto, costoNoleggio) VALUES(?, ?, ?, ?, ?, ?, ?);

/*Operazione 3: Rimuovere un'opera*/
DELETE FROM opera
WHERE idOpera=?;

/*Operazione 4: Inserire una nuova categoria*/
INSERT INTO categoria(nome, descrizione) VALUES(?, ?);

/*Operazione 5: Inserire un nuovo autore */
INSERT INTO autore(nome, nazionalita, dataNascita) VALUES(?, ?, ?);

/*Operazione 6: Inserire una nuova carta di credito*/
INSERT INTO creditcard(numeroCarta, codiceSicurezza, scadenza, intestatario, accountref) VALUES(?, ?, ?, ?, ?);

/*Operazione 7: Effettuare un ordine*/
INSERT INTO ordine(dataOrdine, accountref, creditCard) VALUES(NOW(), ?, ?);

/*Operazione 8: Rimuovere un ordine*/
DELETE FROM ordine
WHERE idOrdine=? && stato = 0 && accountref = ?;

/*Operazione 9: Stampare tutti gli ordini di un utente*/
SELECT idOrdine AS ID, importoTotale AS importo, dataOrdine AS data, stato
FROM ordine
WHERE accountref =?;

/*Operazione 10: Aggiungere l'acquisto di un'opera digitale all'ordine
Si seleziona l'opera da acquistare e si inseriscono i dati dell'acquisto nella tabella ACQUISTOPERA in relazione all'ordine:*/
INSERT INTO acquistopera(dataAcquisto, tipoOpera, opera, ordine) VALUES(NOW(), 0, ?, ?);

/*Si aggiorna l'importo totale dell'ordine, con la seguente query:*/
UPDATE ordine
SET importoTotale = importoTotale + (SELECT costoAcquisto FROM operadigitale WHERE opera = ?)
WHERE idOrdine = ?;

/*Operazione 11: Aggiungere il noleggio di un'opera digitale all'ordine
Si seleziona  l'opera da noleggiare e si inseriscono i dati del noleggio nella tabella NOLEGGIOPERA in relazione all'ordine:*/
INSERT INTO noleggiopera(dataInizioNoleggio, dataFineNoleggio, tipoOpera, opera, ordine) VALUES(NOW(), DATE_ADD(dataInizioNoleggio, INTERVAL 90 DAY), 0, ?, ?);

/*Si aggiorna l'importo totale dell'ordine, con la seguente query:*/
UPDATE ordine
SET importoTotale = importoTotale + (SELECT costoNoleggio FROM operadigitale WHERE opera = ?)
WHERE idOrdine = ?;

/*Operazione 12: Aggiungere l'acquisto di un audiolibro all'ordine
Si seleziona l'opera da acquistare e si inseriscono i dati dell'acquisto nella tabella ACQUISTOPERA in relazione all'ordine:*/
INSERT INTO acquistopera(dataAcquisto, tipoOpera, opera, ordine) VALUES(NOW(), 1, ?, ?);

/*Si aggiorna l'importo totale dell'ordine, con la seguente query:*/
UPDATE ordine
SET importoTotale = importoTotale + (SELECT costoAcquisto FROM audiolibro WHERE opera = ?)
WHERE idOrdine = ?;

/*Operazione 13: Aggiungere il noleggio di un audiolibro all'ordine
Si seleziona l'opera da noleggiare e si inseriscono i dati del noleggio nella tabella NOLEGGIOPERA in relazione all'ordine:*/
INSERT INTO noleggiopera(dataInizioNoleggio, dataFineNoleggio, tipoOpera, opera, ordine) VALUES(NOW(), DATE_ADD(dataInizioNoleggio, INTERVAL 90 DAY), 1, ?, ?);

/*Si aggiorna l'importo totale dell'ordine, con la seguente query:*/
UPDATE ordine
SET importoTotale = importoTotale + (SELECT costoNoleggio FROM audiolibro WHERE opera = ?)
WHERE idOrdine = ?;

/*Operazione 14: Completare un ordine*/
UPDATE ordine
SET stato = 1
WHERE idOrdine = ?;

/*Operazione 15: Scrivere una nuova recensione per un'opera*/
INSERT INTO recensione(titolo, testo, voto, data, accountref, opera) VALUES(?, ?, ?, NOW(), ?, ?);

/*Dopo l'inserimento di una nuova recensione per l'opera, si aggiorna la media voti dell'opera con la seguente query:*/
UPDATE opera
SET mediaVoti = (SELECT AVG(voto) FROM recensione WHERE opera = ?) 
WHERE idOpera = ?;

/*Operazione 16: Stampare il voto medio di un'opera*/
SELECT mediaVoti AS Valutazione
FROM opera
WHERE idOpera = ?;

/*Operazione 17: Stampare la lista delle opere in ordine di apprezzamento*/
SELECT *
FROM opera 
ORDER BY mediaVoti desc, nome asc;

/*Operazione 18: Selezionare tutte le opere di autori italiani*/
SELECT opera.nome AS NOME 
FROM opera INNER JOIN autore on autore = idAutore
WHERE nazionalita = "IT";

/*Operazione 19: Selezionare tutte le recensioni di un'opera*/
SELECT titolo, testo, voto
FROM recensione
WHERE opera = ?;

/*Operazione 20: Stampare tutte le opere acquistate dall'utente*/
SELECT DISTINCT opera.nome AS NOME, casaEditrice AS CASA_EDITRICE, mediaVoti AS VALUTAZIONE, autore.nome AS AUTORE, categoria AS CATEGORIA FROM ordine INNER JOIN acquistopera INNER JOIN opera INNER JOIN autore ON idOrdine = ordine && opera = idOpera && autore = idAutore
WHERE accountref = ? && stato = 1;  

/*Operazione 21: Stampare tutte le opere noleggiate dall'utente*/
SELECT DISTINCT opera.nome AS NOME, casaEditrice AS CASA_EDITRICE, mediaVoti AS VALUTAZIONE, autore.nome AS AUTORE, categoria AS CATEGORIA
FROM ordine INNER JOIN noleggiopera INNER JOIN opera INNER JOIN autore ON idOrdine = ordine && opera = idOpera && autore = idAutore
WHERE accountref = ? && stato = 1;  

/*Operazione 22: Stampare solo le opere digitali acquistate dall'utente*/
SELECT opera.nome AS NOME, casaEditrice AS CASA_EDITRICE, mediaVoti AS VALUTAZIONE, autore.nome AS AUTORE, categoria AS CATEGORIA, numeroPagine AS NrPAGINE, linguaTesto AS LINGUA
FROM ordine INNER JOIN acquistopera INNER JOIN opera INNER JOIN autore INNER JOIN operadigitale ON idOrdine = ordine && acquistopera.opera = idOpera && autore = idAutore && operadigitale.opera = idOpera
WHERE accountref = ? && stato = 1 && tipoOpera = 0;  

/*Operazione 23: Stampare solo le opere digitali noleggiate dall'utente */
SELECT opera.nome AS NOME, casaEditrice AS CASA_EDITRICE, mediaVoti AS VALUTAZIONE, autore.nome AS AUTORE, categoria AS CATEGORIA, numeroPagine AS NrPAGINE, linguaTesto AS LINGUA
FROM ordine INNER JOIN noleggiopera INNER JOIN opera INNER JOIN autore INNER JOIN operadigitale ON idOrdine = ordine && noleggiopera.opera = idOpera && autore = idAutore && operadigitale.opera = idOpera
WHERE accountref = ? && stato = 1 && tipoOpera = 0;

/*Operazione 24: Stampare solo gli audiolibri acquistati dall'utente*/
SELECT opera.nome AS NOME, casaEditrice AS CASA_EDITRICE, mediaVoti AS VALUTAZIONE, autore.nome AS AUTORE, categoria AS CATEGORIA, durata AS DURATA, 
linguaAudio AS LINGUA
FROM ordine INNER JOIN acquistopera INNER JOIN opera INNER JOIN autore INNER JOIN audiolibro ON idOrdine = ordine && acquistopera.opera = idOpera && autore = idAutore && audiolibro.opera = idOpera
WHERE accountref = ? && stato = 1 && tipoOpera = 1;  

/*Operazione 25: Stampare solo gli audiolibri noleggiati dall'utente*/
SELECT opera.nome AS NOME, casaEditrice AS CASA_EDITRICE, mediaVoti AS VALUTAZIONE, autore.nome AS AUTORE, categoria AS CATEGORIA, durata AS DURATA, 
linguaAudio AS LINGUA
FROM ordine INNER JOIN noleggiopera INNER JOIN opera INNER JOIN autore INNER JOIN audiolibro ON idOrdine = ordine && noleggiopera.opera = idOpera && autore = idAutore && audiolibro.opera = idOpera
WHERE accountref = ? && stato = 1 && tipoOpera = 1;