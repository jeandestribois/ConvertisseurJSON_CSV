- Nom du projet		: 	Convertisseur JSON - CSV

- Auteurs 			: 	Payam Akrami, Raphaël Gillot-Roux, Jean Destribois

- État du projet	:	Non fini : 	- La fonctionnalité de conversion entre un fichier
									CSV à JSON est non implémenté (l'inverse fonctionne)
									- La fonctionnalité permettant de générer et d'utiliser.
									un fichier de configuration pour la conversion est
									non implémenté.

- Mise en place 	:	La commande "mvn package" permet de générer une archive jar executable
						dans le dossier "target".

- Usage				:	- Une fois l'application lancée, elle vous demandera si vous souhaitez
						utiliser votre propre fichier de configuration (vous devrez alors le
						rentrer) ou bien utiliser celui par défaut.
						- Suite à cela l'application vous demandera dans quel sens souhaitez
						vous faire la conversion (si vous renseignez dans le sens CSV -> JSON
						l'application fermera car cette fonctionnalité n'est pas implémenté).
						- Et pour finir l'application vous demandera de nommer le nouveau
						fichier créé.

- Conception		:	L'application contient :	- Une classe App contenant la méthode main
													- Une classe Interface s'occupant de gérer
													l'interaction avec l'utilisateur
													- Une classe Convertisseur se chargeant de
													la conversion.
