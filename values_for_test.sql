USE libreria;

INSERT INTO categoria(nome, descrizione) VALUES("Fantasy", "Questa è fantasy");
INSERT INTO categoria(nome, descrizione) VALUES("Horror", "Questa è horror");
INSERT INTO categoria(nome, descrizione) VALUES("Giallo", "Questa è giallo");
INSERT INTO categoria(nome, descrizione) VALUES("Avventura", "Questa è avventura");
INSERT INTO autore(nome, nazionalita, dataNascita) VALUES("Stephen King", "USA", "1947/09/21");
INSERT INTO autore(nome, nazionalita, dataNascita) VALUES("John Tolkien", "UK", "1892/01/03");
INSERT INTO autore(nome, nazionalita, dataNascita) VALUES("Herman Melville", "USA", "1819/08/01");
INSERT INTO autore(nome, nazionalita, dataNascita) VALUES("Umberto Eco", "IT", "1932/01/05");


INSERT INTO opera(nome, casaEditrice, autore, categoria) VALUES("22.11.63", "Feltrinelli", 1, "Giallo");
INSERT INTO opera(nome, casaEditrice, autore, categoria) VALUES("IT", "Feltrinelli", 1, "Horror");
INSERT INTO opera(nome, casaEditrice, autore, categoria) VALUES("THE STAND", "Feltrinelli", 1, "Fantasy");
INSERT INTO opera(nome, casaEditrice, autore, categoria) VALUES("IL SIGNORE DEGLI ANELLI", "Feltrinelli", 2, "Fantasy");
INSERT INTO opera(nome, casaEditrice, autore, categoria) VALUES("LO HOBBIT", "Feltrinelli", 2, "Fantasy");
INSERT INTO opera(nome, casaEditrice, autore, categoria) VALUES("Beren e Luthien", "Feltrinelli", 2, "Fantasy");
INSERT INTO opera(nome, casaEditrice, autore, categoria) VALUES("Moby Dick", "Feltrinelli", 3, "Avventura");
INSERT INTO opera(nome, casaEditrice, autore, categoria) VALUES("Billy Budd", "Feltrinelli", 3, "Avventura");
INSERT INTO opera(nome, casaEditrice, autore, categoria) VALUES("Il Nome Della Rosa", "Feltrinelli", 4, "Giallo");


INSERT INTO operadigitale(nomeFile, opera, numeroPagine, linguaTesto, costoAcquisto, costoNoleggio) VALUES("221163.pdf", 1, 768, "Italiano", 3.25, 2.75);
INSERT INTO operadigitale(nomeFile, opera, numeroPagine, linguaTesto, costoAcquisto, costoNoleggio) VALUES("IT.pdf", 2, 789, "Italiano", 4.06, 2.99);
INSERT INTO operadigitale(nomeFile, opera, numeroPagine, linguaTesto, costoAcquisto, costoNoleggio) VALUES("thestand.pdf", 3, 542, "Italiano", 4.60, 3.31);
INSERT INTO operadigitale(nomeFile, opera, numeroPagine, linguaTesto, costoAcquisto, costoNoleggio) VALUES("LOR.pdf", 4, 854, "Italiano", 5.12, 3.93);
INSERT INTO operadigitale(nomeFile, opera, numeroPagine, linguaTesto, costoAcquisto, costoNoleggio) VALUES("TH.pdf", 5, 933, "Italiano", 4.65, 3.25);
INSERT INTO operadigitale(nomeFile, opera, numeroPagine, linguaTesto, costoAcquisto, costoNoleggio) VALUES("BL.pdf", 6, 638, "Italiano", 4.14, 3.07);
INSERT INTO operadigitale(nomeFile, opera, numeroPagine, linguaTesto, costoAcquisto, costoNoleggio) VALUES("MobyDick.pdf", 7, 821, "Italiano", 4.35, 3.15);
INSERT INTO operadigitale(nomeFile, opera, numeroPagine, linguaTesto, costoAcquisto, costoNoleggio) VALUES("BillyBudd.pdf", 8, 418, "Italiano", 3.05, 2.45);

INSERT INTO audiolibro(nomeFile, opera, durata, linguaAudio, costoAcquisto, costoNoleggio) VALUES("221163.mp3", 1, "8:43:13", "Italiano", 2.25, 1.75);
INSERT INTO audiolibro(nomeFile, opera, durata, linguaAudio, costoAcquisto, costoNoleggio) VALUES("MobyDick.mp3", 7, "7:23:31", "Italiano", 3.35, 3.15);
INSERT INTO audiolibro(nomeFile, opera, durata, linguaAudio, costoAcquisto, costoNoleggio) VALUES("LOR.mp3", 4, "10:13:43", "Italiano", 4.12, 2.93);