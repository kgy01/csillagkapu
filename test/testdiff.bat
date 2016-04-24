@echo off
if -%1-==-- (
  echo Hianyzo inditasi parameter! Hasznalat:
  echo testdiff.bat [kimeneti fajl] [referencia kimeneti fajl]
  echo pl. testdiff.bat output.txt shoot_REF.txt
)
if not -%1-==-- (
  if not -%2-==-- (
    if exist %1 (
      if exist %2 (
        java -classpath ..\target utils.Diff %1 %2
        if not exist %2 echo Nem erheto el a referencia kimeneti fajl
      )
    )
    if not exist %1 echo Nem erheto el a kimeneti fajl
  )
  if -%2-==-- (
    echo Nem adtal meg kimeneti fajlt!
    echo testdiff.bat [kimeneti fajl] [referencia kimeneti fajl]
    echo pl. testdiff.bat output.txt shoot_REF.txt
  )
)