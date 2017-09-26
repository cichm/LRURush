Projekt ten implementuje trzy interfejsy i operuje na strukturze mapy, gdzie kluczem jest zawsze String a wartością Objekt 
(podyktowane jest to właśnie interfejsami i zapewne wiąże się z tym implementacja projektu który bazuje na podobnym Cache’u). 
Powinno się stosować z mechanizmów „generycznej Javy” tak by móc wyeliminować korzystanie z typu Object w przyszłości.

Nie zostało dokładnie powiedziane co ma się dziać, wtedy gdy nastąpi np. próba pobrania 
nieistniejącej wartości lub gdy nastąpi próba pobrania wartości z Cachu, podczas gdy jest on pusty. 
W takim przypadku min. postanowiłem utworzyć własny wyjątek o nazwie NoCacheEntryException. 
LinkedHashMap jest kolekcją pamiętającą kolejność dodawanych elementów i przechowującą pary klucz – wartość i nie jest 
kolekcją synchronizowaną „samą z siebie”, w przypadku późniejszej próby przeobrażenia projektu w mechanizm wielowątkowy należy o tym pamiętać.

Pomocnym w tym jak i wielu innych projektach może okazać się programowanie przy użyciu Javy 8. 
Java 8 to już innej klasy język, bo w stosunku do poprzedniej wersji jest już językiem 
funkcyjnym zorientowanym obiektowo, a jeżeli tak nie jest - to na pewno jest językiem obiektowo-funkcyjnym 
(imperatywno-strukturalno-obiektowo-funkcyjnym) o czym świadczy min. instrukcja InvokeDynamic w ByteCode Javy. 
Przy pomocy wspomnianej funkcyjności można dokonać prób „ominięcia” rzucania i wyłapywania wyjątków i pozbycia się testów, a to za pomocą tzw. 
„referencyjnej przeźroczystości” programów napisanych w sposób funkcyjny (z czym wiąże się niemutowalność kodu). 
Dzięki programowaniu funkcyjnemu zyskuje się także „wyraźne rozdzielenie części kodu, co do którego można dowieźć poprawności, i innych części, 
których wynik zależy od warunków zewnętrznych. W ten sposób programy funkcyjne są programami mniej narażonymi na błędy, 
a same błędy mogą pojawić się tylko w niektórych, ograniczonych obszarach”. To jest atut który może przemawiać 
zwłaszcza gdy mamy do czynienia z projektami wielowątkowymi, których przetestowanie w całości graniczy z cudem.
