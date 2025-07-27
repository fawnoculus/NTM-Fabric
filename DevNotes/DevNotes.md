## Coding Documentation
I'm going to be honest, this is not really coding documentation, this is more just a recording of decisions that I made during development that I wrote down so that I remember them.
- Datagen will be used for advancements, loot-tables, recipes & tags (where possible)
- A lot of Models will be done with Datagen, but obviously custom/advanced Models will remain as Json/Blender Files
- Translation will be done with lang files, not with Datagen
- Don't forget to add EMI & JEI compatibility once they port to whatever version we are at

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
- Ingot of "resource" -> "resource" Ingot
- Bar of "resource" -> "resource" Bar
- Block of "resource" -> "resource" Block
- Blast Furnace -> Alloying Furnace (Blast Furnace already Exists)
- HE (HBM Energy) -> NE (NuclearTech Energy)
- Reinforced Block of Desh -> Desh Block
- Reinforced Block of High-Speed Steel -> High-Speed Steel Block
- Sandwich Garnished with TV Static -> TV Static Sandwich
- Pancake made from Scrap Metal, Nails and Gem Dust -> Scrap Pancake
- Spark Ludicrous Physics-Defying Energy Storage Unit -> Spark Ludicrous Energy Storage Unit

Main Reason for changing names is that the old names where really long & the item ids that we use are usually just the item name with underscores for spaces & in lowercase, however really long item ids can be very annoying so in order to not break consistency things with long names get renamed to have a shorter name

#### Features:
- Energy & Fluid Storages, Providers & Consumers will be able to connect to each other just like Cables/Pipes can (I implemented it this way & changing it would be a pain)
- Features that already have *"replacements"* (Example: old Particle Accelerator) will not be implemented ... yet (maybe we'll do it once the more important stuff is working)
