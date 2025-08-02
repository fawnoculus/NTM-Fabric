
<div align="center">
  <img src="./.idea/icon.svg" alt="Logo" width="300">
  <h1>NTM-Fabric</h1>
  <a href="https://fabricmc.net/"><img src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/supported/fabric_64h.png" alt="Available on Fabric" width="200"></a>
  <a href="https://quiltmc.org/"><img src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/supported/quilt_64h.png" alt="Available on Quilt" width="200"></a>
  <br>
  <a href="https://github.com/fawnoculus/NTM-Fabric/blob/master/LICENSE.txt"><img src="https://img.shields.io/github/license/fawnoculus/NTM-Fabric?style=flat&color=900c3f" alt="Licence: GPL-3.0"></a>
  <a href="https://github.com/fawnoculus/NTM-Fabric/actions/workflows/build.yml"><img src="https://github.com/fawnoculus/NTM-Fabric/actions/workflows/build.yml/badge.svg" alt="Licence: GPL-3.0"></a>
</div>

## What is NTM-Fabric?
NTM-Fabric is an Attempt to recreate [HBM's NTM](https://github.com/HbmMods/Hbm-s-Nuclear-Tech-GIT) (a mod for 1.7.10) on modern Versions of Minecraft in Fabric.
Depending on how development plays out some features from [NTM-Space](https://github.com/JameH2/Hbm-s-Nuclear-Tech-GIT/tree/space-travel-twopointfive) (JameH2's fork of HBM's) may also be implemented.

## **DISCLAIMER, NTM-Fabric is not even remotely finished!**
Most Features are still missing, unfinished or barely functioning.
I will not be publishing the mod in any official capacity (aka: Modrinth / CurseForge) until I feel like the mod is at least in a *"playable"* State

## Installing NTM-Fabric
In the future there may also be Releases on Modrinth & CurseForge (refer to the Disclaimer).
For now your Options for getting the mod are:
- ~~Modrinth~~ (maybe someday)
- ~~CurseForge~~ (maybe someday)
- [GitHub Releases](https://github.com/fawnoculus/NTM-Fabric/releases/latest)
- [GitHub Actions](https://github.com/fawnoculus/NTM-Fabric/actions/workflows/build.yml) (automatically complies jar every commit)
- Building it from Source (refer to the Section Below)


## Building it from Source
Building it from source should be unnecessary as you can download the jar of the latest commit from [GitHub Actions](https://github.com/fawnoculus/NTM-Fabric/actions/workflows/build.yml)
1. Make sure you have [**JDK-21**](https://adoptium.net/temurin/releases/?variant=openjdk8&jvmVariant=hotspot&package=jdk&version=21) and [**git**](https://git-scm.com/downloads) installed
2. Open PowerShell (or Bash if you are using Linux)
3. Navigate to the Directory you wish to copy the Sources to
```bash
cd $HOME/Downloads/
```
4. Download the Sources
```bash
git clone https://github.com/fawnoculus/NTM-Fabric
```
5. enter the sources directory
```bash
cd NTM-Fabric
```
5. build the Mod
```bash
./gradlew build
```
6. If the Command Returns with saying **BUILD SUCCESSFUL** then you should be able to find the mod file at "Downloads/NTM-Fabric/build/libs/ntm-fabric-VERSION.jar"

## Contributing
1. Make sure you have [**JDK-21**](https://adoptium.net/temurin/releases/?variant=openjdk8&jvmVariant=hotspot&package=jdk&version=21) and [**git**](https://git-scm.com/downloads) installed
2. clone the Repository to where you would like to have it
```bash
git clone https://github.com/fawnoculus/NTM-Fabric
```
- If you are using IntelliJ you can simply choose **Clone Repository** on the Projects Screen
4. Set up the Dev-Environment
```bash
    ./gradlew genSources
```

* For Eclipse also run
```bash
    ./gradlew eclipse
    ./gradlew genEclipseRuns
```
* For VS Code also run
```bash
    ./gradlew vscode
```
5. Make the Code Changes you with to make (don't forget to update the Changelog &/or the DevNotes)
6. Make sure that the Code works
```bash
    ./gradlew runClient
```
7. Open a Pull request right here on [GitHub](https://github.com/fawnoculus/NTM-Fabric)

## Licence
This software is licensed under the GNU Public License version 3. In short: This software is free, you may run the software freely, create modified versions,
distribute this software and distribute modified versions, as long as the modified software too has a free software license. The full license can be found in the `LICENSE.txt` file.
