# DomoL
Lexikális elemzés
A lexikális elemzés feladata, hogy a forrásprogramban felismerje az összetartozó
szimbólumokat. Ezeket az összetartozószimbólumokat lexémáknak nevezzük. A 
lexéma a forrásprogram legkisebb, jelentéssel bíró egysége. Lexémák a következők:

• kulcsszavak
• azonosítók
• operátorok
• elhatároló jelek
• zárójelek
• konstansok
Az elemző a forrásprogramban megkeresi a lexémákat, és minden lexémához egy 
előre deﬁniált kódot rendel. A kimenete ezeknek a kódoknak a sorozata (tokensorozat). 
Ez már nem értelmezhető emberek számára. A szimbólumokat reguláris
 kifejezésekkel vagy determinisztikus véges automatákkal írhatjuk le. Ez a legfontosabb 
oka annak, hogy a lexikális elemzőt különválasztjuk a szintaktikai elemzőtől (hiszen a 
része is lehetne): ha nem választanánk külön, akkor a szimbólumokat is 
környezetfüggetlen grammatikával kellene leírnunk, márpedig a reguláris kifejezések 
kezelése sokkal egyszerűbb. A lexikális elemzők létrehozásához először a 
szimbolikus egységeket leírjuk reguláris kifejezésekkel, majd megkonstruáljuk az 
ekvivalens determinisztikus véges automatát. 
Lexikális elemzés – lexémák elkülönítése

kulcsszavak
azonosítók
operátorok

Véges automatával történik. 

Példa

input: l,d,sp,{,},(,),∗,:,=,<,>,p.
 állapotok: 
1. kezdőállapot
2. azonosítóban
3. azonosító vége
4. számban (szám belsejében)
5. szám vége
6. {...} kommentár
7. {...} kommentár vége
8. nyitó zárójelet talált
9. (*...*) kommentár
