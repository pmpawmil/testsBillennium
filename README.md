# Wymagane
[Java 8 JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
[Maven 3.5.0](https://maven.apache.org/download.cgi)

> Aby otworzyć projekt wystarczy otworzyć plik pom.xml w swoim IDE

### Wykorzystane biblioteki:
- selenium;
- testNG;
- logowanie: log4j2;
- raportowanie: allure (allure-testng + aspectjweaver + jaxb-api i slf4j-simple);
- asercja: assertJ

Aby uniknąć duplikacji i łatwiej pracować z webelementami w projekcie wykorzystano wzorzec **Page Object Pattern**. Zakłada on podział części lub całości widzianej strony na obiekty, w których skład wchodzą webelementy oraz metody, które wykonują akcję na nich.

Dodatkowo wykorzystano wzorzec **Fabryka** między innymi poprzez deklaracje webelementów nad metodami przy pomocy adnotacji @FindBy(). Metoda odpowiedzialna za inicjalizacja obiektów znajduje się w klasie abstrakcyjnej "BasePage", która jako klasa rodzic dostarcza elementy potrzebne do poprawnego działania klas Page Objectów.

Budowę kodu oparto na **Płynnym Interfejsie** (ang. “Fluent Interface”) gdzie np. metody danych klas zwracają inny obiekt strony lub siebie poprzez "this".

DriverManager WebDriver jest static, bo nie ma wielu wątków zaimplementowanych. Klasa "WaitForElement" dostarcza metody na czekanie opartę o Explicit Wait.

Każdy krok Selenium od startu przeglądarki, po wykonywanie testów jest zapisywany poprzez instancję Loggera.

W pakiecie listeners znajduje się DriverEventListener klasa typu nasłuchującego, która mając dostęp rejestruje wszystkie zdarzenia, które zostają wykonane.

## Raport z testów.

Wykonać poniższe kroki będąc w katalogu projektu (tam gdzie :
 1. Wykonać komendę "mvn clean test" -> w target\allure-results pojawią
    się wyniki z testów
 2. Wykonać komendę "mvn allure:report" -> wygenerowanie raportu Allure
 3. Otworzyć plik 'target\site\allure-maven-plugin\index.html'

> Jeśli w raporcie się nic nie wyświetla, wtedy wyszukać plik index.html w strukturze projektu z poziomu IntelliJ, otworzyć plik i w prawym górnym rogu otwartego pliku index.html kliknąć na ikonę preferowanej przez nas przeglądarki.*

***Wszystkie testy możemy też odpalić klikając prawym przyciskiem myszy i wybierając "run" na pliku all_tests_suite.xml znajdującego się w folderze resources.***