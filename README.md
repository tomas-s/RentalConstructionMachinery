Školní projekt - informační systém pro půjčovnu pracovních strojů.
Tento soubor slouží jako WIKI našeho projektu.

# Adresáře
 * src/main/java/cz/mufi/PA165/RentalConstructionMachinery/
 obsahuje java kódy aplikace
 
 * src/main/resources/
 obsahuje configuraci aplikace
 
 * src/test/java/cz/mufi/PA165/RentalConstructionMachinery/
 obsahuje testovací třídy
 
 * doc/
 obsahuje dokumentaci aplikace (use-case a ERD diagram)

# Popis projektu
 Systém představuje software pro rezervaci pracovních strojů.
 Systém obsahuje čtyři entity.
 * Customer - zákazník naší půjčovny.
 * Machine - stroj k vypůjčení.
 * Revision - revize stroje, slabá entita závislá na Machine.
 * Rent - výpůjčka stroje zákazníkovi, slabá entina závislá na Customer a Machine.
 
# Rozdělení práce
 * 1 entita + dao + test = 1 člen týmu
 * Zdeněk - Customer 
 * Tomáš  - Revision
 * Matěj  - Rent
 * Jakub  -
 
# HOW TO
 * Maven + Spring + Hibernate + JPA + derby : http://www.adrianwalker.org/2010/08/maven-spring-jpa-skeleton-project.html