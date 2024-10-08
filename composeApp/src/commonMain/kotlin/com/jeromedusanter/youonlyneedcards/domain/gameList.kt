package com.jeromedusanter.youonlyneedcards.domain

val thirtyOne = GameModel(
    id = 1,
    name = "31",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.ELIMINATION),
    minPlayer = 2,
    maxPlayer = 6,
    goal = "Le but du jeu est d'obtenir le plus grand nombre de points sans dépasser 31.",
    material = "Un jeu de 36 cartes (du 6 à l'As)",
    howToPlay = """
        L'un des joueurs est désigné comme le donneur. Après avoir mélangé le paquet, il consulte discrètement les 3 premières cartes. Il peut décider de les conserver si elles lui conviennent, sinon, il les place au centre de la table, face visible. Il prend alors les 3 cartes suivantes du paquet. S'il garde les 3 premières cartes, il met les suivantes au milieu de la table, puis distribue trois cartes à chaque joueur. Le joueur situé à gauche du donneur commence la partie.

        Lors de son tour, le joueur a plusieurs options :
        - Il peut échanger l'une de ses cartes contre l'une de celles posées sur la table (le tour passe ensuite au joueur suivant).
        - Il peut échanger toutes ses cartes avec celles sur la table (le tour passe ensuite au joueur suivant).
        - Il peut choisir de ne pas échanger et de passer son tour. Cela déclenche le dernier tour, où chaque joueur joue une dernière fois avant l'évaluation des mains. Si un joueur atteint 31 points (notamment juste après la distribution), il doit l'annoncer immédiatement et le jeu s'arrête pour passer directement à l'évaluation.

        L'évaluation des mains se fait en additionnant les valeurs des 3 cartes de chaque joueur. Les As valent 11 points, les Rois, Dames et Valets valent 10 points, et les autres cartes valent leur valeur nominale (par exemple, un 8 vaut 8 points). Cependant, seules les cartes de la même couleur (♠, ♥, ♦ ou ♣) sont prises en compte pour le score. La plus haute somme dans une couleur détermine le score final.

        Exemples :
        - 8♥ + 8♠ + D♣ = 10 points
        - 10♠ + 7♥ + 8♠ = 15 points
        - As♠ + V♠ + R♠ = 31 points
        Cas particulier : trois cartes identiques (comme trois As, trois 9, ou trois Dames) valent 30 points.
    """.trimIndent(),
    durationInMinutes = 20,
    difficultyLevel = GameDifficultyLevelModel.MEDIUM,
    end = """
        Le joueur ayant le moins de points à la fin d'un tour est déclaré perdant. Il peut y avoir plusieurs perdants en cas d'égalité. Si tous les joueurs ont le même nombre de points, le tour est rejoué.

        Chaque perdant perd 1 point sur un total de 4 points au départ. Un joueur est éliminé s'il n'a plus de points. Le dernier joueur encore en jeu avec au moins 1 point est déclaré gagnant.
    """.trimIndent()
)
val barbu = GameModel(
    id = 2,
    name = "Barbu",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.TRICKS),
    minPlayer = 2,
    maxPlayer = 6,
    goal = "Le but du jeu est d'avoir le moins de point possible à la fin de la partie. Chaque partie se déroule en plusieurs manches qui ont chacune des règles différentes",
    material = "Un jeu de 52 cartes",
    howToPlay = """
Le jeu se joue en plusieurs manches, qui sont joués dans l’ordre suivant :

moins de levées
pas de coeurs
pas de dames
barbu
générale

A 5 joueurs, on enlève les 2 noirs, et à 3 on enlève le 2 de trèfle.

Un joueur qu'on appellera le "donneur" distribue toutes les cartes (une par une en changeant de joueur dans le sens des aiguilles d'une montre) puis c'est le joueur à sa gauche qui commence la manche. A la manche suivante, le joueur à gauche du donneur devient lui-même le donneur et ainsi de suite.

Chaque manche se déroule en "levées" dans lesquelles les joueurs exposent tour à tour une carte sur la table et celui qui a joué la plus forte s'empare de l'ensemble en la levant et la pliant devant lui. On dit que le joueur fait une levée. Ces cartes ne sont plus utilisables durant toute la manche. La première carte jouée donne la couleur (Pique, Coeur, Carreau, Trèfle) de la levée et les joueurs doivent obligatoirement jouer une carte de la même couleur si ils le peuvent. Si un joueur ne possède pas la couleur demandée, il peut jouer n'importe quelle carte (se défausser) mais est sûr de ne pas pouvoir remporter la levée.

Exemple : le joueur 1 lance la levée avec son 3 de carreau, le joueur 2 pose un 8 de carreau, le joueur 3 n'a pas de carreau et se défausse de son Roi de coeur, enfin le joueur 4 pose son valet de carreau. Le joueur 4 remporte donc la levée et la pose devant lui face cachée. il doit maintenant lancer la prochaine levée et ainsi de suite.

Les levées se jouent dans le sens des aiguilles d'une montre.

Une manche s'arrête quand les joueurs n'ont plus de cartes dans leurs mains.

Moins de levées
Le but est de faire le moins de levées possible. A la fin de la manche, chaque joueur compte le nombre de levées qu’il a fait et marque 5 points par levée.

Pas de coeurs
Le but est de ramasser le moins de coeurs possible dans ses levées. Chaque carte à coeur ramassée vaut 5 points.

Pas de dames
La but est d’éviter de ramasser des dames. Chaque dame vaut 20 points.

Barbu
Il faut éviter de prendre le roi de coeur, qui vaut 80 points.

Générale
On joue toutes les manches ensemble : il ne faut prendre ni levées, ni coeurs, ni dames, ni roi de coeur. On fait alors le total des points ramassés.
""".trimIndent(),
    variants = """
        Choix des manches
        Une variante consiste à laisser le joueur situé après le donneur choisir la manche qu'il souhaite jouer en fonction de son jeu. L'ordre des manches est donc obsolète. Une manche ne peut être jouer qu'une seule fois.
        
        Attention, la manche "Générale" doit forcément être la dernière manche.
        
        A noter que dans cette variante, les joueurs choisissant en dernier seront désavantagés car ils auront moix de choix.

        Nouvelles manches
        Il est possible de rajouter les manches suivantes :

        Plus de levées
        C’est la seule manche où il faut ramasser des levées. Chaque joueur peut enlever 5 points à son total par levée.

        Ni première, ni dernière
        Il ne faut prendre ni la première levée, ni la dernière. Chacune de ces levées vaut 40 points.
    """.trimIndent(),
    end = "Après avoir joué toutes les manches, on fait la somme de tous les points marqués par chaque joueur. le joueur ayant le moins de points est le vainqueur",
    difficultyLevel = GameDifficultyLevelModel.HARD,
    durationInMinutes = 45
)

val corsicaBattle = GameModel(
    id = 3,
    name = "Bataille Corse",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.ELIMINATION),
    minPlayer = 2,
    maxPlayer = 8,
    goal = "Le but du jeu est de remporter toutes les cartes des autres par vos réflexes et votre rapidité !",
    material = "Un jeu de 52 cartes",
    howToPlay = """
Au début du jeu, on distribue de manière égale tout le paquet entre les joueurs.

A chaque manche, un joueur l'ouvre en posant la premiere carte de son paquet au centre de la table, le joueur à sa gauche pose la première carte de son paquet sur cette carte et ainsi de suite (ce qui forme un tas de carte central).

Le but du jeu est de recupérer toute les cartes du jeu et donc de recupérer un maximum de tas centraux qui se forment à chaque manche.

Un joueur qui n'a plus de carte est éliminé (ou pas, voir variantes)

Il y a 2 moyens pour gagner une manche et donc le tas central :

Premier moyen : Etre le premier à taper sur le tas central.

Pour pouvoir taper sur le tas central, il faut que la situation (qu'on appellera situation de tape) suivante se présente :

Deux cartes qui se suivent sont les mêmes (exemple : 5 coeur suit un 5 de pique, une Dame de carreau suit une Dame de trèfle etc...)

On verra dans les variantes qu'on peut ajouter beaucoup plus de situation de tape afin de pimenter le jeu.

Attention, si un joueur tape alors que ce n'était pas une situation de tape, alors il devra mettre 2 cartes de son paquet en dessous du tas central.

Second moyen : Gagner la manche grâce à une tête.

Les têtes (As, Roi, Dame, Valet) sont des cartes un peu spéciales.
Si un joueur pose une tête le joueur suivant doit poser un nombre de cartes (défini par la tête posée) sur le tas central.
- pour un As, il doit poser 4 cartes.
- pour un Roi, il doit poser 3 cartes.
- pour une Dame, il doit poser 2 cartes.
- pour un Valet, il doit poser 1 carte. Le valet est donc la meilleure carte du jeu.

Si après avoir posé le nombre de cartes nécessaires, le joueur n'a pas posé une tête ou qu'il n'y a eu aucune situation de tape, le joueur qui a posé la tête remporte le tas.

Exemple 1 (Dans une partie à 3 joueurs) :
Le joueur 1 met un As. le joueur 2 doit donc poser 4 cartes d'affilée tant qu'aucune tête ou qu'aucune situation de tape ne se présente. Il pose un 7, il doit donc rejouer et pose une Dame. Ayant posé une tête, c'est au tour du joueur 3 de poser des cartes, (2 puisque c'est une dame). le joueur 3 pose un 5 puis un 3. Pas de tête et pas de situation de tape. Le joueur 2 remporte le tas grâce à sa Dame.

Exemple 2 (Dans une partie à 3 joueurs) :
Le joueur 1 pose à un 4, le joueur 2 pose un 3, le joueur 3 pose un 8, le joueur 1 pose un 8, le joueur 3 tape car il y a eu 2 fois la même carte d'affilée (situation de tape) et remporte le tas central.

Le joueur ayant remporté la manche entame la suivante.
""".trimIndent(),
    variants = """
Ajout de sitations de tape :
- on tape quand il y un sandwich de cartes (Exemple: 8, Roi, 8 // 7, As, 7)
- on tape quand il y a deux cartes qui se suivent dont la somme fait 10 (Exemple: 4 et 6 // 3 et 7 // 2 et 8 // As et 9)
- on tape quand il y a la carte 10
- on tape quand il y un sandwich de cartes dont la somme fait 10 (Exemple: 3, 4, 7 // 4, Roi, 6 // As, Valet, 9)

Seconde chance :
Si un joueur n'a plus de cartes il peut continuer à taper à chaque manche quand une situation de tape se présente et revenir dans la partie mais si il fait une erreur alors il est définitevement éliminé.
""".trimIndent(),
    end = "Un joueur gagne la partie quand il remporte toutes les cartes du jeu.",
    difficultyLevel = GameDifficultyLevelModel.EASY,
    durationInMinutes = 30
)

