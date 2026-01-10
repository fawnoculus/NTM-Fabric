
<div align="center">
  <img src="./.idea/icon.svg" alt="NTM-Fabric Icon" width="300">
  <h1>NTM-Fabric</h1>
  <a href="https://fabricmc.net/"><img src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/supported/fabric_64h.png" alt="Available on Fabric" width="200"></a>
  <a href="https://quiltmc.org/"><img src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/supported/quilt_64h.png" alt="Available on Quilt" width="200"></a>
  <br>
  <a href="https://github.com/fawnoculus/NTM-Fabric/blob/master/LICENSE.txt"><img src="https://img.shields.io/github/license/fawnoculus/NTM-Fabric?style=flat&color=900c3f" alt="Licence: GPL-3.0"></a>
  <a href="https://github.com/fawnoculus/NTM-Fabric/actions/workflows/build.yml"><img src="https://github.com/fawnoculus/NTM-Fabric/actions/workflows/build.yml/badge.svg" alt="Build Workflow"></a>
</div>

## What is NTM-Fabric?
NTM-Fabric is an Attempt to recreate [HBM's NTM](https://github.com/HbmMods/Hbm-s-Nuclear-Tech-GIT) (a mod for 1.7.10) on modern Versions of Minecraft in Fabric.
Depending on how development plays out some features from [NTM-Space](https://github.com/JameH2/Hbm-s-Nuclear-Tech-GIT/tree/space-travel-twopointfive) (JameH2's fork of HBM's) may also be implemented.

## DISCLAIMERS
1. I am not in any way associated with HBM (aka Bob), I am developing this Recreation purely because I liked HBM's NTM and at some point thought "Wow, this would be really cool in newer Versions!"
2. NTM-Fabric is not even remotely finished!
  Most Features are still missing, unfinished, unpolished or barely functioning.
  There will be no release of mod on Modrinth / CurseForge until It is at least in a *"playable"* State
3. Don't bother contributors of the original mod with problems of this one! (We don't want to bother them with hundreds of unnecessary Bug Reports)

## Installing NTM-Fabric
In the future there may also be Releases on Modrinth & CurseForge.
For now your Options for getting this mod are:
- ~~Modrinth~~ (maybe someday)
- ~~CurseForge~~ (maybe someday)
- [GitHub Releases](https://github.com/fawnoculus/NTM-Fabric/releases/latest)
- [GitHub Actions](https://github.com/fawnoculus/NTM-Fabric/actions/workflows/build.yml) (refer to the Section Below)
- Building it from Source (refer to the Section Below)

## Downloading from GitHub actions
1. Navigate to the Latest (topmost) successfully ran (green check) [Action](https://github.com/fawnoculus/NTM-Fabric/actions/workflows/build.yml)
2. Click on that bad boy
3. On the bottom right there should be a button for downloading the Artifact (you may need to scroll down)
4. If you unzip the File you should now have a working version of the mod (you don't want the file that ends in "-sources.jar")

## Building it from Source
Building it from source should be unnecessary as you can download a jar of the latest commit from [GitHub Actions](https://github.com/fawnoculus/NTM-Fabric/actions/workflows/build.yml)
* Make sure you have [**JDK-21**](https://adoptium.net/temurin/releases/?variant=openjdk8&jvmVariant=hotspot&package=jdk&version=21) and [**git**](https://git-scm.com/downloads) installed
* Open PowerShell (or Bash if you are using Linux)
* Navigate to the Directory you wish to copy the Sources to
```shell
cd $HOME/Downloads/
```
* Download the Sources
```shell
git clone https://github.com/fawnoculus/NTM-Fabric
```
* enter the sources directory
```shell
cd NTM-Fabric
```
* build the Mod
```shell
./gradlew build
```
If the Command Returns with saying **BUILD SUCCESSFUL** then you should be able to find the mod file at "Downloads/NTM-Fabric/build/libs/ntm-fabric-VERSION.jar"

## Contributing
Please read [CONTRIBUTING.md](./docs/CONTRIBUTING.md) for information of how you can aid in development.

## Licence
This software is licensed under the GNU Public License version 3. In short: This software is free, you may run the software freely, create modified versions,
distribute this software and distribute modified versions, as long as the modified software too has a free software license. The full license can be found in the `LICENSE.txt` file.
