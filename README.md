# Java - Gredu !!

Le but de ce TP est de te familiariser avec la POO. Tu vas créer des classes et les utiliser pour gérer un jeu de combat.

- Au début, tu vas créer une classe `Personnage` (`Archer` avec pour arme un arc, `Guerrier` avec pour arme une épée ou `Mage` avec pour arme un sceptre).
- Il faudra ensuite que ce `Personnage` puisse se battre ! Il lui faudra donc une `Arme`.

## Consigne
### Classe Personnage

Un personnage devra pouvoir disposer d’un nom, d'une classe (`Archer`, `Guerrier` ou `Mage`), d’une arme et d’une vie.

Inutile de créer des classes `Archer`, `Guerrier` ou `Mage`. On va utiliser une énumération `Classe` qui représentera ces cas. 

Un personnage commencera à 100 points de vie, et s'il atteint 0, cela voudra dire que le personnage est mort.

Un personnage devra aussi pouvoir jouer un tour de jeu, recevoir des dégâts ou en infliger à son adversaire en l’attaquant ou encore améliorer son arme en augmentant la capacité des dégâts de l’arme.

Enfin, à chaque tour, j’aimerais que tu affiches le nom du personnage, sa jauge de vie et les dégâts que provoque son arme grâce à une méthode de la classe `Personnage`.

### Classe Arme

Cette classe est toute simple, elle servira juste à indiquer le nombre de dégâts que cette arme inflige. C’est avec ces dégâts que le personnage perd de la vie. Il existe donc les classes `Arc`, `Epee` et `Sceptre` qui hériteront de `Arme`. C'est dans ces trois dernières classes qu'il faudra préciser les dégâts. 

Il faudra donc définir une propriété `Arme` au `Personnage`. Puisque `Arc`, `Epee` et `Sceptre` hériteront de la classe `Arme` rien n'empêchera donc d'instancier un `Arc` ou une `Epee` sur le `Personnage` : l'héritage sert à cela. Ce genre de code est donc possible :
```java
Arme arme = new Epee();
```

## Correction

### Arme



### Personnage
