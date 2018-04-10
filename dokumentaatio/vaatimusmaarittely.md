# Vaatimusmäärittely


Huomio! Muutettu 10.4 koska alkuperäinen aihe ei vastannut [työn aloittamiseen](https://github.com/mluukkai/otm-2018/blob/master/web/tyon_aloitus.md#harjoitusty%C3%B6n-aloitus) liittyviä suosituksia

## Sovelluksen tarkoitus

Sovellus on pienimuotoinen seikkailuroolipeli samaan tapaan kuin [Nethack](https://fi.wikipedia.org/wiki/NetHack)

Pelissä pelaaja ohjaa hahmoa ruudutetulla kartalla luolastossa, jossa on erilaisia hirviöitä.

## Perusversion tarjoama toiminnallisuus

### Alkuvalikko
- Käyttäjä voi aloittaa uuden pelin
- Käyttäjä voi lopettaa pelin

### Pelinäkymä

- Pelaaja voi poistua aloitusnäkymään painamalla ESC

- Peliruudulla näkyy:
  - Pelaajahahmo
  - Seiniä
  - Hirviöitä
  - Ruudun alareunassa pelaajan status (HP)

- Pelihahmoa voi liikuttaa ruudukolla kahdeksaan suuntaan numpadilla
  - Kun pelaaja liikkuu askeleen, niin hirviötkin liikkuvat askeleen suoraan pelaajaa kohti jos tilaa riittää
  - Jos pelaaja tai hirviö liikkuu ruutuun jossa toinen on, lyö liikkuja toista ja tapahtuu vahinkoa

## Jatkokehitysideoita

- Pelaajalla ja hirviöillä on ominaisuuksia jotka vaikuttavat siihen, miten vahinkoa otetaan ja jaetaan
- Pelaajalla ja hirviöillä on muitakin asioita tehtävänä kuin liikkuminen ja lyöminen
- Peliruudulla on esineitä joita voi poimia jotka päivittävät pelaajaa

