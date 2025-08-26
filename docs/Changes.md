## Stuff that was changed from the Original:
(Some of the original version of textures and translations will be available through a built-in resource pack)

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
- Explosion Effect: from "! ! !" to "Explosion"

Main Reason for changing names is that the old names where really long & the item ids that we use are usually just the item name with underscores for spaces & in lowercase,
however really long item ids can be very annoying so in order to not break consistency things with long names get renamed to have a slightly shorter name

#### Features:
- Energy & Fluid Storages, Providers & Consumers will be able to connect to each other just like Cables/Pipes can (I implemented it this way & changing it would be a pain)
- Features that already have *"replacements"* (Example: old Particle Accelerator) will not be implemented ... yet (maybe we'll do it once the more important stuff is working)
