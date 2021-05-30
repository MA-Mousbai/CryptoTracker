# CryptoTracker

Projet de programmation mobile 3A sous Android Studio (Kotlin)

## Description générale de l'application

Cette application mobile permet de visualiser les différentes cryptomonnaies existantes et de voir le montant unitaire de chaque monnaie grâce à l'API LunarCrush.
Le détail de chaque monnaie affiche un court résumé de cryptomonnaie.

## Description technique de l'application

L'application affiche la liste de cryptomonnaies à travers une RecyclerView.
Chaque item contient (de gauche à droite) : 
* Un logo appartenant à la crypto en question (afficher grâce à Glide)
* Le nom de la cryptomonnaire
* Le prix actuel de la cryptomonnaies (en USD)

L'application récupère ces données grâce à une API Rest en utilisant Retrofit et stocke ces données en cache (via le cache HTTP)
Cette application suit l'architecture MVVM.

L'application gère les erreurs en affichant un petit message lorsque l'appel à l'API n'est pas concluant pour X ou Y raisons.
Il y a également une icône personnalisée sur l'écran d'accueil pour l'application

## Aperçu visuel de l'application
* Page principale :
<img src="/screenshots/Main_screen.png" width="25%" height="25%">

* Page de détail :
<img src="/screenshots/Detail_screen.png" width="25%" height="25%">

* Page de chargement (lors de l'appel API) :
<img src="/screenshots/Loading_screen.png" width="25%" height="25%">

* Page d'erreur :
<img src="/screenshots/error_screen.png" width="25%" height="25%">


* Icône de l'application :
<img src="/screenshots/icon_screen.png" width="25%" height="25%">

## Auteur

MOUSBAI Mohamed-Ali UFA-3A
