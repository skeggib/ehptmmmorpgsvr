CC=javac
JAVAFILES=$(find . -name "*.java" | sed "s#.\/#$PWD/#")

$CC $JAVAFILES
