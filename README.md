# Siemens Energy Coding Rules List - Clean Code 🧹

## Generell
- maximale Zeilenanzahl für Funktionen: 30 Zeichen
    - Plot functions excluded! - Extrahiere Plot Funktionen in andere Files wenn möglich
- Keine Debug / Logging Ausgaben (prints) in produktivem Code - falls doch, muss man es erklären können
- Keine Magic Numbers im Code verteilen - stattdessen zentral als Konstante deklarieren
- Generelle Konfigurationsvariablen können zentral in einem Block am Anfang eines Files stehen
    - Alle anderen Variablen so "nah" an ihrem Verwendungspunkt wie möglich deklarieren
- Benutze Typen, wann immer möglich
- TODO: Welche Warnung sind akzeptierbar, welche müssen wir wegräumen

---
## Naming
- Variablennamen in Camel-Case
- Namen sprechend gestalte
- Keine Typen in Variablennamen codieren
- Namen mit Abkürzungen in gemeinsames Abkürzungsverzeichnis aufnehmen
- Methoden = Verben (außer bei Test Cases)
- Klassen = Substantive
- Capability Interfaces ("able") = Adjektiv / Adverb
- Encoding der Herkunft einer Variablen, wenn man den Kontext sonst verliert: `userName = user.name`
- reservierte Namen mit vordefinierter Bedeutung nicht wo anders verwenden (z.B. get)
- wenn Werte, die aus Funktionsaufrufen stammen, mehr als zweimal verwendet werden, dann eine neue Variable dafür einführen
- x, y nur bei für allen klarer Bedeutung verwenden - i, j und e werden überhaupt nicht benutzt!


---
## Kommentare
- Kommentare so knapp wie möglich - am besten sollte Code sich selbst erklären
- keine auskommentieren Codeblöcke
- Kommentare bei Reviews auf Konsistenz überprüfen
- Funktionsbeschreibung / Header-Kommentare müssen geschrieben werden (keine doppelten Informationen zur Argument Sektion)

---
## Formatierung
- = Alignments sind okay bei
    - Variablendeklarationen (+ Kommentaren)
    - Arguments
    - evtl. Lookup-Tables
- Leerzeilen nach "Sections" - eine Section sollte ohne Scrollen erfassbar sein

---
## Methoden / Funktionen
- Ein return pro Funktion
- maximal drei Argumente pro Funktion
- Argument-Sektion benutzen
- keine Magic Numbers bei Funktionsaufrufen
- Single Responsibility! Wenn eine Methode mehr als eine Sache macht: Aufteilen!

---
## Klassen und Objekte
- Empfohlener Aufbau:
    1. Konstanten
    2. Variablen
    3. Konstruktor
    4. andere Methoden (private, public, abstract, overrided methods)
    5. redefinierte Operatoren
    6. Getter / Setter

- Loose Coupling, high cohesion
- Argument-Sektion benutzen
- Properties sollen inital private sein - Zugriff optional mit Gettern & Settern
- Verwende DTOs (Data Transfer Objects - "Amazon Pakete" 📦) um strukturierte Daten an Nutzer weiterzugeben
- Nutze Interfaces und abstrakte Klassen wo immer möglich
- Keine Mehrfachvererbung
- Capability Interfaces nutzen ("Tag" System)
- Wenn der Aufruf eines Konstruktors missverständlich ist, dann benutze das Factory Method-Pattern oder das Builder Pattern
### SOLID
- Liskov: Subklassen müssen an die Stelle ihrer Elternklassen treten können
- Single Responsibility: Keine Utility Klassen als Funktions-Sammlung

---
## Errorhandling
- Prio 1: Errorhandling / Validierung über if / then / else, assert function
- Prio 2: Try catch Blöcke
- Prio 3: return Codes (so gut es geht vermeiden!)



---


