# Défis algorithmiques

- [Trois défis](#trois-défis)
- [Analyses de la compléxité](#analyses-de-la-complexité-algorithmique)

## Trois défis

Vous devez trouvez une solution en groupes de 2 ou 3 personnes pour les deux premiers défis suivants. Si vous trouvez une solution valide pour le deuxième, vous devrez également tenter le troisième.

Le fichier `Driver.java` est une coquille incluant les signatures pour les méthodes à développer.

### Défi 1 - structure de fichier valide

Créer un algorithme pour déterminer si la structure d'un fichier texte nommé `./test_data/*.qz` est valide pour les quiz fait comme démonstration en début de semestre (voir la [section 2024 des démonstrations de la page de revue](https://physcrowley.github.io/ICS4U/u1-Revue.html#dmonstrations)). La méthode devrait prendre un objet `File` associé au chemin du fichier en paramètre.

Les test à passer sont pour :

- un fichier vide (`empty.qz`) -> `false`
- un fichier qui contient la quantité initiale de <= 0 (`zero.qz`) -> `false`
- manque la ligne d'options (`missing_options.qz`) -> `false`
- l'ordre des lignes d'informations pour une question n'est pas régulier (`wrong_order.qz`) -> `false`
- l'index n'est pas un nombre (`not_a_number.qz`) -> `false`
- un indexe invalide (`bad_index.qz`) -> `false`
- le nombre de questions est inférieure à la quantité initiale (`wrong_number.qz`) -> `false`
- un fichier valide (`valid.qz`) -> `true`

> **Pistes de démarrage**
> 
> - Vous pouvez utiliser le code fourni dans la démonstration comme base pour la lecture du fichier. Votre travail consistera à changer la > façon que le fichier est lu afin de valider sa structure.
> - Il y a une version de l'algorithme pour trouver les fichiers qui utilise l'objet `File`, soit `chooseSourceV2()`. Cette version inclut quelques techniques de base sur l'utilisation de l'objet `File`, bien que la logique ne s'applique globale (objectif différent) ne s'applique pas à ce défi spécifique.

### Défi 2 - structure de dossier

Créer un algorithme qui présente la structure d'un dossier sous forme d'un String.

- Les dossiers devraient être écrits sous la forme `nom(...)` où les `...` réprésentent le contenu du dossier. Les dossiers dans le même dossier parent sont séparés par une virgule.
- Les fichiers devraient être écrits sous la forme `"nom.extension"` et séparés par des virgules dans le dossier.
- Une virgule terminale est acceptable à la fin d'une liste de fichiers ou de dossiers.
- _Note : pour inclure les `"` dans un String, il faut les échapper avec un `\`, soit `\"`._
  

Exemple 1 
: le dossier `src` qui contient un seul fichier `App.java` -> <br> `"src(\"App.java\",),"`

Exemple 2 
: le dossier `a` qui contient juste le sous-dossier `b` qui contient le fichier `C.txt` -> <br> `"a(b(\"C.txt\",),),"`

Exemple 3 
: le dossier `d` qui contient les fichiers `E.txt` et `F.txt` -> <br> `"d(\"E.txt\",\"F.txt\",)"` ou `"d(\"F.txt\",\"E.txt\",),"`_(l'ordre des fichiers n'est pas nécessairement alphabétique)_

Tests à réussir :

- dossier `test_subfolderA` ->  `"test_subfolderA(a(b(\"xx.txt\",\"yy.txt\",),\"x.txt\",),c(\"z.txt\",\"zzz.txt\",),),"`

- dossier `test_subfolderB` -> `"test_subfolderB(.vscode(\"settings.json\",),bin(edu(ics4u(algos(\"App.class\",),),),),lib(\"hamcrest-core-1.3.jar\",\"junit-4.13.2.jar\",),src(edu(ics4u(algos(\"App.java\",),),),),\"README.md\",),"`

> **Pistes de démarrage**
> 
> - Vous devez utiliser la récursivité pour parcourir les structures de dossiers : un dossier est le cas récursif; un fichier est le cas de  base.
> - Il faudra bâtir un String en lui collant les différents morceaux dans le bon ordre (noms, parenthèses, guillemets, virgules)
> - Notez que l'ordre exacte des fichiers peut varier (pas nécessairement en ordre alphabétique comme dans l'explorateur), mais la structure des dossiers doit être identique et tous les fichiers doivent être présents au bon endroit.
> - L'objet `java.io.File` inclut les méthodes utiles suivantes (et d'autres) :
>   - listFiles()
>   - getName()
>   - isDirectory()
>   - isFile()
> - Certaines parties de l'algorithme dans `chooseSourceV2()` peuvent s'appliquer ici

### Défi 3 - raffinement de la sortie de 2 pour un affichage lisible par les humains

Écrire un algorithme pour :

1. enlever ou ignorer les `,` terminales des résultats précédents;
2. remplacer les `(` par un retour de ligne et une indentation augmentée de 4 espaces;
3. remplacer les `,` séparant des items par un retour de ligne et l'indentation actuelle
4. rétirer les `)` et réduire l'indentation de 4 espaces pour chaque occurence.
5. retourner le nouveau String.

Pour ce résultat du défi précédant : `test_subfolderA(a(b(\"xx.txt\",\"yy.txt\",),\"x.txt\",),c(\"z.txt\",\"zzz.txt\",),),`, l'algorithme devrait produire (avec `return`) le String suivant : 

```
"test_subfolderA\n    a\n        b\n            \"xx.txt\"\n            \"yy.txt\"\n        \"x.txt\"\n    c\n        \"z.txt\"\n        \"zzz.txt\"\n"
```

Ce qui donne la sortie suivante quand on l'affiche (avec `println`) :

```
test_subfolderA
    a
        b
            "xx.txt"
            "yy.txt"
        "x.txt"
    c
        "z.txt"
        "zzz.txt"

```

> **Pistes de démarrage**
> 
> - Il y a plusieurs méthodes de String qui sont pratique pour ce genre de tâche et vous pouvez les enchaînées
> - ... par contre, vous n'aurez aucune idée de la complexité algorithmique à moins de lire le code source (`Ctrl` + `clic` sur le nom de la méthode... et possiblment plusieurs autres clics en suivant la chaîne).
> - Vous pouvez aussi implémenter vos propres boucles de vérification en construisant un String résultant qui inclut ou saute le caractère à chaque index.

## Analyses de la complexité algorithmique

Pour chaque défi complété, vous devez analyser la complexité de votre algorithme et déterminer son ordre de grandeur "grand O" pour le nombre d'opérations. Vous devez expliquer comment vous êtes arrivé à cette conclusion pour la compléxité, notamment en faisant référence aux structures caractéristiques de votre algorithme (boucles, récursivité, etc.).

Placez votre analyse dans un fichier `analyse.md` à la racine de votre dépôt.

Utilisez les balises suivantes pour structurer votre document :

~~~
# titre 1

## titre 2

- élément de liste
- élément de liste

1. élément de liste numérotée
2. élément de liste numérotée

```java
// extrait de bloc de code Java
```

`code en ligne`, inclut dans le texte.
~~~

> Saviez-vous que vous pouvez aussi **travailler dans un Google Docs et l'exportez en format Markdown ou le copier comme Markdown** et le coller ici par la suite?

# Bonne chance!
