cd src

../make.sh
CLASSFILES=`find . -name "*.class"`

jar cfev Jeu.jar mmorpg.jeu.Moteur $CLASSFILES

mv Jeu.jar ../
cd ../

jar ufv Jeu.jar ressources
