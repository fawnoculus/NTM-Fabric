## Coding Documentation
I'm going to be honest, this is not really coding documentation, this is more just a record of decisions that I made during development that I wrote down so that I remember them.
#
- Datagen will be used for advancements, loot-tables, recipes & tags (where possible)
- A lot of Models will be done with Datagen, but obviously custom/advanced Models will remain as Json/Blender Files
- Translation will be done with lang files, not with Datagen
- Don't forget to add EMI & JEI compatibility once they port beyond 1.21.1
- The original hbm's displayed some information next to your Crosshair (like info about an RBMK Reactor) this will likely be moved to the Jade compatibility Plugin
- 
#
### Some Stuff will be changed to fit into modern Versions (or because i felt like it):
(Maybe make the old names & textures advisable through a resource pack)
#### Textures:
- Industrial Copper -> Standard Minecraft Copper
- Ores : the new Stone/Netherrack/Endstone Texture
- Buckets : the new Bucket Texture
#### Names:
- Industrial Grade Copper -> Copper (Copper already exist after all)
- Minecraft Grade Copper -> Red Copper (Consistency)
- Combine Steel -> CMB Steel (Consistency)
- Basalt -> Volcanic Basalt (Basalt Already Exists)
- Tantalium -> Tantalum
- Lanthanium -> Lanthanum
- Sandwich Garnished with TV Static -> TV Static Sandwich
- Pancake made from Scrap Metal, Nails and Gem Dust -> Scrap Pancake
- Ingot of "resource" -> "resource" Ingot
- Bar of "resource" -> "resource" Bar
- Block of "resource" -> "resource" Block
- Blast Furnace -> Alloying Furnace (Blast Furnace already Exists)
- HE (HBM Energy) -> NTE (Nuclear Tech Energy)
- Reinforced Block of Desh -> Desh Block
- Reinforced Block of High-Speed Steel -> High-Speed Steel Block
#### Features:
- Energy & Fluid Storages, Providers & Consumers will be able to connect to each other just like Cables/Pipes can
- Features that already have *replacements* (Example: Particle Accelerator) will not be implemented ... yet (maybe we'll do it once the rest is working)
