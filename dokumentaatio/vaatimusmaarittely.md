# Vaatimusm��rittely


Huomio! Muutettu 10.4 koska alkuper�inen aihe ei vastannut [ty�n aloittamiseen](https://github.com/mluukkai/otm-2018/blob/master/web/tyon_aloitus.md#harjoitusty%C3%B6n-aloitus) liittyvi� suosituksia

## Sovelluksen tarkoitus

Sovellus on pienimuotoinen seikkailuroolipeli samaan tapaan kuin [Nethack](https://fi.wikipedia.org/wiki/NetHack)

Peliss� pelaaja ohjaa hahmoa ruudutetulla kartalla luolastossa, jossa on erilaisia hirvi�it�.

## Perusversion tarjoama toiminnallisuus

### Alkuvalikko
- K�ytt�j� voi aloittaa uuden pelin
- K�ytt�j� voi lopettaa pelin

### Pelin�kym�

- Pelaaja voi poistua aloitusn�kym��n painamalla ESC

- Peliruudulla n�kyy:
  - Pelaajahahmo
  - Seini�
  - Hirvi�it�
  - Ruudun alareunassa pelaajan status (HP)

- Pelihahmoa voi liikuttaa ruudukolla kahdeksaan suuntaan numpadilla
  - Kun pelaaja liikkuu askeleen, niin hirvi�tkin liikkuvat askeleen suoraan pelaajaa kohti jos tilaa riitt��
  - Jos pelaaja tai hirvi� liikkuu ruutuun jossa toinen on, ly� liikkuja toista ja tapahtuu vahinkoa

## Jatkokehitysideoita

- Pelaajalla ja hirvi�ill� on ominaisuuksia jotka vaikuttavat siihen, miten vahinkoa otetaan ja jaetaan
- Pelaajalla ja hirvi�ill� on muitakin asioita teht�v�n� kuin liikkuminen ja ly�minen
- Peliruudulla on esineit� joita voi poimia jotka p�ivitt�v�t pelaajaa

