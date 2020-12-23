# PortalWorkSpace

Piccolo progettino che implementare dei desktop paralleli per gestire meglio i file sul desktop.

**Come usarlo:**
- usa il makefile per compilare : "make"
- nella prima esecuzione setta il DB per implementare la permanenza della configurazione (configurazione guidata CLI)
- dalla seconda esecuzione si può usare "make desk="fold" execute" dove fold è una cartella all'interno della cartella dei parallel desktops

**Per creare un desktop parallelo :**
- crea una cartella nella cartella dei parallel desktop settata alla prima configurazione

**Che succede quando carico un desktop parallelo?**
- semplicemente aggiorna il desktop che sta sostituendo (sostituendo i file ed eventuali modifiche nella cartella dei parallel desktop) e copia i file 
  del desktop sostituitivo.
  
**////////Esempio di Utilizzo//////////**

- creo 2 parallel desktop (studio e cazzeggio) creando 2 cartelle e sistemando i file che voglio all'interno

- uso **make desk="studio" execute** per salvare lo stato attuale del desktop nella PD usato in precedenza (la prima volta usa la cartella def (DEFAULT))
  e sostituisce i file della cartella studio.
  
- uso normalmente il parallel desktop "studio" (per esempio creo una cartella "Calcolo numerico")

- ho finito di studiare , switcho al parallel desktop "cazzeggio" con **make desk="studio" execute** , il programma salva lo stato del PD "studio" (cartella "Calcolo numerico" inclusa) e sposta sul desktop lo stato del PD "cazzeggio".


//////////CLI Aggiuntivo///////////////

Si può aggiungere una funzionalità settare un comando per la shell globale :   **portal** "parallel desktop"
  
  -apri il file "conf.sh" e modifica la riga (@ cd /home/chilledpanda/PortalWorkSpace) con 
   @ cd <PATH DELLA DIRECTORY DI PARALLEL DESKTOPS>
  
  -apri la shell e modifica gedit ~/.bashrc (bootstrap della shell)
  
  -aggiungi a fine file **source /home/chilledpanda/PortalWorkSpace/command.sh**
  
  


  
  
