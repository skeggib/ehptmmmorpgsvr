CC=javadoc
CURRENTDIR=`pwd`
SCRIPTDIR=`dirname $0`
SCRIPTDIR=`cd $SCRIPTDIR; pwd`

JAVAFILES=$(find $SCRIPTDIR -name "*.java" | sed "s#.#$SRIPTDIR/#")

cd doc/
$CC $JAVAFILES
