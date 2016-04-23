@echo off
if -%1-==-- (
  echo A futtatashoz add meg elso parameterkent a futtatando teszteset sorszamat, masodik parameterkent a kimeneti fajl nevet!
  echo testlauncher test_case output_file
  echo pl.: testlauncher shoot output.txt
  echo Elerheto tesztesetek:
  echo shoot
  echo zpm
  echo jatek_betolt
  echo leptetes
  echo doboz_fel
  echo doboz_le
  echo doboz_megsemm
  echo ajto_nyit
  echo ajto_zar
  echo zpm_felvesz
  echo loves2
  echo feregjarat_nyit
  echo feregjarat_athalad
  echo jatekos_megoles
  echo replicator_szakadek
  echo gyozelem
  echo jatekos_zart_ajton
  echo replikator_zart_ajton
  echo portal_zart_ajton
  echo portal_nyitot_ajton
  echo jatekos_lep_dobozra
  echo ket_doboz_felvetele
  echo replikator_jatekos_utkozik
  echo replikator_dobozra_lep
  echo replikator_zpm_lep
  echo jatekosok_utkoznek
  echo azonos_portal
  echo kulonbozo_portal
  echo egy_portal
)
if not -%1-==-- (
  if not -%2-==-- (
    if exist %1_COMMANDS.txt (
      echo A %1 teszteset futtatasa...
      java -classpath ..\src main.Main >>%2 <%1_COMMANDS.txt 2>&1
    )
    if not exist %1_COMMANDS.txt echo Nem erheto el a bemeneti fajl
  )
  if -%2-==-- echo Nem adtal meg kimeneti fajlt!
)