val corruption = GameModel(
    id = 4,
    name = "Corruption",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.HIDDEN_IDENTITY, GameTagModel.ELIMINATION),
    minPlayer = 2,
    maxPlayer = 6,
    goal = "Le but du jeu est d'être le dernier en vie à la fin de la partie. Le bluff, le mensonge et la stratégie seront vos meilleurs alliés pour assassiner et survivre à vos voisins!",
    material = "Un jeu de 52 cartes",
    durationInMinutes = 30,
    howToPlay = """
Au début du jeu, on sépare les têtes et les 10 des autres cartes. Les têtes et les 10 seront les cartes de soutiens, les autres cartes représenteront l'or.

On distribue 2 cartes de soutiens et 2 d'or à chaque joueur sachant qu'une carte de soutien représente 1 vie. Chaque joueur a donc 2 vies au début de la partie. 

On forme une pioche avec le reste des cartes de soutiens et un autre tas avec toutes les autres cartes qu'on appelera "banque".

A 4 joueurs et moins, on enlève un exemplaire de chaque carte de soutien, c'est à dire un 10, un valet, une dame, un roi et un As. Il y a donc 3 exemplaires de chaque cartes de soutiens.  

Le jeu se déroulera tour par tour dans le sens des aiguilles d'une montre après avoir désigné un premier joueur.

Au début de son tour de jeu, un joueur peut réaliser une action parmis les suivantes :
- Piocher une pièce d'or
- Piocher 2 pièces d'or mais peut-être contrer par la dame
- Utiliser l'un des pouvoirs de ses cartes soutiens
- Assassiner quelqu'un pour 7 pièces d'or. La personne assassinée perd une seule vie. Cette action n'est pas contrable. Les 7 pièces d'or sont remis dans la banque.

Les différents pouvoirs des cartes sont les suivants :
- 10: Contre l'action du valet
- Valet: Assassine pour seulement 3 pièces d'or mais peut se faire contrer par le 10
- Dame: Pioche 3 pièces d'or et contre l'action de piocher 2 pièces d'or
- Roi: Vole 2 pièces d'or à un joueur de son choix mais peut se faire contrer par un autre roi
- As: peut effectuer une des 2 actions possibles : 
       - Regarder une carte soutien d'un autre joueur et décider de la défausser ou pas. Si il la défausse, l'autre joueur doit piocher une nouvelle carte soutien. 
       - Piocher une carte soutien directement dans la pioche et l'échanger (ou pas) de façon secrete avec une de ses cartes soutiens. La carte soutien qu'il ne veut plus sera mise sous la pioche face cachée.

Le contre : 
N'importe quel joueur peut contrer une action même si ce n'est pas pendant son tour de jeu et même si il n'est pas directement impliqué. Un joueur dont on a contré l'action ne peut pas rejouer à ce tour, on considère qu'il a réalisé son action malgré le contre.

Exemple : Si le joueur 1 décide d'assasiner le joueur 2 avec son valet, le joueur 2 peut contrer avec son 10. Si le joueur 2 n'a pas de 10, le joueur 4 peut contrer avec son 10 et défendre le joueur 2. le joueur 1 est donc contré, il perd ses 3 pièces d'or, le joueur 2 n'a pas perdu de vie et ça sera à son tour de jouer.

Cette régle s'applique pour tous les contres disponibles.

La mise en cause : 
Sachant que personne ne connait les cartes de soutiens des autres joueurs, chaque joueur a la possibilité de bluffer et de faire une action qu'il (en principe) ne peut pas faire. 

Exemple : Le joueur 1 a un valet et un 10 mais prétend qu'il a une dame et prend 3 pièces d'or à la banque.

Si un autre joueur pense qu'il ment, il peut le "mettre en cause", c'est-à-dire lui demander de prouver qu'il a bien la carte qu'il prétend avoir. Le joueur mis en cause doit donc dévoiler sa carte de soutien.
Si le joueur mis en cause avait bel et bien la carte qu'il prétendait avoir, alors le joueur qui l'a mis en cause perd une vie.
Si le joueur mis en cause n'avait pas la carte qu'il prétendait avoir, alors il perd une vie.

Exemple : Si on reprend l'exemple ci-dessus, si le joueur 2 met en cause le joueur 1. Alors le joueur 1 perdra une vie et ne prendra pas les 3 pièces d'or.

On peut mettre en cause les contres.

Exemple : Le joueur 1 a un roi et décide de voler 2 pièces d'or au joueur 2. Le joueur 2 décide de contrer l'action avec son roi. Le joueur 1 peut mettre en cause le joueur 2. Si le joueur 2 a un roi alors le joueur 1 perd une vie et ne vole pas les 2 pièces d'or. Si le joueur 2 n'a pas de roi alors il perd une vie et le joueur 1 lui vole 2 pîèces d'or.

Plusieurs cas particuliers :
- le joueur 1 a un valet et assassine le joueur 2 pour 3 pièces d'or. Si le joueur 2 pense qu'il ment et le met en cause, il perdra 2 points de vie puisque l'action d'assassinat aura lieu en plus de la mise en cause échouée. Si le joueur 1 n'a pas de valet, c'est le joueur 1 qui perd une vie mais pas ces 3 pièces d'or puisque l'action est annulée.
- Le joueur 1 a un valet et assassine le joueur 2 pour 3 pièces d'or. Le joueur 2 bluffe et contre avec un 10 qu'il n'a pas. Si le joueur 1 (ou n'importe quel autre joueur d'ailleurs) le met en cause, le joueur 2 perdra aussi 2 points de vie puisque puisque l'action d'assassinat aura lieu en plus de la mise en cause échouée. Dans le cas, où le joueur 2 a vraiment un 10, le joueur 1 perdra un point de vie et ces 3 pièces d'or puisque l'action aura été contrée.

Quand un joueur perd un point de vie, il se défausse de la carte soutien de son choix mais la garde face visible à côté de son autre carte soutien. Il ne peut donc plus utiliser le pouvoir de la carte soutien visible.

Quand un joueur met en cause un autre joueur mais que la mise en cause échoue. Le joueur qui a montré sa carte la pose en dessous de la pioche des cartes de soutiens et pioche une nouvelle carte de soutien.

Si un joueur perd ses 2 cartes soutiens (ces 2 points de vies) il est éliminé et ne peut plus intéragir avec les autres joueurs.

Si au début de son tour, un joueur cumule 10 pièces d'or ou plus, il doit obligatoirement effectuer un assassinat (en payant 3 ou 7 pièces d'or).
""",
    end = "La partie s'arrête quand il n'y a plus qu'un seul joueur. Ce joueur est le vainqueur",
    difficultyLevel = GameDifficultyLevelModel.HARD
)

val president = GameModel(
    id = 5,
    name = "Président",
    tagList = listOf(GameTagModel.CARDS),
    minPlayer = 4,
    maxPlayer = 6,
    goal = "Le but du jeu est de se débarrasser de toutes ses cartes en premier.",
    material = "Un jeu de 52 cartes.",
    howToPlay = """
        Hiérarchie des cartes
        La carte la plus forte est le 2, suivie par l'As, le Roi, la Dame, le Valet, le 10, et ainsi de suite. Le 2 permet au joueur qui la possède de terminer une série de cartes.

        Distribution et début de la partie
        Lors de la première partie, toutes les cartes sont distribuées entre les joueurs. Le joueur à gauche du donneur commence en posant 1 à 4 cartes de même valeur.

        Déroulement du jeu
        À chaque tour, un joueur a plusieurs options :
        1. **Passer** : Si le joueur n'a pas de cartes plus hautes ou pas le bon nombre, il passe son tour.
        2. **Poser des cartes supérieures** : Le joueur peut poser une ou plusieurs cartes d'une valeur supérieure à celles déjà jouées.
        3. **Poser des cartes "2"** : Si un joueur pose un 2, la série s'arrête immédiatement et il recommence une nouvelle série.

        Exemple : 
        - Le joueur 1 pose deux 7.
        - Le joueur 2 pose deux 9.
        - Le joueur 3 pose deux Valets.
        - Le joueur 4 pose un 2, la série s'arrête et il recommence une nouvelle série.

        Si plus aucun joueur ne peut ou ne souhaite poser une carte, le dernier joueur à avoir joué recommence une nouvelle série.

        Règles spécifiques
        - Les cartes posées doivent toujours être supérieures aux précédentes.
        - Il est interdit de finir par un 2.
        - Il est impossible de "boucler" après le 2 (exemple : poser un As suivi d'un 2 et recommencer avec un 3).

        Redistribution des rôles
        À la fin d'une manche, les joueurs prennent les rôles suivants selon leur ordre de victoire :
        - Président** : Le premier à avoir terminé.
        - Vice-président : Le deuxième à avoir terminé.
        - Neutre (si 5 joueurs) : Le troisième à avoir terminé.
        - Vice-trou du cul : L'avant-dernier joueur.
        - Trou du cul : Le dernier joueur à terminer.

        Redistribution des cartes
        Lors de la prochaine partie :
        - Le Président reçoit les deux meilleures cartes du Trou du cul et lui donne deux cartes de son choix.
        - Le Vice-président échange une carte avec le Vice-trou du cul.
        - Si un joueur est neutre (5 joueurs), il ne donne ni ne reçoit de carte.

        Début de la manche suivante
        Le Trou du cul commence toujours la manche suivante afin de lui permettre de placer ses cartes faibles.
    """.trimIndent(),
    durationInMinutes = 20,
    difficultyLevel = GameDifficultyLevelModel.MEDIUM,
    end = """
        Le gagnant de la partie est le premier joueur à se débarrasser de toutes ses cartes. Le jeu continue jusqu'à ce qu'il ne reste qu'un joueur avec des cartes. Ce joueur est déclaré "Trou du cul".

        À la fin de chaque partie, les rôles sont redistribués en fonction de l'ordre de victoire, et une nouvelle partie commence.
    """.trimIndent()
)

val canasta = GameModel(
    id = 6,
    name = "Canasta",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.TEAM),
    minPlayer = 2,
    maxPlayer = 6,
    goal = "Le but du jeu est de se débarrasser de toutes ses cartes en formant des combinaisons de même valeur, avec des bonus pour les canastas (combinaisons de 7 cartes).",
    material = "Deux jeux de 54 cartes (avec 4 jokers).",
    howToPlay = """
        Combinaisons :
        À la Canasta, les joueurs forment des combinaisons de cartes de même valeur (exemple : trois valets, quatre 10). Une combinaison de 7 cartes est appelée "canasta". Les cartes spéciales comme les jokers et les 2 remplacent n’importe quelle carte et sont appelées "cartes volantes". Les 3 rouges sont des cartes bonus et les 3 noirs bloquent l'écart (le tas de défausse).

        Distribution :
        Chaque joueur reçoit 11 cartes (13 pour 3 joueurs et 15 pour 2 joueurs). Le reste des cartes constitue le talon, et la première carte est retournée pour former l’écart. Si cette carte est un joker, un 2 ou un 3 rouge, une nouvelle carte est retournée. Si un joueur reçoit un 3 rouge, il le dépose et tire une nouvelle carte.

        Prise de l'écart :
        Au lieu de prendre une carte du talon, un joueur peut prendre l'ensemble de l'écart, à condition qu'il puisse immédiatement utiliser la carte du dessus pour compléter ou former une combinaison. Si l'écart contient un 2 ou un joker, il est "gelé" et ne peut être pris qu'avec une combinaison pure (sans joker ou 2).
        Exemple : Supposons que l'écart (le tas de défausse) contient plusieurs cartes, et la carte du dessus est un 6 de cœur. Un joueur décide de prendre l'écart au lieu de tirer une carte du talon. Il peut le faire parce qu'il a dans sa main un 6 de trèfle et un joker, ce qui lui permet de compléter une nouvelle combinaison (6 de cœur + 6 de trèfle + joker). Si l'écart avait contenu un 2 ou un joker sur le dessus, il aurait été "gelé", et le joueur n'aurait pu prendre l'écart qu'en posant une combinaison pure, comme deux autres 6 sans utiliser de cartes volantes (joker ou 2).

        Déroulement :
        Le joueur commence par tirer une carte du talon ou prendre l'écart, puis il peut poser ou compléter une combinaison. Il termine en se défaussant d'une carte. Le jeu continue dans le sens des aiguilles d’une montre.
        Exemple : Lors de son tour, un joueur tire une carte du talon, un 9 de pique. Il a déjà une combinaison de 9 (9 de cœur, 9 de carreau) sur la table, donc il peut immédiatement compléter cette combinaison en ajoutant son 9 de pique. Ensuite, pour terminer son tour, il se défausse d'une carte, un 4 de trèfle, qu'il pose sur l'écart. Le jeu passe alors au joueur suivant, qui peut soit prendre une carte du talon, soit ramasser l'écart, en fonction de sa main.
        
        Fin de manche :
        La manche se termine lorsqu'un joueur a posé toutes ses cartes. Pour finir, l’équipe doit avoir au moins une canasta complète et le joueur doit obtenir l'accord de son partenaire. Si le talon est épuisé, le jeu continue jusqu'à ce qu'un joueur ne puisse plus jouer.
    """.trimIndent(),
    durationInMinutes = 60,
    difficultyLevel = GameDifficultyLevelModel.HARD,
    end = """
        À la fin de chaque manche, chaque équipe compte ses points en fonction des combinaisons posées et des cartes restantes en main. Une canasta pure (sans joker) vaut 500 points, une canasta impure vaut 300 points. Les jokers et les 2 valent 50 points, les As 20 points, et les cartes de 8 à Roi valent 10 points. Les 3 rouges rapportent 100 points chacun. Le premier camp à atteindre 5000 points gagne la partie.
    """.trimIndent(),
    variants = """
        - Il faut deux canastas pour terminer la partie.
        - Les cartes peuvent être tirées 2 par 2 du talon.
    """.trimIndent()
)

