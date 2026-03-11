# 🧩 Aufgabe: Clean Code in der Praxis – BMI-Rechner

## 🎯 Ziel der Aufgabe
Diese Aufgabe soll das Bewusstsein für **Clean Code Prinzipien** schärfen und die Fähigkeit fördern, **gut wartbaren, lesbaren und erweiterbaren Java-Code** zu schreiben.  
Sie besteht aus **zwei Phasen**:
1. **Entwicklung einer Java-Applikation (BMI-Rechner)**
2. **Code Review einer fremden Lösung**

---
## 🔹 Phase 1 – Entwicklung eines BMI-Rechners

### 🎯 Ziel
Entwickeln Sie eine saubere, wartbare und erweiterbare Java-Applikation, die den **BMI mehrerer Personen** berechnet, die Ergebnisse speichert und eine **Statistik** ausgibt.

---
### 🧠 Funktionsbeschreibung

Die Applikation soll:
1. **Mehrere Personen** aufnehmen (Name, Größe, Gewicht)
2. Für jede Person den **BMI berechnen** und interpretieren
3. Eine **statistische Auswertung** erstellen, z. B.:
    - Durchschnittlicher BMI
    - Minimaler und maximaler BMI
    - Anzahl pro Gewichtskategorie (z. B. Normalgewicht, Übergewicht …)
4. Die Ergebnisse übersichtlich auf der Konsole ausgeben

---

### 🧩 Technische Anforderungen

| Aspekt | Beschreibung |
|--------|---------------|
| **Sprache** | Java (≥ 11) |
| **Eingabe** | Hardcodierte Daten oder Konsoleneingabe |
| **Ausgabe** | Textausgabe in der Konsole |
| **Struktur** | Mehrere Klassen, klar getrennte Verantwortlichkeiten |
| **Datenhaltung** | Liste von `Person`-Objekten |
| **Architekturprinzipien** | Anwendung von SOLID und Clean Code Grundsätzen |
| **Erweiterbarkeit** | Möglichkeit zur Erweiterung (z. B. neue Berechnungsarten, alternative Ausgabeformate) |

---

### ⚙️ Programmablauf (Main)

1. Liste von Personen anlegen
2. Für jede Person BMI berechnen (`BmiCalculator`)
3. Kategorie bestimmen
4. Statistische Auswertung durchführen
5. Ergebnisse formatiert in der Konsole ausgeben

---

### 🧱 Architektur

Die Anwendung soll in klar getrennte Verantwortlichkeiten aufgeteilt werden. Folgende Klassen sind mindestens zu nutzen:

| Klasse | Verantwortung |
|--------|----------------|
| `Main` | Einstiegspunkt der Anwendung – orchestriert den Ablauf |
| `Person` | Repräsentiert eine Person mit Name, Größe und Gewicht |
| `BmiCalculator` | Enthält Logik zur Berechnung des BMI |

Folgende Klassen können optional in Erwägung gezogen werden:

| Klasse | Verantwortung |
|--------|----------------|
| `BmiCategoryService` | Kategorisiert BMI-Werte (z. B. Normalgewicht, Übergewicht etc.) |
| `BmiStatisticsService` | Berechnet statistische Kennzahlen (Durchschnitt, Min, Max etc.) |
| `PersonRepository` | Verwaltet die Liste der Personen |

---

### 🧼 Clean Code Fokus
- **Klare Verantwortlichkeiten:** jede Klasse hat *eine* Aufgabe (Single Responsibility)
- **Offen für Erweiterung:** z. B. könnte später ein `JsonExporter` hinzugefügt werden (Open/Closed Principle)
- **Sinnvolle Benennung:** Methoden sollen klar beschreiben, was sie tun
- **Keine Duplikationen:** Logik nicht mehrfach implementieren
- **Kurze Methoden:** Jede Methode soll *eine logische Aufgabe* erfüllen

---

### 📦 Optionale Erweiterungen (wenn noch Zeit übrig ist)
- Validierung von Eingaben (keine negativen Werte)
- Ausgabe sortiert nach BMI
- Export der Statistik in eine Datei (CSV oder JSON)
- Einfache Unit Tests für `BmiCalculator` und `BmiStatisticsService`

---

## 🔹 Phase 2 – Code Review

### 🧠 Aufgabe
Sie erhalten den Quellcode eines anderen Teilnehmers und führen ein **strukturiertes Code Review** durch.

### 🔍 Ziel
Erkennen Sie **Code Smells** und bewerten Sie, inwiefern die Clean Code Prinzipien eingehalten wurden.

### 🧾 Vorgehensweise
1. Lesen Sie den Code sorgfältig.
2. Bewerten Sie:
    - Verständlichkeit des Codes
    - Struktur und Verantwortlichkeiten
    - Anwendung der SOLID-Prinzipien
    - Namenskonventionen
    - Sinnvolle Nutzung von Interfaces und Klassen
    - Lesbarkeit und Kommentierung
    - Testbarkeit und Erweiterbarkeit
3. Erstellen Sie ein kurzes schriftliches Feedback:
    - **Positives Feedback:** Was wurde gut umgesetzt?
    - **Verbesserungspotenzial:** Wo bestehen Clean-Code-Verstöße oder Code Smells?
    - **Vorschläge:** Wie könnte der Code verbessert oder refaktoriert werden?

---

### 🧮 Bewertungskriterien

| Kriterium | Beschreibung                                                  |
|------------|---------------------------------------------------------------|
| **Funktionalität** | Berechnung und Ausgabe des BMI funktionieren korrekt          |
| **Code-Struktur** | Klassen, Methoden und Verantwortlichkeiten sind klar getrennt |
| **Lesbarkeit & Namensgebung** | Code ist verständlich und aussagekräftig                      |
| **Clean Code Prinzipien** | SOLID (DRY, KISS, YAGNI) wird erkennbar beachtet      |
