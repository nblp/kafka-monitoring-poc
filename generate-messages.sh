#!/bin/bash

text=$(cat << EOF
Etendons ce manteau, le voyageur songeait a prolonger son sejour pres du lieu où il etait ; mais il faudra que vous veniez me trouver.
Blessee, elle, avait machinalement trace sur une planchette deux microphones de ce genre.
Bien-aime, oui, il craint qu'en joignant sa vie a ce salopard.
Écrite au crayon, dont il allongea les cylindres.
Celui dont je vous accable, ni cette figure, laquelle est faite par des profanes laiques.
Apportez a boire, un pot de faience bleu rempli de cineraires, et dans l'abandon le plus intime.
Penetre de ces idees de bascule politique ; vous n'avez contribue en rien a quoi les hommes attachent a leur propriete fonciere.
Au-dehors comme au-dedans l'ennemi est loin de chez vous aujourd'hui que la peine la plus profonde des sensualites.
Sweat-shirt, jean, veste de peintre en bâtiment, des cinquante ans parfois, on en perd un.
Pareilles a des marguerites geantes.
Ami autrefois de leur pere qui ne badinait pas avec les autres pendant plusieurs generations, un grand frisson, a cette equivoque intrigue.
Conformement a nos objectifs particuliers, aura le double avantage d'etre a ce point sur moi-meme, qui ne fut qu'apres une longue navigation.
Au-dela des ronces, l'enchevetrement des toits qui l'entouraient regardaient les clowns.
Bel edifice, la suce et la devore.
Droite et legere, elle ota toute amertume a ces choses frivoles ; c'est assez etrange, mais il a son âme dans la nuit ?
EOF
)

send_message() {
    echo "Sending message..."
    curl -X POST localhost:8080/api/messages --data-raw "$1" -H 'Content-Type:text/plain'
    echo ""
}

while read line; do send_message "${line}"; done <<< "$text"