val spikeLady = GameModel(
    id = 7,
    name = "Dame de Pique",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.TRICKS),
    minPlayer = 4,
    maxPlayer = 4,
    goal = "Le but est de totaliser le moins de points à la fin de la partie.",
    material = "Un jeu de 52 cartes.",
    howToPlay = """
        Le jeu se joue à 4 joueurs. Chaque joueur reçoit 13 cartes après distribution. Le but du jeu est d'éviter de prendre des cartes de pénalité. Les cartes de cœur valent 1 point chacune, et la Dame de Pique vaut 13 points. 
        Lors du premier tour, les joueurs échangent 3 cartes avec leurs voisins selon un ordre défini (gauche, droite, face à soi, pas d'échange à chaque quatrième tour).
        
        Le joueur qui possède le 2 de Trèfle commence en jouant cette carte, et chaque joueur doit suivre la couleur (coeur, carreau, trèfle, pique) de la carte qui lui est si possible. Si un joueur ne peut pas suivre, il peut se défausser d'une autre carte. Le joueur ayant joué la carte la plus forte remporte la levée et démarre le tour suivant.
        Exemple :

        Le joueur 1 commence avec le 2 de Trèfle. Les autres joueurs doivent alors jouer une carte de la même couleur, c'est-à-dire un trèfle, s'ils en ont.

        Le joueur 2 joue le 5 de Trèfle.
        Le joueur 3 joue le 8 de Trèfle.
        Le joueur 4, n'ayant pas de trèfle, se défausse de la Dame de Cœur.
        Le joueur 3, ayant joué le 8 de Trèfle (la carte la plus forte parmi les trèfles), remporte la levée. Il commence alors le tour suivant en jouant une nouvelle carte.
   
        Après avoir remporté la levée, le joueur 3 commence un nouveau tour.

        Le joueur 3 joue un 10 de Carreau.
        Le joueur 4, qui a des carreaux, joue un Roi de Carreau.
        Le joueur 1 suit en jouant un 3 de Carreau.
        Le joueur 2 n'a plus de carreaux et se défausse de la Dame de Pique.
        Le joueur 4, ayant joué le Roi de Carreau (la carte la plus forte dans cette couleur), remporte la levée. Il commence alors le tour suivant en jouant une nouvelle carte.

        Lors du premier tour, il est interdit de poser des cartes qui valent des points (cœur ou Dame de Pique). De plus, un joueur ne peut pas démarrer une levée avec un cœur tant que cette couleur n'a pas été jouée par un autre joueur.

        Si un joueur parvient à ramasser tous les cœurs ainsi que la Dame de Pique, il réalise un "Grand Chelem" et inflige 26 points à ses adversaires tout en ne marquant aucun point pour lui-même.
    """.trimIndent(),
    durationInMinutes = 30,
    difficultyLevel = GameDifficultyLevelModel.MEDIUM,
    end = """
        La partie se termine lorsque l'un des joueurs atteint ou dépasse 100 points. Le joueur ayant le moins de points à la fin de la partie est déclaré vainqueur.
    """.trimIndent(),
    variants = """
        Valet de carreau :
        Dans cette variante, le Valet de carreau vaut -10 points. Les joueurs doivent essayer de prendre cette carte sans ramasser la Dame de Pique. Lors d'un Grand Chelem, le Valet de carreau ne compte pas dans les 26 points infligés aux autres joueurs.
        
        Sept de trèfle :
        Dans cette variante, le Sept de trèfle vaut 7 points. Il devient une carte à éviter, en plus de la Dame de Pique. Lors d'un Grand Chelem, le Sept de trèfle ne compte pas dans les 26 points infligés aux autres joueurs.
    """
)

val fiveThousand = GameModel(
    id = 8,
    name = "5000",
    tagList = listOf(GameTagModel.DICE),
    minPlayer = 2,
    maxPlayer = 8,
    goal = "Le but du jeu est d'être le premier joueur à atteindre exactement 5000 points en réalisant des combinaisons de dés.",
    material = "5 dés à 6 faces",
    howToPlay = """
Chaque joueur lance les 5 dés à son tour et tente de marquer des points en réalisant des combinaisons spécifiques.

Pour commencer à comptabiliser les points, un joueur doit "ouvrir", c'est-à-dire marquer au moins 750 points en un seul tour. Une fois ouvert, il n'y a plus de score minimum requis pour marquer des points.

Si un joueur ne marque aucun point lors d'un lancer, il perd tous les points qu'il avait accumulés pendant ce tour, et c'est au joueur suivant de jouer.

Lorsqu'un joueur réussit à obtenir des points sur tous les dés lors d'un lancer, il a la possibilité de relancer tous les dés pour essayer de marquer encore plus. Cependant, comme indiqué précedemment, s'il n'obtient aucun point lors de ce relancer, il perd tous les points accumulés lors de ce tour.

Les combinaisons de dés permettent de marquer des points :
- Un 1 vaut 100 points.
- Un 5 vaut 50 points.
- Un brelan (3 dés identiques) vaut 100 fois la valeur du dé (exemple : un brelan de 3 vaut 300 points). Un brelan de 1 vaut 1000 points.
- Une suite de 1 à 5 vaut 500 points, une suite de 2 à 6 vaut 500 points également.
- Si un joueur réalise cinq 1 en un seul lancer, il remporte immédiatement la partie, peu importe le score des autres joueurs.

Le but est d'atteindre exactement 5000 points pour gagner la partie. Si vous dépassez 5000, votre score est réinitialisé à celui du tour précédent.
    """.trimIndent(),
    durationInMinutes = 30,
    difficultyLevel = GameDifficultyLevelModel.EASY,
    end = """
La partie se termine lorsque l'un des joueurs atteint exactement 5000 points en premier. Ce joueur remporte la partie. 
    """.trimIndent(),
    variants = """
- Si un joueur égale le score d'un autre joueur, celui-ci retombe à son score précédent.
- Si un joueur fait trois tours consécutifs sans marquer de points, il retombe à zéro ou à son score précédent.
- Une variante impose que les gains de points ne soient validés que s'ils sont des multiples de 100. Sinon, le joueur doit relancer.
- Une variante inclut une règle spéciale où un joueur peut prédire le score de ses dés restants après avoir marqué avec trois dés. S'il prédit correctement, il double son score.
    """
)

val solitaire = GameModel(
    id = 9,
    name = "Solitaire",
    tagList = listOf(GameTagModel.CARDS),
    minPlayer = 1,
    maxPlayer = 1,
    goal = "Le but du jeu est de former 4 piles de cartes (une pour chaque couleur) classées dans l'ordre croissant, de l'As au Roi.",
    material = "Un jeu de 52 cartes.",
    howToPlay = """
Le jeu commence avec 7 colonnes de cartes. Seule la dernière carte de chaque colonne est visible, les autres étant face cachée. La première colonne contient une carte, la deuxième deux cartes (une face visible, une face cachée), et ainsi de suite jusqu'à la septième colonne avec six cartes face cachée et une carte face visible. Le reste des cartes forme le talon, qui sert de pioche.

Le but est de compléter quatre piles (une pour chaque couleur : ♠, ♥, ♦, ♣), en commençant par les As et en allant jusqu'au Roi, dans l'ordre croissant. Ces piles doivent être formées au-dessus des colonnes.

Vous pouvez déplacer les cartes visibles entre les colonnes selon les règles suivantes :
- Une carte peut être placée sur une autre si elle est d'une couleur différente (alternant entre rouge et noir) et immédiatement inférieure en valeur. Par exemple, un 7 de cœur peut être placé sur un 8 de trèfle.
- Les cartes cachées sont retournées lorsque la carte visible au-dessus est déplacée.
- Si une colonne devient vide, un Roi ou une séquence commençant par un Roi peut y être placée.

Lorsque vous ne pouvez plus déplacer de cartes entre les colonnes, vous pouvez utiliser le talon. Le talon distribue des cartes une par une ou par trois, selon la variante que vous choisissez. Seule la carte supérieure du talon peut être jouée, soit sur les piles à compléter, soit sur les colonnes.

L'objectif est de déplacer toutes les cartes vers les piles en commençant par les As, puis en suivant l'ordre croissant (As, 2, 3... jusqu'au Roi) pour chaque couleur.

Si vous êtes bloqué et ne pouvez plus faire de mouvements, vous pouvez retourner au talon et continuer à chercher des mouvements jusqu'à ce que toutes les cartes soient placées ou qu'aucun autre coup ne soit possible.
    """.trimIndent(),
    durationInMinutes = 15,
    difficultyLevel = GameDifficultyLevelModel.MEDIUM,
    end = """
Vous gagnez la partie si vous réussissez à compléter les 4 piles de chaque couleur, de l'As au Roi. Cependant, il est possible de se retrouver bloqué sans pouvoir déplacer de carte, dans ce cas la partie se termine sans victoire.
    """.trimIndent(),
    variants = """
- Variante avec distribution d'une carte : vous pouvez jouer avec un talon distribuant les cartes une par une plutôt que par trois, ce qui rend le jeu plus facile.
- Une variante consiste à jouer avec des jokers, en les considérant comme des cartes passe-partout, pouvant être placées à tout moment dans les colonnes ou les piles.
    """
)

val elevator = GameModel(
    id = 10,
    name = "Ascenseur",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.TRICKS),
    minPlayer = 4,
    maxPlayer = 6,
    goal = "Le but est d'avoir le plus de points en respectant le contrat annoncé au début de chaque manche",
    material = "Un jeu de 52 cartes",
    howToPlay = """
Le jeu se déroule sur plusieurs manches, où le nombre de cartes distribuées augmente progressivement, puis diminue lors des manches suivantes. 
Les cartes vont donc être distribuées ainsi :

Manche 1 : 1 carte
Manche 2 : 2 cartes
…
Manche 13 : 13 cartes (sans atout)
Manche 14 : 12 cartes
Manche 15 : 11 cartes
...
Manche 25 : 1 carte
Puis, on redescend à 1 carte lors de la 25e manche.

Il peut y avoir un nombre de manches différents en fonction du nombre de joueurs.

Lors de chaque manche, les joueurs annoncent le nombre de levées qu'ils pensent pouvoir remporter. Le dernier joueur à faire son annonce ne peut pas choisir un nombre de levées qui rendrait le total des annonces égal au nombre de levées possibles. 

Exemple: si trois joueurs ont déjà annoncé 2, 3 et 2 levées dans un tour où 8 levées sont possibles, le dernier joueur doit annoncer soit plus soit moins d'une levée que le total de 7 annoncé.

Après les annonces, le jeu se déroule selon le principe des levées : 
Dans le sens des aiguilles d'une montre et chacun son tour, chaque joueur doit jouer une carte de la couleur demandée, et s'il ne peut pas suivre, il peut jouer un atout ou une autre carte. L'atout est déterminé par la première carte retournée de la pioche après la distribution. Si un joueur n'a pas d'atout, il peut jouer une autre carte. La carte la plus forte dans la couleur jouée ou l'atout remporte la levée. Le joueur qui remporte la levée lance la suivante.

Exemple de levée avec atout avec atout Cœur et 5 cartes distribuées par personne

Le premier joueur commence en jouant un 9 de Trèfle.
Le deuxième joueur, n'ayant pas de Trèfle, joue un 8 de Cœur (qui est un atout).
Le troisième joueur possède un As de Trèfle, il doit jouer dans la couleur demandée, donc il joue son As de Trèfle.
Le quatrième joueur n'a pas de Trèfle non plus, mais possède un Valet de Cœur (atout). Il joue cette carte.
Comme les Cœurs sont les atouts, le Valet de Cœur l'emporte sur toutes les autres cartes. Le quatrième joueur remporte donc la levée et commence la prochaine levée.

Deuxième exemple de levée avec atout avec atout Cœur et 5 cartes distribuées par personne

Le premier joueur joue un 7 de Pique.
Le deuxième joueur suit avec un 10 de Pique.
Le troisième joueur n'ayant pas de Pique, se défausse d'un 3 de Carreau.
Le quatrième joueur, ayant un Roi de Pique, joue cette carte.
Le Roi de Pique est la carte la plus forte dans la couleur demandée (Pique), donc le quatrième joueur remporte la levée et commence la levée suivante.
        
Lors de la manche où le maximum de cartes est distribué (13 cartes à 4 joueurs), il n'y a pas d'atout et la manche est jouée en "sans atout".

Chaque nouvelle manche est dirigée par un nouveau donneur choisit dans le sens des aiguilles d'une montre.
    """.trimIndent(),
    durationInMinutes = 60,
    difficultyLevel = GameDifficultyLevelModel.MEDIUM,
    end = """
Chaque joueur marque des points selon s'il a respecté son contrat ou non. Un joueur ayant réalisé exactement le nombre de levées annoncées marque 1 point de plus que le nombre de levées faites. 
Exemple :  s'il annonce 3 levées et en fait 3, il marque 4 points. 

Un joueur ayant échoué dans son contrat perd autant de points que la différence entre son annonce et le nombre de levées réalisées. 
Exemple : s'il annonce 4 levées mais n'en fait que 2, il perd 2 points.
Exemple 2 : s'il annonce 2 levées et en fait 4, il perd 2 points

La partie se termine à la fin de la dernière manche, et le joueur avec le plus grand nombre de points remporte la partie.
    """.trimIndent(),
)

