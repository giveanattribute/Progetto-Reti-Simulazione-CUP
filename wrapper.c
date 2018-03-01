#include "wrapper.h"

/** Funzione wrapper per la socket() **/
int Socket(int family, int type, int protocol)
{
    int n;

    if((n = socket(family, type, protocol)) < 0)
    {
        fprintf(stderr,"Socket Error\n");
        exit (1);
    }
    return n;
}

/** Funzione wrapper per la connect() **/
void Connect(int socket_fd, struct sockaddr_in servaddr, int size_servaddr)
{
    if(connect(socket_fd,(struct sockaddr *) &servaddr, size_servaddr) < 0)
    {
        fprintf(stderr,"connect error\n");
        exit(1);
    }
}

/** Funzione wrapper per la bind() **/
void Bind(int listen_fd, struct sockaddr_in servaddr, int size_servaddr)
{
    if(bind(listen_fd,(struct sockaddr *) &servaddr, size_servaddr) < 0 )
    {
        perror("bind");
        exit(1);
    }
}

/** Funzione wrapper per la listen() **/
void Listen(int listen_fd, int size_queue)
{
    if (listen(listen_fd, size_queue) < 0 )
    {
        perror("listen");
        exit(1);
    }
}

/** Funzione wrapper per la accept() **/
int Accept(int listen_fd, struct sockaddr *servaddr, int *size_servaddr)
{
    int n;

    if ((n = accept(listen_fd, servaddr, size_servaddr)) < 0 )
    {
        perror("accept");
        exit(1);
    }

    return n;
}


ssize_t FullWrite(int fd, const void *buf, size_t count)
{
	size_t nleft;
	ssize_t nwritten;
	nleft = count;
	while(nleft>0)
	{
		if((nwritten = write(fd,buf,nleft)) < 0) 
		{
			if(errno == EINTR)
				continue;
			else
			{
				if(errno == EPIPE)
					break;
				else
					printf("nwritten = %d errno = %d", nwritten, errno);
					exit(nwritten);
			}		
				
		}
		nleft -= nwritten;
		buf += nwritten;
	}
	return nleft;
}


ssize_t FullRead(int fd, const void *buf, size_t count)
{
	size_t nleft;
	ssize_t nread;
	nleft = count;
	while(nleft>0)
	{
		if((nread = read(fd,buf,nleft)) < 0) 
		{
			if(errno == EINTR)
				continue;
			else 
				exit(nread);
		}
		else
		{
			if(nread == 0)
				break;
		}
		nleft -= nread;
		buf += nread;
	}
	buf=0;
	return nleft;
}


/** Funzione che restituisce il totale da pagare **/
float TotalePagamento(MENU_PACKAGE menu)
{
	int i,j;
	float sum = 0;
	for(i=0; i<menu.size_ordini; i++)
	{
		for(j=0; j<20; j++)
		{
			if(menu.ordini[i][0]-1 == j)
			{
				sum = sum + menu.piatto[j].prezzo*menu.ordini[i][1];
				break;
			}
		}
	}
	return sum;
}


/** Funzione che stampa il menù **/
void print_menu(MENU_PACKAGE menu)
{
	int i;
	system("clear");
	printf("\n");
	printf("+----------------------------------------------------+\n");
	printf("|                         MENU                       |\n");
	printf("|                   SOCKET & MANGIATO                |\n");
	printf("+----------------------------------------------------+\n");
	printf("|                                                    |\n");
	
	for(i = 0 ; i < 20 ; i++)
	{
		if(menu.piatto[i].flag == 1)
		{
			menu.piatto[i].prezzo < 10.00 ? printf("|%d) %-20s\t\t\t%4.2f€|\n", i+1, menu.piatto[i].nome_piatto, menu.piatto[i].prezzo) :
				printf("|%d) %-20s\t\t       %4.2f€|\n", i+1, menu.piatto[i].nome_piatto, menu.piatto[i].prezzo);
		}
	}
	
	printf("|                                                    |\n");
	printf("+----------------------------------------------------+\n");
}

/** Funzione che stampa le scelte che può fare l'admin **/
void admin_choice()
{
	printf("+----------------------------------------------------+\n");
	printf("| Premere:                                           |\n");
	printf("+----------------------------------------------------+\n");
	printf("| 1) Aggiungi un piatto                              |\n");
	printf("| 2) Modifica un piatto                              |\n");
	printf("| 3) Elimina un piatto                               |\n");
	printf("| 4) Termina operazioni                              |\n");
	printf("+----------------------------------------------------+\n");
}


/** Funzione che agginuge un piatto al menù **/
void aggiungi_piatto(PIATTO piatto_aggiunto , MENU_PACKAGE *menu)
{
	int i;
	for(i=0; i<20; i++)
	{
		if(menu->piatto[i].flag == 0)
		{
			strcpy(menu->piatto[i].nome_piatto,piatto_aggiunto.nome_piatto);
			menu->piatto[i].prezzo = piatto_aggiunto.prezzo;
			menu->piatto[i].flag = 1;
			menu->piatti_inseriti++;
			break;
		}
	}
}


/** Funzione che modifica un piatto nel menù **/
void modifica_piatto(int codice_piatto, PIATTO piatto_modificato , MENU_PACKAGE *menu)
{
	strcpy(menu->piatto[codice_piatto].nome_piatto,piatto_modificato.nome_piatto);
	menu->piatto[codice_piatto].prezzo = piatto_modificato.prezzo;
	menu->piatto[codice_piatto].flag = 1;
}


/** Funzione che inizializza il menù con dei piatti standard **/
void inizializza_menu(MENU_PACKAGE *menu_package)
{
	strcpy(menu_package->piatto[0].nome_piatto, "Gnocchi alla sorrentina");
	menu_package->piatto[0].prezzo = 3.50;
	menu_package->piatto[0].flag = 1;

	strcpy(menu_package->piatto[1].nome_piatto, "Pasta al forno");
	menu_package->piatto[1].prezzo = 3.00;
	menu_package->piatto[1].flag = 1;

	strcpy(menu_package->piatto[2].nome_piatto, "Hamburger con patate");
	menu_package->piatto[2].prezzo = 4.00;
	menu_package->piatto[2].flag = 1;

	strcpy(menu_package->piatto[3].nome_piatto, "Bistecca");
	menu_package->piatto[3].prezzo = 3.50;
	menu_package->piatto[3].flag = 1;
	
	strcpy(menu_package->piatto[3].nome_piatto, "Macedonia");
	menu_package->piatto[3].prezzo = 1.50;
	menu_package->piatto[3].flag = 1;

	menu_package->piatti_inseriti = 5;
}


