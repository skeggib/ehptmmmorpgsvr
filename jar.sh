cd src
CLASSFILES=`find . -name "*.class"`

jar cfev Jeu.jar jeu.Moteur $CLASSFILES

mv Jeu.jar ../
cd ../

jar ufv Jeu.jar ressources