val tamalou = GameModel(
    id = 11,
    name = "Tamalou",
    tagList = listOf(GameTagModel.CARDS),
    minPlayer = 2,
    maxPlayer = 6,
    goal = "Le but du jeu est d'obtenir le moins de points possible à la fin de la partie.",
    material = "Un jeu de 54 cartes",
    howToPlay = """
Le jeu se déroule en plusieurs manches. Chaque joueur reçoit 4 cartes qu'il dispose en carré devant lui, faces cachées. Avant le début de la partie, les joueurs prennent connaissance de deux de leurs cartes et doivent s'en souvenir. La pioche est placée au centre avec une défausse à côté.

À chaque tour, un joueur pioche une carte, qu'il peut soit :
- La placer dans la défausse (et utiliser son pouvoir, si applicable),
- L'échanger avec une de ses cartes en jeu, en défaussant la carte remplacée.

À tout moment, un joueur peut jeter une, deux ou trois cartes de même valeur que celle visible dans la défausse, issues des cartes disposées devant lui. Si plusieurs joueurs ont une carte de même valeur à jeter, le plus rapide l’emporte ; le plus lent replace sa carte dans son jeu. En cas d’erreur d’appariement, le joueur concerné pioche une nouvelle carte, qu’il ajoute à sa disposition.

Exemple : Supposons que la carte visible dans la défausse soit un 9. Le joueur 1 possède deux cartes de valeur 9 devant lui, tandis que le joueur 2 en a également une. Lors du tour, dès que la carte 9 est posée dans la défausse, les deux joueurs peuvent essayer de jeter leurs cartes de même valeur le plus rapidement possible. Le joueur 1, plus rapide, réussit à jeter ses deux cartes 9 sur la défausse, réduisant ainsi ses cartes en jeu. Le joueur 2, étant plus lent, doit replacer son 9 dans son jeu.
Si un joueur se trompe et tente de jeter une carte d’une autre valeur, par exemple un 8 au lieu d’un 9, il pioche immédiatement une nouvelle carte et l’ajoute à son carré sans la regarder, augmentant ainsi ses points potentiels.

 Chaque joueur cherche à minimiser la valeur de ses cartes tout au long de la manche. Lorsqu'un joueur pense que la somme de ses cartes est inférieure ou égale à 5 points, il peut annoncer un "Tamalou", ce qui déclenche un dernier tour pour les autres joueurs.

 À la fin d'une manche, chaque joueur révèle ses cartes et compte ses points. Le joueur ayant le moins de points remporte la manche. Si un joueur annonce un Tamalou et a effectivement 5 points ou moins, il ne marque aucun point. Si un autre joueur a moins de points ou égale son score, ils ne marquent pas non plus de points.

 Les pouvoirs des cartes défaussées sont les suivants :
 - 7, 8 : Le joueur peut regarder une de ses propres cartes puis la replacer face cachée.
 - 9, 10 : Le joueur peut regarder une des cartes de son adversaire puis la replacer face cachée.
 - Valets, Dames : Le joueur peut échanger une carte de son jeu avec une carte du jeu d'un adversaire, sans que ni l'un ni l'autre ne voient les cartes échangées.
 - Rois noirs (♠, ♣) : Le joueur peut regarder une carte d'un adversaire et ensuite échanger cette carte avec une de ses cartes.
 - Rois rouges (♥, ♦) : Valeur de 0 point, mais sans pouvoir spécial.
 - Joker : Le joueur peut choisir de prendre une carte supplémentaire et l'ajouter à son jeu sans la regarder, augmentant ainsi son risque.
    """.trimIndent(),
    durationInMinutes = 20,
    difficultyLevel = GameDifficultyLevelModel.MEDIUM,
    end = """
        La partie se termine après un nombre de manches déterminé à l'avance. Le joueur ayant cumulé le moins de points à la fin de toutes les manches est déclaré vainqueur.
    """.trimIndent()
)

val yahtzee = GameModel(
    id = 12,
    name = "Yahtzee (ou Yam's)",
    tagList = listOf(GameTagModel.DICE),
    minPlayer = 1,
    maxPlayer = 4,
    goal = "Le but du jeu est de réaliser les meilleures combinaisons possibles en lançant les dés, afin de marquer le maximum de points à la fin des 13 tours.",
    material = "5 dés, une feuille de score, un stylo.",
    howToPlay = """
        Chaque joueur dispose de 3 lancers par tour pour tenter de réaliser une combinaison. Lors du premier lancer, le joueur jette tous les dés. Après ce lancer, il peut soit marquer son score immédiatement, soit choisir de relancer certains dés ou tous les dés pour améliorer son résultat. Après les 3 lancers, il est obligé de noter son score dans une case de la fiche de score ou de barrer une combinaison. Si aucune combinaison ne peut être réalisée, il doit barrer une case.

        Une partie se déroule sur 13 tours, chaque tour correspondant à une des combinaisons de la fiche de score. Le joueur marque des points selon les combinaisons qu'il a réussies et remplit les cases correspondantes sur sa feuille.

        Les combinaisons à réaliser sont divisées en deux sections :
        
        Section haute :
        - As : Marquez la somme des dés de valeur 1.
        - Deux : Marquez la somme des dés de valeur 2.
        - Trois : Marquez la somme des dés de valeur 3.
        - Quatre : Marquez la somme des dés de valeur 4.
        - Cinq : Marquez la somme des dés de valeur 5.
        - Six : Marquez la somme des dés de valeur 6.
        Bonus : Si la somme des scores dans cette section atteint ou dépasse 63 points, un bonus de 35 points est attribué.
        
        Section basse :
        - Brelan : 3 dés identiques, score = somme des 5 dés.
        - Carré : 4 dés identiques, score = somme des 5 dés.
        - Full : 3 dés identiques et 2 dés identiques, score = 25 points.
        - Petite suite : 4 dés qui se suivent, score = 30 points.
        - Grande suite : 5 dés qui se suivent, score = 40 points.
        - Yahtzee (Yam's) : 5 dés identiques, score = 50 points.
        - Chance : Addition des 5 dés, quelle que soit la combinaison obtenue.
        
        Si un joueur réalise un deuxième Yahtzee (5 dés identiques) après avoir déjà marqué 50 points dans la case Yahtzee, il reçoit un bonus de 100 points, mais doit barrer une autre case encore disponible. Ce bonus peut s'appliquer plusieurs fois.
        
        Le joueur doit remplir ou barrer une case de la fiche à chaque tour. Si aucune combinaison n'est possible, il devra inscrire un 0 dans une case.
    """.trimIndent(),
    durationInMinutes = 30,
    difficultyLevel = GameDifficultyLevelModel.EASY,
    end = """
        La partie se termine lorsque tous les joueurs ont rempli ou barré toutes les cases de leur fiche de score. Les points de chaque joueur sont additionnés. Le gagnant est celui ayant accumulé le plus de points, en tenant compte des bonus et des sections haute et basse.
    """.trimIndent(),
    variants = """
       Variante « plus et moins » : 
       En remplacement de la case « Chance », deux nouvelles figures sont ajoutées. La figure « plus » est la somme des cinq dés sans condition particulière, tandis que la figure « moins » soustrait la somme des cinq dés du score total.
       
       Brelan, carré et full modifiés :
       Dans cette variante, le brelan rapporte 10 points additionnés à la somme des trois dés identiques, le carré rapporte 20 points additionnés à la somme des quatre dés identiques, et le full rapporte 10 points additionnés à la somme des cinq dés.
       
       Variante « complexe » : 
       Le joueur doit compléter trois colonnes, chacune avec les mêmes figures que dans la version classique. La première colonne doit être complétée dans l'ordre ascendant, la deuxième dans l'ordre descendant, et la troisième peut être remplie librement. Une quatrième colonne, dite « sec », peut être ajoutée, dans laquelle le joueur n'a droit qu'à un seul lancer par tour.
    """.trimIndent()
)

val kems = GameModel(
    id = 13,
    name = "Kem's",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.TEAM),
    minPlayer = 4,
    maxPlayer = 8,
    goal = "Former un carré de 4 cartes identiques et le faire deviner à son partenaire via un signe secret.",
    material = "Un jeu de 52 cartes (ou 32 cartes pour 4 joueurs), un papier et un crayon pour le score.",
    howToPlay = """
        Le Kem's se joue en équipe de 2 joueurs. Chaque équipe choisit un signe secret en début de partie, que les partenaires utiliseront pour se signaler discrètement qu'ils ont réuni 4 cartes identiques.

        Le donneur distribue 4 cartes à chaque joueur, puis étale 4 cartes supplémentaires au centre de la table. Quand il dit « top », les joueurs peuvent échanger leurs cartes avec celles du centre. Ils doivent poser une carte de leur main avant d'en prendre une du centre, et doivent toujours conserver 4 cartes en main.

        Le but est de former un carré (4 cartes identiques). Lorsqu'un joueur réussit, il fait le signe secret à son partenaire. Si ce dernier le voit, il crie « Kem's » et l'équipe marque 1 point. Si les deux partenaires ont chacun un carré, ils peuvent crier « double Kem's » pour marquer 2 points.

        Les adversaires peuvent crier « Contre-Kem's » s'ils devinent le signe secret d'une équipe. Si cela est correct, l'équipe qui a crié « Contre-Kem's » gagne 1 point. En cas d'erreur, le joueur fautif doit montrer 2 cartes et ne peut plus dire « Contre-Kem's » jusqu'à la fin de la manche.

        Le jeu continue avec des phases de « balayage » où les cartes non échangées sont mises de côté dans la « poubelle » et 4 nouvelles cartes sont posées sur la table. Lorsque toutes les cartes ont été utilisées, les cartes de la « poubelle » sont mélangées et deviennent la nouvelle pioche.
    """.trimIndent(),
    durationInMinutes = 20,
    difficultyLevel = GameDifficultyLevelModel.MEDIUM,
    end = """
        La partie se termine lorsqu'un nombre de points fixé au départ est atteint (par exemple, 10 points). L'équipe avec le plus de points gagne la partie.
    """.trimIndent(),
)

val nightyNine = GameModel(
    id = 14,
    name = "99",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.DRINKS),
    minPlayer = 2,
    maxPlayer = 8,
    goal = "Le but du jeu est d'additionner des cartes sans jamais dépasser 99 ou une sanction tombera !",
    material = "Un jeu de 52 cartes.",
    howToPlay = """
        Chaque joueur reçoit 2 cartes au début de la partie et doit en avoir 2 tout au long du jeu. Le but est de faire monter le compte total jusqu'à 99 sans le dépasser.

        À chaque tour, les joueurs posent une carte de leur main et annoncent à voix haute le nouveau compte. Le jeu se poursuit jusqu'à ce qu'un joueur dépasse le compte de 99.

        Les valeurs des cartes sont les suivantes :
        - De 2 à 10 : les cartes valent leurs valeurs numériques.
        - Valet : -10 du compte.
        - Dame : le sens du jeu change.
        - Roi : le compte va directement à 70 ou retourne à 70.
        - As : vaut 1 ou 11, au choix du joueur.
        - Joker : le joueur choisit une valeur entre 1 et 9.

        Les joueurs doivent piocher une carte après chaque tour pour maintenir 2 cartes en main.
        
        Des pénalités sont infligées pour certaines erreurs :
        - Si un joueur oublie de piocher une carte avant que le joueur suivant joue, il reçoit une pénalité de 2.
        - Si un joueur se trompe dans le calcul du compte, il reçoit une pénalité de 2.
        - Si un joueur demande quel est le compte, il reçoit une pénalité de 2.
        
        Lorsqu'un joueur pose une carte qui fait arriver le compte à une dizaine (10, 20, 30, etc.), il peut distribuer des pénalités à ses adversaires. Le nombre de pénalités correspond à la dizaine atteinte (par exemple, 60 = 6 pénalités).
    """.trimIndent(),
    durationInMinutes = 15,
    difficultyLevel = GameDifficultyLevelModel.EASY,
    end = """
        La partie se termine lorsque le compte dépasse 99. Le joueur qui dépasse le compte doit recevoir 2 pénalités plus un nombre supplémentaire égal à l'excédent (par exemple, si le compte est 105, il reçoit 2 + 6 = 8 pénalités).
    """.trimIndent(),
    variants = """
        Il est possible d'ajouter d'autres règles pour rendre le jeu plus complexe, comme des cartes spéciales qui annulent les pénalités ou des variantes sur les valeurs des cartes.
    """.trimIndent()
)

