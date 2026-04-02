CREATE SCHEMA libreria;
USE libreria;

CREATE TABLE ACCOUNTUSER (
    username VARCHAR(20) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    passw VARCHAR(50) NOT NULL,
    dataNascita DATE,
    nazionalita VARCHAR(30),
    PRIMARY KEY (username)
);

CREATE TABLE CREDITCARD (
    numeroCarta CHAR(16) NOT NULL,
    codiceSicurezza CHAR(3) NOT NULL,
    scadenza CHAR(7),
    intestatario VARCHAR(102) NOT NULL,
    accountref VARCHAR(20) NOT NULL,
    PRIMARY KEY (numeroCarta),
    FOREIGN KEY (accountref)
        REFERENCES ACCOUNTUSER (username)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ORDINE (
    idOrdine INT NOT NULL AUTO_INCREMENT,
    dataOrdine DATETIME,
    importoTotale FLOAT(8 , 2 ) UNSIGNED NOT NULL DEFAULT 000000.00,
    stato BIT DEFAULT 0,
    accountref VARCHAR(20) NOT NULL,
    creditCard CHAR(16) NOT NULL,
    PRIMARY KEY (idOrdine),
    FOREIGN KEY (accountref)
        REFERENCES ACCOUNTUSER (username)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (creditCard)
        REFERENCES CREDITCARD (numeroCarta)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE AUTORE (
    idAutore INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    nazionalita VARCHAR(30),
    dataNascita DATE,
    PRIMARY KEY (idAutore)
);

CREATE TABLE CATEGORIA (
    nome VARCHAR(30) NOT NULL,
    descrizione VARCHAR(500) NOT NULL,
    PRIMARY KEY (nome)
);

CREATE TABLE OPERA (
    idOpera INT NOT NULL AUTO_INCREMENT,
    ISBN CHAR(13) DEFAULT '0000000000000',
    nome VARCHAR(50) NOT NULL,
    casaEditrice VARCHAR(50),
    mediaVoti FLOAT(2 , 1 ) UNSIGNED NOT NULL DEFAULT 0.0,
    autore INT NOT NULL,
    categoria VARCHAR(30) NOT NULL,
    PRIMARY KEY (idOpera),
    FOREIGN KEY (autore)
        REFERENCES AUTORE (idAutore)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (categoria)
        REFERENCES CATEGORIA (nome)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE RECENSIONE (
    idRecensione INT NOT NULL AUTO_INCREMENT,
    titolo VARCHAR(100) NOT NULL,
    testo VARCHAR(500) NOT NULL,
    voto TINYINT(1) UNSIGNED NOT NULL,
    data DATETIME,
    accountref VARCHAR(20) NOT NULL,
    opera INT NOT NULL,
    PRIMARY KEY (idRecensione),
    FOREIGN KEY (accountref)
        REFERENCES ACCOUNTUSER (username)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (opera)
        REFERENCES OPERA (idOpera)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE NOLEGGIOPERA (
    idNoleggio INT NOT NULL AUTO_INCREMENT,
    dataInizioNoleggio DATETIME NOT NULL,
    dataFineNoleggio DATE NOT NULL,
    tipoOpera BIT NOT NULL,
    opera INT NOT NULL,
    ordine INT NOT NULL,
    PRIMARY KEY (idNoleggio),
    FOREIGN KEY (opera)
        REFERENCES OPERA (idOpera)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (ordine)
        REFERENCES ORDINE (idOrdine)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ACQUISTOPERA (
    idAcquisto INT NOT NULL AUTO_INCREMENT,
    dataAcquisto DATETIME NOT NULL,
    tipoOpera BIT NOT NULL,
    opera INT NOT NULL,
    ordine INT NOT NULL,
    PRIMARY KEY (idAcquisto),
    FOREIGN KEY (opera)
        REFERENCES OPERA (idOpera)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (ordine)
        REFERENCES ORDINE (idOrdine)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE OPERADIGITALE (
    nomeFile VARCHAR(30) NOT NULL,
    opera INT NOT NULL,
    bookFile BLOB DEFAULT NULL,
    numeroPagine INT,
    linguaTesto VARCHAR(20),
    costoAcquisto FLOAT(5 , 2 ) NOT NULL,
    costoNoleggio FLOAT(5 , 2 ) NOT NULL,
    PRIMARY KEY (opera),
    FOREIGN KEY (opera)
        REFERENCES OPERA (idOpera)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE AUDIOLIBRO (
    nomeFile VARCHAR(30) NOT NULL,
    opera INT NOT NULL,
    audioFile BLOB DEFAULT NULL,
    durata TIME,
    linguaAudio VARCHAR(20),
    costoAcquisto FLOAT(5 , 2 ) NOT NULL,
    costoNoleggio FLOAT(5 , 2 ) NOT NULL,
    PRIMARY KEY (opera),
    FOREIGN KEY (opera)
        REFERENCES OPERA (idOpera)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE FORNITORE (
    nome VARCHAR(50) NOT NULL,
    partitaIVA CHAR(11) DEFAULT '00000000000' NOT NULL,
    PRIMARY KEY (nome)
);

CREATE TABLE FORNITA_DA (
    opera INT NOT NULL,
    fornitore VARCHAR(50) NOT NULL,
    PRIMARY KEY (opera , fornitore),
    FOREIGN KEY (opera)
        REFERENCES OPERA (idOpera)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (fornitore)
        REFERENCES FORNITORE (nome)
        ON DELETE CASCADE ON UPDATE CASCADE
);