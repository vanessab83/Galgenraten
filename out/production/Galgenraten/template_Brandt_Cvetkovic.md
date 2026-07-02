*Ersetzt jedes* TODO *mit den zu eurem Projekt passenden Details.*

*Den vollständigen Projektplan lasst ihr eurem Tutor/eurer Tutorin zukommen, wahlweise per Direktnachricht oder im Tutoriums-Kanal. Zu diesem Projektplan werden wir euch Feedback geben sowie unsere Erwartungen zu dem, was wir in der Präsentation gerne sehen würden.*

*Deadline zur Einreichung: Freitag, 12.06.2026, Tagesende.*



# Titel: Galgenmännchen

Name 1: Mihajlo Cvetkovic
Name 2: Vanessa Brandt
GitHub-Benutzername 1: Mihajlo005
GitHub-Benutzername 2: vanessab83

## Kurzbeschreibung

*In ein, zwei Sätzen: Was soll das Programm sein und tun?*



Unser Programm ist ein Galgenmännchen-Spiel für zwei Spieler als Java-Kommandozeilenprogramm. Eine Person gibt am Anfang ein geheimes Wort ein, und die andere Person versucht danach, dieses Wort durch das Eingeben einzelner Buchstaben zu erraten, bevor zu viele Fehlversuche gemacht wurden.

## Benutzungsbeispiel

*Beschreibt Schritt für Schritt, wie eine typische Benutzung eures Programms abläuft (wer gibt was ein, was tut das Programm, was erscheint auf dem Bildschirm). Schreibt anschließend explizit auf, was ihr dafür programmieren müsst — denn euer Benutzungsbeispiel ist eure Anforderungsliste. Beispiel: „Gibt der Nutzer eine ungültige Eingabe ein, meldet das Programm den Fehler und fragt erneut.“ → Daraus folgt: Ihr braucht eine Prüfung, ob eine Eingabe gültig ist.*



Beim Start des Programms wird der erste Spieler aufgefordert, ein geheimes Wort einzugeben. Dieses Wort wird vom Programm gespeichert. Danach wird die Anzeige durch mehrere Leerzeilen verdeckt, damit der zweite Spieler das eingegebene Wort nicht sieht.



Das geheime Wort wird dem zweiten Spieler nur durch Platzhalter angezeigt, zum Beispiel:



\_ \_ \_ \_ \_



Der zweite Spieler gibt über die Kommandozeile einen Buchstaben ein, zum Beispiel:



a



Das Programm prüft dann, ob der Buchstabe im gesuchten Wort vorkommt. Wenn der Buchstabe richtig ist, werden alle passenden Stellen im Wort aufgedeckt. Wenn das Wort zum Beispiel „Apfel“ ist und der Spieler „p“ eingibt, erscheint:



\_ p \_ \_ \_



Wenn der Buchstabe nicht im Wort vorkommt, wird die Anzahl der Fehlversuche erhöht. Nach jeder Eingabe zeigt das Programm den aktuellen Stand des Wortes, die bereits geratenen Buchstaben und die verbleibenden Versuche an.



Gibt der zweite Spieler eine ungültige Eingabe ein, zum Beispiel mehrere Buchstaben, eine Zahl oder ein Sonderzeichen, meldet das Programm den Fehler und fordert erneut zur Eingabe auf.



Das Spiel endet, wenn der zweite Spieler entweder das vollständige Wort erraten hat oder wenn die maximale Anzahl an Fehlversuchen erreicht wurde. Am Ende gibt das Programm aus, ob der zweite Spieler gewonnen oder verloren hat. Falls der zweite Spieler verloren hat, wird das gesuchte Wort angezeigt.



Dafür müssen wir programmieren:



* Eine Eingabe für das geheime Wort durch den ersten Spieler
* Eine Prüfung, ob das geheime Wort gültig ist
* Ein Verdecken der Eingabe, zum Beispiel durch viele Leerzeilen
* Eine Darstellung des Wortes mit Platzhaltern
* Eine Eingabe einzelner Buchstaben durch den zweiten Spieler
* Eine Prüfung, ob die Buchstabeneingabe gültig ist
* Eine Prüfung, ob der eingegebene Buchstabe im geheimen Wort vorkommt
* Eine Aktualisierung der sichtbaren Buchstaben
* Eine Speicherung bereits geratener Buchstaben
* Eine Zählung der Fehlversuche
* Eine Abbruchbedingung für Sieg oder Niederlage
* Eine Ausgabe des aktuellen Spielstands nach jeder Runde

## Essenzielle Ziele

*Geht kleinschrittig vor: Was sind die grundlegendsten Schritte, auf denen alles Weitere aufbaut? Essenziell ist, was zwingend notwendig ist, um die Kernfunktion eures Programms zu zeigen — also die zentrale Logik, die ihr z. B. über die Kommandozeile prüfen könnt. Tipp: Überlegt euch die einzelnen Schritte erst abstrakt (ohne an die konkrete Implementierung zu denken) und fragt euch dann, welche davon unverzichtbar sind. Beispiel: „Logik zur Prüfung, ob eine Eingabe gültig ist.“*



* Das Programm kann über die Kommandozeile gestartet werden.
* Der erste Spieler kann ein geheimes Wort eingeben.
* Das Wort wird auf Gültigkeit geprüft (Groß- und Kleinbuchstaben werden gleichwertig betrachtet, Sonderzeichen und Ziffern sind ungültig).
* Das Programm speichert dieses Wort intern.
* Das geheime Wort wird vor dem zweiten Spieler verdeckt.
* Das gesuchte Wort wird zunächst mit Platzhaltern angezeigt.
* Der zweite Spieler kann einzelne Buchstaben eingeben.
* Das Programm prüft, ob die Eingaben gültig sind.
* Das Programm erkennt, ob der Buchstabe im Wort enthalten ist.
* Richtig geratene Buchstaben werden im Wort sichtbar gemacht.
* Falsch geratene Buchstaben erhöhen die Anzahl der Fehlversuche.
* Bereits geratene Buchstaben werden gespeichert und angezeigt.
* Das Programm erkennt, ob der zweite Spieler gewonnen hat.
* Das Programm erkennt, ob der zweite Spieler verloren hat.
* Am Ende wird eine passende Gewinn- oder Verlustmeldung ausgegeben.

## Optionale Ziele

*Alles, was das Projekt erweitert, aber für den Erfolg nicht zwingend nötig ist — zum Beispiel eine grafische Oberfläche oder zusätzliche Komfortfunktionen. Gerne umsetzen, wenn die essenziellen Ziele stehen! (Tipp: lieber „klein, aber fertig“ als „groß, aber kaputt“.)*



* Eine einfache grafische Darstellung des Galgenmännchens in Textform.
* Verschiedene Schwierigkeitsstufen, zum Beispiel leicht, mittel und schwer.
* Unterschiedlich viele Fehlversuche je nach Schwierigkeitsgrad.
* Die Möglichkeit, nach Spielende eine neue Runde zu starten.
* Eine Anzeige der Anzahl der gewonnenen und verlorenen Spiele.
* Eine ausführlichere Anleitung beim Programmstart.
* Eine Trennung des Codes in mehrere Methoden, damit der Code übersichtlicher ist.
* Optional zusätzlich ein Einzelspieler-Modus mit einer kleinen Wortliste.
* Combo Counter