val pyramid = GameModel(
    id = 15,
    name = "Pyramide",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.DRINKS),
    minPlayer = 3,
    maxPlayer = 8,
    goal = "Le but est d'éviter de subir trop de pénalités et d'en donner un maximum durant les 2 phases de ce jeux.",
    material = "Un jeu de 54 cartes.",
    howToPlay = """
        Le jeu est divisé en 2 phases 

        Phase 1 : Distribution des cartes de base
        1. Le croupier mélange les cartes et demande à chaque joueur, dans le sens des aiguilles d'une montre, "rouge ou noir ?" pour deviner la couleur de la carte qu'il va recevoir. Si le joueur se trompe, il reçoit une pénalité.
        2. Au second tour, le croupier demande "plus haut ou plus bas ?" et les joueurs doivent deviner si la prochaine carte sera supérieure ou inférieure à leur première. Si un joueur se trompe, il reçoit une pénalité. Si les deux cartes sont identiques, une nouvelle carte est distribuée.
        3. Au troisième tour, le croupier demande "intérieur ou extérieur ?", demandant aux joueurs de deviner si la prochaine carte sera entre les deux premières ou en dehors de l'intervalle. Si un joueur se trompe, il reçoit une pénalité.
        4. Au dernier tour de cette phase, les joueurs doivent deviner la couleur (♠, ♣, ♥ ou ♦) de la prochaine carte. Une bonne réponse leur permet de distribuer 5 pénalités aux autres joueurs, sinon, ils reçoivent une pénalité.

        Phase 2 : Pyramide
        Le croupier construit une pyramide de cartes face cachée, avec 5 cartes à la base, puis 4, 3, 2, et enfin 1 carte au sommet.
        
        Chaque joueur garde ses cartes distribuées secrètes. À chaque carte retournée dans la pyramide, un joueur peut annoncer qu'il possède cette carte, que ce soit vrai ou non, et distribuer un nombre de pénalités correspondant à la rangée où la carte se trouve. S'il possède ou dit posséder deux fois cette carte, il peut doubler le nombre de pénalités distribuées.

        Cependant, tout autre joueur peut contester cette annonce en disant "menteur". Si l'annonceur mentait et ne possédait pas la carte, il prend le double des pénalités qu'il souhaitait distribuer. Si l'annonceur disait la vérité et qu'il avait bien la carte, c'est le joueur qui a dit "menteur" qui prend le double des pénalités.

        Plus on monte dans la pyramide, plus les pénalités sont importantes : 1 pénalité par carte dans la rangée du bas, 2 pénalités dans la rangée suivante, et ainsi de suite jusqu'à 5 pénalités pour la carte du sommet. Le joueur peut choisir à qui distribuer les pénalités.     
    """.trimIndent(),
    durationInMinutes = 30,
    difficultyLevel = GameDifficultyLevelModel.EASY,
    end = """
        Le jeu se termine quand toutes les cartes de la pyramide ont été retournées
    """.trimIndent(),
    variants = """
        A la fin du jeu, vous pouvez rajouter une étape supplémentaire : 
        
        Chacun leur tour, les joueurs vont dévoiler leur jeu à tout leur adversaire en annoncant la carte juste avant de la retourner. Le joueur prend la pénalité ultime si il fait la moindre erreur.
        
        Exemple: Le joueur 1 annonce "2♠" et retourne sa première carte qui est un 2♠. Il annonce "3♦" et retourne sa deuxième carte qui est un 3♦. Il annonce "4♣" er retourne sa troisième carte mais c'est un 7♦. Il a fait une erreur et prend la pénalité.
    """.trimIndent()
)

val fuckTheDealer = GameModel(
    id = 16,
    name = "Fuck the Dealer",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.DRINKS),
    minPlayer = 3,
    maxPlayer = 8,
    goal = "Le but du jeu est de deviner correctement les cartes pour éviter de recevoir des pénalités, tout en tentant de faire perdre le dealer.",
    material = "Un jeu de 52 cartes.",
    howToPlay = """
        Un joueur est désigné comme le dealer. Le dealer prend le paquet de cartes face cachée et demande au premier joueur de deviner la première carte tirée. Le joueur a deux chances pour deviner correctement :
        
        1ère chance : Si le joueur devine la bonne valeur dès le premier coup, le dealer perd et reçoit un nombre de pénalités égal à la valeur de la carte (exemple : un valet = 11 pénalités, une dame = 12 pénalités, etc). Si le joueur se trompe, le dealer lui indique si la vraie valeur est plus haute ou plus basse.
        
        2ème chance : Si le joueur devine correctement à la deuxième tentative, le dealer reçoit des pénalités égales à la moitié de la valeur de la carte (arrondi au supérieur). Si le joueur se trompe encore, il doit prendre des pénalités égales à la différence entre la valeur annoncée et la vraie valeur de la carte. 
        Exemple : le joueur dit 7 et la carte est un valet, il doit prendre 11-7 = 4 pénalités.
        
        Les cartes utilisées sont ensuite placées face visible sur la table, triées par valeur pour que tous les joueurs puissent voir quelles cartes restent dans le paquet. Le tour passe au joueur suivant.

        Changement de dealer : Le changement de dealer dépend de la règle que vous aurez établie avant de commencer. Quelques exemples de règles :
        - Le dealer change après 3 pertes consécutives.
        - Le dealer change après avoir perdu 3 fois au total.
        - Le dealer change après avoir distribué à chaque joueur une fois.
        - Le dealer change après 3 victoires consécutives.
        
        Vous pouvez aussi choisir de tirer au sort le prochain joueur ou de changer le dealer après chaque tour selon vos préférences.
    """.trimIndent(),
    durationInMinutes = 20,
    difficultyLevel = GameDifficultyLevelModel.EASY,
    end = """
        La partie se termine quand toutes les cartes du paquet ont été placées face visible sur la table.
    """.trimIndent()
)

val shoshoi = GameModel(
    id = 17,
    name = "Shoshoï",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.DRINKS),
    minPlayer = 4,
    maxPlayer = 8,
    goal = "Le but est de respecter les règles définies au cours de la partie pour éviter de recevoir des pénalités.",
    material = "Un jeu de 52 cartes.",
    howToPlay = """
        Un maître du jeu, désigné au préalable prend le paquet de carte et tire les cartes une à une du paquet.
        
        Chaque carte applique un effet à un joueur.  
        
        La carte est ensuite défaussée et le maître du jeu tire la carte suivante pour le joueur suivant.

        Exemple : Le maître du jeu commence par tirer une carte du paquet. Par exemple, il tire le 4♥ et annonce la carte à voix haute. Le joueur 1 est désigné pour ce tour et applique l'effet correspondant de la carte tirée. Une fois l'effet appliqué, la carte est défaussée. Le maitre du jeu tire une nouvelle carte dont l'effet s'applique pour le joueur 2 etc...

        Effets des cartes :
        - As à 5 Rouge : Si un joueur tire une carte rouge (♦ ou ♥), il distribue un nombre de pénalités égal à la valeur de la carte (ex : un 2 de ♥ permet de donner 2 pénalités).
        - As à 5 Noir : Si la carte tirée est noire (♠ ou ♣), le joueur reçoit une pénalité équivalente à la valeur de la carte.
        - 6 : Le joueur devient "SnakeEyes" et conserve ce statut jusqu'à ce qu'un autre joueur tire un 6. Tant qu'il est SnakeEyes, toute personne qui le regarde dans les yeux reçoit une pénalité.
        - 7 : Le joueur précédent prend une pénalité.
        - 8 : Le joueur choisit un thème (exemple : marques de vêtements, fruits, sports, etc.) et propose un mot dans ce thème. Les autres joueurs doivent, à tour de rôle, proposer un nouveau mot dans ce thème. Celui qui échoue à trouver un mot unique reçoit une pénalité.
        - 9 : Le joueur qui tire cette carte doit inventer une nouvelle règle qui s'imposera à tous les joueurs jusqu'à la fin de la partie. (Exemple : parler avec un accent ou ajouter une phrase à la fin de chaque intervention). Chaque manquement à la règle entraînera une pénalité pour le joueur fautif.
        - 10 : Tous les joueurs doivent se lever, crier "Shoshoï!", le dernier à effectuer cette action prend une pénalité.
        - Valet : Le joueur qui tire cette carte peut désigner un autre joueur qui deviendra son "petit frère". Ce dernier prendra une pénalité à chaque fois que le joueur ayant tiré le valet prendra une pénalité. Attention, l'inverse n'est pas vrai. Exemple : (Joueur 1 tire le valet et choisit joueur 2 en tant que petit frère. Si le joueur 1 prend une pénalité, alors le joueur 2 doit aussi en prendre une. Mais si le joueur 2 prend une pénalité, le joueur 1, lui, n'en prend pas).
        - Dame : Le joueur qui tire cette carte devient la "Reine des questions" et conserve ce statut jusqu'à ce qu'un autre joueur tire une dame. Si un joueur répond à une question de la reine des questions, il prend une pénalité.
        - Roi : Pour les trois premiers rois tirés, une pénalité est placée dans un verre au centre de la table. Le joueur qui tire le quatrième roi doit boire le contenu du verre et reçoit toutes les pénalités accumulées.
    """.trimIndent(),
    durationInMinutes = 20,
    difficultyLevel = GameDifficultyLevelModel.EASY,
    end = """
        Le jeu se termine après que toutes les cartes ont été défaussées.
    """.trimIndent()
)

val sevenAndHalf = GameModel(
    id = 18,
    name = "7.5",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.DRINKS),
    minPlayer = 2,
    maxPlayer = 10,
    goal = "Le but est d'atteindre ou de s'approcher le plus possible de 7 et demi avec la valeur de ses cartes, sans jamais dépasser ce total. Ce jeu est un dérivé du Black Jack",
    material = "Un jeu de 52 cartes",
    durationInMinutes = 20,
    difficultyLevel = GameDifficultyLevelModel.MEDIUM,
    howToPlay = """
        Chaque joueur commence avec une carte face cachée. Le banquier (joueur désigné comme tel) traite avec les joueurs un par un. 
        
        Valeur des cartes :
        - Les cartes de 1 à 7 conservent leur valeur numérique.
        - Les Valets, Dames et Rois valent 0.5 point chacun.
        - Le 8 vaut 0.
        - Les cartes 9 et 10 sont retirées du jeu.

        Déroulement d'un tour :
        Le banquier propose des cartes aux joueurs. Les joueurs peuvent demander des cartes supplémentaires une à une, en les recevant face visible. Le but est de s'approcher de 7 et demi sans jamais dépasser cette valeur. À tout moment, un joueur peut décider de s'arrêter s'il pense être proche du 7 et demi.

        Une fois que chaque joueur a terminé de demander des cartes ou de s'arrêter, le banquier joue. 
        
        Dans un premier temps, le banquier doit deviner si parmi les joueurs qui viennent de jouer, certains ont dépassé 7.5. Si il pense qu'un joueur a dépassé, il le désigne. Si le joueur a effectivement dépassé, alors il prend une pénalité et sort du jeu. Sinon, c'est le banquier qui prend une pénalité.
        
        Puis dans un second temps, Il demande des cartes à son tour et s'arrêter quand il le souhaite. Si le banquier dépasse 7 et demi, il perd contre tous les joueurs encore en jeu et prend une pénalité par joueur contre qui il a perdu.

        Règles supplémentaires :
        - En cas d'égalité entre un joueur et la banque, c'est la banque qui l'emporte.
        
        Exemple d'une manche : 
        
        Distribution des cartes : Chaque joueur reçoit une carte face cachée. Joueur 1 reçoit un 4, Joueur 2 un 5, et Joueur 3 un Roi (qui vaut 0.5).
        
        Joueur 1 joue : Il demande une carte supplémentaire et obtient un 2, ce qui lui fait un total de 6. Il décide de s’arrêter là.
        
        Joueur 2 joue : Il demande également une carte et reçoit un Valet (valeur de 0.5). Son total est de 5.5. Il décide de prendre encore une carte et reçoit un 3, ce qui le fait atteindre 8.5. Il dépasse 7.5 et s'arrête de jouer. Le banquier ne sait pas qu'il a dépassé.
        
        Joueur 3 joue : Il décide de prendre une carte et obtient un 6, ce qui le fait atteindre 6.5. Il choisit de s’arrêter.

        Le Banquier joue : Le Banquier tente de deviner qui parmi les joueurs a dépassé 7.5. Il tente de désigner Joueur 2, qui a effectivement 8.5. Joueur 2 prend une pénalité et sort du jeu.
        
        Le Banquier continue : Le Banquier décide de jouer pour lui-même. Il commence avec un 3 face cachée et prend une carte supplémentaire, un 4, ce qui fait un total de 7. Il choisit de s’arrêter là. Il révèle son total à Joueur 1 et Joueur 3.
        
        Résultats : Joueur 1 a 6, Joueur 3 a 6.5, et le Banquier a 7. Le Banquier gagne contre Joueur 1 et Joueur 3 car leur total est inférieur au sien, donc ils prennent chacun une pénalité.
    """.trimIndent(),
    end = """
        Le jeu n'a pas vraiment de fin et se finit quand les joueurs ont en décidé ainsi.
    """.trimIndent()
)

