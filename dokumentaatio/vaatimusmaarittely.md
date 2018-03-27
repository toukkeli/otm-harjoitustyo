# Vaatimusm‰‰rittely

## Sovelluksen tarkoitus

Sovelluksen tarkoitus on toimia alustana pˆyt‰roolipelikamppanioiden hallintaan, jakamiseen ja arkistoimiseen.

Tavallinen k‰ytt‰j‰ voi kirjauduttuaan luoda uuden kamppanian, selata muita sovellukseen tallennettuja pelej‰ ja liitty‰ pelaajaksi avoimiin peleihin.

Sovelluksen on tarkoitus hyˆdynt‰‰ HTML:l‰‰, ja se pit‰isi olla teoriassa mahdollista siirt‰‰ nettiin

## K‰ytt‰j‰t

Sovellukseen tulee useita _perusk‰ytt‰ji‰_, joilla jokaisella on samat oikeudet.

Jonkinlainen Admin-k‰ytt‰j‰tunnus, jolla on oikeudet muokata kaikkea sis‰ltˆ‰ olisi hyv‰ luoda julkista k‰yttˆ‰ varten.

## Perusversion tarjoama toiminnallisuus

### Ennen kirjautumista

- k‰ytt‰j‰ voi luoda j‰rjestelm‰‰n k‰ytt‰j‰tunnuksen
  - k‰ytt‰j‰tunnuksen t‰ytyy olla uniikki ja pituudeltaan v‰hint‰‰n 3 merkki‰
  - luonnin yhteydess‰ annetaan salasana, joka liitet‰‰n k‰ytt‰j‰tunnukseen

- k‰ytt‰j‰ voi kirjautua j‰rjestelm‰‰n
  - kirjautuminen onnistuu syˆtett‰ess‰ olemassaoleva k‰ytt‰j‰tunnus ja salasana kirjautumislomakkeelle
  - jos k‰ytt‰j‰‰ ei olemassa, ilmoittaa j‰rjestelm‰ t‰st‰
  - Jos k‰ytt‰j‰ on olemassa, mutta salasana ei t‰sm‰‰, ilmoittaa j‰rjestelm‰ t‰st‰

### Kirjautumisen j‰lkeen / kampanialista

- K‰ytt‰j‰ n‰kee listan kampanioita ja niitten lyhytkuvauksia
  - K‰ytt‰j‰n omat kampaniat listan alussa
  - K‰ytt‰j‰ voi valita listasta kampanian ja p‰‰st‰ sen kampaniasivulle

- k‰ytt‰j‰ voi luoda uuden kampanian
  - Luotaessa kampanialle annetaan nimi
  - luotu kampania ilmestyy n‰kyviin kaikkien k‰ytt‰jien listoihin

- k‰ytt‰j‰ voi kirjautua ulos j‰rjestelm‰st‰

### Kampaniasivu - Yleinen

- K‰ytt‰j‰ n‰kee sivulla pelin kuvauksen
  - Kuvaus tekstimuotoinen

- K‰ytt‰j‰ voi palata takaisin listan‰kym‰‰n

### Kampaniasivu - Oma

- Mik‰li k‰ytt‰j‰ siirtyi oman kampaniansa n‰kym‰‰n, h‰n voi muokata sit‰
  - Pelin kuvauksen tilalla tekstikentt‰ jossa kuvausta voi muokata

- K‰ytt‰j‰ voi nyt myˆs poistaa pelin jolloin se h‰vi‰‰ kaikista listauksista

## Jatkokehitysideoita

Perusversion j‰lkeen j‰rjestelm‰‰ t‰ydennet‰‰n ajan salliessa esim. seuraavilla toiminnallisuuksilla

- Kampanialla voisi olla yhden kuvauksen sijasta useita eri muokattavia tietoja, kuten nimi, luontip‰iv‰, pelinjohtajan tiedot, pelinjohtajan yhteystiedot, genre, jne.

