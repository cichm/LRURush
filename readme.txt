Projekt ten implementuje trzy interfejsy i operuje na strukturze mapy, gdzie kluczem jest zawsze String a wartoœci¹ Objekt 
(podyktowane jest to w³aœnie interfejsami i zapewne wi¹¿e siê z tym implementacja projektu który bazuje na podobnym Cache’u). 
Powinno siê stosowaæ z mechanizmów „generycznej Javy” tak by móc wyeliminowaæ korzystanie z typu Object w przysz³oœci.

Nie zosta³o dok³adnie powiedziane co ma siê dziaæ, wtedy gdy nast¹pi np. próba pobrania 
nieistniej¹cej wartoœci lub gdy nast¹pi próba pobrania wartoœci z Cachu, podczas gdy jest on pusty. 
W takim przypadku min. postanowi³em utworzyæ w³asny wyj¹tek o nazwie NoCacheEntryException. 
LinkedHashMap jest kolekcj¹ pamiêtaj¹c¹ kolejnoœæ dodawanych elementów i przechowuj¹c¹ pary klucz – wartoœæ i nie jest 
kolekcj¹ synchronizowan¹ „sam¹ z siebie”, w przypadku póŸniejszej próby przeobra¿enia projektu w mechanizm wielow¹tkowy nale¿y o tym pamiêtaæ.

Pomocnym w tym jak i wielu innych projektach mo¿e okazaæ siê programowanie przy u¿yciu Javy 8. 
Java 8 to ju¿ innej klasy jêzyk, bo w stosunku do poprzedniej wersji jest ju¿ jêzykiem 
funkcyjnym zorientowanym obiektowo, a je¿eli tak nie jest - to na pewno jest jêzykiem obiektowo-funkcyjnym 
(imperatywno-strukturalno-obiektowo-funkcyjnym) o czym œwiadczy min. instrukcja InvokeDynamic w ByteCode Javy. 
Przy pomocy wspomnianej funkcyjnoœci mo¿na dokonaæ prób „ominiêcia” rzucania i wy³apywania wyj¹tków i pozbycia siê testów, a to za pomoc¹ tzw. 
„referencyjnej przeŸroczystoœci” programów napisanych w sposób funkcyjny (z czym wi¹¿e siê niemutowalnoœæ kodu). 
Dziêki programowaniu funkcyjnemu zyskuje siê tak¿e „wyraŸne rozdzielenie czêœci kodu, co do którego mo¿na dowieŸæ poprawnoœci, i innych czêœci, 
których wynik zale¿y od warunków zewnêtrznych. W ten sposób programy funkcyjne s¹ programami mniej nara¿onymi na b³êdy, 
a same b³êdy mog¹ pojawiæ siê tylko w niektórych, ograniczonych obszarach”. To jest atut który mo¿e przemawiaæ 
zw³aszcza gdy mamy do czynienia z projektami wielow¹tkowymi, których przetestowanie w ca³oœci graniczy z cudem.

Moje spostrze¿enia zapisuje w pliku readme.txt i wci¹¿ bije siê z myœl¹ czy nie dosz³o do drobnej pomy³ki, w zwi¹zku z rozszerzeniem pliku. 
Czy przypadkiem nie powinienem tego zapisaæ w pliku README.md.