val threeMan = GameModel(
    id = 19,
    name = "Three Man",
    tagList = listOf(GameTagModel.DICE, GameTagModel.DRINKS),
    minPlayer = 3,
    maxPlayer = 6,
    goal = "Le but est de suivre les règles définies par les résultats des dés et de distribuer ou prendre des pénalités en fonction des résultats.",
    material = "Deux dés à six faces.",
    howToPlay = """
        Désignation du Three Man :
        
        Pour commencer, chaque joueur lance un dé à tour de rôle. Le premier joueur à obtenir un 3 devient le "Three Man". Ce joueur peut porter un objet distinctif (comme un chapeau) pour signaler son rôle. 

        Puis à tour de rôle, les joueurs vont lancer les dés autant de fois que ces dés produiront un effet cité ci-dessous. Si les dés ne produise pas d'effet, on passe au joueur suivant.

        Effets des dés 
        
        - Trois : Si le résultat total des dés est 3, ou si l'un des dés affiche un 3, le Three Man doit prendre une pénalité.
        - Sept : Si la somme des dés est de 7, le joueur à gauche de celui qui a lancé les dés doit prendre une pénalité. Si les dés affichent 3 et 4, le Three Man doit aussi boire.
        - Dix : Si le résultat des dés est 10, cela déclenche un "social" : tous les joueurs prennent une pénalité.
        - Onze : Si la somme des dés est de 11, le joueur à droite de celui qui a lancé les dés prend une pénalité.
        - Doubles : Si un joueur lance des doubles (par exemple 2-2, 3-3), il peut donner les dés à un ou deux autres joueurs, qui doivent les relancer et appliquer les résultats. Si ce relancer donne à nouveau un double, le joueur original qui a lancé les premiers doubles doit prendre une pénalité correspondant à la somme des dés.

        Changement du Three Man :
        Après que tous les joueurs ont lancé les dés, y compris le Three Man, la désignation d'un nouveau Three Man recommence comme décrit ci-dessus.
    """.trimIndent(),
    durationInMinutes = 20,
    difficultyLevel = GameDifficultyLevelModel.EASY,
    end = """
        Le jeu se termine lorsque les joueurs en décident ainsi, ou lorsqu'il n'y a plus de pénalités à attribuer !
    """.trimIndent()
)

val rami = GameModel(
    id = 20,
    name = "Rami",
    tagList = listOf(GameTagModel.CARDS),
    minPlayer = 2,
    maxPlayer = 5,
    goal = "Le but du jeu est de se débarrasser de toutes ses cartes en formant des combinaisons avant les autres joueurs. Le joueur ayant le moins de points à la fin de la partie gagne.",
    material = "2 jeux de 52 cartes, jokers inclus.",
    durationInMinutes = 30,
    howToPlay = """
        Chaque joueur reçoit 13 cartes distribuées une par une dans le sens inverse des aiguilles d'une montre. Les cartes restantes forment la pioche, et la première carte est retournée pour commencer la défausse.
        
        Dans les règles du rami, les joueurs ne peuvent poser leurs cartes que lorsqu’ils ont une combinaison qui atteint 51 points et qu’elle inclut une « tierce franche », c'est-à-dire une suite de trois cartes consécutives minimum (sans joker). Il n'y a pas de limite de tours : un joueur doit attendre jusqu'à ce qu'il puisse poser cette combinaison. 

        Exemple : Si vous avez dans votre main une suite composée de "5♥, 6♥, 7♥" et une autre combinaison, par exemple un brelan de "8♠, 8♣, 8♦", vous pourrez poser ces combinaisons car la suite "5♥, 6♥, 7♥" forme une tierce franche. Ces deux combinaisons atteignent un total de 51 points (5+6+7+8+8+8 = 51 points). Cependant, si vos combinaisons ne totalisent pas 51 points ou si vous n'avez pas de tierce franche, vous devrez continuer à piocher et attendre jusqu'à ce que vous puissiez poser.

        Une fois cette condition remplie, à chaque tour, un joueur peut :
           - Piocher une carte de la pioche ou de la défausse.
           - Former des combinaisons valides et les poser. Les combinaisons valides sont les suivantes: 
               - Brelan : Trois cartes de la même valeur, comme trois "7" (Exemple: 7♠, 7♣, 7♦).
               - Carré : Quatre cartes de la même valeur, comme quatre "5" (Exemple: 5♠, 5♣, 5♦, 5♥).
               - Séquence (Suite) : Trois cartes ou plus de la même couleur et consécutives, comme "3-4-5-6" de cœur (Exemple: 3♥, 4♥, 5♥, 6♥).
           - Ajouter des cartes à des combinaisons déjà posées. (Exemple: Si une séquence de "7♠, 8♠, 9♠" est déjà posée sur la table, vous pouvez ajouter "10♠" à cette séquence. De même, si un joueur a posé un brelan de "4♣, 4♦, 4♥", vous pouvez ajouter "4♠" pour compléter un carré.)
           - Se défausser d'une carte pour terminer son tour.
    """.trimIndent(),
    end = """
        Une manche se termine lorsqu'un joueur se débarrasse de toutes ses cartes. Les autres joueurs comptent alors les points des cartes restantes dans leur main et le joueur ayant accumulé le moins de points gagne.
       
        - Les cartes de 2 à 10 valent leur valeur nominale.
        - Les figures (Valet, Dame, Roi) valent 10 points.
        - L'As peut valoir 1 ou 11 points, selon sa position dans la combinaison.
        - Le joker remplace n'importe quelle carte et prend sa valeur.
        
        La partie se termine quand un joueur atteint ou dépasse les 1000 points.
    """.trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.MEDIUM
)

val crapette = GameModel(
    id = 22,
    name = "Crapette",
    tagList = listOf(GameTagModel.CARDS),
    minPlayer = 2,
    maxPlayer = 2,
    goal = "Le but du jeu est de se défaire de toutes ses cartes avant son adversaire en les plaçant dans les piles centrales ou dans le tableau, en respectant les règles de placement.",
    material = "2 jeux de 52 cartes avec des dos différents.",
    durationInMinutes = 45,
    howToPlay = """
La Crapette se joue à deux joueurs, chacun ayant un paquet de 52 cartes. Voici les étapes de préparation et de déroulement du jeu :

Préparation:
- Chaque joueur mélange son paquet, le donne à couper à son adversaire, puis tire les 13 premières cartes pour former une pile appelée « Crapette », placée à sa droite.
- Il tire ensuite 4 cartes visibles qu’il dispose verticalement au-dessus de la Crapette pour former la base de son tableau.
- Les 35 cartes restantes constituent le Talon, placé sous la Crapette.
- Chaque joueur retourne la première carte de sa Crapette et celui avec la carte la plus forte commence.

Disposition des cartes :

            Joueur A
  Crapette      Défausse      Talon

      5♣          ♠      ♠          J♠
      9♥          ♥      ♥          Q♥
      K♠          ♦      ♦          A♦
      8♠          ♣      ♣          9♥

   Talon          Défausse        Crapette
            Joueur B


Déroulement du jeu:
- Le joueur ayant la main retourne la carte du dessus de son Talon et réalise autant de mouvements que possible, en respectant les règles de placement des cartes.
- Les piles centrales sont constituées de cartes de la même couleur et placées dans l'ordre croissant de l'As au Roi.
- Les colonnes du tableau doivent être constituées de cartes décroissantes en alternant les couleurs (rouge et noir).
- Les cartes visibles de la Crapette, du Talon ou du tableau peuvent être déplacées dans les piles centrales ou dans les colonnes du tableau.

Exemple de deux tours de jeu (avec la disposition ci-dessus):

Tour 1 : Joueur A
- Joueur A pioche une carte de son Talon. Il tire un 10♠.
- Il place ensuite le 10♠ sur la colonne du J♠ (décroissante et couleur alternée) dans son tableau.
- Il vérifie s’il peut placer d'autres cartes : il déplace le 9♥ (de son tableau) sur le 10♠.
- Il termine son tour en défaussant une carte de son Talon dans la pile Défausse.

Tour 2 : Joueur B
- Joueur B pioche une carte de son Talon et tire un 8♦.
- Il place le 8♦ dans son tableau, car il n'y a pas d'autres mouvements possibles pour cette carte.
- Il regarde son tableau et déplace le 10♣ de la Crapette vers le tableau dans une colonne vide.
- Il termine son tour en défaussant une carte dans la pile Défausse.

Crapette ! :
- Si un joueur ne remarque pas un déplacement possible, son adversaire peut interrompre son tour en disant « Crapette ! ». Le joueur doit alors arrêter de jouer et passer son tour.
- Si un joueur vide entièrement sa Crapette, il doit obligatoirement jouer la carte suivante sur une case libre dans le tableau.

Fin de partie :
- Le premier joueur à avoir posé toutes ses cartes sur le tableau ou les piles centrales gagne la partie.
""".trimIndent(),
    end = """
Le jeu se termine lorsqu'un joueur a placé toutes ses cartes. L'adversaire ne peut plus jouer et le joueur qui a terminé en premier est déclaré vainqueur.
    """.trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.HARD
)

val pileOfShit = GameModel(
    id = 23,
    name = "Tas de Merde",
    tagList = listOf(GameTagModel.CARDS),
    minPlayer = 3,
    maxPlayer = 10,
    goal = "Le but est d'obtenir quatre cartes identiques et de piocher le moins de kilos de merde possible.",
    material = "Un jeu de 52 cartes.",
    durationInMinutes = 30,
    howToPlay = """
Tas de Merde est un jeu de cartes amusant. Le but du jeu est d'avoir quatre cartes identiques pour piocher le moins de kilos de merde possible.

Préparation :
- Chaque joueur reçoit un certain nombre de cartes en fonction du nombre de participants :
  - 3 joueurs : Rois, Dames, Valets sont distribués.
  - 4 joueurs : Rois, Dames, Valets, 2.
  - 5 joueurs : Rois, Dames, Valets, 2, 3.
  - 6 joueurs : Rois, Dames, Valets, 2, 3, 4.
  - 7 joueurs : Rois, Dames, Valets, 2, 3, 4, 5.
  - 8 joueurs : Rois, Dames, Valets, 2, 3, 4, 5, 6.
  - 9 joueurs : Rois, Dames, Valets, 2, 3, 4, 5, 6, 8.
  - 10 joueurs : Rois, Dames, Valets, 2, 3, 4, 5, 6, 8, 9.
- Le reste des cartes forme le "Tas de Merde" au centre de la table.

Déroulement du jeu :
- Chaque joueur commence avec quatre cartes en main.
- Le joueur qui a la Dame de cœur débute la partie en passant une carte de sa main au joueur à sa droite.
- Chaque joueur fait de même à tour de rôle en passant une carte au joueur suivant.
- L'objectif est d'obtenir quatre cartes identiques (même valeur ou même couleur).
- Lorsqu'un joueur a quatre cartes identiques, il tape le "Tas de Merde" au centre de la table.
- Les autres joueurs doivent taper le tas le plus rapidement possible après lui. Le dernier joueur à taper doit piocher une carte du tas.
- La carte piochée détermine le nombre de "kilos de merde" que ce joueur reçoit (le chiffre sur la carte correspond au nombre de kilos).
- Attention : Le joueur ayant quatre cartes identiques doit attendre que tous les autres joueurs aient quatre cartes avant de taper le tas.
- Il est possible de bluffer en faisant semblant de taper le tas. Si un autre joueur tombe dans le piège, il doit piocher une carte du tas.

Règle spéciale : La chasse d'eau
- Si un joueur pioche un 7, il pioche la carte "Chasse d'Eau". Cette carte lui permet de remettre toutes ses cartes piochées (les kilos de merde) sous le tas de merde.
""".trimIndent(),
    end = """
La partie se termine après le nombre de manches défini. Chaque joueur compte ses cartes piochées, chaque carte correspondant à un certain nombre de kilos de merde :
- 5 = 5 kilos
- Valet = 11 kilos
- Dame = 12 kilos
- Roi = 13 kilos
- As = 100 kilos

Le joueur avec le moins de kilos de merde à la fin de la partie est déclaré vainqueur.
    """.trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.EASY
)


