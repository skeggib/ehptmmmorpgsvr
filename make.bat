@echo off

echo Recherche...
for /R %%i in (*.java) do (
	call :AddFile "%%i"
)

echo Compilation...
javac %a%

echo Fini !
goto End

:AddFile
	set a=%a% %1

:End