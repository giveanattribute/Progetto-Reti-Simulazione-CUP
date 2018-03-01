#ifdef __arm__
		#include <wiringPi.h>
#endif
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <errno.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <time.h>
#include <signal.h>

struct ConnectionData
{
	char username[20];
	int esito_connessione;
	char messaggio[200];
};

typedef struct ConnectionData CONNECTION_PACKAGE;


struct Piatto
{
	char nome_piatto[100];
	float prezzo;
	int flag;
};

typedef struct Piatto PIATTO;


struct Menu
{
	PIATTO piatto[20];
	int piatti_inseriti;
	int ordini[20][2];
	int size_ordini;
	char sede_ritiro[50];
	char matricola[20];
	char messaggio[200];
	char flag;
	unsigned int orario_consegna;
	float totale_pagamento;
	float importo_pagato;
	float resto;
};

typedef struct Menu MENU_PACKAGE;


struct InfoServer
{
	int descriptor;
	char sede[100];
	struct sockaddr_in address;
};

typedef struct InfoServer INFO_SERVER;


struct DatiConnessioneUtente
{
	char username[20];
	int pipe_fd_1[2];
	int pipe_fd_2[2];
	int flag;
	int insert_flag;
};

typedef struct DatiConnessioneUtente DATI_CONNESSIONE_UTENTE;


struct IdPackage
{
	char matricola[20];
	int id_transation;
	unsigned int orario_consegna;
	struct sockaddr_in address_connection;
	int new_port;
};

typedef struct IdPackage ID_PACKAGE;


struct IdPackage_Consegna
{
	int id_consegna;
	char messaggio[200];
	int flag;
};

typedef struct IdPackage_Consegna ID_PACKAGE_CONSEGNA;

int Socket(int, int, int);
void Connect(int, struct sockaddr_in, int);
void Bind(int, struct sockaddr_in, int);
void Listen(int, int);
int Accept(int, struct sockaddr *, int *);
ssize_t FullWrite(int , const void *, size_t);
ssize_t FullRead(int, const void *, size_t);
float TotalePagamento(MENU_PACKAGE);
void print_menu(MENU_PACKAGE);
void admin_choice();
void aggiungi_piatto(PIATTO, MENU_PACKAGE *);
void modifica_piatto(int, PIATTO , MENU_PACKAGE *);
void inizializza_menu(MENU_PACKAGE *);