val lousy = GameModel(
    id = 24,
    name = "Pouilleux",
    tagList = listOf(GameTagModel.CARDS),
    minPlayer = 2,
    maxPlayer = 6,
    goal = "Le but du jeu est de former des paires de cartes et de ne pas finir avec le Pouilleux, une carte non appairée.",
    material = "Un jeu de 52 cartes sans la Dame de ♣ ou une autre carte choisie au hasard.",
    durationInMinutes = 15,
    howToPlay = """
Pouilleux se joue avec un jeu de 52 cartes dont une carte est retirée. Le but est de former des paires et de ne pas garder le Pouilleux.

Préparation :
- Mélangez le jeu de cartes et retirez une carte, par exemple la Dame de ♣. Distribuez ensuite les cartes entre les joueurs.
- Chaque joueur regarde ses cartes et élimine toutes les paires qu'il possède (même valeur).

Déroulement du jeu :
- Les joueurs jouent à tour de rôle, en prenant une carte au hasard dans la main du joueur à leur gauche.
- Si cela forme une nouvelle paire, la paire est immédiatement défaussée.
- Le jeu continue jusqu'à ce que toutes les cartes aient été défaussées sauf une : le Pouilleux.
""".trimIndent(),
    end = """
Le jeu se termine lorsque toutes les paires ont été formées et défaussées, à l'exception du Pouilleux. Le joueur ayant cette carte est déclaré perdant.
    """.trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.EASY
)

val fourHundredTwentyOne = GameModel(
    id = 26,
    name = "421",
    tagList = listOf(GameTagModel.DICE, GameTagModel.DRINKS),
    minPlayer = 2,
    maxPlayer = 8,
    goal = "Le but du jeu est de réaliser la meilleure combinaison possible avec trois dés, tout en accumulant le moins de pénalités possible.",
    material = "3 dés.",
    durationInMinutes = 15,
    howToPlay = """
Le jeu 421 se joue avec 3 dés, et l'objectif est d'obtenir la meilleure combinaison possible. Le joueur ayant la plus faible combinaison à la fin de chaque manche reçoit une ou plusieurs pénalités.

Déroulement du jeu :
- Le premier joueur lance les 3 dés et peut choisir de relancer jusqu'à trois fois. Il peut également s'arrêter à tout moment s'il est satisfait de sa combinaison.
- Le nombre de lancers du premier joueur détermine le nombre de lancers pour les autres joueurs.
- Lors de chaque lancer, un joueur peut choisir de conserver un ou deux dés et de relancer uniquement les dés restants.
- Le joueur ayant la plus faible combinaison après les lancers reçoit un nombre de pénalités correspondant à la meilleure combinaison des autres joueurs.
- Les dés sont toujours lus du plus fort au plus faible (ex : 521 au lieu de 125, etc.).

Combinaisons possibles (de la plus forte à la plus faible) :
- 421 : 8 pénalités (meilleure combinaison possible).
- 111 : 7 pénalités.
- 666, 116 : 6 pénalités.
- 555, 115 : 5 pénalités.
- 444, 114 : 4 pénalités.
- 333, 113 : 3 pénalités.
- 222, 112 : 2 pénalités.
- Suites (ex : 123, 234, 345, 456) : 2 pénalités.
- Autres combinaisons (ex : 322, 331, 664, 665) : 1 pénalité.
- 221 (appelé "Nénette") : 1 pénalité, plus faible combinaison.

""".trimIndent(),
    end = """
Le joueur qui perd une manche devient le premier à lancer les dés pour la manche suivante. Le jeu se termine lorsque les joueurs en décident ainsi, ou lorsqu'il n'y a plus de pénalités à attribuer !
    """.trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.MEDIUM,
)

val eightAmerican = GameModel(
    id = 28,
    name = "8 Américain",
    tagList = listOf(GameTagModel.CARDS),
    minPlayer = 2,
    maxPlayer = 8,
    goal = "Le but du jeu est de se débarrasser de toutes ses cartes avant les autres joueurs. Ce jeu est l'ancêtre du Uno",
    material = "Un jeu de 52 cartes (ou deux jeux pour 4 joueurs et plus).",
    durationInMinutes = 30,
    howToPlay = """
Le 8 Américain est un jeu de cartes dont l'objectif est de se défaire de toutes ses cartes en respectant certaines règles spéciales liées aux cartes jouées.

Préparation :
- Le donneur distribue 8 cartes à chaque joueur. Le reste des cartes constitue la pioche.
- La première carte de la pioche est retournée pour former la défausse.

Déroulement du jeu :
- Le premier joueur est celui assis après le donneur.
- À son tour, chaque joueur doit poser une carte de la même couleur ou de la même valeur que la carte visible sur la défausse.
- S'il ne peut pas jouer, il doit piocher une carte. Si celle-ci peut être jouée, il peut la poser immédiatement, sinon il passe son tour.
- Certaines cartes ont des effets spéciaux :
  - 8 : Carte joker que l'on peut poser n'importe quand sauf sur un 2. Il permet aussi de changer la couleur de jeu.
  - As : Oblige tous les autres joueurs à poser un As (ou un 8) ou de piocher deux cartes. Tout le monde doit participer à la règle puis c'est au joueur suivant celui qui a posé l'as qui joue.
  - 2 : Fait piocher 2 cartes au joueur suivant à moins qu'il pose un 2 aussi. Dans ce cas là, c'est au joueur d'après de piocher 4 cartes et ainsi de suite.
  - Valet : Change le sens du jeu
  - 10 : Oblige le joueur l'ayant posé à rejouer (s'il joue encore un 10, il continue). A noter que si le 10 est la dernière carte, le joueur doit piocher une nouvelle carte.
  - 7 : Le joueur suivant passe son tour.
  
Lorsqu'un joueur n'a plus qu'une carte, il doit annoncer "Carte" et pourra tenter de l'emporter en la posant au tour suivant.

A 2 jeux de cartes, les joueurs peuvent poser des cartes mêmes si ce n'est pas leur tour. Pour cela, ils doivent poser exactement la même carte que la première carte de la défausse. Le jeu reprend ensuite à la suite du joueur qui a "intercepté" la carte.

Pénalités :
- Une pénalité de deux cartes est appliquée à tout joueur qui réalise une des fautes suivantes :
  - Poser une carte qui n'est pas correcte en fonction de la défausse.
  - Oublier d'annoncer "Carte" lorsqu'il ne lui reste plus qu'une carte en main.
""".trimIndent(),
    end = """
A la fin de chaque manche, Chaque joueur comptabilise le nombre de points des cartes restantes dans sa main :
  - 50 points pour un 8
  - 25 points pour 2 et As
  - 10 points par figure
  - 5 points pour chaque autre carte.
La partie se termine lorsqu'un joueur totalise 500 points en cumulant des parties.
    """.trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.MEDIUM
)

val gangsters = GameModel(
    id = 30,
    name = "Gangsters",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.ELIMINATION),
    minPlayer = 4,
    maxPlayer = 6,
    goal = "Le but du jeu est de survivre aux 8 tours de jeu et accumuler le plus d'argent.",
    material = "2 jeux de 52 cartes.",
    durationInMinutes = 45,
    howToPlay = """
Dans ce jeu, chaque participant doit sélectionner 8 cartes d'une même couleur, numérotées de 6 à roi. Ces cartes sont les "balles" que les joueurs utiliseront pour charger leurs armes fictives, représentées par le geste de pointer un doigt (l’index) vers un autre joueur avec le pouce levé, simulant un pistolet prêt à tirer.

Voici la classification des balles :
- Les cartes numérotées 6, 7, 8, 9 et 10 sont des balles à blanc.
- Les cartes valet et dame sont des balles standards.
- Les rois sont des balles puissantes.

Les cartes numérotées de l'as à 5 sont séparées du reste des cartes pour former un tas distinct. Ce tas représente le butin que les joueurs se partageront à la fin de chaque tour.

Déroulement d'un tour :
Le tour se divise en sept étapes :
1. Cinq cartes sont tirées du tas de butin et placées au centre de la table, face cachée. Après le premier tour, les cartes restantes du tour précédent peuvent encore être présentes et ajoutées aux nouvelles.
2. Chaque joueur sélectionne secrètement une carte balle et la place face cachée devant lui. Cette carte ne pourra pas être rejouée par la suite.
3. Tous les joueurs comptent jusqu’à trois et pointent simultanément leur index vers un autre joueur, indiquant ainsi leur cible.
4. Après un nouveau décompte jusqu’à trois, chaque joueur peut décider de se coucher (poser sa main sur la table) ou de rester dans le jeu en criant "pitbull !". Ceux qui se couchent ne peuvent plus être blessés, mais ils ne participent pas au partage du butin. Si un joueur qui se couche est visé, celui qui l'a visé défausse également sa carte sans la dévoiler.
5. Les joueurs qui ont choisi une carte roi la révèlent. Ces joueurs sont les premiers à tirer et infligent une blessure à la personne visée. Toute personne blessée à ce stade se défausse de sa carte balle sans la montrer et est exclue du partage du butin.
6. Ensuite, les autres joueurs révèlent leurs cartes. Les valets et dames infligent des blessures aux joueurs visés. Si deux joueurs se ciblent simultanément avec ces cartes, les deux sont blessés. Les cartes 6, 7, 8, 9 et 10 (balle à blanc) ne causent aucune blessure.
7. Les gangsters qui ne sont pas couchés et qui n’ont pas été blessés pendant ce tour partagent le butin. Les cartes butin sont réparties de manière équitable entre eux. Par exemple, si 7 cartes doivent être partagées entre 3 joueurs, chaque joueur en choisira deux, et la carte restante sera conservée pour le tour suivant.

Une fois ces étapes terminées, on recommence un nouveau tour à partir de la première étape, et cela pendant 8 tours.
""".trimIndent(),
    end = """
À l'issue du huitième tour, les joueurs qui sont encore en jeu dévoilent leur butin. Le joueur avec la plus grande somme d’argent remporte la partie (les rois valent 1 000 ${'$'}, les 2 valent 2 000 ${'$'}, les 3 valent 3 000 ${'$'}, etc.).
    """.trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.MEDIUM
)

val getaway = GameModel(
    id = 31,
    name = "Getaway",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.TRICKS),
    minPlayer = 3,
    maxPlayer = 8,
    goal = "Le but du jeu est d'éviter d'être le dernier joueur avec des cartes en main.",
    material = "Un ou deux jeux de 52 cartes sans joker.",
    durationInMinutes = 30,
    howToPlay = """
Le Getaway est un jeu de levées où les cartes sont classées du 2 à l’as. Voici comment se déroule une partie :

1. Toutes les cartes sont distribuées aux joueurs par le donneur, qui change à chaque partie.
2. Le joueur possédant l’as de pique commence la partie en jouant cette carte. Les autres joueurs doivent jouer, à tour de rôle, une carte de la même couleur s’ils en ont. Sinon, ils peuvent poser une carte d’une autre couleur de leur choix.
3. Le premier levée est défaussée, face cachée. Au tour suivant, c’est le joueur qui avait l'as de pique qui commence en jouant la carte de son choix.
4. Si tous les joueurs jouent une carte de la couleur demandée, alors la levée est défaussée face cachée et la partie continue.
5. Si un joueur ne peut pas fournir la couleur demandée, il peut jouer une carte d’une autre couleur, appelée "tochoo". Cela interrompt la levée, et les joueurs suivants ne peuvent plus jouer.
6. Le joueur qui a joué la carte la plus forte de la couleur demandée (ou le dernier joueur à jouer un tochoo) remporte la levée et ajoute les cartes à sa main.
7. Si un joueur parvient à se débarrasser de toutes ses cartes, il entre en mode "Getaway". Ce joueur a réussi à quitter la table et ne peut plus perdre. Attention, il n'est pas possible de se séparer de ses cartes en remportant une levée car ce même joueur devra entamer le tour suivant. Dans ce cas-là, le joueur prend une carte au hasard dans la défausse et la joue.

Règle particulière :
- Avant chaque nouvelle levée, un joueur peut décider d’ajouter le jeu de son voisin de gauche à sa main. Si le voisin est déjà en Getaway, il prend le jeu du joueur suivant à gauche, et ainsi de suite. Le joueur dont le jeu est pris entre à son tour en mode Getaway.
""".trimIndent(),
    end = """
La partie continue jusqu'à ce qu'un joueur soit le dernier à avoir encore des cartes en main. Ce joueur perd la partie, et une nouvelle partie peut commencer.
""".trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.MEDIUM
)

