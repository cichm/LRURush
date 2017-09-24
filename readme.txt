Projekt ten implementuje trzy interfejsy i operuje na strukturze mapy, gdzie kluczem jest zawsze String a warto�ci� Objekt 
(podyktowane jest to w�a�nie interfejsami i zapewne wi��e si� z tym implementacja projektu kt�ry bazuje na podobnym Cache�u). 
Powinno si� stosowa� z mechanizm�w �generycznej Javy� tak by m�c wyeliminowa� korzystanie z typu Object w przysz�o�ci.

Nie zosta�o dok�adnie powiedziane co ma si� dzia�, wtedy gdy nast�pi np. pr�ba pobrania 
nieistniej�cej warto�ci lub gdy nast�pi pr�ba pobrania warto�ci z Cachu, podczas gdy jest on pusty. 
W takim przypadku min. postanowi�em utworzy� w�asny wyj�tek o nazwie NoCacheEntryException. 
LinkedHashMap jest kolekcj� pami�taj�c� kolejno�� dodawanych element�w i przechowuj�c� pary klucz � warto�� i nie jest 
kolekcj� synchronizowan� �sam� z siebie�, w przypadku p�niejszej pr�by przeobra�enia projektu w mechanizm wielow�tkowy nale�y o tym pami�ta�.

Pomocnym w tym jak i wielu innych projektach mo�e okaza� si� programowanie przy u�yciu Javy 8. 
Java 8 to ju� innej klasy j�zyk, bo w stosunku do poprzedniej wersji jest ju� j�zykiem 
funkcyjnym zorientowanym obiektowo, a je�eli tak nie jest - to na pewno jest j�zykiem obiektowo-funkcyjnym 
(imperatywno-strukturalno-obiektowo-funkcyjnym) o czym �wiadczy min. instrukcja InvokeDynamic w ByteCode Javy. 
Przy pomocy wspomnianej funkcyjno�ci mo�na dokona� pr�b �omini�cia� rzucania i wy�apywania wyj�tk�w i pozbycia si� test�w, a to za pomoc� tzw. 
�referencyjnej prze�roczysto�ci� program�w napisanych w spos�b funkcyjny (z czym wi��e si� niemutowalno�� kodu). 
Dzi�ki programowaniu funkcyjnemu zyskuje si� tak�e �wyra�ne rozdzielenie cz�ci kodu, co do kt�rego mo�na dowie�� poprawno�ci, i innych cz�ci, 
kt�rych wynik zale�y od warunk�w zewn�trznych. W ten spos�b programy funkcyjne s� programami mniej nara�onymi na b��dy, 
a same b��dy mog� pojawi� si� tylko w niekt�rych, ograniczonych obszarach�. To jest atut kt�ry mo�e przemawia� 
zw�aszcza gdy mamy do czynienia z projektami wielow�tkowymi, kt�rych przetestowanie w ca�o�ci graniczy z cudem.

Moje spostrze�enia zapisuje w pliku readme.txt i wci�� bije si� z my�l� czy nie dosz�o do drobnej pomy�ki, w zwi�zku z rozszerzeniem pliku. 
Czy przypadkiem nie powinienem tego zapisa� w pliku README.md.