val gileter = GameModel(
    id = 32,
    name = "Gileter",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.TRICKS),
    minPlayer = 3,
    maxPlayer = 4,
    goal = "Le but du jeu est d'obtenir le plus grand nombre de levées sur un total de 13 manches, mais pour gagner une levée, il faut jouer la deuxième carte la plus élevée.",
    material = "Un jeu de 52 cartes.",
    durationInMinutes = 45,
    howToPlay = """
Le Gileter se joue avec 52 cartes pour 4 joueurs, ou 39 cartes pour 3 joueurs (les cœurs sont retirés). Les cartes sont classées dans un ordre allant du 2 à l’as, l'as étant la carte la plus puissante.

En cas d’égalité, les couleurs des cartes sont classées de la manière suivante : pique, trèfle, carreau, puis cœur. Par exemple, un 9 de pique battra un 9 de cœur.

Déroulement :
- Le donneur distribue 13 cartes à chaque joueur en plusieurs étapes : d’abord 2 cartes, puis 4, ensuite 3 et enfin 1.
- Le donneur entame la manche en jouant une carte visible sur la table. Les autres joueurs doivent alors poser une carte face cachée.
- Après que chaque joueur ait posé sa carte, elles sont toutes révélées simultanément.
- C’est la deuxième carte la plus forte qui remporte la levée. Si deux cartes ont la même valeur, celle appartenant à la couleur la plus élevée remporte la manche.
- La main passe alors au joueur qui a joué la carte la plus faible lors de la manche précédente.
- Lorsque les 13 levées sont jouées, chaque joueur marque 1 point par levée remportée.

""".trimIndent(),
    end = """
La partie prend fin lorsqu'un joueur parvient à accumuler 21 points. Si plusieurs joueurs atteignent ce score au même moment, celui qui a le plus de points remporte la partie. Si ils sont à égalité, on démarre une nouvelle manche jusqu'à ce qu'un gagnant se démarque.
""".trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.MEDIUM
)

val guess = GameModel(
    id = 33,
    name = "Guess",
    tagList = listOf(GameTagModel.NO_MATERIAL, GameTagModel.TEAM),
    minPlayer = 4,
    maxPlayer = 8,
    goal = "Le but est de faire deviner des mots à ses partenaires en utilisant le moins d'indices possible.",
    material = "Aucun matériel spécifique n'est requis.",
    durationInMinutes = 30,
    howToPlay = """
Les joueurs se répartissent en deux équipes. Un membre de la première équipe choisit un mot (ce mot ne doit pas être un nom propre) et le transmet secrètement à un joueur de l’équipe adverse. Ce mot ne doit être entendu par personne d’autre. À partir de là, les deux joueurs vont entrer en duel.

1. Le joueur qui a reçu le mot annonce combien d'indices il estime nécessaires pour faire deviner ce mot à son équipe (par exemple, "en 3 indices").
2. Le joueur ayant donné le mot peut à son tour lancer un défi et tenter de faire deviner ce mot avec encore moins d'indices (par exemple, "je peux le faire en 2").
3. L'équipe ayant proposé le plus petit nombre d'indices remporte le défi et commence la phase de devinette.

Lors de la phase de devinette :
- Le joueur qui donne les indices énonce à voix haute le premier indice. Ses coéquipiers doivent alors deviner le mot.
- Le processus se répète avec le nombre d'indices convenu.

Il est permis d’utiliser des adjectifs, des verbes conjugués, etc., pour faire deviner un mot, mais l’usage de mots composés (par exemple, "Chapeau melon") ou de mots partageant la même racine est interdit. Cependant, des mots ayant des sonorités proches peuvent être utilisés.

Dans les équipes de plus de deux personnes, les membres doivent discuter entre eux pour proposer une seule réponse.

Système de points :
- Si une équipe devine le mot avec 4 indices : aucun point.
- En 3 indices : 1 point.
- En 2 indices : 2 points.
- En 1 indice : 3 points.

Les points attribués se basent sur l'annonce initiale et non sur le nombre réel d'indices utilisés. Par exemple, si un joueur annonce qu'il fera deviner en 2 indices mais réussit avec 1 seul, son équipe gagne 2 points et non 3.

Après chaque phase de devinette, qu’elle soit réussie ou non, c'est le joueur qui a fait deviner le mot qui choisit un nouveau mot pour un autre joueur de l’équipe adverse (mais pas le joueur contre lequel il vient de faire le défi).

""".trimIndent(),
    end = """
La première équipe à accumuler 20 points remporte la partie.
""".trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.MEDIUM
)

val liar = GameModel(
    id = 34,
    name = "Menteur",
    tagList = listOf(GameTagModel.CARDS),
    minPlayer = 2,
    maxPlayer = 4,
    goal = "Le but du jeu est de débarrasser de toutes ses cartes.",
    material = "Un jeu de 52 cartes.",
    durationInMinutes = 20,
    howToPlay = """
Le jeu se déroule ainsi :
- Toutes les cartes sont distribuées entre les joueurs.
- Le premier joueur pose au centre de la table une carte face visible tout en annonçant sa couleur (par exemple "Cœur").
- Le joueur suivant doit à son tour poser une carte de la même couleur, cette fois-ci face cachée, en l'annonçant à haute voix (il peut choisir de mentir ou de dire la vérité).
- Chaque joueur répète cette action à son tour.

Les joueurs peuvent choisir de mentir sur la couleur annoncée. Par exemple, un joueur peut annoncer "Cœur" et poser en réalité une carte de Trèfle face cachée.

Si un joueur soupçonne un autre d'avoir menti, il peut le traiter de "menteur". Dans ce cas, le joueur accusé doit montrer la carte qu'il vient de poser.

Deux scénarios sont possibles :
- Si l'accusé a effectivement menti, il prend toutes les cartes posées sur la table et les ajoute à son jeu. Il recommence ensuite en posant une carte face visible de la couleur de son choix.
- Si l'accusé n'a pas menti, c'est l'accusateur qui doit prendre le paquet de cartes et poser une nouvelle carte face visible pour continuer la partie.
""".trimIndent(),
    end = """
Le premier joueur à se débarrasser de toutes ses cartes gagne la partie. Cependant, les autres joueurs continuent jusqu'à ce qu'un joueur ramasse l'ensemble des 52 cartes. Celui-ci est alors déclaré perdant.
""".trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.EASY
)

val scopa = GameModel(
    id = 35,
    name = "Scopa",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.TRICKS),
    minPlayer = 2,
    maxPlayer = 6,
    goal = "Le but du jeu est d'accumuler un maximum de levées pour gagner des points dans plusieurs catégories.",
    material = "Un jeu de 52 cartes sans les figures.",
    durationInMinutes = 30,
    howToPlay = """
Le Scopa se joue à 2, 3, 4 et 6 joueurs, à l'aide d'un jeu de 52 cartes dont les figures ont été retirées. On utilise donc 40 cartes numérotées de 1 à 10. L'as est la carte la plus faible. L'objectif est de ramasser un maximum de levées pour accumuler des points.

Déroulement du jeu :
- Le donneur distribue à chaque joueur 3 cartes qu'il tient en main, puis place 4 cartes visibles au centre de la table.
- Les cartes restantes forment la pioche.
- Le premier joueur à gauche du donneur commence la partie.
- À son tour, chaque joueur a deux options :
   - Prendre une ou plusieurs cartes sur la table si la valeur de sa carte équivaut à la somme de certaines cartes du centre. Par exemple, poser un 3 pour ramasser un 2 et un 1. Il est interdit de poser une carte avec laquelle on peut faire une levée. (Exemple: on ne peut poser un 5 si il y a un 2 et 3 au centre. Le joueur doit prendre les 2 et 3). De plus, si on pose une carte qui peut prendre une carte ou une combinaison, on prendra toujours le moins de cartes possible.
   - Poser une carte sans effectuer de levée dans le cas où aucune carte ou somme de carte n'a la même valeur que la carte posée. 
- Si un joueur parvient à ramasser toutes les cartes du centre de la table, il réalise une "Scopa", ce qui lui donne un point bonus. Le joueur suivant doit obligatoirement poser une carte au milieu de la table.
- Si tous les joueurs ont joué leurs 3 cartes, le donneur distribue 3 nouvelles cartes à chaque personne. Par ailleurs, on ne remet jamais des cartes au centre de la table.
- Le jeu continue ainsi jusqu'à ce que toutes les cartes aient été jouées.

Une fois que le donneur a joué la dernière carte, le dernier joueur à avoir fait une levée gagne les cartes restantes au milieu. Le donneur ne peut pas faire scopa sur la dernière levée même si sa dernière carte lui permet.

Comptage des points :
À la fin de la manche, 4 points sont attribués pour les 4 catégories suivantes :
1. Celui qui a récolté le plus de cartes.
2. Celui qui a obtenu le plus grand nombre de cartes de carreaux.
3. Celui qui a récupéré le plus de 7.
4. Celui qui possède le 7 de carreaux.

En cas d'égalité dans une catégorie, aucun point n'est attribué pour cette catégorie.

""".trimIndent(),
    end = """
Le jeu se termine lorsque l'un des joueurs atteint 11 points avec un écart d'au moins 2 points. Si l'écart n'est que d'un point, la partie continue.
""".trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.MEDIUM
)

val yaniv = GameModel(
    id = 36,
    name = "Yaniv",
    tagList = listOf(GameTagModel.CARDS),
    minPlayer = 2,
    maxPlayer = 8,
    goal = "Le bu du jeu est de réduire sa main à 7 points ou moins avant la fin de la manche et de finir avec le plus bas score au terme de la partie.",
    material = "Un jeu de 52 cartes, accompagné de 2 jokers. Pour les parties avec 5 joueurs ou plus, il est nécessaire d'utiliser deux jeux de cartes.",
    durationInMinutes = 30,
    howToPlay = """
Le jeu se compose de plusieurs manches, au terme desquelles un pointage est effectué pour chaque participant. Voici les étapes de la partie :

1. Les cartes ont les valeurs suivantes :
   - L'as vaut 1 point.
   - Les cartes numérotées de 2 à 10 valent leur chiffre.
   - Les figures (valet, dame, roi) valent 10 points chacune.
   - Les jokers ne valent aucun point.
   
2. Le donneur distribue 5 cartes à chaque joueur, puis place le reste des cartes, faces cachées, au centre de la table pour former la pioche.

3. À chaque tour, un joueur a deux options :
   - Se défausser d'une ou plusieurs cartes (dans une pile de défausse commune à tous) et tirer ensuite une carte, soit depuis la pioche, soit depuis les cartes récemment défaussées par l’adversaire.
   - Déclarer "Yaniv" lorsqu'il estime que son total de points est de 7 ou moins. Cela met fin à la manche, et un comptage des points a lieu. "Yaniv" ne peut être déclaré qu’à son propre tour.

Les combinaisons possibles à jouer en une seule fois incluent :
- Des suites d’au moins trois cartes de même couleur (les as ne peuvent pas compléter des suites avec dame et roi, seulement avec 2 et 3).
- Des paires, brelans ou carrés de cartes ayant la même valeur.

Les jokers peuvent remplacer n'importe quelle carte dans ces combinaisons.

Lorsque vous tirez une carte dans la pile de défausse :
- Vous pouvez prendre la carte qui se trouve à l’une des extrémités d’une suite ou d’un brelan/carré (cette carte peut être un joker).
- Vous pouvez aussi remplacer un joker dans une suite si vous avez la carte correspondante (il n'est pas permis de remplacer un joker dans un brelan ou un carré).

""".trimIndent(),
    end = """
Décompte des points :
- Quand un joueur déclare Yaniv, il dévoile sa main. Si un autre joueur a un total de points inférieur ou égal, il peut déclarer "Assaf", et dévoiler également sa main.
- Le joueur avec la main ayant le total le plus bas gagne la manche et ne reçoit pas de points.
- Si "Assaf" est déclaré, le joueur qui a annoncé Yaniv reçoit une pénalité : 30 points pour un seul Assaf, ou 20 points par Assaf s'il y en a plusieurs. Tous les autres joueurs ajoutent à leur score la somme de leurs cartes restantes.

Cas spéciaux :
- Si un joueur obtient un total exact de 100 ou 200 points, son score est réduit (à 50 ou 100 points respectivement).
La partie prend fin lorsque l’un des joueurs dépasse 200 points. Le joueur ayant le moins de points remporte alors la partie.
""".trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.MEDIUM
)


val gameList = listOf(
    barbu,
    thirtyOne,
    corsicaBattle,
    corruption,
    president,
    canasta,
    spikeLady,
    fiveThousand,
    solitaire,
    elevator,
    tamalou,
    yahtzee,
    kems,
    nightyNine,
    pyramid,
    fuckTheDealer,
    shoshoi,
    sevenAndHalf,
    threeMan,
    rami,
    crapette,
    pileOfShit,
    lousy,
    fourHundredTwentyOne,
    eightAmerican,
    gangsters,
    getaway,
    gileter,
    guess,
    liar,
    scopa,
    yaniv
).sortedBy { it.name }